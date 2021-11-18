package nl.tijsbeek.api.results.html.compiled.linter.errors;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLError {
    private static final Logger logger = LoggerFactory.getLogger(HTMLError.class);

    private final String value;
    private final String errorMessage;

    @Contract(pure = true)
    public HTMLError(@Nullable final String value, @Nullable final String message) {
        this.value = value;
        errorMessage = message;
    }

    @Nullable
    public String getValue() {
        return value;
    }

    @Nullable
    public String getErrorMessage() {
        return errorMessage;
    }

    @NonNls
    @Override
    @Contract(pure = true)
    public String toString() {
        return "ErrorHTML{" +
                "message='" + errorMessage + '\'' +
                '}';
    }
}