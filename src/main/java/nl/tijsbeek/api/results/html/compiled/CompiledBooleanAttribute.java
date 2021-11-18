package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.BooleanAttributeWarning;
import org.jetbrains.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public abstract class CompiledBooleanAttribute<A extends HTMLAttribute<?>>
        implements CompiledHTMLAttribute<A, HTMLAttributeError<A>, BooleanAttributeWarning<A>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledBooleanAttribute.class);

    private final List<HTMLAttributeError<A>> errors;
    private final List<BooleanAttributeWarning<A>> warnings;

    @Contract(pure = true)
    protected CompiledBooleanAttribute(final A attribute, final boolean success, final @Nullable String value) {
        errors = Collections.emptyList();

        if (success) {
            warnings = Collections.emptyList();
        } else {
            warnings = Collections.singletonList(new BooleanAttributeWarning<>(attribute, value));
        }
    }

    @NotNull
    @UnmodifiableView
    public List<HTMLAttributeError<A>> errors() {
        return errors;
    }

    @Override
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    @NotNull
    @Override
    @UnmodifiableView
    public List<BooleanAttributeWarning<A>> warnings() {
        return warnings;
    }

    @Override
    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "CompiledBooleanAttribute{" +
                "errors=" + errors +
                ", warnings=" + warnings +
                '}';
    }
}