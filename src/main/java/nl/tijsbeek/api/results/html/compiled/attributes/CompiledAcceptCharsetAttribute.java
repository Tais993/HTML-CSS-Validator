package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AcceptCharsetAttribute;
import nl.tijsbeek.api.results.html.DefaultCompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.UnfinishedCompiledHTML;
import nl.tijsbeek.api.results.html.compiled.linter.errors.HTMLAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

//TODO
public final class CompiledAcceptCharsetAttribute
        extends UnfinishedCompiledHTML<
        HTMLAttributeError<AcceptCharsetAttribute>,
        HTMLAttributeWarning<AcceptCharsetAttribute>>
        implements DefaultCompiledHTMLAttribute<AcceptCharsetAttribute> {

    private static final Logger logger = LoggerFactory.getLogger(CompiledAcceptCharsetAttribute.class);
    private final boolean success;
    private final @NotNull String content;


    @Contract(pure = true)
    public CompiledAcceptCharsetAttribute(final boolean success, @NotNull final String content) {
        this.success = success;
        this.content = Objects.requireNonNull(content, "The given content cannot be null");
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AcceptCharsetAttribute attribute() {
        return new AcceptCharsetAttribute();
    }

    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {return success;}

    @NotNull
    @Contract(pure = true)
    public String content() {return content;}


    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CompiledAcceptCharsetAttribute) obj;
        return this.success == that.success &&
                Objects.equals(this.content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, content);
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledAcceptCharsetAttribute[" +
                "success=" + success + ", " +
                "content=" + content + ']';
    }

}