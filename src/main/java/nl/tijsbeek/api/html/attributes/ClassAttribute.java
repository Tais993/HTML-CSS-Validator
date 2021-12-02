package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledClassAttribute;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class ClassAttribute implements HTMLAttribute<CompiledClassAttribute> {
    public static final String CLASS_ATTRIBUTE_NAME = "class";
    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");

    @Override
    public @NotNull String name() {
        return CLASS_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @NotNull
    @Override
    public CompiledClassAttribute compile(@NotNull final String content) {
        Objects.requireNonNull(content, "The given content cannot be null");

        List<String> classes = List.of(SPACE_PATTERN.split(content));

        Collection<String> tempSet = new HashSet<>(classes.size());

        List<String> duplicatedClasses = classes.stream()
                .filter(className -> !tempSet.add(className))
                .toList();


        return new CompiledClassAttribute(content, classes, duplicatedClasses);
    }
}