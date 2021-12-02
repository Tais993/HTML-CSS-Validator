package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.ClassAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.DuplicatedClassAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CompiledClassAttribute implements CompiledHTMLAttribute<ClassAttribute,
        HTMLAttributeError<ClassAttribute>, List<DuplicatedClassAttributeWarning>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledClassAttribute.class);

    private static final ClassAttribute CLASS_ATTRIBUTE_INSTANCE = new ClassAttribute();

    private final String content;
    private final List<String> classes;
    private final List<DuplicatedClassAttributeWarning> warnings;

    @Contract(pure = true)
    public CompiledClassAttribute(@NotNull final String content, @NotNull final List<String> classes
            , @NotNull final Collection<String> duplicates) {
        this.content = Objects.requireNonNull(content, "The given content cannot be null");

        Objects.requireNonNull(classes, "The given classes cannot be null");
        Objects.requireNonNull(duplicates, "The given duplicates cannot be null");

        this.classes = Collections.unmodifiableList(classes);

        if (duplicates.isEmpty()) {
            warnings = Collections.emptyList();
        } else {
            warnings = Collections.unmodifiableList(
                    duplicates.stream()
                            .map(DuplicatedClassAttributeWarning::new)
                            .toList()
            );
        }
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return false;
    }

    @Nullable
    @Override
    public HTMLAttributeError<ClassAttribute> errors() {
        return null;
    }

    @NotNull
    @Override
    public List<DuplicatedClassAttributeWarning> warnings() {
        return warnings;
    }

    @Override
    public @NotNull ClassAttribute attribute() {
        return CLASS_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }

    public List<String> getClasses() {
        return classes;
    }
}