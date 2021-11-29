package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoCompleteAttribute;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoCompleteAttribute implements HTMLAttribute<CompiledAutoCompleteAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AutoCompleteAttribute.class);

    private static final String AUTO_COMPLETE_ATTRIBUTE_NAME = "autocomplete";

    @Override
    public @NotNull String name() {
        return AUTO_COMPLETE_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @Override
    public @NotNull CompiledAutoCompleteAttribute compile(@NotNull @NonNls String content) {
        return new CompiledAutoCompleteAttribute(content);
    }
}