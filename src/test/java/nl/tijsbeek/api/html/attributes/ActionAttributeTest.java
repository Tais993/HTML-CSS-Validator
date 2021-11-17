package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledActionAttribute;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActionAttributeTest {
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

        validArguments.forEach(validArgument -> {
            CompiledActionAttribute validCompile = actionAttribute.compile(validArgument);

            assertTrue(validCompile.success(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach(invalidArgument -> {
            CompiledActionAttribute invalidCompile = actionAttribute.compile(invalidArgument);

            assertFalse(invalidCompile.success(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}