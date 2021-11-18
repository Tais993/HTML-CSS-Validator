package nl.tijsbeek.api.html;

import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.NotNull;

public interface HTMLAttribute<T extends CompiledHTMLAttribute<?, ?, ?>> {

    @NotNull
    String name();

    boolean requiresValue();

    @NotNull
    T compile(final String content);
}