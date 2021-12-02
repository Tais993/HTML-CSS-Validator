package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledControlsAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlsAttribute implements HTMLAttribute<CompiledControlsAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(ControlsAttribute.class);

    public static final String CONTROLS_ATTRIBUTE_NAME = "controls";

    @Override
    public @NotNull String name() {
        return CONTROLS_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return false;
    }

    @Override
    public @NotNull CompiledControlsAttribute compile(@Nullable final String content) {
        return new CompiledControlsAttribute(content);
    }
}