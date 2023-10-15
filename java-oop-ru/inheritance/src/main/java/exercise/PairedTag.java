package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String body;
    private final List<Tag> childTags;

    public PairedTag(String tagName, Map<String, String> attributes,
                     String body, List<Tag> childTags) {
        super(tagName, attributes);
        this.body = body;
        this.childTags = childTags;
    }
    @Override
    public String toString() {
        var child = new StringBuilder();
        var result = new StringBuilder();

        for (var tag : childTags) {
            child.append(tag.toString());
        }

        return result.append("<")
                .append(getTagName())
                .append(attributesToString())
                .append(">")
                .append(child)
                .append(body)
                .append("</")
                .append(getTagName())
                .append(">")
                .toString();
    }
}
// END
