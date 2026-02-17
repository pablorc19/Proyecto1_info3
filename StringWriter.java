import java.io.FileWriter;
import java.io.IOException;


public class StringWriter {
    private FileWriter writer;
        
    public StringWriter(String filePath) {
        try{
            writer=new FileWriter(filePath);
        } catch (IOException e){
            System.out.println("Error de sistema: "+ e.getMessage());
            e.printStackTrace();
        }
    }

    public void write(boolean result) {
        if(writer!=null){
                try{
                writer.write(Boolean.toString(result)+"\n");
                writer.flush();
            } catch (IOException e){
                System.out.println("Error de sistema: "+ e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void close() {
        if(writer!=null){
                try{
                writer.flush();
                writer.close();
            } catch (IOException e){
                System.out.println("Error de sistema: "+ e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
