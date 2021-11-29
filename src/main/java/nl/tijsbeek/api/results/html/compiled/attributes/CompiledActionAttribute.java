package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ActionAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.ActionAttributeWarning;
import org.jetbrains.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Objects;

public final class CompiledActionAttribute
        implements CompiledHTMLAttribute<ActionAttribute, HTMLAttributeError<ActionAttribute>,
        ActionAttributeWarning> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledActionAttribute.class);
    private final boolean success;
    private final String content;
    private final URL url;

    private final @Nullable HTMLAttributeError<ActionAttribute> errors;
    private final @Nullable ActionAttributeWarning warnings;

    public CompiledActionAttribute(final boolean success, @NotNull final String content, @Nullable final URL url) {
        this.success = success;
        this.url = url;
        this.content = Objects.requireNonNull(content, "The given content cannot be null");

        errors = null;

        if (success) {
            warnings = null;
        } else {
            warnings = new ActionAttributeWarning(content);
        }
    }


    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public ActionAttribute attribute() {
        return new ActionAttribute();
    }


    @Nullable
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public HTMLAttributeError<ActionAttribute> errors() {
        return errors;
    }

    @Nullable
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public ActionAttributeWarning warnings() {
        return warnings;
    }


    @Override
    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {
        return success;
    }

    @NotNull
    @Override
    @Contract(pure = true)
    public String contentAsString() {
        return content;
    }

    @NotNull
    @Contract(pure = true)
    public URL getUrl() {
        throwIfNoSuccess();
        return url;
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        CompiledActionAttribute that = (CompiledActionAttribute) obj;
        return success == that.success &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, content);
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledActionAttribute{" +
                "success=" + success +
                ", content='" + content + '\'' +
                ", errors=" + errors +
                ", warnings=" + warnings +
                '}';
    }
}