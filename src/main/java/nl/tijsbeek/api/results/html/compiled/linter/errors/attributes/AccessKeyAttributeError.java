package nl.tijsbeek.api.results.html.compiled.linter.errors.attributes;

import nl.tijsbeek.api.html.attributes.AccessKeyAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class AccessKeyAttributeError extends HTMLAttributeError<AccessKeyAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AccessKeyAttributeError.class);

    public AccessKeyAttributeError(@NotNull final String content) {
        super(new AccessKeyAttribute(), Objects.requireNonNull(content), "Content has to be a single character");
    }
}