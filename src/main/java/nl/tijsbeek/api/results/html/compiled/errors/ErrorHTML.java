package nl.tijsbeek.api.results.html.compiled.errors;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHTML {
    private static final Logger logger = LoggerFactory.getLogger(ErrorHTML.class);

    private final String message;

    @Contract(pure = true)
    public ErrorHTML(@Nullable final String message) {
        this.message = message;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    @NonNls
    @Override
    @Contract(pure = true)
    public String toString() {
        return "ErrorHTML{" +
                "message='" + message + '\'' +
                '}';
    }
}