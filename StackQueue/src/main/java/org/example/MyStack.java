package org.example;

public class MyStack implements Stack {
    private MyList top;

    /**
     * Standard-Konstruktor
     */
    public MyStack(){
        this.top = new MyList();
    }

    /**
     * Gibt aus, ob Stack leer ist.
     * @return Boolean, ob Stack leer ist.
     */
    public boolean isEmpty(){ return this.top.isEmpty(); }

    /**
     * Fuegt ein Element dem Stack ein.
     * @param o Dem Element wird ein Wert o zugewiesen.
     */
    public void push(Object o){
        Node n = new Node(o, this.top.head.getNext());
        this.top = new MyList(n);
    }

    /**
     * Loescht ein Element aus dem Stack nach dem FIFO-Prinzip.
     * @return Gibt den Wert des Elements aus.
     * @throws ListEmptyException Falls Stack leer ist, wird diese Exception beim Ausfuehren der Methode geworfen.
     */
    public Object pop() throws ListEmptyException {
        if (this.isEmpty()){ throw new ListEmptyException(); }
        else{
            Object temp = this.top.head.getNext().getValue();
            this.top = new MyList(this.top.head.getNext().getNext());
            return temp;
        }

    }

    /**
     * Gibt den Stack als String aus.
     * @return String, der den Stack repraesentiert.
     */
    public String toString() {
        return top.toString();
    }



}
