package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledActionAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActionAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(ActionAttributeTest.class);

    private static final List<String> validArguments =
            List.of(
                    "https://google.com",
                    "https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form#attr-action",
                    "https://github.com/Tais993/Java-OsuApiV1/blob/master/build.gradle"
            );

    private static final List<String> invalidArguments =
            List.of(
                    "test",
                    ""
            );

    @Test
    public void testActionAttribute() {
        ActionAttribute actionAttribute = new ActionAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledActionAttribute validCompile = actionAttribute.compile(validArgument);

            assertTrue(validCompile.hasSuccessFullyCompiled(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledActionAttribute invalidCompile = actionAttribute.compile(invalidArgument);

            assertFalse(invalidCompile.hasSuccessFullyCompiled(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}