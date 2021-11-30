package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.html.HTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.attributes.CompiledCaptureAttribute;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CaptureAttribute implements HTMLAttribute<CompiledCaptureAttribute> {

    private static final String CAPTURE_ATTRIBUTE_NAME = "capture";

    @Override
    public @NotNull String name() {
        return CAPTURE_ATTRIBUTE_NAME;
    }

    @Override
    public boolean requiresValue() {
        return true;
    }

    @Override
    public @NotNull CompiledCaptureAttribute compile(
            @Language(value = "HTML", prefix = "<input capture=\"", suffix = "\">")
            @NotNull final String content) {

        Objects.requireNonNull(content, "The given content cannot be null");

        try {
            Capture capture = Capture.getByHTMLValue(content);
            return new CompiledCaptureAttribute(content, capture);
        } catch (final IllegalArgumentException ignore) {
            return new CompiledCaptureAttribute(content, null);
        }
    }
}