package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoCapitalize;
import nl.tijsbeek.api.html.attributes.AutoCapitalizeAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidEnumValueAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes.EmptyAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledAutoCapitalizeAttribute implements CompiledHTMLAttribute<AutoCapitalizeAttribute,
        InvalidEnumValueAttributeError<AutoCapitalizeAttribute>, EmptyAttributeWarning<AutoCapitalizeAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAutoCapitalizeAttribute.class);

    private static final AutoCapitalizeAttribute AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE = new AutoCapitalizeAttribute();

    private final AutoCapitalize autoCapitalize;
    private final String content;
    private final boolean success;

    private final @Nullable InvalidEnumValueAttributeError<AutoCapitalizeAttribute> errors;
    private final @Nullable EmptyAttributeWarning<AutoCapitalizeAttribute> warnings;

    @Contract(pure = true)
    public CompiledAutoCapitalizeAttribute(@Nullable AutoCapitalize autoCapitalize, @NotNull String content) {
        this.autoCapitalize = autoCapitalize;
        this.content = content;
        this.success = true;

        if (autoCapitalize == null) {
            errors = new InvalidEnumValueAttributeError<>(AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE,
                    AutoCapitalize.class, content);
        } else {
            errors = null;
        }

        if (content.isBlank()) {
            warnings = new EmptyAttributeWarning<>(AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE);
        } else {
            warnings = null;
        }
    }

    @NotNull
    @Override
    public AutoCapitalizeAttribute attribute() {
        return AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return success;
    }

    @Nullable
    @Override
    public InvalidEnumValueAttributeError<AutoCapitalizeAttribute> errors() {
        return errors;
    }

    @Nullable
    @Override
    public EmptyAttributeWarning<AutoCapitalizeAttribute> warnings() {
        return warnings;
    }

    @Nullable
    @Override
    public String contentAsString() {
        return content;
    }

    @NotNull
    public AutoCapitalize getAutoCapitalize() {
        throwIfNoSuccess();
        return autoCapitalize;
    }
}