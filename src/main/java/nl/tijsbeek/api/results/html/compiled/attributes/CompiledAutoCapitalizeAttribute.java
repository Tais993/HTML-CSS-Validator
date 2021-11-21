package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoCapitalize;
import nl.tijsbeek.api.html.attributes.AutoCapitalizeAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidEnumValueAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class CompiledAutoCapitalizeAttribute implements CompiledHTMLAttribute<AutoCapitalizeAttribute,
        InvalidEnumValueAttributeError<AutoCapitalizeAttribute>, HTMLAttributeWarning<AutoCapitalizeAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAutoCapitalizeAttribute.class);

    private static final AutoCapitalizeAttribute AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE = new AutoCapitalizeAttribute();

    private final AutoCapitalize autoCapitalize;
    private final String content;
    private final boolean success;

    private final List<InvalidEnumValueAttributeError<AutoCapitalizeAttribute>> errors;
    private final List<HTMLAttributeWarning<AutoCapitalizeAttribute>> warnings;

    @Contract(pure = true)
    public CompiledAutoCapitalizeAttribute(@Nullable AutoCapitalize autoCapitalize, @NotNull String content) {
        this.autoCapitalize = autoCapitalize;
        this.content = content;
        this.success = true;

        if (autoCapitalize == null) {
            errors = Collections.singletonList(
                    new InvalidEnumValueAttributeError<>(AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE,
                            AutoCapitalize.class, content));
        } else {
            errors = Collections.emptyList();
        }

        if (content.isBlank()) {
            // TODO: add warning
            warnings = Collections.emptyList();
        } else {
            warnings = Collections.emptyList();
        }
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return success;
    }

    @NotNull
    @Override
    @UnmodifiableView
    public List<InvalidEnumValueAttributeError<AutoCapitalizeAttribute>> errors() {
        return errors;
    }

    @NotNull
    @Override
    @UnmodifiableView
    public List<HTMLAttributeWarning<AutoCapitalizeAttribute>> warnings() {
        return warnings;
    }

    @Override
    public @NotNull AutoCapitalizeAttribute attribute() {
        return AUTO_CAPITALIZE_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }

    public AutoCapitalize getAutoCapitalize() {
        return autoCapitalize;
    }
}