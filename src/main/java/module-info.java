module HTML.CSS.Validator.main {
    requires org.jetbrains.annotations;
    requires org.slf4j;

    exports nl.tijsbeek.api.html;
    exports nl.tijsbeek.api.html.attributes;
    exports nl.tijsbeek.api.validator;
    exports nl.tijsbeek.api.results.html.compiled;
    exports nl.tijsbeek.api.results.html.compiled.attributes;
    exports nl.tijsbeek.api.results.html.compiled.linter.errors;
    exports nl.tijsbeek.api.results.html.compiled.linter.errors.attributes;
    exports nl.tijsbeek.api.results.html.compiled.linter.warnings;
    exports nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;
    exports nl.tijsbeek.api.results.html.compiler;
}