package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AccessKeyAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.AccessKeyAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public final class CompiledAccessKeyAttribute
        implements CompiledHTMLAttribute<AccessKeyAttribute, AccessKeyAttributeError,
        HTMLAttributeWarning<AccessKeyAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAccessKeyAttribute.class);
    private final boolean success;
    private final @NotNull String content;
    private final @Nullable AccessKeyAttributeError errors;
    private final @Nullable HTMLAttributeWarning<AccessKeyAttribute> warnings;


    public CompiledAccessKeyAttribute(final boolean success, @NotNull final String content) {
        this.success = success;
        this.content = content;

        if (success) {
            errors = null;
        } else {
            errors = new AccessKeyAttributeError(content);
        }

        warnings = null;
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AccessKeyAttribute attribute() {
        return new AccessKeyAttribute();
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public AccessKeyAttributeError errors() {
        return errors;
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public HTMLAttributeWarning<AccessKeyAttribute> warnings() {
        return warnings;
    }


    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {return success;}

    @NotNull
    @Contract(pure = true)
    public String contentAsString() {return content;}

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        var that = (CompiledAccessKeyAttribute) obj;
        return success == that.success &&
                Objects.equals(content, that.content) &&
                Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, content, errors);
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledAccessKeyAttribute{" +
                "success=" + success +
                ", content='" + content + '\'' +
                ", errors=" + errors +
                ", warnings=" + warnings +
                '}';
    }
}