package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAccessKeyAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class AccessKeyAttribute implements HTMLAttribute<CompiledAccessKeyAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AccessKeyAttribute.class);

    public static final String ACCESSKEY_ATTRIBUTE_NAME = "accesskey";

    private static final Pattern ANY_SINGLE_CHARACTER_PATTERN = Pattern.compile(".");
    private static final Predicate<String> SINGLE_CHARACTER_PREDICATE = ANY_SINGLE_CHARACTER_PATTERN.asMatchPredicate();

    @NotNull
    @Override
    public String name() {
        return ACCESSKEY_ATTRIBUTE_NAME;
    }

    @NotNull
    @Override
    public CompiledAccessKeyAttribute compile(@NotNull final String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        boolean success = SINGLE_CHARACTER_PREDICATE.test(content);

        return new CompiledAccessKeyAttribute(success, content);
    }
}