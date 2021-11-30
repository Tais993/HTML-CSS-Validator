package nl.tijsbeek.api.html.attributes;

import nl.tijsbeek.api.results.html.compiled.attributes.CompiledAcceptAttribute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static nl.tijsbeek.Util.listToString;

class AcceptAttributeTest {
    private static final Logger logger = LoggerFactory.getLogger(AcceptAttributeTest.class);

    private static final List<String> validArguments =
            List.of(
                    ".doc",
                    ".docx",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document"
            );

    private static final List<String> invalidArguments =
            List.of(
                    "test",
                    "ahjw.wp"
            );

    @Test
    public void testAcceptAttribute() {
        AcceptAttribute acceptAttribute = new AcceptAttribute();

        CompiledAcceptAttribute validAcceptAttribute = acceptAttribute.compile(
                listToString(validArguments, ","));


        Assertions.assertFalse(validAcceptAttribute.hasWarnings() || validAcceptAttribute.hasErrors(), "valid attributes found to be invalid.");
        Assertions.assertIterableEquals(validArguments, validAcceptAttribute.permittedTypes());


        CompiledAcceptAttribute invalidAcceptAttribute = acceptAttribute.compile(
                listToString(invalidArguments, ","));

        Assertions.assertTrue(invalidAcceptAttribute.hasWarnings() || invalidAcceptAttribute.hasErrors(), "invalid attributes found to be valid.");
        Assertions.assertIterableEquals(invalidArguments, invalidAcceptAttribute.invalidTypes());
    }
}