package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledCiteAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class CiteAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(CiteAttributeTest.class);

    private static final List<String> validArguments =
            List.of(
                    "https://google.com",
                    "https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-action",
                    "https://github.com/Tais993/Java-OsuApiV1/blob/master/build.gradle",
                    "On the newspaper"
            );

    @Test
    public void testCiteAttribute() {
        CiteAttribute citeAttribute = new CiteAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledCiteAttribute validCompile = citeAttribute.compile(validArgument);

            assertFalse(validCompile.hasErrors() || validCompile.hasWarnings(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });
    }
}