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
import java.util.Optional;

public class ActionAttribute implements HTMLAttribute<CompiledActionAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(ActionAttribute.class);

    public static final String ACTION_ATTRIBUTE_NAME = "action";

    @Override
    public @NotNull String name() {
        return ACTION_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @Override
    public @NotNull CompiledActionAttribute compile(@NotNull final String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        Optional<URL> optional = toURL(content);

        return new CompiledActionAttribute(optional.isPresent(), content, optional.orElse(null));
    }

    private static Optional<URL> toURL(@NotNull final String url) {
        Objects.requireNonNull(url, "The given content cannot be null");

        try {
            new URL(url).toURI();
            return Optional.of(new URL(url));
        } catch (URISyntaxException | MalformedURLException ignored) {
        }

        return Optional.empty();
    }
}