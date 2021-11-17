package nl.tijsbeek.api.html;

import org.jetbrains.annotations.NotNull;

public interface HTMLAttribute<T> {

    @NotNull String name();

    @NotNull T compile(@NotNull final String content);
}