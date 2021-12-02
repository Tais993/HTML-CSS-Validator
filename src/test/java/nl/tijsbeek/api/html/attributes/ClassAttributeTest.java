package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledClassAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ClassAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(ClassAttributeTest.class);

    private static final List<String> validArguments =
            Arrays.asList(
                    "test poggers lol",
                    "menuItem capital",
                    "menu body_title"
            );

    @Test
    public void testCheckedAttribute() {
        ClassAttribute classAttribute = new ClassAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledClassAttribute validCompile = classAttribute.compile(validArgument);

            assertFalse(validCompile.hasWarnings() || validCompile.hasErrors(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });
    }
}