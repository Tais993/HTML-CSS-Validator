package nl.tijsbeek.api.results.html.compiled.linter.errors;

import nl.tijsbeek.api.html.HTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class HTMLAttributeError<A extends HTMLAttribute<?>> extends HTMLError {
    private static final Logger logger = LoggerFactory.getLogger(HTMLAttributeError.class);

    private final A attribute;
    private final String message;

    public HTMLAttributeError(@NotNull final A attribute, final @Nullable String value, final @Nullable String errorMessage) {
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
    public String toString() {
        return "ErrorHTMLAttribute{" +
                "attribute=" + attribute +
                ", message='" + message + '\'' +
                '}';
    }
}