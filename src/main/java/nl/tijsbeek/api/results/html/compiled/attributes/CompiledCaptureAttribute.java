package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.Capture;
import nl.tijsbeek.api.html.attributes.CaptureAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.InvalidEnumValueAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CompiledCaptureAttribute implements CompiledHTMLAttribute<CaptureAttribute,
        InvalidEnumValueAttributeError<CaptureAttribute>, HTMLAttributeWarning<CaptureAttribute>> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledCaptureAttribute.class);

    private static final CaptureAttribute CAPTURE_ATTRIBUTE_INSTANCE = new CaptureAttribute();

    private final String content;
    private final Capture capture;

    private final @Nullable InvalidEnumValueAttributeError<CaptureAttribute> error;
    private final @Nullable HTMLAttributeWarning<CaptureAttribute> warning;

    @Contract(pure = true)
    public CompiledCaptureAttribute(@NotNull final String content, @Nullable final Capture capture) {
        this.content = Objects.requireNonNull(content, "The given content cannot be null");
        this.capture = capture;

        if (capture == null) {
            error = new InvalidEnumValueAttributeError<>(
                    CAPTURE_ATTRIBUTE_INSTANCE, Capture.class, content);
        } else {
            error = null;
        }

        warning = null;
    }

    @Override
    public boolean hasSuccessFullyCompiled() {
        return true;
    }

    @Nullable
    @Override
    public InvalidEnumValueAttributeError<CaptureAttribute> errors() {
        return error;
    }

    @Nullable
    @Override
    public HTMLAttributeWarning<CaptureAttribute> warnings() {
        return warning;
    }

    @Override
    public @NotNull CaptureAttribute attribute() {
        return CAPTURE_ATTRIBUTE_INSTANCE;
    }

    @Override
    public @NotNull String contentAsString() {
        return content;
    }

    @NonNls
    @NotNull
    @Override
    public String toString() {
        return "CompiledCaptureAttribute{" +
                "content='" + content + '\'' +
                ", capture=" + capture +
                '}';
    }
}