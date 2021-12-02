package nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AboveMaxIntegerWarning<A extends HTMLAttribute<?>> extends HTMLAttributeWarning<A> {
    private static final Logger logger = LoggerFactory.getLogger(AboveMaxIntegerWarning.class);

    private final int maxAllowed;

    @Contract(pure = true)
    public AboveMaxIntegerWarning(@NotNull final A attribute, final int value, final int maxAllowed) {
        super(attribute, String.valueOf(value), "Integer is above the max value of " + maxAllowed);
        this.maxAllowed = maxAllowed;
    }

    @Contract(pure = true)
    public int getMaxAllowed() {
        return maxAllowed;
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "AboveMaxIntegerWarning{" +
                "maxAllowed=" + maxAllowed +
                '}';
    }
}