package nl.tijsbeek.api.results.html;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;

public interface DefaultCompiledHTMLAttribute<A extends HTMLAttribute<?>>
        extends CompiledHTMLAttribute<A, HTMLAttributeError<A>, HTMLAttributeWarning<A>> {
}