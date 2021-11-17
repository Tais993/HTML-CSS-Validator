package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AcceptCharsetAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public record CompiledAcceptCharsetAttribute(@Contract(pure = true) boolean success,
                                             @Contract(pure = true) @NotNull String content)
        implements CompiledHTMLAttribute<AcceptCharsetAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAcceptCharsetAttribute.class);

    @Contract(pure = true)
    public CompiledAcceptCharsetAttribute(final boolean success, @NotNull final String content) {
        this.success = success;
        this.content = Objects.requireNonNull(content, "The given content cannot be null");
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AcceptCharsetAttribute attribute() {
        return new AcceptCharsetAttribute();
    }
}