package nl.tijsbeek.api.results.html.compiled;

import java.util.Collection;

public interface CompiledHTML<E, W> {

    boolean hasSuccessFullyCompiled();

    E errors();

    default boolean hasErrors() {
        Object errors = errors();

        if (errors == null) {
            return false;
        } else if (errors instanceof Collection<?> errorsCollection) {
            return !errorsCollection.isEmpty();
        }

        return true;
    }

    W warnings();

    default boolean hasWarnings() {
        Object warnings = warnings();

        if (warnings == null) {
            return false;
        } else if (warnings instanceof Collection<?> warningsCollection) {
            return !warningsCollection.isEmpty();
        }

        return true;
    }
}