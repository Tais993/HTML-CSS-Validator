package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledCaptureAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CaptureAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(CaptureAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    "user",
                    "environment"
            );

    private static final List<String> invalidArguments =
            List.of(
                    "124",
                    "awp"
            );

    @Test
    public void captureAttributeTest() {
        CaptureAttribute captureAttribute = new CaptureAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            //noinspection LanguageMismatch
            CompiledCaptureAttribute validCompile = captureAttribute.compile(validArgument);

            assertFalse(validCompile.hasErrors() && validCompile.hasWarnings(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });


        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            //noinspection LanguageMismatch
            CompiledCaptureAttribute invalidCompile = captureAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings() || invalidCompile.hasErrors(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}