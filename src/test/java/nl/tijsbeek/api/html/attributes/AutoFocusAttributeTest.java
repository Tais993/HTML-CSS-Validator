package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoFocusAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AutoFocusAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(AutoFocusAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    null,
                    ""
            );

    private static final List<String> invalidArguments =
            List.of(
                    "test",
                    "ahjw.wp"
            );

    @Test
    public void testAutoFocusAttribute() {
        AutoFocusAttribute autoFocusAttribute = new AutoFocusAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledAutoFocusAttribute validCompile = autoFocusAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledAutoFocusAttribute invalidCompile = autoFocusAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}