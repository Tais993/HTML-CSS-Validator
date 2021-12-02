package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AsyncAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledAsyncAttribute extends CompiledBooleanAttribute<AsyncAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAsyncAttribute.class);

    private static final AsyncAttribute ASYNC_ATTRIBUTE_INSTANCE = new AsyncAttribute();

    private final String content;

    public CompiledAsyncAttribute(@Nullable final String content) {
        super(ASYNC_ATTRIBUTE_INSTANCE, content);

        this.content = content;
    }

    @Override
    public @NotNull AsyncAttribute attribute() {
        return ASYNC_ATTRIBUTE_INSTANCE;
    }

    public boolean isAsync() {
        return isTrue();
    }

    @Nullable
    @Override
    public String contentAsString() {
        return content;
    }


    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "CompiledAsyncAttribute{" +
                "content='" + content + '\'' +
                '}';
    }
}