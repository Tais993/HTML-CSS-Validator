package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.CheckedAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledCheckedAttribute extends CompiledBooleanAttribute<CheckedAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledCheckedAttribute.class);

    public static final CheckedAttribute CHECKED_ATTRIBUTE_INSTANCE = new CheckedAttribute();

    public CompiledCheckedAttribute(@Nullable final String content) {
        super(CHECKED_ATTRIBUTE_INSTANCE, content);
    }

    @Override
    public @NotNull CheckedAttribute attribute() {
        return CHECKED_ATTRIBUTE_INSTANCE;
    }

    public boolean isCheckedOnStart() {
        return isTrue();
    }
}