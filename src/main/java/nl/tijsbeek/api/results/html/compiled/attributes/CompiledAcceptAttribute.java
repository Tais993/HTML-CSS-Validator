package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AcceptAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import nl.tijsbeek.api.results.html.compiled.linter.errors.attributes.AcceptAttributeError;
import nl.tijsbeek.api.results.html.compiled.linter.warnings.HTMLAttributeWarning;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final record CompiledAcceptAttribute(
        boolean success,
        @NotNull String content,
        @NotNull @UnmodifiableView List<String> permittedTypes,
        @NotNull @UnmodifiableView List<String> permittedMimeTypes,
        @NotNull @UnmodifiableView List<String> permittedFileExtensions,
        @NotNull @UnmodifiableView List<String> invalidTypes,
        @NotNull @UnmodifiableView List<AcceptAttributeError> errors,
        @NotNull @UnmodifiableView HTMLAttributeWarning<AcceptAttribute> warnings

)
        implements CompiledHTMLAttribute<AcceptAttribute, List<AcceptAttributeError>,
        HTMLAttributeWarning<AcceptAttribute>> {

    private static final Logger logger = LoggerFactory.getLogger(CompiledAcceptAttribute.class);


    public CompiledAcceptAttribute(@NotNull final String content,
                                   @NotNull final List<String> permittedTypes,
                                   @NotNull final List<String> permittedMimeTypes,
                                   @NotNull final List<String> permittedFileExtensions,
                                   @NotNull final List<String> invalidTypes) {
        this(true, content, permittedTypes, permittedMimeTypes,
                permittedFileExtensions, invalidTypes, generateErrors(invalidTypes), null);
    }

    public CompiledAcceptAttribute(final boolean success,
                                   @NotNull final String content,
                                   @NotNull final List<String> permittedTypes,
                                   @NotNull final List<String> permittedMimeTypes,
                                   @NotNull final List<String> permittedFileExtensions,
                                   @NotNull final List<String> invalidTypes,
                                   @NotNull List<AcceptAttributeError> errors,
                                   HTMLAttributeWarning<AcceptAttribute> warnings) {

        Objects.requireNonNull(content, "The given content cannot be null");
        Objects.requireNonNull(permittedTypes, "The given permittedTypes cannot be null");
        Objects.requireNonNull(permittedMimeTypes, "The given permittedMimeTypes cannot be null");
        Objects.requireNonNull(permittedFileExtensions, "The given permittedFileExtensions cannot be null");
        Objects.requireNonNull(invalidTypes, "The given invalidTypes cannot be null");

        Objects.requireNonNull(errors, "The given errors cannot be null");

        this.success = success;

        this.content = content;

        this.permittedTypes = Collections.unmodifiableList(permittedTypes);
        this.permittedMimeTypes = Collections.unmodifiableList(permittedMimeTypes);
        this.permittedFileExtensions = Collections.unmodifiableList(permittedFileExtensions);
        this.invalidTypes = Collections.unmodifiableList(invalidTypes);

        this.warnings = warnings;
        this.errors = Collections.unmodifiableList(errors);
    }

    @NotNull
    @UnmodifiableView
    private static List<AcceptAttributeError> generateErrors(@NotNull Collection<String> invalidTypes) {
        return invalidTypes.stream()
                .map(AcceptAttributeError::new)
                .toList();
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


    @Contract(pure = true)
    public boolean hasSuccessFullyCompiled() {
        return success;
    }

    @NotNull
    @Contract(pure = true)
    public String contentAsString() {
        return content;
    }
}