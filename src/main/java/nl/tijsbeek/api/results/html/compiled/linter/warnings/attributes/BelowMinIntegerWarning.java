package nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BelowMinIntegerWarning<A extends HTMLAttribute<?>> extends HTMLAttributeWarning<A> {
    private static final Logger logger = LoggerFactory.getLogger(BelowMinIntegerWarning.class);

    private final int minAllowed;

    @Contract(pure = true)
    public BelowMinIntegerWarning(@NotNull final A attribute, final int value, final int minAllowed) {
        super(attribute, String.valueOf(value), "Integer is below the min value of " + minAllowed);
        this.minAllowed = minAllowed;
    }

    @Contract(pure = true)
    public int getMinAllowed() {
        return minAllowed;
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "BelowMinIntegerWarning{" +
                "minAllowed=" + minAllowed +
                '}';
    }
}