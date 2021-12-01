package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.CiteAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record CompiledCiteAttribute(String source) implements CompiledHTMLAttribute<CiteAttribute,
        HTMLAttributeError<CiteAttribute>, HTMLAttributeWarning<CiteAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledCiteAttribute.class);

    private static final CiteAttribute CITE_ATTRIBUTE_INSTANCE = new CiteAttribute();

    @Override
    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {
        return false;
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public HTMLAttributeError<CiteAttribute> errors() {
        return null;
    }

    @Override
    @Nullable
    @Contract(pure = true)
    public HTMLAttributeWarning<CiteAttribute> warnings() {
        return null;
    }

    @NotNull
    @Override
    @Contract(pure = true)
    public CiteAttribute attribute() {
        return CITE_ATTRIBUTE_INSTANCE;
    }

    @Contract(pure = true)
    public String getSource() {
        return source;
    }

    @Nullable
    @Override
    @Contract(pure = true)
    public String contentAsString() {
        return source;
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledCiteAttribute{" +
                "source='" + source + '\'' +
                '}';
    }
}