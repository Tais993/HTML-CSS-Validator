package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledColSpanAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ColSpanAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(ColSpanAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    "1",
                    "999",
                    "25"
            );

    private static final List<String> invalidArguments =
            Arrays.asList(
                    "-1",
                    "1928",
                    "jhrwwa"
            );

    @Test
    public void testCheckedAttribute() {
        ColSpanAttribute colSpanAttribute = new ColSpanAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledColSpanAttribute validCompile = colSpanAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledColSpanAttribute invalidCompile = colSpanAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings() || invalidCompile.hasErrors(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}