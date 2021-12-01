package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledCheckedAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckedAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(CheckedAttributeTest.class);

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
    public void testCheckedAttribute() {
        CheckedAttribute checkedAttribute = new CheckedAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledCheckedAttribute validCompile = checkedAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledCheckedAttribute invalidCompile = checkedAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings() || invalidCompile.hasErrors(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}