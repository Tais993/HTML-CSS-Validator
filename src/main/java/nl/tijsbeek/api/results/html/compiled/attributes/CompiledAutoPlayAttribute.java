package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AutoPlayAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledBooleanAttribute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompiledAutoPlayAttribute extends CompiledBooleanAttribute<AutoPlayAttribute> {
    private static final AutoPlayAttribute AUTO_PLAY_ATTRIBUTE = new AutoPlayAttribute();

    private final boolean shouldAutoPlay;
    private final String content;

    public CompiledAutoPlayAttribute(final boolean shouldAutoPlay, final String content) {
        super(AUTO_PLAY_ATTRIBUTE, shouldAutoPlay, content);
        this.shouldAutoPlay = shouldAutoPlay;
        this.content = content;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Override
    public @NotNull AutoPlayAttribute attribute() {
        return AUTO_PLAY_ATTRIBUTE;
    }

    @Override
    public @Nullable String contentAsString() {
        return content;
    }

    public boolean shouldAutoPlay() {
        return shouldAutoPlay;
    }
}