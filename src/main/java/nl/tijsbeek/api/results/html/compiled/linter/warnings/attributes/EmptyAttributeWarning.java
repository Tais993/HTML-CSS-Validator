package nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmptyAttributeWarning<A extends HTMLAttribute<?>> extends HTMLAttributeWarning<A> {
    private static final Logger logger = LoggerFactory.getLogger(EmptyAttributeWarning.class);
    private static final String ERROR_MESSAGE = "The attribute is empty, this may be confusing to people that don't know the default value.";

    public EmptyAttributeWarning(@NotNull final A attribute) {
        super(attribute, "", ERROR_MESSAGE);
    }
}