package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledControlsAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControlsAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(ControlsAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    null,
                    ""
            );

    private static final List<String> invalidArguments =
            Arrays.asList(
                    "q2rnhewi",
                    "12944"
            );

    @Test
    public void testCheckedAttribute() {
        ControlsAttribute controlsAttribute = new ControlsAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledControlsAttribute validCompile = controlsAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledControlsAttribute invalidCompile = controlsAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings() || invalidCompile.hasErrors(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}