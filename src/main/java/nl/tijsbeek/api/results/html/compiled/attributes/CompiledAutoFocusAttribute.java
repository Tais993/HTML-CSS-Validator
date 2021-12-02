package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoFocusAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledAutoFocusAttribute extends CompiledBooleanAttribute<AutoFocusAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAutoFocusAttribute.class);

    private static final AutoFocusAttribute AUTO_FOCUS_ATTRIBUTE = new AutoFocusAttribute();

    private final String content;

    public CompiledAutoFocusAttribute(@Nullable final String content) {
        super(AUTO_FOCUS_ATTRIBUTE, content);
        this.content = content;
    }

    @Override
    public @NotNull AutoFocusAttribute attribute() {
        return AUTO_FOCUS_ATTRIBUTE;
    }

    public boolean shouldAutoFocus() {
        return isTrue();
    }
}