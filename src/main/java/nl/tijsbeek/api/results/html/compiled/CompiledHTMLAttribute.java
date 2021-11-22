package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CompiledHTMLAttribute<A extends HTMLAttribute<?>,
        E extends HTMLAttributeError<A>, W extends HTMLAttributeWarning<A>>
        extends CompiledHTML<E, W> {

    default void throwIfNoSuccess() {
        if (hasSuccessFullyCompiled()) {
            throw new IllegalStateException("Compile wasn't successfull");
        }
    }


    @NotNull A attribute();

    @Nullable
    String contentAsString();


    @Override
    default boolean hasWarnings() {
        return !warnings().isEmpty();
    }

    @Override
    default boolean hasErrors() {
        return !errors().isEmpty();
    }
}