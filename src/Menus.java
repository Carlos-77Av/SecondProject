import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menus {
    public static void subjectMenu(){
        Scanner read = new Scanner(System.in);
        boolean incorrectOpc = false;
        do {
            System.out.println("Welcome to Project 2\n\n");
            System.out.println("::::::::::::: SUBJECTS :::::::::::::");
            System.out.println("\t 1 - Mathematics");
            System.out.println("\t 2 - History");
            System.out.println("\t 3 - Programming");
            System.out.print("Enter the number of the option required: ");
            String opc = read.next();
            switch (opc) {
                case "1":
                    System.out.println("You chose Mathematics\n\n");
                    subMenu(opc, read, "mathematics");
                    incorrectOpc = false;
                    break;
                case "2":
                    System.out.println("Asi");
                    subMenu(opc, read, "history");
                    incorrectOpc = false;

                    break;
                case "3":
                    System.out.println("asf");
                    subMenu(opc, read, "programming");
                    incorrectOpc = false;

                    break;
                default:
                    System.out.println("The subject does not exist");
                    incorrectOpc = true;
            }
        }while(incorrectOpc);
    }

    public static void subMenu(String selection, Scanner read, String chose){
        LinkedHashMap<String, String> studentData;
        boolean other = false;
        do{
            System.out.println("\n");
            System.out.println("::::::::::::: MENU OF " + chose.toUpperCase() + " :::::::::::::");
            System.out.println("\t 1 - Load file");
            System.out.println("\t 2 - Add student to subject");
            System.out.println("\t 3 - Generate and send report");
            System.out.println("\t 4 - Exit");
            System.out.print("Enter the number of the menu to use: ");
            String opcMenu = read.next();
            switch (opcMenu){
                case "1":
                    System.out.println("The file is loading now");
                    Subjects subjectData = new Subjects(chose + ".txt");

                    //saving the information in a Map
                    studentData = subjectData.readData();

                    //In an illustrative way the system print the information of the file
                /*
                for (Map.Entry data : studentData.entrySet()){
                    System.out.println("Student name: " + data.getKey() + "\t\t Student grade: " + data.getValue());
                }
                 */
                    Statistics stats = new Statistics();
                    stats.minGrade(studentData); // Change the recursive function and use a do while loop

                    System.out.println("\nThe information has been loaded correctly.\n");

                    //After reading the information, the system return to the previous menu
                    subMenu(selection, read, chose);

                    break;
                case "2":
                    System.out.println("::::::::::::: Generate and send report :::::::::::::");

                    break;
                case "3":
                    System.out.println();

                    break;
                case "4":
                    subjectMenu();
                    break;
                default:
                    System.out.println("The option selected does not exist");
                    subMenu(selection, read, chose);
            }
        }while(other);

    }
}
