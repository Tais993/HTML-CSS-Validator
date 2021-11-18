package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAccessKeyAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccessKeyAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(AccessKeyAttributeTest.class);

    private static final List<String> validArguments =
            List.of(
                    "s",
                    "1",
                    "~",
                    "ä"
            );

    private static final List<String> invalidArguments =
            List.of(
                    "121",
                    "aa"
            );

    @Test
    public void testAccessKeyAttribute() {
        AccessKeyAttribute accessKeyAttribute = new AccessKeyAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledAccessKeyAttribute validCompile = accessKeyAttribute.compile(validArgument);

            assertTrue(validCompile.hasSuccessFullyCompiled(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });

        invalidArguments.forEach((@NonNls String invalidArgument) -> {
            CompiledAccessKeyAttribute invalidCompile = accessKeyAttribute.compile(invalidArgument);

            assertFalse(invalidCompile.hasSuccessFullyCompiled(),
                    () -> "Invalid argument is seen as valid, " + invalidArgument);
        });
    }
}