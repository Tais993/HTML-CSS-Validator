package nl.tijsbeek.api.results.html.compiled.linter.errors.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NegativeIntegerAttributeError<A extends HTMLAttribute<?>> extends HTMLAttributeError<A> {
    private static final Logger logger = LoggerFactory.getLogger(NegativeIntegerAttributeError.class);

    public NegativeIntegerAttributeError(@NotNull final A attribute, @Nullable final String value) {
        super(attribute, value, "A non-negative Integer is expected.");
    }
}