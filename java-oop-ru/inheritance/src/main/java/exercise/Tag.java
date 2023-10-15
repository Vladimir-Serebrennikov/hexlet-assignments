package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    private final String tagName;
    private final Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }
    public String getTagName() {
        return tagName;
    }

    public String attributesToString() {
        var result = new StringBuilder();

        for (var entry : attributes.entrySet()) {
            result.append(" ")
                    .append(entry.getKey())
                    .append("=\"")
                    .append(entry.getValue())
                    .append("\"");
        }
        return result.toString();
    }
    @Override
    public abstract String toString();

}
// END
