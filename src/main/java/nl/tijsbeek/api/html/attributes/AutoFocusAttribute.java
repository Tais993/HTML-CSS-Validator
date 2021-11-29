package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoFocusAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoFocusAttribute implements HTMLAttribute<CompiledAutoFocusAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AutoFocusAttribute.class);

    private static final String AUTO_FOCUS_ATTRIBUTE_NAME = "auto_focus";

    @Override
    public @NotNull String name() {
        return AUTO_FOCUS_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return false;
    }

    @Override
    public @NotNull CompiledAutoFocusAttribute compile(@Nullable final String content) {

        if (content == null) {
            return new CompiledAutoFocusAttribute(true, null);
        }

        boolean isAsync = content.isEmpty();

        return new CompiledAutoFocusAttribute(isAsync, content);
    }
}