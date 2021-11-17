package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AccessKeyAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record CompiledAccessKeyAttribute(boolean success,
                                         @NotNull String content)
        implements CompiledHTMLAttribute<AccessKeyAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAccessKeyAttribute.class);

    @Override
    @Contract(pure = true)
    public boolean success() {
        return success;
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AccessKeyAttribute attribute() {
        return new AccessKeyAttribute();
    }

    @NotNull
    @Override
    @Contract(pure = true)
    public String content() {
        return content;
    }
}