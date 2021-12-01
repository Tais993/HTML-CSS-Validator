package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.CheckedAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompiledCheckedAttribute extends CompiledBooleanAttribute<CheckedAttribute> {
    public static final CheckedAttribute CHECKED_ATTRIBUTE_INSTANCE = new CheckedAttribute();

    private final String content;

    public CompiledCheckedAttribute(final boolean success, @Nullable final String value) {
        super(CHECKED_ATTRIBUTE_INSTANCE, success, value);

        this.content = value;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Override
    public @NotNull CheckedAttribute attribute() {
        return CHECKED_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return null;
    }
}