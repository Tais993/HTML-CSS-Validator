package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoCompleteAttribute;
import org.jetbrains.annotations.NotNull;

public class AutoCompleteAttribute implements HTMLAttribute<CompiledAutoCompleteAttribute> {
    @Override
    public @NotNull String name() {
        return null;
    }

    @Override
    public boolean requiresValue() {
        return false;
    }

    @Override
    public @NotNull CompiledAutoCompleteAttribute compile(String content) {
        return null;
    }
}