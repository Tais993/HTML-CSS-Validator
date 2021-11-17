package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAcceptCharsetAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AcceptCharsetAttribute implements HTMLAttribute<CompiledAcceptCharsetAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AcceptCharsetAttribute.class);

    public static final String ACCEPT_CHARSET_ATTRIBUTE_NAME = "accept-charset";

    @NotNull
    @Override
    public String name() {
        return ACCEPT_CHARSET_ATTRIBUTE_NAME;
    }

    @NotNull
    @Override
    public CompiledAcceptCharsetAttribute compile(final @NotNull String content) {
        Objects.requireNonNull(content, "The given content cannot be null");


        // TODO unsure

        return new CompiledAcceptCharsetAttribute(true, content);
    }
}