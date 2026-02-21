import java.util.*;


public class BinaryTree {
    private Nodo raiz; 
    
    public BinaryTree(String filePath) {
        // Constructor de la clase. Aqui debes leer el archivo y construir tu arbol binario
         
        

    }

    public boolean contains_string(String string) {
        // Evalua si un arbol contiene otro sub arbol que pueda generar la cadena proporcionada
        return false;
    }

    private void lector_de_lineas(String linea, Queue<Nodo> cola){
        String[] nodos = linea.split("\\|");
       
        for(String partesNodo:nodos){
            String[] partes=partesNodo.trim().split(",");
            
            char letra=partes[0].charAt(0);
            int hijo_izquierdo=Integer.parseInt(partes[1]);
            int hijo_derecho=Integer.parseInt(partes[2]);
            cola.add(new Nodo(letra,hijo_izquierdo,hijo_derecho));
        }
    }

}
