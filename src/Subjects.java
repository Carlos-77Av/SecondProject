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
        LinkedHashMap<String, String> email = new LinkedHashMap<>();
        File txt = new File(file);
        try{
            Scanner readerFile = new Scanner(txt);
            email.put("email", readerFile.nextLine());
            while (readerFile.hasNext()){
                data.put(readerFile.nextLine().split(",")[0], readerFile.nextLine().split(",")[1]);
            }
        }catch(IOException ex){
            System.out.println("An error occurred loading the txt file");
        }
        return data;
    }

}
