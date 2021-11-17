package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledActionAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class ActionAttribute implements HTMLAttribute<CompiledActionAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(ActionAttribute.class);

    public static final String ACTION_ATTRIBUTE_NAME = "action";

    @Override
    public @NotNull String name() {
        return ACTION_ATTRIBUTE_NAME;
    }

    @Override
    public @NotNull CompiledActionAttribute compile(@NotNull final String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        return new CompiledActionAttribute(isValidUrl(content), content);
    }

    private static boolean isValidUrl(@NotNull final String url) {
        Objects.requireNonNull(url, "The given content cannot be null");

        try {
            new URL(url).toURI();
        } catch (URISyntaxException | MalformedURLException e) {
            return false;
        }

        return true;
    }
}