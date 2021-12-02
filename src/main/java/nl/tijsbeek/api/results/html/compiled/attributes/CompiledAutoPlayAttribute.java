package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoPlayAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompiledAutoPlayAttribute extends CompiledBooleanAttribute<AutoPlayAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAutoPlayAttribute.class);

    private static final AutoPlayAttribute AUTO_PLAY_ATTRIBUTE = new AutoPlayAttribute();

    public CompiledAutoPlayAttribute(final String content) {
        super(AUTO_PLAY_ATTRIBUTE, content);
    }

    @Override
    public @NotNull AutoPlayAttribute attribute() {
        return AUTO_PLAY_ATTRIBUTE;
    }

    public boolean shouldAutoPlay() {
        return isTrue();
    }
}