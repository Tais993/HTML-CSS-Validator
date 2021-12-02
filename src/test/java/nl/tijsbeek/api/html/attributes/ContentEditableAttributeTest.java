package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledContentEditableAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentEditableAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(ContentEditableAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    "true",
                    "false",
                    "inherit"
            );

    private static final List<String> warningArguments =
            Arrays.asList(
                    "",
                    null
            );

    private static final List<String> errorArguments =
            Arrays.asList(
                    "12y4whrWR"
            );

    @Test
    public void testCheckedAttribute() {
        ContentEditableAttribute contentEditableAttribute = new ContentEditableAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledContentEditableAttribute validCompile = contentEditableAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        warningArguments.forEach((@NonNls String warningArgument) -> {
            CompiledContentEditableAttribute warningCompile = contentEditableAttribute.compile(warningArgument);

            assertTrue(warningCompile.hasWarnings(),
                    () -> "Warning argument is seen as valid" + warningArgument);
        });

        errorArguments.forEach((@NonNls String errorArgument) -> {
            CompiledContentEditableAttribute errorCompile = contentEditableAttribute.compile(errorArgument);

            assertTrue(errorCompile.hasErrors(),
                    () -> "Error argument is seen as valid" + errorArgument);
        });
    }
}