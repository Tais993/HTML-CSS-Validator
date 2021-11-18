package nl.tijsbeek.api.results.html.compiled.linter.warnings.attributes;

import nl.tijsbeek.api.html.attributes.ActionAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionAttributeWarning extends HTMLAttributeWarning<ActionAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(ActionAttributeWarning.class);

    public ActionAttributeWarning(@Nullable final String url) {
        super(new ActionAttribute(), url, "Invalid URL");
    }
}