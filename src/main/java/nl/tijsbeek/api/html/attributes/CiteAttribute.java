package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledCiteAttribute;
import org.jetbrains.annotations.NotNull;

public class CiteAttribute implements HTMLAttribute<CompiledCiteAttribute> {
    public static final String CITE_ATTRIBUTE_NAME = "cite";

    @Override
    public @NotNull String name() {
        return CITE_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @Override
    public @NotNull CompiledCiteAttribute compile(@NotNull final String content) {
        return new CompiledCiteAttribute(content);
    }
}