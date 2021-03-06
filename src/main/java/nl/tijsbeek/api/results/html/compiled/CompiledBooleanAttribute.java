package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.BooleanAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CompiledBooleanAttribute<A extends HTMLAttribute<?>>
        implements CompiledHTMLAttribute<A, HTMLAttributeError<A>, BooleanAttributeWarning<A>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledBooleanAttribute.class);

    private final String value;
    private final @Nullable BooleanAttributeWarning<A> warnings;

    @Contract(pure = true)
    protected CompiledBooleanAttribute(final A attribute, final @Nullable String value) {
        this.value = value;

        if (value == null || value.isEmpty()) {
            warnings = null;
        } else {
            warnings = new BooleanAttributeWarning<>(attribute, value);
        }
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Nullable
    @Override
    public HTMLAttributeError<A> errors() {
        return null;
    }

    @Nullable
    @Override
    public BooleanAttributeWarning<A> warnings() {
        return warnings;
    }

    @Nullable
    @Override
    public String contentAsString() {
        return value;
    }

    public boolean isTrue() {
        return true;
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "CompiledBooleanAttribute{" +
                "value='" + value + '\'' +
                ", warnings=" + warnings +
                '}';
    }
}