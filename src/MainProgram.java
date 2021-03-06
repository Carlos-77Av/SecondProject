/*
* Author's name: Carlos Jose Alvarez Ventura
*
* Program description:
*       Create a Java application using OOP, Maven and lombok to manage the grades of 3 subjects
*       for X students (dynamic input).

        The program could have a menu with these main options, for each subject: load file (subject),
        add student to subject, generate and send reports, exit. Could have a subjects menu and other
        sub menu to manage options.

        The input of students and their grades will be through a file (name and grade) for each subject
        or input through keyboard. The program should give you the option of input (file or keyboard).
        In case of input by keyboard, it is necessary to validate numbers(not negative, ≥ 0 and ≤10, only numbers).
        We can suppose that each file is a subject. You might need a menu to ask user if wants
        to add a new student and grade.

        It is necessary to generate a report with the full list of students by each subject, a set of statistics
        (min, max, avg, most repeated; in all cases show the sub list of people with that grade and the number
        of repetitions, except the avg). This report must be generated as .txt file and .PDF file. and sent to
        an email that will be read from each file (the first line is assumed as destination email)
        (research how to do it and add your dependencies to your pom).

        We need to see your design (could be top down, UML) . Your design must depict your interfaces and classes,
        properties, methods, access modifiers and any other thing that you will include in your program.

        All the application must be written in english (all, all, all).
*/

public class MainProgram {
    public static void main(String[] args){
        //Showing the initial menu

        Menus menu = new Menus();
        menu.subjectMenu();
    }
}
