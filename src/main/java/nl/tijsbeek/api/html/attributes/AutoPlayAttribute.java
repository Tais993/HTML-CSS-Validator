package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoPlayAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoPlayAttribute implements HTMLAttribute<CompiledAutoPlayAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AutoPlayAttribute.class);

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
    public @NotNull CompiledAutoPlayAttribute compile(@Nullable final String content) {

        if (content == null) {
            return new CompiledAutoPlayAttribute(true, null);
        }

        boolean isAutoPlay = content.isEmpty();

        return new CompiledAutoPlayAttribute(isAutoPlay, content);
    }
}