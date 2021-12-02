package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ColSpanAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidIntegerAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.AboveMaxIntegerWarning;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.BelowMinIntegerWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static nl.tijsbeek.api.html.attributes.ColSpanAttribute.MAX_VALUE;
import static nl.tijsbeek.api.html.attributes.ColSpanAttribute.MIN_VALUE;
import static nl.tijsbeek.api.html.attributes.ColsAttribute.DEFAULT_VALUE;

public class CompiledColSpanAttribute implements CompiledHTMLAttribute<ColSpanAttribute,
        InvalidIntegerAttributeError<ColSpanAttribute>, HTMLAttributeWarning<ColSpanAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledColSpanAttribute.class);

    public static final ColSpanAttribute COLSPAN_ATTRIBUTE_INSTANCE = new ColSpanAttribute();

    private final String content;
    private final int colspan;

    private final @Nullable InvalidIntegerAttributeError<ColSpanAttribute> error;
    private final @Nullable HTMLAttributeWarning<ColSpanAttribute> warning;

    @Contract(pure = true)
    public CompiledColSpanAttribute(@NotNull final String content, final int colspan) {
        this.content = Objects.requireNonNull(content, "The given content cannot be null");
        this.colspan = colspan;
        this.error = null;
        this.warning = null;
    }

    @Contract(pure = true)
    public CompiledColSpanAttribute(@NotNull final String content, final int colspan, final boolean validNumber) {
        this.content = Objects.requireNonNull(content, "The given content cannot be null");

        if (!validNumber) {
            this.colspan = DEFAULT_VALUE;
            this.error = new InvalidIntegerAttributeError<>(COLSPAN_ATTRIBUTE_INSTANCE, content);
            this.warning = null;
            return;
        }


        if (colspan < 1) {
            this.colspan = DEFAULT_VALUE;
            this.warning = new BelowMinIntegerWarning<ColSpanAttribute>(COLSPAN_ATTRIBUTE_INSTANCE, colspan, MIN_VALUE);
        } else if (colspan > MAX_VALUE) {
            this.colspan = MAX_VALUE;
            this.warning = new AboveMaxIntegerWarning<>(COLSPAN_ATTRIBUTE_INSTANCE, colspan, MAX_VALUE);
        } else {
            this.colspan = colspan;
            this.warning = null;
        }

        this.error = null;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Nullable
    @Override
    public InvalidIntegerAttributeError<ColSpanAttribute> errors() {
        return error;
    }

    @Nullable
    @Override
    public HTMLAttributeWarning<ColSpanAttribute> warnings() {
        return warning;
    }

    @Override
    public @NotNull ColSpanAttribute attribute() {
        return COLSPAN_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "CompiledColSpanAttribute{" +
                "content='" + content + '\'' +
                ", colspan=" + colspan +
                ", error=" + error +
                ", warning=" + warning +
                '}';
    }
}