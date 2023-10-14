package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String tag;
    private String childTag;

    public LabelTag(String tag, TagInterface childTag) {
        this.tag = tag;
        this.childTag = childTag.render();
    }

    @Override
    public String render() {
        return "<label>" + tag + childTag + "</label>";
    }
}
// END
