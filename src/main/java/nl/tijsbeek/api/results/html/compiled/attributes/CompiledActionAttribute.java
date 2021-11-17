package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ActionAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public record CompiledActionAttribute(
        boolean success,
        @NotNull String url)
        implements CompiledHTMLAttribute<ActionAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledActionAttribute.class);

    public CompiledActionAttribute(final boolean success) {
        this(success, "");
    }

    public CompiledActionAttribute(@NotNull final String url) {
        this(!url.isBlank(), url);
    }

    public CompiledActionAttribute(final boolean success, @NotNull final String url) {
        this.success = success;
        this.url = Objects.requireNonNull(url, "The given url cannot be null");
    }

    @Override
    @Contract(pure = true)
    public boolean success() {
        return success;
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public ActionAttribute attribute() {
        return new ActionAttribute();
    }

    @NotNull
    @Override
    @Contract(pure = true)
    public String content() {
        return url;
    }
}