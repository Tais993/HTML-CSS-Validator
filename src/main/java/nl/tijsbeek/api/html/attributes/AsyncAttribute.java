package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAsyncAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncAttribute implements HTMLAttribute<CompiledAsyncAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AsyncAttribute.class);

    public static final String ASYNC_ATTRIBUTE_NAME = "async";

    @Override
    public @NotNull String name() {
        return ASYNC_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return false;
    }

    @Override
    public @NotNull CompiledAsyncAttribute compile(@Nullable final String content) {
        return new CompiledAsyncAttribute(content);
    }
}