package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoComplete;
import nl.tijsbeek.api.html.attributes.AutoCompleteAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidEnumValueAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Pattern;

public class CompiledAutoCompleteAttribute implements CompiledHTMLAttribute<AutoCompleteAttribute,
        List<InvalidEnumValueAttributeError<AutoCompleteAttribute>>, List<HTMLAttributeWarning<AutoCompleteAttribute>>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAutoCompleteAttribute.class);

    private static final AutoCompleteAttribute AUTO_COMPLETE_ATTRIBUTE_INSTANCE = new AutoCompleteAttribute();
    private static final Pattern SPACES_PATTERN = Pattern.compile("\\s+");

    private final boolean success;
    private final String content;
    private final List<AutoComplete> autoCompleteTypes;
    private final List<InvalidEnumValueAttributeError<AutoCompleteAttribute>> errors;
    private final List<HTMLAttributeWarning<AutoCompleteAttribute>> warnings;

    public CompiledAutoCompleteAttribute(@NotNull @NonNls String content) {
        this.success = true;
        this.content = Objects.requireNonNull(content, "The given content cannot be null");

        String[] items = SPACES_PATTERN.split(content);

        List<AutoComplete> autoCompleteTypes = new ArrayList<>(items.length);

        List<InvalidEnumValueAttributeError<AutoCompleteAttribute>> errors = new ArrayList<>(items.length);
        List<HTMLAttributeWarning<AutoCompleteAttribute>> warnings = new ArrayList<>(items.length);

        for (final @NonNls String item : items) {

            if (!item.toLowerCase(Locale.ROOT).equals(item)) {
                warnings.add(new HTMLAttributeWarning<>(AUTO_COMPLETE_ATTRIBUTE_INSTANCE, item,
                        "Keep autocomplete values lowercase for improved readability"));
            }

            try {
                AutoComplete autoCompleteItem = AutoComplete.valueOf(item);
                autoCompleteTypes.add(autoCompleteItem);
            } catch (final IllegalArgumentException e) {
                errors.add(new InvalidEnumValueAttributeError<>(
                        AUTO_COMPLETE_ATTRIBUTE_INSTANCE, AutoComplete.class, item));
            }
        }

        this.autoCompleteTypes = Collections.unmodifiableList(autoCompleteTypes);
        this.warnings = Collections.unmodifiableList(warnings);
        this.errors = Collections.unmodifiableList(errors);

    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return success;
    }

    @NotNull
    @Override
    public List<InvalidEnumValueAttributeError<AutoCompleteAttribute>> errors() {
        return errors;
    }

    @NotNull
    @Override
    public List<HTMLAttributeWarning<AutoCompleteAttribute>> warnings() {
        return warnings;
    }

    @Override
    public @NotNull AutoCompleteAttribute attribute() {
        return AUTO_COMPLETE_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }

    @NotNull
    public List<AutoComplete> getAutoCompleteTypes() {
        return autoCompleteTypes;
    }
}