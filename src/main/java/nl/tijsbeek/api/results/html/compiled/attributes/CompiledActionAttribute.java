package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ActionAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.ActionAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CompiledActionAttribute
        implements CompiledHTMLAttribute<ActionAttribute, HTMLAttributeError<ActionAttribute>,
        ActionAttributeWarning> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledActionAttribute.class);
    private final boolean success;
    private final @NotNull String content;

    private final List<HTMLAttributeError<ActionAttribute>> errors;
    private final List<ActionAttributeWarning> warnings;

    public CompiledActionAttribute(final boolean success, @NotNull final String content) {
        this.success = success;
        this.content = Objects.requireNonNull(content, "The given content cannot be null");

        errors = Collections.emptyList();

        if (success) {
            warnings = Collections.emptyList();
        } else {
            warnings = Collections.singletonList(new ActionAttributeWarning(content));
        }
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public ActionAttribute attribute() {
        return new ActionAttribute();
    }


    @NotNull
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public List<HTMLAttributeError<ActionAttribute>> errors() {
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
    public List<ActionAttributeWarning> warnings() {
        return warnings;
    }

    @Override
    @Contract(pure = true)
    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

    @Override
    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {return success;}

    @NotNull
    @Override
    @Contract(pure = true)
    public String content() {return content;}

    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        var that = (CompiledActionAttribute) obj;
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