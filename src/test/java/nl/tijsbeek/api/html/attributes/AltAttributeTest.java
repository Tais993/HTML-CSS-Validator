package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAltAttribute;
import org.jetbrains.annotations.NonNls;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AltAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(AltAttributeTest.class);

    private static final List<String> validArguments =
            List.of(
                    "Image of a Java Chad",
                    "Sunset at the river"
            );

    @Test
    public void testAltAttribute() {
        AltAttribute altAttribute = new AltAttribute();

        validArguments.forEach((@NonNls String validArgument) -> {
            CompiledAltAttribute validCompile = altAttribute.compile(validArgument);

            assertTrue(validCompile.hasSuccessFullyCompiled(),
                    () -> "Valid argument is seen as invalid, " + validArgument);
        });
    }
}