package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.html.HTMLAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CompiledHTMLAttribute<A extends HTMLAttribute<?>, E, W>
        extends CompiledHTML<E, W> {

    default void throwIfNoSuccess() {
        if (hasSuccessFullyCompiled()) {
            throw new IllegalStateException("Compile wasn't successfull");
        }
    }


    @NotNull A attribute();

    @Nullable
    String contentAsString();
}