package nl.tijsbeek.api.results.html.compiled.linter.errors.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class InvalidEnumValueAttributeError<A extends HTMLAttribute<?>> extends HTMLAttributeError<A> {
    private static final Logger logger = LoggerFactory.getLogger(InvalidEnumValueAttributeError.class);

    private final Class<? extends Enum<?>> enumClass;
    private final List<? extends Enum<?>> enumValues;
    private final String validValuesAsString;

    public InvalidEnumValueAttributeError(@NotNull final A attribute, @NotNull final Class<? extends Enum<?>> enumClass,
                                          @Nullable final String content) {
        super(attribute, content, "Invalid enum value, " + content);

        this.enumClass = enumClass;
        this.enumValues = List.of(enumClass.getEnumConstants());
        this.validValuesAsString = enumArrayToString(enumValues);
    }


    @NotNull
    private static String enumArrayToString(@NotNull final List<? extends Enum<?>> enumConstants) {
        Objects.requireNonNull(enumConstants, "The given enumValues cannot be null");

        StringBuilder stringBuilder = new StringBuilder(100);

        enumConstants.forEach(enumValue -> {
            stringBuilder.append(enumValue.name()).append(", ");
        });

        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }


    public List<? extends Enum<?>> getEnumValues() {
        return enumValues;
    }

    public String getValidValuesAsString() {
        return validValuesAsString;
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "InvalidEnumValueAttributeError{" +
                "enumClass=" + enumClass +
                ", enumValues=" + enumValues +
                ", validValuesAsString='" + validValuesAsString + '\'' +
                '}';
    }
}