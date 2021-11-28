package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoComplete;
import nl.tijsbeek.api.html.attributes.AutoCompleteAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledAutoCompleteAttribute implements CompiledHTMLAttribute<AutoCompleteAttribute, HTMLAttributeError<AutoCompleteAttribute>, HTMLAttributeError<AutoCompleteAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAutoCompleteAttribute.class);

    private static final AutoCompleteAttribute AUTO_COMPLETE_ATTRIBUTE_INSTANCE = new AutoCompleteAttribute();

    @Override
    public boolean hasSuccessFullyCompiled() {
        return false;
    }

    @Override
    public HTMLAttributeError<AutoCompleteAttribute> errors() {
        return null;
    }

    @Override
    public HTMLAttributeError<AutoCompleteAttribute> warnings() {
        return null;
    }

    @Override
    public @NotNull AutoCompleteAttribute attribute() {
        return AUTO_COMPLETE_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @Nullable String contentAsString() {
        return null;
    }

    public @Nullable AutoComplete getAutoCompleteType() {
        return null;
    }
}