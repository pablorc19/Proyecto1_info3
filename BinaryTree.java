import java.io.File;
import java.util.*;

public class BinaryTree {
    private Nodo raiz; 
    
    public BinaryTree(String filePath) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            sc.nextLine();
            
            if (sc.hasNextLine()) {
                Queue<Nodo> colaPadres = new LinkedList<>();
                String lineaRaiz = sc.nextLine();
                String[] partesRaiz = lineaRaiz.split(",");
                raiz = new Nodo(partesRaiz[0].charAt(0), Integer.parseInt(partesRaiz[1]), Integer.parseInt(partesRaiz[2]));
                colaPadres.add(raiz);

                while (sc.hasNextLine()) {
                    String linea = sc.nextLine();
                    Queue<Nodo> colaHijos = new LinkedList<>();
                    lector_de_lineas(linea, colaHijos);
                    
                    int tamanoNivel = colaPadres.size();
                    for (int i = 0; i < tamanoNivel; i++) {
                        Nodo p = colaPadres.poll();
                        if (p.ver_izquierdo()) {
                            p.nodo_izquierdo = colaHijos.poll();
                            colaPadres.add(p.nodo_izquierdo);
                        }
                        if (p.ver_derecho()) {
                            p.nodo_derecho = colaHijos.poll();
                            colaPadres.add(p.nodo_derecho);
                        }
                    }
                }
            }
            sc.close();
        } catch (Exception e) {}
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

    public boolean contains_string(String string) {
        if (string == null || string.equals("") || raiz == null) return false;
        return buscarDesdeTodoElArbol(raiz, string);
    }

    private boolean buscarDesdeTodoElArbol(Nodo n, String s) {
        if (n == null) return false;
        if (validarRuta(n, s, 0)) return true;
        return buscarDesdeTodoElArbol(n.nodo_izquierdo, s) || buscarDesdeTodoElArbol(n.nodo_derecho, s);
    }

    private boolean validarRuta(Nodo n, String s, int i) {
        if (i == s.length()) return true;
        if (n == null || n.letra != s.charAt(i)) return false;
        if (i == s.length() - 1) return true;
        
        return validarRuta(n.nodo_izquierdo, s, i + 1) || validarRuta(n.nodo_derecho, s, i + 1);
    }
}