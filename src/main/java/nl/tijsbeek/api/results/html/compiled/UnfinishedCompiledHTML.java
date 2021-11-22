package nl.tijsbeek.api.results.html.compiled;

import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class UnfinishedCompiledHTML<E extends HTMLError, W extends HTMLWarning>
        implements CompiledHTML<E, W> {
    private static final Logger logger = LoggerFactory.getLogger(UnfinishedCompiledHTML.class);

    @NotNull
    @Override
    @Unmodifiable
    @Contract(pure = true)
    public E errors() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    @Contract(pure = true)
    public boolean hasErrors() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @NotNull
    @Override
    @Unmodifiable
    @Contract(pure = true)
    public W warnings() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    @Contract(pure = true)
    public boolean hasWarnings() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}