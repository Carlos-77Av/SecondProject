import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Subjects {
    private final String file;

    public Subjects(String file){
        this.file = file;
    }


    public LinkedHashMap<String, String> readData(){
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        File txt = new File(file);
        try{
            Scanner readerFile = new Scanner(txt);
            data.put("email", readerFile.nextLine());
            while (readerFile.hasNext()){
                String[] parts = readerFile.nextLine().split(",");
                data.put(parts[0], parts[1].trim());
            }
        }catch(IOException ex){
            System.out.println("An error occurred loading the txt file");
        }
        return data;
    }

}
