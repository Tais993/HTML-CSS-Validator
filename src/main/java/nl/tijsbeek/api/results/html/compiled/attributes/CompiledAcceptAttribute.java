package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AcceptAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.AcceptAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class CompiledAcceptAttribute
        implements CompiledHTMLAttribute<AcceptAttribute, AcceptAttributeError,
        HTMLAttributeWarning<AcceptAttribute>> {

    private static final Logger logger = LoggerFactory.getLogger(CompiledAcceptAttribute.class);

    private final boolean success;
    private final String content;
    private final List<String> permittedTypes;
    private final List<String> permittedMimeTypes;
    private final List<String> permittedFileExtensions;
    private final List<String> invalidTypes;

    private List<AcceptAttributeError> errors;
    private List<HTMLAttributeWarning<AcceptAttribute>> warnings;


    public CompiledAcceptAttribute(@NotNull final String content,
                                   @NotNull final List<String> permittedTypes,
                                   @NotNull final List<String> permittedMimeTypes,
                                   @NotNull final List<String> permittedFileExtensions,
                                   @NotNull final List<String> invalidTypes) {
        this(invalidTypes.isEmpty(), content, permittedTypes, permittedMimeTypes,
                permittedFileExtensions, invalidTypes);
    }

    public CompiledAcceptAttribute(final boolean success, @NotNull final String content,
                                   @NotNull final List<String> permittedTypes,
                                   @NotNull final List<String> permittedMimeTypes,
                                   @NotNull final List<String> permittedFileExtensions,
                                   @NotNull final List<String> invalidTypes) {

        this.success = success;

        this.content = Objects.requireNonNull(content,
                "The given content cannot be null");

        this.permittedTypes = Objects.requireNonNull(permittedTypes,
                "The given permittedTypes cannot be null");

        this.permittedMimeTypes = Objects.requireNonNull(
                permittedMimeTypes, "The given permittedMimeTypes cannot be null");

        this.permittedFileExtensions = Objects.requireNonNull(permittedFileExtensions,
                "The given permittedFileExtensions cannot be null");

        this.invalidTypes = Objects.requireNonNull(invalidTypes,
                "The given invalidTypes cannot be null");

        warnings = Collections.emptyList();
    }

    @NotNull
    @Override
    @Contract(value = " -> new", pure = true)
    public AcceptAttribute attribute() {
        return new AcceptAttribute();
    }

    @Contract(pure = true)
    public boolean isValidType(final String type) {
        return permittedMimeTypes.contains(type) || permittedFileExtensions.contains(type);
    }

    @Contract(pure = true)
    public boolean isValidMime(final String type) {
        return permittedMimeTypes.contains(type);
    }

    @Contract(pure = true)
    public boolean isValidExtension(final String type) {
        return permittedFileExtensions.contains(type);
    }


    @NotNull
    @Override
    @Contract(pure = true)
    public List<AcceptAttributeError> errors() {
        return Collections.unmodifiableList(loadErrors());
    }

    @Override
    @Contract(pure = true)
    public boolean hasErrors() {
        return !loadErrors().isEmpty();
    }


    private List<AcceptAttributeError> loadErrors() {
        if (errors == null) {
            errors = invalidTypes().stream()
                    .map(AcceptAttributeError::new)
                    .toList();
        }

        return errors;
    }


    @NotNull
    @Override
    @UnmodifiableView
    @Contract(pure = true)
    public List<HTMLAttributeWarning<AcceptAttribute>> warnings() {
        return Collections.unmodifiableList(warnings);
    }

    @Override
    @Contract(pure = true)
    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }


    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {return success;}

    @NotNull
    @Contract(pure = true)
    public String content() {return content;}

    @NotNull
    @UnmodifiableView
    @Contract(pure = true)
    public List<String> permittedTypes() {return Collections.unmodifiableList(permittedTypes);}

    @NotNull
    @UnmodifiableView
    @Contract(pure = true)
    public List<String> permittedMimeTypes() {return Collections.unmodifiableList(permittedMimeTypes);}

    @NotNull
    @UnmodifiableView
    @Contract(pure = true)
    public List<String> permittedFileExtensions() {return Collections.unmodifiableList(permittedFileExtensions);}

    @NotNull
    @UnmodifiableView
    @Contract(pure = true)
    public List<String> invalidTypes() {return Collections.unmodifiableList(invalidTypes);}


    @Override
    @Contract(value = "null -> false", pure = true)
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CompiledAcceptAttribute that = (CompiledAcceptAttribute) obj;

        if (success != that.success) return false;
        if (!content.equals(that.content)) return false;
        if (!permittedTypes.equals(that.permittedTypes)) return false;
        if (!permittedMimeTypes.equals(that.permittedMimeTypes)) return false;
        if (!permittedFileExtensions.equals(that.permittedFileExtensions)) return false;
        if (!invalidTypes.equals(that.invalidTypes)) return false;
        return Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + content.hashCode();
        result = 31 * result + permittedTypes.hashCode();
        result = 31 * result + permittedMimeTypes.hashCode();
        result = 31 * result + permittedFileExtensions.hashCode();
        result = 31 * result + invalidTypes.hashCode();
        return result;
    }

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledAcceptAttribute{" +
                "success=" + success +
                ", content='" + content + '\'' +
                ", permittedTypes=" + permittedTypes +
                ", permittedMimeTypes=" + permittedMimeTypes +
                ", permittedFileExtensions=" + permittedFileExtensions +
                ", invalidTypes=" + invalidTypes +
                ", errors=" + errors +
                '}';
    }
}