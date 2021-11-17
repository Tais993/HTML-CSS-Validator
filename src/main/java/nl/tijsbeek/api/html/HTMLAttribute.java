package nl.tijsbeek.api.html;

public interface HTMLAttribute {

    String name();

    boolean isValidContent(String content);
}