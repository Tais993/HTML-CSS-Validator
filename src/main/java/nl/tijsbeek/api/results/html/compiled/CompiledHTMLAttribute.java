package nl.tijsbeek.api.results.html.compiled;

import org.jetbrains.annotations.NotNull;

public interface CompiledHTMLAttribute<T> extends CompiledHTML {

    @NotNull T attribute();

    @NotNull String content();
}