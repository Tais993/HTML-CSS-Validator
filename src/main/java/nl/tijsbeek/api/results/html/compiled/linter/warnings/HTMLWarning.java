package nl.tijsbeek.api.results.html.compiled.linter.warnings;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HTMLWarning {
    private static final Logger logger = LoggerFactory.getLogger(HTMLWarning.class);

    private final String value;
    private final String errorMessage;

    @Contract(pure = true)
    public HTMLWarning(@Nullable final String value, @Nullable final String message) {
        this.value = value;
        this.errorMessage = message;
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
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "HTMLWarning{" +
                "value='" + value + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}