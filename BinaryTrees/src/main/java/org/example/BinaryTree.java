package org.example;

/**
 * Binary Tree Klasse.
 * @param <T> Jeder Typ, der auch Comparable ist.
 */
public class BinaryTree <T extends Comparable<T>> {

    /**
     * Wurzel des Baumes
     */
    private TreeNode<T> root;

    /**
     * Erzeugt Baum ohne root.
     */
    public BinaryTree() {
    }

    /**
     * Erzeugt Baum mit einem root.
     * @param value  Wert der Wurzel
     */
    public BinaryTree(T value) {
        this.root = new TreeNode<T>(value);
    }

    /**
     * Konstruktor für einen AVL Baum
     * @param root AVL Node für die Wurzel
     */
    public BinaryTree( AVLNode<T> root ) {
        this.root = root;
    }

    /**
     *
     * @return Gibt aus, ob Bau, leer ist.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     *
     * @return Gibt die Wurzel aus.
     */
    public TreeNode<T> getRoot() {
        return this.root;
    }

    /**
     * Nachträgliche Setzung der Wurzel.
     * @param root Ein Knoten, der zur Wurzel wird.
     */
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }


    /**
     * Fügt einen neuen Knoten hinzu
     * @param value Wert des Knotens
     * @return boolean, ob das Hinzufügen erfolgreich war
     */
    public boolean insert(T value) {
        if (this.isEmpty()) {
            this.root = new TreeNode<T>(value);
            return true;
        } else {
            return this.root.insert(value);
        }
    }

    /**
     * Sucht nach einem Knoten
     * @param value Wert des Knotens
     * @return Gibt zurück, ob Wert gefunden wurde
     */
    public boolean find(T value) {
        if (this.isEmpty()) {
            return false;
        } else {
            return this.root.find(value);
        }
    }

    /**
     * Sucht rekursiv den kleinsten Wert
     * @return Gibt den kleinsten Knoten zurück
     * @throws EmptyTreeException Wird geworfen, wenn Baum leer ist
     */
    public T findMinRekursiv() throws EmptyTreeException {
        if (this.isEmpty()) {
            throw new EmptyTreeException();
        } else {
            return this.root.findMinRekursiv();
        }
    }

    /**
     * Sucht iterativ nach dem kleinsten Wert im Baum
     * @return Gibt den kleinsten Wert zurück
     * @throws EmptyTreeException Wird geworfen, wenn Baum leer ist
     */
    public T findMinIterativ() throws EmptyTreeException {
        if (this.isEmpty()) {
            throw new EmptyTreeException();
        } else {
            return this.root.findMinIterativ();
        }
    }

    /**
     * Sucht nach dem größten Wert im Baum
     * @return Gibt den größten Wert zurück.
     * @throws EmptyTreeException Wird geworfen, wenn Baum leer ist
     */
    public T findMaxElement() throws EmptyTreeException {
        if (this.isEmpty()) {
            throw new EmptyTreeException();
        } else {
            return this.root.findMaxElement();
        }
    }


    /**
     * Loescht einen Knoten
     * @param value Knoten, nach dem gesucht werden soll
     * @return Gibt zurück, ob das Loeschen erfolgreich war
     * @throws EmptyTreeException
     */
    public boolean remove(T value) throws EmptyTreeException {
        if (this.isEmpty()) { throw new EmptyTreeException(); }
        // Mit find() gucken, ob der Knoten überhaupt erstmal existiert
        else if (!this.find(value)){ return false; }
        else if (this.root.hasNoChildren() && this.root.getKey().compareTo(value) == 0){
            this.root = null;
            return true;
        }
        else {
            return this.root.delete(value);
        }
    }

    /**
     * Traversierungen eines Baums
     * @param traversal Ist vom Typ Traversal. INORDER, POSTORDER, PREORDER
     * @return Gibt die Traversierung als String aus
     */
    public String traverse(Traversal traversal) {
        return this.root.traverse(traversal);
    }


    /**
     * Gibt den Baum als String aus
     * @return String-Repräsebtation des Baums
     */
    public String toString() {
        if (this.isEmpty()) { return null; }
        else { return this.root.toString(); }
    }
}




