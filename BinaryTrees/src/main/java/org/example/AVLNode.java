package org.example;

public class AVLNode<T extends Comparable<T>> extends TreeNode<T> {

    /**
     * Rechter Nachfolger
     */
    private AVLNode<T> right;

    /**
     * Linker Nachfolger
     */
    private AVLNode<T> left;

    /**
     * Balance des Knotens
     */
    private int balance;
    /**
     * Hoehe des Knotens
     */
    private int height;

    /**
     * Konstruktor
     * @param value Wert fuer den Knoten
     */
    public AVLNode(T value) {
        super(value);
    }


    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public AVLNode<T> getLeft() {
        return left;
    }

    /**
     * {@inheritDoc}
     * @param left
     */
    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }


    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public AVLNode<T> getRight() {
        return right;
    }

    /**
     * {@inheritDoc}
     * @param right
     */
    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    /**
     *
     * @return Gibt Balance aus
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * Setzt Balance
     * @param balance Wert der Balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     *
     * @return Gibt Hoehe zurück
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setzt Hoehe
     * @param height Wert der Hoehe
     */
    public void setHeight(int height) {
        this.height = height;
    }


    /**
     * Gibt Anzahl der Kinder aus
     * @return Max. Anzahl der Kinder
     */
    public int getTotalNumberOfChildren(){
        if (this.getLeft() == null && this.getRight() == null){
            return 1;
        }
        else if (this.getLeft() == null && this.getRight() != null){
            return 1 + this.getRight().getTotalNumberOfChildren();
        }
        else if (this.getLeft() != null && this.getRight() == null){
            return  1 + this.getLeft().getTotalNumberOfChildren();
        }
        else {
            return 1 + this.getLeft().getTotalNumberOfChildren() + this.getRight().getTotalNumberOfChildren();
        }
    }
}
