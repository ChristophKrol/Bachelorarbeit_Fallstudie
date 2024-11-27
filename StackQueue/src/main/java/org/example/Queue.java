package org.example;

public interface Queue {

    /**
     * Gibt einen Boolean zurueck, ob die Queue leer ist.
     * @return Gibt einen Boolean zurueck, ob die Queue leer ist.
     */
    public boolean isEmpty();

    /**
     * Ein Element wird zu der Queue angeschlossen.
     * @param enter Wert, der dem Element zugewiesen wird.
     */
    public void enter(Object enter);

    /**
     * Loescht ein Element nach dem LIFO-Prinzip und gibt es aus.
     * @return Gibt Wert des geloeschten Elements aus.
     * @throws ListEmptyException Wenn diese Methode auf eine Leere Liste/Queue angewendet wird, kommt diese Exception.
     */
    public Object leave() throws ListEmptyException;
}
