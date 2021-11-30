package nl.tijsbeek.api.html.attributes;

import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

public enum Capture {
    USER("user", "The user-facing camera and/or microphone should be used."),
    ENVIRONMENT("environment", "The outward-facing camera and/or microphone should be used");

    @NotNull
    public static Capture getByHTMLValue(@Language(value = "HTML", prefix = "<input capture=\"", suffix = "\">")
                                         @NotNull final String htmlValue) {
        Objects.requireNonNull(htmlValue, "The given htmlValue cannot be null");

        @NonNls String formattedValue = htmlValue.toLowerCase(Locale.ROOT).trim();

        for (final Capture capture : Capture.values()) {
            if (capture.getValue().equals(formattedValue)) {
                return capture;
            }
        }

        throw new IllegalArgumentException("Invalid HTML value");
    }

    private final String value;
    private final String description;

    @Contract(pure = true)
    Capture(final @NotNull String value, final @NotNull String description) {
        this.value = Objects.requireNonNull(value, "The given value cannot be null");
        this.description = Objects.requireNonNull(description, "The given description cannot be null");
    }

    @NotNull
    @Contract(pure = true)
    public String getValue() {
        return value;
    }

    @NotNull
    @Contract(pure = true)
    public String getDescription() {
        return description;
    }
}