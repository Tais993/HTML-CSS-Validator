package nl.tijsbeek.api.results.html.compiled.linter.errors.attributes;

import nl.tijsbeek.api.html.attributes.AcceptAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AcceptAttributeError extends HTMLAttributeError<AcceptAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AcceptAttributeError.class);

    public AcceptAttributeError(@NotNull final String type) {
        super(new AcceptAttribute(), Objects.requireNonNull(type) + "  isn't a valid MIME or file extension");
    }
}