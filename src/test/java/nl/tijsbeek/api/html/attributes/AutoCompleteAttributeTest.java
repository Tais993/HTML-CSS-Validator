package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAutoCompleteAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AutoCompleteAttributeTest {
    private static final List<String> validArguments =
            EnumSet.allOf(AutoComplete.class)
                    .stream()
                    .map(AutoComplete::getHtmlValue)
                    .toList();

    private static final List<String> errorArguments =
            Arrays.asList(
                    "test",
                    "okay",
                    "-"
            );

    private static final List<String> warningArguments =
            Arrays.asList(
                    "ON",
                    "transaction-Currency"
            );

    @Test
    public void testAutoCompleteAttribute() {
        AutoCompleteAttribute autoCompleteAttribute = new AutoCompleteAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledAutoCompleteAttribute validCompile = autoCompleteAttribute.compile(validArgument);

            assertTrue(validCompile.hasSuccessFullyCompiled(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        errorArguments.forEach((@NonNls String errorArgument) -> {
            CompiledAutoCompleteAttribute invalidCompile = autoCompleteAttribute.compile(errorArgument);

            assertTrue(invalidCompile.hasErrors(),
                    () -> "Error argument is seen as non-error, " + errorArgument);
        });

        warningArguments.forEach((@NonNls String warningArgument) -> {
            CompiledAutoCompleteAttribute invalidCompile = autoCompleteAttribute.compile(warningArgument);

            assertTrue(invalidCompile.hasWarnings(),
                    () -> "Warning argument is seen as non-warning, " + warningArgument);
        });
    }
}