package nl.tijsbeek.api.html;

import java.util.List;

public interface HTMLElement {

    String name();

    List<HTMLAttribute<?>> permittedAttributes();

    List<HTMLElement> permittedElements();
}