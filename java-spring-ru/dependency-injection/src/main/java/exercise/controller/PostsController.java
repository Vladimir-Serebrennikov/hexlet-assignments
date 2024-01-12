package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Post> index() {
        var posts = postRepository.findAll();
        return posts;
    }

    @GetMapping(path = "/{id}")
    public Post show(@PathVariable long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return post;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post data) {
        return postRepository.save(data);
    }

    @PutMapping(path = "/{id}")
    public Post update(@PathVariable long id, @RequestBody Post data) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        postRepository.save(post);
        return post;
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable long id) {
        try {
            postRepository.deleteById(id);
            commentRepository.deleteByPostId(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }

    }
}
// END
