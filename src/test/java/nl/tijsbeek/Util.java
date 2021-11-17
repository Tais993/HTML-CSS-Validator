package nl.tijsbeek;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Util {
    ;

    public static <T> String listToString(@NotNull final Collection<T> list, final String separator) {
        Objects.requireNonNull(list, "The given list cannot be null");

        return list.stream()
                .map(object -> object.toString() + separator)
                .collect(Collectors.joining());
    }
}