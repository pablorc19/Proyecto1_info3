import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class StringReader {
    private ArrayList<String> cadenas=new ArrayList<>();
    public StringReader(String filePath) throws FileNotFoundException {
        try(Scanner readerScanner=new Scanner(new FileReader(filePath))){
            while(readerScanner.hasNextLine()){
                String linea = readerScanner.nextLine().trim();
                if(!linea.isEmpty()){//excluye lineas vacias, como enters o espacios, asumiendolas como accidentales. 
                    cadenas.add(linea);
                }           
            }
        }
    }

    public int length() {
        return cadenas.size();
    }

    public String get(int index) {
        if(index>=cadenas.size()||index<0){
            throw new IndexOutOfBoundsException("Indice no válido: "+index);
        } else {
            return cadenas.get(index);
        }
    }
}
