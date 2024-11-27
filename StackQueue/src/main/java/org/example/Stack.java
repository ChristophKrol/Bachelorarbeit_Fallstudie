package org.example;

public interface Stack {

    /**
     * Gibt einen Boolean zurueck, ob der Stack leer ist.
     * @return Gibt einen Boolean zurueck, ob der Stack leer ist.
     */
    public boolean isEmpty();

    /**
     * Ein Element wird zum Stack hinzugefuegt.
     * @param o Dem Element wird ein Wert o zugewiesen.
     */
    public void push(Object o );

    /**
     * Ein Element wird nach dem FIFO-Prinzip geloescht und ausgegeben.
     * @return Wert des geloeschten Elements wird ausgegeben.
     * @throws ListEmptyException Wenn diese Methode auf eine Leere Liste/Stack angewendet wird, kommt diese Exception.
     */
    public Object pop() throws ListEmptyException;
}
