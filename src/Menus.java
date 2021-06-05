import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Menus {
    public void subjectMenu(){
        Scanner read = new Scanner(System.in);
        boolean incorrectOpc;
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
                    subMenu(opc, read, "history");
                    incorrectOpc = false;

                    break;
                case "3":
                    subMenu(opc, read, "programming");
                    incorrectOpc = false;

                    break;
                default:
                    System.out.println("The subject does not exist");
                    incorrectOpc = true;
            }
        }while(incorrectOpc);
    }

    public void subMenu(String selection, Scanner read, String chose){
        LinkedHashMap<String, String> studentData = new LinkedHashMap<>();
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
                    //changing the boolean variable for stop looping
                    other = true;

                    break;
                case "2":
                    System.out.println("::::::::::::: Add students manually :::::::::::::");
                    try{
                        System.out.print("Please, enter the student name: ");
                        String sName = read.next();
                        System.out.print("Please, enter the student grade (0-10): ");
                        double sGrade = read.nextDouble();
                        if (sGrade >= 0 && sGrade <= 10){
                            boolean rep;
                            do {
                                Students addStudent = new Students(sName, sGrade);
                                rep = addStudent.AddStudents(read, studentData);
                            }while (rep);
                        }
                        else{
                            System.out.println("\n\nThe grade entered is not correct.");
                        }
                    }catch (InputMismatchException ex){
                        System.out.println("The name must be between 0 and 10");
                    }
                    break;
                case "3":
                    System.out.println();
                    Statistics stats = new Statistics();
                    stats.minGrade(studentData); // Change the recursive function and use a do while loop
                    stats.maxGrade(studentData);
                    stats.avgGrade(studentData);
                    stats.mostRepGrade(studentData);

                    System.out.println("\nThe information has been loaded correctly.\n");

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
