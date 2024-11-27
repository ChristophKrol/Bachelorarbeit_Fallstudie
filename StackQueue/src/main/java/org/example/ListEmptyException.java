package org.example;

public class ListEmptyException extends Exception {
    /**
     * Erzeugt eine Exception mit der Nachricht "Liste ist leer.".
     */
    public ListEmptyException() {
        super("Liste ist leer");

    }


}
