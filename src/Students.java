import java.util.LinkedHashMap;
import java.util.Scanner;

public class Students {
    private String name;
    private double grade;

    //Constructor of the class
    public Students(String name, double grade){
        this.name = name;
        this.grade = grade;
    }

    public boolean AddStudents(Scanner read, LinkedHashMap<String, String> studentData){
        //This add the new Students to the map with the information passed previously by the constructor
        studentData.put(this.name, Double.toString(this.grade));

        System.out.print("\nDo you want to add another student (Y/N)? ");
        char ans = read.next().charAt(0);

        if (ans == 'Y' || ans == 'y'){
            return true;
        }
        else if (ans == 'N' || ans == 'n'){
            return false;
        }
        else{
            System.out.println("The option is not correct.");
            return false;
        }
    }
}
