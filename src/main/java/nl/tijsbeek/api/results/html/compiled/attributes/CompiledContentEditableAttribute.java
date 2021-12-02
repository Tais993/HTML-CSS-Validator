package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ContentEditable;
import nl.tijsbeek.api.html.attributes.ContentEditableAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidEnumValueAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.EmptyAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CompiledContentEditableAttribute implements CompiledHTMLAttribute<ContentEditableAttribute,
        InvalidEnumValueAttributeError<ContentEditableAttribute>, HTMLAttributeWarning<ContentEditableAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledContentEditableAttribute.class);

    private static final ContentEditableAttribute CONTENT_EDITABLE_ATTRIBUTE = new ContentEditableAttribute();

    private final String content;
    private final ContentEditable contentEditable;

    private final @Nullable InvalidEnumValueAttributeError<ContentEditableAttribute> error;
    private final @Nullable HTMLAttributeWarning<ContentEditableAttribute> warning;

    @Contract(pure = true)
    public CompiledContentEditableAttribute(@Nullable final ContentEditable contentEditable, @Nullable final String content) {
        if (contentEditable == null) {
            this.error = new InvalidEnumValueAttributeError<>(
                    CONTENT_EDITABLE_ATTRIBUTE, ContentEditable.class, content);

            this.contentEditable = ContentEditableAttribute.DEFAULT_VALUE;
        } else {
            this.error = null;
            this.contentEditable = contentEditable;
        }

        if (content == null || content.isEmpty()) {
            this.warning = new EmptyAttributeWarning<>(CONTENT_EDITABLE_ATTRIBUTE);
        } else {
            this.warning = null;
        }

        this.content = content;
    }

    @Contract(pure = true)
    public ContentEditable getContentEditable() {
        return contentEditable;
    }

    @Override
    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public InvalidEnumValueAttributeError<ContentEditableAttribute> errors() {
        return error;
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public HTMLAttributeWarning<ContentEditableAttribute> warnings() {
        return warning;
    }

    @Override
    @Contract(pure = true)
    public @NotNull ContentEditableAttribute attribute() {
        return CONTENT_EDITABLE_ATTRIBUTE;
    }

    @Override
    @Contract(pure = true)
    public @Nullable String contentAsString() {
        return null;
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledContentEditableAttribute{" +
                "contentEditable=" + contentEditable +
                '}';
    }
}