package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AccessKeyAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.AccessKeyAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CompiledAccessKeyAttribute
        implements CompiledHTMLAttribute<AccessKeyAttribute, AccessKeyAttributeError,
        HTMLAttributeWarning<AccessKeyAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAccessKeyAttribute.class);
    private final boolean success;
    private final @NotNull String content;
    private final List<AccessKeyAttributeError> errors;
    private final List<HTMLAttributeWarning<AccessKeyAttribute>> warnings;


    public CompiledAccessKeyAttribute(final boolean success, @NotNull final String content) {
        this(success, content, null);
    }

    public CompiledAccessKeyAttribute(final boolean success,
                                      @NotNull final String content,
                                      final List<AccessKeyAttributeError> errors) {
        this.success = success;
        this.content = content;

        if (errors == null) {
            if (success) {
                this.errors = Collections.emptyList();
            } else {
                this.errors = Collections.singletonList(new AccessKeyAttributeError(content));
            }
        } else {
            this.errors = new ArrayList<>(errors);
        }

        warnings = Collections.emptyList();
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AccessKeyAttribute attribute() {
        return new AccessKeyAttribute();
    }

    @NotNull
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public List<AccessKeyAttributeError> errors() {
        return Collections.unmodifiableList(errors);
    }

    @Override
    @Contract(pure = true)
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @NotNull
    @Override
    @Unmodifiable
    @Contract(pure = true)
    public List<HTMLAttributeWarning<AccessKeyAttribute>> warnings() {
        return warnings;
    }

    @Override
    @Contract(pure = true)
    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {return success;}

    @Contract(pure = true)
    public @NotNull String content() {return content;}

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CompiledAccessKeyAttribute) obj;
        return this.success == that.success &&
                Objects.equals(this.content, that.content) &&
                Objects.equals(this.errors, that.errors);
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