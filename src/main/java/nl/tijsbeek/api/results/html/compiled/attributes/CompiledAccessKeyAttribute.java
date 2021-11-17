package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AccessKeyAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record CompiledAccessKeyAttribute(@Contract(pure = true) boolean success,
                                         @Contract(pure = true) @NotNull String content)
        implements CompiledHTMLAttribute<AccessKeyAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAccessKeyAttribute.class);

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AccessKeyAttribute attribute() {
        return new AccessKeyAttribute();
    }
}