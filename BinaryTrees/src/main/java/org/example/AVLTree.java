package org.example;

public class AVLTree <T extends Comparable<T>>{

    /**
     * Wurzel des Baumes
     */
    private AVLNode<T> root;

    /**
     * Erzeugt Baum mit einem root.
     * @param value  Wert der Wurzel
     */
    public AVLTree (T value){
        this.root = new AVLNode<>(value);
    }

    /**
     *
     * @return Gibt die Wurzel aus.
     */
    public AVLNode<T> getRoot() {
        return root;
    }

    /**
     * Nachträgliche Setzung der Wurzel.
     * @param root Ein Knoten, der zur Wurzel wird.
     */
    public void setRoot(AVLNode<T> root) {
        this.root = root;
    }

    /**
     * Gibt Hoehe des Baums zurueck
     * @return Hoehe des Baums
     */
    public int height() {
        if (root == null) return 0;
        return root.getHeight();
    }

    /**
     * Guckt, ob Baum leer ist
     * @return Gibt Boolean zurück, ob Baum leer ist.
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Sucht knoten im Baum
     * @param value Wert des zu suchenden Knotens
     * @return Gibt aus, ob Knoten gefunden wurde
     */
    public boolean find(T value) {
        return contains(root, value);
    }

    /**
     * Hilfsmethode für find()
     * @param node Knoten, bei welchem die Suche anfangen soll
     * @param value Wert des zu suchenden Knotens
     * @return Gibt aus, ob Knoten gefunden wurde
     */
    private boolean contains(AVLNode<T> node, T value) {
        if (node == null) return false;

        // Vergleiche Wert mit Wert im Knoten
        int cmp = value.compareTo(node.getKey());

        // Wenn kleiner, gehe in linken Teilbaum
        if (cmp < 0) return contains(node.getLeft(), value);

        // Gehe in rechten Teilbaum, wenn groeßer
        if (cmp > 0) return contains(node.getRight(), value);

        // Wert gefunden.
        return true;
    }

    /**
     * Fügt einen neuen Knoten hinzu
     * @param value Wert des Knotens
     * @return boolean, ob das Hinzufügen erfolgreich war
     */
    public boolean insert(T value) {
        if (value == null) return false;
        if (!contains(root, value)) {
            root = insert(root, value);

            return true;
        }
        return false;
    }

    /**
     * Hilfsmethode für insert()
     * @param node Knoten, auf dem insert() anfangen soll
     * @param value Wert des zu suchenden Knotens
     * @return Gibt aus, ob Knoten hinzugefügt wurde
     */
    private AVLNode<T> insert(AVLNode<T> node, T value) {

        if (node == null) return new AVLNode<>(value);

        // Vergleiche value mit dem Key vom node
        int cmp = value.compareTo(node.getKey());

        // Wenn kleiner, dann weiter im linken Teilbaum fortfahren
        if (cmp < 0) {
            node.setLeft(insert(node.getLeft(), value));

            // Wenn größer, dann im rechten Teilbaum fortfahren
        } else {
            node.setRight(insert(node.getRight(), value));
        }

        // Update balance und Höhe.
        update(node);

        // Rebalanzierung des Baumes
        return balance(node);
    }

    /**
     * Aktualisiert nach Veränderungs-Operationen die Balance und Hoehe Werte
     * @param node Knoten, auf dem die Werte geupdatet werden
     */
    private void update(AVLNode<T> node) {
        int leftNodeHeight = (node.getLeft() == null) ? -1 : node.getLeft().getHeight();
        int rightNodeHeight = (node.getRight() == null) ? -1 : node.getRight().getHeight();

        // Aktualisiere die Höhe des Knotens
        node.setHeight( 1 + Math.max(leftNodeHeight, rightNodeHeight));

        // Aktualisiere Balance des Knotens
        node.setBalance(rightNodeHeight - leftNodeHeight);
    }

    /**
     * Rebalanciert einen Baum
     * @param node Knoten, auf dem die Operation stattfinden soll
     * @return gibt den balanzierten Knoten zurück
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        // Links-geneigter Unterbaum.
        if (node.getBalance() == -2) {

            // Left-Left case.
            if (node.getLeft().getBalance() <= 0) {
                return leftLeftCase(node);

                // Left-Right case.
            } else {
                return leftRightCase(node);
            }

            //Rechts-geneigter Teilbaum.
        } else if (node.getBalance() == +2) {

            // Right-Right case.
            if (node.getRight().getBalance() >= 0) {
                return rightRightCase(node);

                // Right-Left case.
            } else {
                return rightLeftCase(node);
            }
        }
        return node;
    }

    /**
     * Wenn Knoten Links voneinander stehen, soll eine Rechtsrotation stattfinden
     * @param node Knoten, auf dem das stattfinden soll
     * @return gib den Knoten aus
     */
    private AVLNode<T> leftLeftCase(AVLNode<T> node) {
        return rightRotation(node);
    }

    /**
     * Linker Knoten hat Rechten Nachfolger. Eine Linksrotation muss stattfinden
     * @param node Knoten, auf dem die Rotation stattfinden soll
     * @return Gibt den knoten aus
     */
    private AVLNode<T> leftRightCase(AVLNode<T> node) {
        node.setLeft(leftRotation(node.getLeft()));
        return leftLeftCase(node);
    }

    /**
     * Knoten liegen rechts voneinander
     * @param node Knoten, auf dem die Rechtsrotation stattfinden soll
     * @return Gibt den Knoten wieder aus
     */
    private AVLNode<T> rightRightCase(AVLNode<T> node) {
        return leftRotation(node);
    }

    /**
     * Rechter Knoten hat linkes kind. Linker Nachfolger muss nach rechts
     * @param node Knoten, auf dem die Operation stattfindet
     * @return Gibt den Knoten wieder aus
     */
    private AVLNode<T> rightLeftCase(AVLNode<T> node) {
        node.setRight(rightRotation(node.getRight()));
        return rightRightCase(node);
    }

    /**
     * Linksrotation um einen Knoten
     * @param node Knoten, um den eine Linksrotation stattfinden soll
     * @return Gibt den Parent vom node aus, der vorher ein rechtes Kind vom node war
     */
    private AVLNode<T> leftRotation(AVLNode<T> node) {
        AVLNode<T> newParent = node.getRight();
        node.setRight(newParent.getLeft());
        newParent.setLeft(node);
        update(node);
        update(newParent);
        return newParent;
    }

    /**
     * Rechtsrotation um einen Knoten
     * @param node Knoten, um den eine Rechtsrotation stattfinden soll
     * @return Gibt den Parent vom node aus, der vorher ein linkes Kind vom node war
     */
    private AVLNode<T> rightRotation(AVLNode<T> node) {
        AVLNode<T> newParent = node.getLeft();
        node.setLeft(newParent.getRight());
        newParent.setRight(node);
        update(node);
        update(newParent);
        return newParent;
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
