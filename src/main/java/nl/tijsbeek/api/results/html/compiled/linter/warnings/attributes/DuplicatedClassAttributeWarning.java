package nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;

import nl.tijsbeek.api.html.attributes.ClassAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuplicatedClassAttributeWarning extends HTMLAttributeWarning<ClassAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(DuplicatedClassAttributeWarning.class);

    public DuplicatedClassAttributeWarning(@NotNull final String className) {
        super(new ClassAttribute(), className, "Class is added multiple times in the same attribute.");
    }
}