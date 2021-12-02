package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledColSpanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ColSpanAttribute implements HTMLAttribute<CompiledColSpanAttribute> {
    public static final String COLSPAN_ATTRIBUTE_NAME = "colspan";

    public static final int DEFAULT_VALUE = 1;
    public static final int MAX_VALUE = 1000;
    public static final int MIN_VALUE = 1;

    @Override
    public @NotNull String name() {
        return COLSPAN_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @Override
    public @NotNull CompiledColSpanAttribute compile(@Nullable final String content) {

        if (content == null) {
            return new CompiledColSpanAttribute(String.valueOf(DEFAULT_VALUE), DEFAULT_VALUE);
        }

        try {
            int columnsCallSpans = Integer.parseInt(content);
            return new CompiledColSpanAttribute(content, columnsCallSpans, true);
        } catch (final NumberFormatException ignore) {
            return new CompiledColSpanAttribute(content, 0, false);
        }
    }
}