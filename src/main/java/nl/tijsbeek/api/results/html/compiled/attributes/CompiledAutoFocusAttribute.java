package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoFocusAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompiledAutoFocusAttribute extends CompiledBooleanAttribute<AutoFocusAttribute> {
    private final static AutoFocusAttribute AUTO_FOCUS_ATTRIBUTE = new AutoFocusAttribute();

    private final boolean shouldAutoFocus;
    private final String content;

    public CompiledAutoFocusAttribute(boolean shouldAutoFocus, String content) {
        super(AUTO_FOCUS_ATTRIBUTE, shouldAutoFocus, content);
        this.shouldAutoFocus = shouldAutoFocus;
        this.content = content;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Override
    public @NotNull AutoFocusAttribute attribute() {
        return AUTO_FOCUS_ATTRIBUTE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }

    public boolean shouldAutoFocus() {
        return shouldAutoFocus;
    }
}