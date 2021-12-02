package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledCheckedAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckedAttribute implements HTMLAttribute<CompiledCheckedAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CheckedAttribute.class);

    public static final String CHECKED_ATTRIBUTE_NAME = "checked";

    @Override
    public @NotNull String name() {
        return CHECKED_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return false;
    }

    @Override
    public @NotNull CompiledCheckedAttribute compile(@Nullable final String content) {
        return new CompiledCheckedAttribute(content);
    }
}