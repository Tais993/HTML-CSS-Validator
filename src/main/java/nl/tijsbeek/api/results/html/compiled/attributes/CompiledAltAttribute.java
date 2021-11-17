package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AltAttribute;
import nl.tijsbeek.api.results.html.DefaultCompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CompiledAltAttribute
        implements DefaultCompiledHTMLAttribute<AltAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAltAttribute.class);
    private final boolean success;
    private final @NotNull String content;

    private final List<HTMLAttributeError<AltAttribute>> errors;
    private final List<HTMLAttributeWarning<AltAttribute>> warnings;

    public CompiledAltAttribute(final boolean success,
                                @NotNull final String content) {
        this.success = success;
        this.content = content;

        errors = Collections.emptyList();
        warnings = Collections.emptyList();
    }

    @Override
    @Contract(pure = true)
    public @NotNull AltAttribute attribute() {
        return new AltAttribute();
    }

    @NotNull
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public List<HTMLAttributeError<AltAttribute>> errors() {
        return errors;
    }

    @Override
    @Contract(pure = true)
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @NotNull
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public List<HTMLAttributeWarning<AltAttribute>> warnings() {
        return warnings;
    }

    @Override
    @Contract(pure = true)
    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

    @Contract(pure = true)
    public boolean success() {return success;}

    @Contract(pure = true)
    public @NotNull String content() {return content;}

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CompiledAltAttribute) obj;
        return this.success == that.success &&
                Objects.equals(this.content, that.content);
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