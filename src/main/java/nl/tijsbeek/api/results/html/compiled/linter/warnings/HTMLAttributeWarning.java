package nl.tijsbeek.api.results.html.compiled.linter.warnings;

import nl.tijsbeek.api.html.HTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class HTMLAttributeWarning<A extends HTMLAttribute<?>> extends HTMLWarning {

    private static final Logger logger = LoggerFactory.getLogger(HTMLAttributeWarning.class);

    private final A attribute;
    private final String message;

    public HTMLAttributeWarning(@NotNull final A attribute, final @Nullable String value, final @Nullable String errorMessage) {
        super(value, errorMessage);

        Objects.requireNonNull(attribute, "The given attribute cannot be null");

        this.attribute = attribute;
        this.message = errorMessage;
    }

    public @NotNull A getAttribute() {
        return attribute;
    }

    @NonNls
    @Override
    @Contract(pure = true)
    public @NotNull String toString() {
        return "HTMLAttributeWarning{" +
                "attribute=" + attribute +
                ", message='" + message + '\'' +
                '}';
    }
}