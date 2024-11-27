package org.example;

public class MyList implements List {

    protected Node head;

// Konstruktoren

    /**
     * Standard-Konstruktor, der nur einen Head aufbaut.
     */
    public MyList(){
        this.head = new Node("HEAD");
    }

    /**
     * Erzeugt eine Liste mit einem Element.
     * @param node Einzufuegender Knoten.
     */
    public MyList(Node node){
        this.head = new Node("HEAD");
        this.head.setNext(node);
    }

    /**
     * Erzeugt eine Liste mit einem Element
     * @param value Wert, mit dem der neue Knoten initialisiert wird.
     */
    public MyList(Object value) {
        this.head = new Node("HEAD");
        this.head.setNext(new Node(value));
    }

    /**
     * Erzeugt eine Liste mit beliebig vielen Werten. Pro Wert wird ein neuer Knoten erstellt und zur Liste hinzugefuegt.
     * @param values Werte fuer die Knoten.
     */
    public MyList(Object ...values){
        this.head = new Node("HEAD");
        Node cur = this.head;
        for (int i = 0; i < values.length -1 ; i++) {
            cur.setNext(new Node(values[i]));
            cur = cur.getNext();

        }
    }


    /**
     * Gibt Boolean zurueck, ob Liste leer ist.
     * @return Gibt Boolean zurueck, ob Liste leer ist.
     */
    public boolean isEmpty() {
        return this.head.getNext() == null;
    }

    /**
     * Fuegt einen Knoten an Anfang der Liste
     * @param value Wert, der hinzugefuegt werden soll.
     */
    public void addFirst(Object value) {
        if(isEmpty()){
            this.head.setNext(new Node(value));
        }
        else{
            Node temp = this.head.getNext();
            this.head.setNext(new Node(value, temp));  // new Node (value, next)
        }
    }

    /**
     *
     * @return Gibt Wert des ersten Knotens zurueck.
     * @throws ListEmptyException Falls Liste leer ist, wird beim Ausfuehren der Methode diese Exception geworfen.
     */
    public Object getFirst() throws ListEmptyException{
        if (this.isEmpty()){ throw new ListEmptyException(); }
        else{  return this.head.getNext().getValue(); }

    }

    /**
     * Loescht ersten Knoten.
     * @return Gibt Wert vom geloeschten Knoten aus.
     * @throws ListEmptyException Falls Liste leer ist, wird beim Ausfuehren der Methode diese Exception geworfen.
     */
    public Object removeFirst() throws ListEmptyException {
        if (this.isEmpty()){ throw new ListEmptyException(); }
        else{
            Object temp = this.getFirst();
            this.head.setNext(this.head.getNext().getNext());
            return temp;
        }

    }

    /**
     * Fuegt einen Knoten an das Ende der Liste ein.
     * @param value Das Element kriegt einen Wert zugewiesen.
     */
    public void addLast(Object value) {
        if(this.isEmpty()){ this.head.setNext(new Node(value)); }
        else { this.head.addLast(value); }
    }

    /**
     *
     * @return Gibt mithilfe einer rekursiven Methode den Wert des letzen Knotens zurueck.
     * @throws ListEmptyException Falls Liste leer ist, wird beim Ausfuehren der Methode diese Exception geworfen.
     */
    public Object getLast() throws ListEmptyException{
        if(this.isEmpty()){ throw new ListEmptyException(); }
        else{ return this.head.getLast();}
    }

    /**
     * Loescht mithilfe einer rekursiven Methode den letzten Knoten.
     * @return Gibt den Wert des geloeschten Knotens aus.
     * @throws ListEmptyException
     */
    public Object removeLast() throws ListEmptyException{
        if(this.isEmpty()){ throw new ListEmptyException();}
        else{ return this.head.removeLast();}
    }

    /**
     * Erstellt mithilfe einer rekursiven Methode einen String der Liste.
     * @return Gibt eine String Repraesentation der liste aus.
     */
    public String toString() {
        if(this.isEmpty()){ return "[" + "HEAD" + "]"; }
        else{ return this.head.toString(); }

    }
}
