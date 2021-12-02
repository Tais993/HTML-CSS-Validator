package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledColsAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColsAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(ColsAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    "5",
                    "129521",
                    "20"
            );

    private static final List<String> invalidArguments =
            Arrays.asList(
                    "-1",
                    "%s2a"
            );

    @Test
    public void testCheckedAttribute() {
        ColsAttribute colsAttribute = new ColsAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledColsAttribute validCompile = colsAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledColsAttribute invalidCompile = colsAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings() || invalidCompile.hasErrors(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}