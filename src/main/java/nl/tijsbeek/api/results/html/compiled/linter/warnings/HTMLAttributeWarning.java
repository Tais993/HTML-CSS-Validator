package nl.tijsbeek.api.results.html.compiled.linter.warnings;

import nl.tijsbeek.api.html.HTMLAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class HTMLAttributeWarning<A extends HTMLAttribute<?>> extends HTMLWarning {

    private final A attribute;
    private final String message;

    public HTMLAttributeWarning(@NotNull final A attribute, final @Nullable String message) {
        super(message);

        Objects.requireNonNull(attribute, "The given attribute cannot be null");

        this.attribute = attribute;
        this.message = message;
    }

    public @NotNull A getAttribute() {
        return attribute;
    }
}