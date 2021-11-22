package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoCapitalizeAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AutoCapitalizeAttributeTest {
    private static final List<String> validArguments =
            EnumSet.allOf(AutoCapitalize.class)
                    .stream()
                    .map(Enum::name)
                    .toList();

    private static final List<String> invalidArguments =
            Arrays.asList(
                    "test",
                    "okay",
                    null
            );

    @Test
    public void testAutoCapitalizeAttribute() {
        AutoCapitalizeAttribute autoCapitalizeAttribute = new AutoCapitalizeAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledAutoCapitalizeAttribute validCompile = autoCapitalizeAttribute.compile(validArgument);

            assertTrue(validCompile.hasSuccessFullyCompiled(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledAutoCapitalizeAttribute invalidCompile = autoCapitalizeAttribute.compile(invalidArgument);

            assertTrue(invalidCompile.hasWarnings() || invalidCompile.hasErrors(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}