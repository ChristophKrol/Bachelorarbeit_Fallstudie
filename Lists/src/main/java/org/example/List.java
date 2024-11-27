package org.example;

public interface List {
    /**
     * Gibt einen Boolean zurueck, ob Liste leer ist.
     * @return Gibt einen Boolean zurück, ob Liste leer ist.
     */
    public boolean isEmpty();

    /**
     * Ein Knoten wird als erstes Element hinzugefuegt
     * @param value Wert, der hinzugefuegt werden soll.
     */
    public void addFirst(Object value);

    /**
     * Gibt den Wert des ersten Knotens zurueck.
     * @return Gibt den Wert des ersten Knotens zurueck.
     * @throws ListEmptyException Wenn diese Methode auf eine Leere Liste angewendet wird, kommt diese Exception.
     */
    public Object getFirst() throws ListEmptyException;

    /**
     * Loescht das erste Element und gibt es aus.
     * @return Gibt Wert des geloeschten Elements aus.
     * @throws ListEmptyException Wenn diese Methode auf eine Leere Liste angewendet wird, kommt diese Exception.
     */
    public Object removeFirst() throws ListEmptyException;

    /**
     * Ein Element wird an das Ende der Liste hinzugefuegt.
     * @param value Das Element kriegt einen Wert zugewiesen.
     */
    public void addLast(Object value);

    /**
     * Gibt das letzte Element zurueck.
     * @return Gibt das letzte Element zurueck.
     * @throws ListEmptyException Wenn diese Methode auf eine Leere Liste angewendet wird, kommt diese Exception.
     */
    public Object getLast() throws ListEmptyException;

    /**
     * Loescht das letzte Element und gibt es aus.
     * @return Gibt den Wert des geloeschten Elements aus.
     * @throws ListEmptyException Wenn diese Methode auf eine Leere Liste angewendet wird, kommt diese Exception.
     */
    public Object removeLast() throws ListEmptyException;
}
