package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.NotNull;

public interface CompiledHTMLAttribute<A extends HTMLAttribute<?>,
        E extends HTMLAttributeError<A>, W extends HTMLAttributeWarning<A>>
        extends CompiledHTML<E, W> {

    @NotNull A attribute();

    @NotNull
    String content();
}