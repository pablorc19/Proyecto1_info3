public class Nodo {
    public char letra;
    public int hijo_izquierdo; //indicadores en el archivo de texto
    public int hijo_derecho;
    public Nodo nodo_izquierdo; //indicadores en el arbol
    public Nodo nodo_derecho;

    public Nodo(char letra, int hijo_izquierdo, int hijo_derecho){
        //archivo de texto
        this.letra=letra;
        this.hijo_izquierdo=hijo_izquierdo;
        this.hijo_derecho=hijo_derecho;
        //partes del arbol
        this.nodo_derecho=null;
        this.nodo_izquierdo=null;
    }

    public boolean ver_derecho(){
         return hijo_derecho==1;
    }

    public boolean ver_izquierdo(){
         return hijo_izquierdo==1;
    }
    
}
