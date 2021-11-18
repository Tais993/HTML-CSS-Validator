package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAltAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AltAttribute implements HTMLAttribute<CompiledAltAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AltAttribute.class);

    public static final String ALT_ATTRIBUTE_NAME = "alt";

    @NotNull
    @Override
    public String name() {
        return ALT_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @NotNull
    @Override
    public CompiledAltAttribute compile(@NotNull final String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        return new CompiledAltAttribute(true, content);
    }
}