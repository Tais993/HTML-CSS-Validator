package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAcceptAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class AcceptAttribute implements HTMLAttribute<CompiledAcceptAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(AcceptAttribute.class);

    public static final String ACCEPT_ATTRIBUTE_NAME = "accept";

    public static final Pattern COMA_PATTERN = Pattern.compile(",");

    public static final Pattern MIME_PATTERN = Pattern.compile("[^,/]+/[^,]+");
    public static final Predicate<String> MIME_PREDICATE = MIME_PATTERN.asMatchPredicate();

    public static final Pattern FILENAME_EXTENSION_PATTERN = Pattern.compile("\\.[^, ]+");
    public static final Predicate<String> FILENAME_EXTENSION_PREDICATE = FILENAME_EXTENSION_PATTERN.asMatchPredicate();

    @NotNull
    @Override
    public String name() {
        return ACCEPT_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @NotNull
    @Override
    public CompiledAcceptAttribute compile(final @NotNull String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        List<String> list = List.of(COMA_PATTERN.split(content));

        List<String> permittedTypes = new ArrayList<>(list.size());
        List<String> permittedFileTypes = new ArrayList<>(list.size());
        List<String> permittedMimeTypes = new ArrayList<>(list.size());

        List<String> invalidTypes = new ArrayList<>(list.size());

        for (final String item : list) {
            if (MIME_PREDICATE.test(item)) {
                permittedMimeTypes.add(item);
                permittedTypes.add(item);

            } else if (FILENAME_EXTENSION_PREDICATE.test(item)) {
                permittedFileTypes.add(item);
                permittedTypes.add(item);

            } else {
                invalidTypes.add(item);
            }
        }

        return new CompiledAcceptAttribute(content, permittedTypes, permittedMimeTypes,
                permittedFileTypes, invalidTypes);
    }
}