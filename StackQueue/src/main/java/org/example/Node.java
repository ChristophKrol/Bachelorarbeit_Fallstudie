package org.example;

public class Node {

    private Object value;
    private Node next;
    private Node prev;

    /**
     * Erzeugt einen Listenknoten.
     * @param value Value ist der Wert des Knotens.
     * @param next Next ist der Nachfolger des Knotens.
     */
    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;

    }

    /**
     * Erzeugt einen Listenknoten.
     * @param value Value ist der Wert des Knotens.
     */
    public Node(Object value){

        this.value = value;
    }

    /**
     * Standard-Konstruktor ohne Zuweisungen.
     */
    public Node(){ }


    /**
     * Knotenkonstruktor fuer Doppelt-Verkettete Listen.
     * @param value Wert des Knotens.
     * @param next Nachfolger-Knoten.
     * @param prev Vorgaenger-Knoten.
     */
    public Node(Object value, Node next, Node prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
        next.setPrev(this);
        prev.setNext(this);
    }


    /**
     * Methode fuer Doppelt-Verkettete Listen.
     * @return Gibt den Vorgaenger eines Knotens zurueck.
     */
    public Node getPrev() {
        return prev;
    }


    /**
     * Methode fuer Doppelt-Verkettete Listen.
     * @param prev Setzt einen Vorgaenger-Knoten.
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }


    /**
     * Gibt den Wert eines Knotens zurueck.
     * @return Gibt den Wert eines Knotens zurueck.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Setzt einen Wert fuer den Knoten.
     * @param value Setzt einen Wert fuer den Knoten.
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Gibt den Nachfolger eines Knotens zurueck.
     * @return Gibt den Nachfolger eines Knotens zurueck.
     */
    public Node getNext() {
        return next;
    }

    /**
     * Setzt einen Nachfolger fuer den aktuellen Knoten.
     * @param next Setzt einen Nachfolger fuer den aktuellen Knoten.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Rekursive Hilfsmethode zum Einfuegen eines Knotens ans Ende einer Liste.
     * @param value Wert, mit dem der neue Knoten initialisiert werden soll.
     */
    public void addLast(Object value) {
        if(this.next == null){
            this.next = new Node(value);
        }
        else{ this.next.addLast(value); }
    }

    /**
     * Gibt den letzen Knoten zurueck.
     * @return Gibt letzen Knoten zurueck.
     */
    public Node getLastElement() {
        if(this.next == null){ return this; }
        else{ return this.next.getLastElement(); }
    }

    /**
     * Rekursive Hilfsmethode zum Ausgeben eines Wertes.
     * @return Gibt den Wert des letzen Knotens zurueck.
     */
    public Object getLast() {
        if(this.next == null){ return this.value; }
        else{ return this.next.getLast(); }
    }

    /**
     * Rekursive Hilfsmethode zum Loeschen des letzen Knotens.
     * @return Gibt den Wert des geloeschten Knotens.
     */
    public Object removeLast() {
        if(this.next.next == null){
            Object temp = this.next.value;
            this.next = null;
            return temp;
        }
        else{ return this.next.removeLast(); }
    }

    /**
     * Rekursive Hilfsmethode zum Ausgeben einer String-Repraesentation der Liste. Dabei wird zwischen der Einfachen- und Doppeltverketetten Liste unterschieden.
     * @return String-Repraesentation einer Liste
     */
    public String toString(){
        if(this.next == null ){
            return "[" + this.value + "]";
        }
        else{
            if ((this.next.prev != null && this.value == "HEAD") || this.prev != null){ return "[" + this.value +"]" + "<->" + this.next.toString(); }    // Wenn ein Node Referenzen auf Vorgänger hat, muss es sich um eine Doppelt verkettete Liste handeln
            else { return "[" + this.value +"]" + "->" + this.next.toString(); }
        }
    }
}
