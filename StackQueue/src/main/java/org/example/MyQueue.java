package org.example;

public class MyQueue implements Queue {
    private DList queue;

    /**
     * Erstellt eine Leere Queue.
     */
    public MyQueue(){
        this.queue = new DList();
    }

    /**
     * Gibt einen Boolean aus, ob die Queue leer ist.
     * @return Gibt einen Boolean aus, ob die Queue leer ist.
     */
    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }


    /**
     * Fügt einen Knoten in die Queue ein nach dem LIFO-Prinzip.
     * @param enter Wert, der dem Knoten zugewiesen wird.
     */
    @Override
    public void enter(Object enter) {
        this.queue.addLast(enter);

    }

    /**
     * Löscht einen Knoten nach dem LIFO-Prinzip.
     * @return Gibt den Wert des geloeschten Knotens aus.
     * @throws ListEmptyException Falls Queue leer ist, wird diese Exception geworfen.
     */
    @Override
    public Object leave() throws ListEmptyException {
        if (this.isEmpty()) { throw new ListEmptyException(); }
        else {
            Object temp = this.queue.getFirst();
            this.queue.removeFirst();
            return temp;
        }

    }

    /**
     * Gibt eine String-Repraesentaion der Queue aus.
     * @return Gibt eine String-Repraesentaion der Queue aus.
     */
    public String toString() {
        return this.queue.toString();
    }
}
