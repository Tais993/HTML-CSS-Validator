package nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooleanAttributeWarning<A extends HTMLAttribute<?>> extends HTMLAttributeWarning<A> {
    private static final Logger logger = LoggerFactory.getLogger(BooleanAttributeWarning.class);

    public BooleanAttributeWarning(@NotNull final A attribute, @Nullable final String value) {
        super(attribute, value, "Invalid boolean value, has to be empty or removed");
    }
}