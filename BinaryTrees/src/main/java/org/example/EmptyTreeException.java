package org.example;

/**
 * Exception wenn Operationen auf leeren Baum durchgeführt werden
 */
public class EmptyTreeException extends Exception {

    public EmptyTreeException(){
        super("Baum ist leer.");
    }

}
