package nl.tijsbeek.api.html.attributes;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.Objects;

public enum AutoCapitalize {
    DEFAULT,
    OFF,
    NONE,
    ON,
    SENTENCES,
    WORDS,
    CHARACTERS;

    @Nullable
    @Contract(pure = true)
    public static AutoCapitalize fromHTMLName(@Nullable String name) {
        if (name == null) {
            return SENTENCES;
        }

        return switch (name.toUpperCase(Locale.ROOT).trim()) {
            case "OFF" -> OFF;
            case "NONE" -> NONE;
            case "ON" -> ON;
            case "SENTENCES" -> SENTENCES;
            case "WORDS" -> WORDS;
            case "CHARACTERS" -> CHARACTERS;
            case "" -> DEFAULT;
            default -> null;
        };
    }

    public static boolean isValidHTMLName(@NotNull String name) {
        Objects.requireNonNull(name, "The given name cannot be null");

        return switch (name.toUpperCase(Locale.ROOT)) {
            case "OFF", "CHARACTERS", "WORDS", "SENTENCES", "ON", "NONE", "" -> true;
            default -> false;
        };
    }
}