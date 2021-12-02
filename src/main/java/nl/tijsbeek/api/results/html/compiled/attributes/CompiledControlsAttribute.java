package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ControlsAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledControlsAttribute extends CompiledBooleanAttribute<ControlsAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledControlsAttribute.class);

    public static final ControlsAttribute CONTROLS_ATTRIBUTE_INSTANCE = new ControlsAttribute();

    public CompiledControlsAttribute(@Nullable final String value) {
        super(CONTROLS_ATTRIBUTE_INSTANCE, value);
    }

    @Override
    public @NotNull ControlsAttribute attribute() {
        return CONTROLS_ATTRIBUTE_INSTANCE;
    }

    public boolean hasControls() {
        return isTrue();
    }
}