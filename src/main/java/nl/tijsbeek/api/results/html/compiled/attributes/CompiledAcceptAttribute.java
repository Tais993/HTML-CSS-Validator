package nl.tijsbeek.api.results.html.compiled.attributes;

import nl.tijsbeek.api.html.attributes.AcceptAttribute;
import nl.tijsbeek.api.results.html.compiled.CompiledHTMLAttribute;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnmodifiableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public record CompiledAcceptAttribute(
        boolean success,
        @NotNull String content,
        @UnmodifiableView @NotNull List<String> permittedTypes,
        @UnmodifiableView @NotNull List<String> permittedMimeTypes,
        @UnmodifiableView @NotNull List<String> permittedFileExtensions,
        @UnmodifiableView @NotNull List<String> invalidTypes)
        implements CompiledHTMLAttribute<AcceptAttribute> {
    private static final Logger logger = LoggerFactory.getLogger(CompiledAcceptAttribute.class);

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

    @NonNls
    @NotNull
    @Override
    @Contract(pure = true)
    public String toString() {
        return "CompiledAcceptAttribute{" +
                "content='" + content + '\'' +
                ", permittedMimeTypes=" + permittedMimeTypes +
                ", permittedFileExtensions=" + permittedFileExtensions +
                '}';
    }
}