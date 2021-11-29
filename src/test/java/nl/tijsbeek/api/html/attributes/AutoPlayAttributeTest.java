package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoPlayAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AutoPlayAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(AutoPlayAttributeTest.class);

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
    public void testAutoPlayAttribute() {
        AutoPlayAttribute autoFocusAttribute = new AutoPlayAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledAutoPlayAttribute validCompile = autoFocusAttribute.compile(validArgument);

            assertTrue(validCompile.hasSuccessFullyCompiled(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledAutoPlayAttribute invalidCompile = autoFocusAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}