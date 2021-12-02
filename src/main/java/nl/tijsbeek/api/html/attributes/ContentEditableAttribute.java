package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledContentEditableAttribute;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ContentEditableAttribute implements HTMLAttribute<CompiledContentEditableAttribute> {
    public static final ContentEditable DEFAULT_VALUE = ContentEditable.INHERIT;

    public static final String CONTENTEDITABLE_ATTRIBUTE_NAME = "contenteditable";

    @Override
    public @NotNull String name() {
        return CONTENTEDITABLE_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return false;
    }

    @Override
    public @NotNull CompiledContentEditableAttribute compile(@Nullable @NonNls final String content) {
        if (content == null) {
            return new CompiledContentEditableAttribute(ContentEditable.INHERIT, null);
        }

        return switch (content) {
            case "true" -> new CompiledContentEditableAttribute(ContentEditable.TRUE, content);
            case "false" -> new CompiledContentEditableAttribute(ContentEditable.FALSE, content);
            case "inherit" -> new CompiledContentEditableAttribute(ContentEditable.INHERIT, content);
            default -> {
                if (content.isEmpty()) {
                    yield new CompiledContentEditableAttribute(ContentEditable.INHERIT, content);
                }

                yield new CompiledContentEditableAttribute(null, content);
            }
        };
    }
}