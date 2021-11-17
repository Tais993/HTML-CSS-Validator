package nl.tijsbeek.api.results.html.compiled.errors;

import nl.tijsbeek.api.html.HTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ErrorHTMLAttribute<T> extends ErrorHTML {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHTMLAttribute.class);

    private final HTMLAttribute<T> attribute;
    private final String message;

    public ErrorHTMLAttribute(@NotNull final HTMLAttribute<T> attribute, final @Nullable String message) {
        super(message);

        Objects.requireNonNull(attribute, "The given attribute cannot be null");

        this.attribute = attribute;
        this.message = message;
    }

    public @NotNull HTMLAttribute<T> getAttribute() {
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