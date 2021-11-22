package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoCapitalizeAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AutoCapitalizeAttribute implements HTMLAttribute<CompiledAutoCapitalizeAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AutoCapitalizeAttribute.class);

    private static final String AUTO_CAPITALIZE_ATTRIBUTE_NAME = "autocapitalize";

    @Override
    public @NotNull String name() {
        return AUTO_CAPITALIZE_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @NotNull
    @Override
    public CompiledAutoCapitalizeAttribute compile(@NotNull String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        AutoCapitalize autoCapitalize = AutoCapitalize.fromHTMLName(content);

        return new CompiledAutoCapitalizeAttribute(autoCapitalize, content);
    }
}