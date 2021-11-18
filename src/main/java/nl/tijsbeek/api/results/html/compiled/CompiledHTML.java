package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLWarning;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.List;

public interface CompiledHTML<E extends HTMLError, W extends HTMLWarning> {

    boolean hasSuccessFullyCompiled();

    @NotNull
    @UnmodifiableView
    List<E> errors();

    boolean hasErrors();

    @NotNull
    @UnmodifiableView
    List<W> warnings();

    boolean hasWarnings();
}