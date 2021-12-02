package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledColsAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColsAttribute implements HTMLAttribute<CompiledColsAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(ColsAttribute.class);

    public static final String COLS_ATTRIBUTE_NAME = "cols";

    public static final int DEFAULT_VALUE = 20;

    @Override
    public @NotNull String name() {
        return COLS_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @Override
    public @NotNull CompiledColsAttribute compile(@Nullable final String content) {
        if (content == null) {
            return new CompiledColsAttribute(String.valueOf(DEFAULT_VALUE), DEFAULT_VALUE);
        }

        try {
            int charactersPerLine = Integer.parseInt(content);
            return new CompiledColsAttribute(content, charactersPerLine, true);
        } catch (final NumberFormatException ignore) {
            return new CompiledColsAttribute(content, 0, false);
        }
    }
}