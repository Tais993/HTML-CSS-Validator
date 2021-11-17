package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AltAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record CompiledAltAttribute(@Contract(pure = true) boolean success,
                                   @Contract(pure = true) @NotNull String content)
        implements CompiledHTMLAttribute<AltAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAltAttribute.class);
    
    @NotNull
    @Override
    @Contract(pure = true)
    public AltAttribute attribute() {
        return new AltAttribute();
    }
}