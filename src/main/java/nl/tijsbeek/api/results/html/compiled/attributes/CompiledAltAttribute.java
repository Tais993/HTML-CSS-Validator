package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AltAttribute;
import nl.tijsbeek.api.results.html.DefaultCompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public final class CompiledAltAttribute
        implements DefaultCompiledHTMLAttribute<AltAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAltAttribute.class);
    private final boolean success;
    private final @NotNull String content;

    private final @Nullable HTMLAttributeError<AltAttribute> errors;
    private final @Nullable HTMLAttributeWarning<AltAttribute> warnings;

    public CompiledAltAttribute(final boolean success,
                                @NotNull final String content) {
        this.success = success;
        this.content = content;

        errors = null;
        warnings = null;
    }

    @Override
    @Contract(pure = true)
    public @NotNull AltAttribute attribute() {
        return new AltAttribute();
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public HTMLAttributeError<AltAttribute> errors() {
        return errors;
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public HTMLAttributeWarning<AltAttribute> warnings() {
        return warnings;
    }


    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {
        return success;
    }

    @Contract(pure = true)
    public @NotNull String contentAsString() {
        return content;
    }

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        CompiledAltAttribute that = (CompiledAltAttribute) obj;
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
        return "CompiledAltAttribute[" +
                "success=" + success + ", " +
                "content=" + content + ']';
    }

}