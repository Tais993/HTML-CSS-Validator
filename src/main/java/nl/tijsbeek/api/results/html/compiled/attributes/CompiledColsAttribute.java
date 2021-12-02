package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ColsAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidIntegerAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.NegativeIntegerAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CompiledColsAttribute implements CompiledHTMLAttribute<ColsAttribute,
        HTMLAttributeError<ColsAttribute>, HTMLAttributeWarning<ColsAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledColsAttribute.class);

    private static final ColsAttribute COLS_ATTRIBUTE_INSTANCE = new ColsAttribute();

    private final String content;
    private final int cols;

    private HTMLAttributeError<ColsAttribute> error;


    @Contract(pure = true)
    public CompiledColsAttribute(@NotNull final String content, final int cols) {
        this.content = Objects.requireNonNull(content, "The given content cannot be null");
        this.cols = cols;
    }

    @Contract(pure = true)
    public CompiledColsAttribute(@NotNull final String content, final int cols, final boolean validNumber) {
        this.content = Objects.requireNonNull(content, "The given content cannot be null");

        if (!validNumber) {
            this.cols = ColsAttribute.DEFAULT_VALUE;
            this.error = new InvalidIntegerAttributeError<>(COLS_ATTRIBUTE_INSTANCE, content);
        } else if (cols < 0) {
            this.cols = ColsAttribute.DEFAULT_VALUE;
            this.error = new NegativeIntegerAttributeError<>(COLS_ATTRIBUTE_INSTANCE, content);
        } else {
            this.cols = cols;
        }
    }

    public int getCols() {
        return cols;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Override
    public @Nullable HTMLAttributeError<ColsAttribute> errors() {
        return error;
    }

    @Override
    public @Nullable HTMLAttributeWarning<ColsAttribute> warnings() {
        return null;
    }

    @Override
    public @NotNull ColsAttribute attribute() {
        return COLS_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }
}