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

    private static final AsyncAttribute asyncAttribute = new AsyncAttribute();

    private final boolean isAsync;
    private final String content;

    public CompiledAsyncAttribute(final boolean isAsync, @Nullable final String content) {
        super(asyncAttribute, isAsync, content);

        this.isAsync = isAsync;
        this.content = content;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Override
    public @NotNull AsyncAttribute attribute() {
        return asyncAttribute;
    }

    public boolean isAsync() {
        return isAsync;
    }

    @Nullable
    @Override
    public String content() {
        return content;
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "CompiledAsyncAttribute{" +
                "isAsync=" + isAsync +
                ", content='" + content + '\'' +
                '}';
    }
}