import java.util.*;

public class Statistics {

    public LinkedHashMap<String, Double> minGrade (LinkedHashMap<String, String> studentData){
        //Declaration of an map where ig going to be save the new list without email
        Map<String, Double> map = new HashMap<>();
        //Declaration of the new map which contain the list of students with the lowest grade
        LinkedHashMap<String, Double> returnData = new LinkedHashMap<>();
        //Declaring variable that is going to contain one of the grade in order to comparing with others
        double initialValue;

        for (Map.Entry<String, String> element: studentData.entrySet()) {
            //This is in order to avoid the email
            if (!element.getKey().equals("email")) {
                map.put(element.getKey(), Double.parseDouble(element.getValue()));
            }
        }

        //Taking one of the grade values
        initialValue = map.get(map.keySet().toArray()[0]);

        //Looping the new map that contains students and their grades
        for (Map.Entry<String, Double> entry: map.entrySet()){
            //Checking if the actual value of map is greater than previous (initialValue)
            if (initialValue > entry.getValue()){
                initialValue = entry.getValue();
                //In case previous value were lowest, this is going to clear the map and add the new lowest grade
                returnData.clear();
                returnData.put(entry.getKey(), entry.getValue());
            }//If it is equal it will be add to the map
            else if (initialValue == entry.getValue()){
                returnData.put(entry.getKey(), entry.getValue());
            }
        }

        //This is just for knowing if it works correctly
        System.out.println("The list of student grades lowest is the following: \n");
        returnData.forEach((name, grade) -> System.out.println("Name: " + name + " \t " + grade));
        System.out.println();
        return returnData;
    }


    public LinkedHashMap<String, Double> maxGrade (LinkedHashMap<String, String> studentData){
        //Declaration of an map where ig going to be save the new list without email
        Map<String, Double> map = new HashMap<>();
        //Declaration of the new map which contain the list of students with the greater grade
        LinkedHashMap<String, Double> returnData = new LinkedHashMap<>();
        //Declaring variable that is going to contain one of the grade in order to comparing with others
        double initialValue;

        for (Map.Entry<String, String> element: studentData.entrySet()) {
            //This is in order to avoid the email
            if (!element.getKey().equals("email")) {
                map.put(element.getKey(), Double.parseDouble(element.getValue()));
            }
        }

        //Taking one of the grade values
        initialValue = map.get(map.keySet().toArray()[0]);

        //Looping the new map that contains students and their grades
        for (Map.Entry<String, Double> entry: map.entrySet()){
            //Checking if the actual value of map is greater than previous (initialValue)
            if (initialValue < entry.getValue()){
                initialValue = entry.getValue();
                //In case previous value were lowest, this is going to clear the map and add the new greater grade
                returnData.clear();
                returnData.put(entry.getKey(), entry.getValue());
            }//If it is equal it will be add to the map
            else if (initialValue == entry.getValue()){
                returnData.put(entry.getKey(), entry.getValue());
            }
        }

        //This is just for knowing if it works correctly
        System.out.println("The list of student grades lowest is the following: \n");
        returnData.forEach((name, grade) -> System.out.println("Name: " + name + " \t " + grade));
        System.out.println();
        return returnData;
    }

    public double avgGrade(LinkedHashMap<String, String> studentData){
        //Declaration of an map where ig going to be save the new list without email
        Map<String, Double> map = new HashMap<>();
        double avg = 0;

        for (Map.Entry<String, String> element: studentData.entrySet()) {
            //This is in order to avoid the email
            if (!element.getKey().equals("email")) {
                map.put(element.getKey(), Double.parseDouble(element.getValue()));
            }
        }

        for (Map.Entry<String, Double> entry: map.entrySet()){
            avg += entry.getValue();
        }
        avg /= map.size();
        System.out.println("The grade average is: " + avg);
        return avg;
    }

    public LinkedHashMap<String, Double> mostRepGrade (LinkedHashMap<String, String> studentData){
        //Counter for most repeated
        int counter = 0, previousCounter = 0;
        //Declaration of an map where ig going to be save the new list without email
        Map<String, Double> map = new HashMap<>();
        //Declaration of the new map which contain the list of students with the greater grade
        LinkedHashMap<String, Double> returnData = new LinkedHashMap<>();
        //Declaring variable that is going to contain one of the grade in order to comparing with others

        for (Map.Entry<String, String> element: studentData.entrySet()) {
            //This is in order to avoid the email
            if (!element.getKey().equals("email")) {
                map.put(element.getKey(), Double.parseDouble(element.getValue()));
            }
        }

        //Looping the new map that contains students and their grades
        for (Map.Entry<String, Double> entry: map.entrySet()){
            //Checking if the actual value of map is greater than previous (initialValue)
            for (Map.Entry<String, Double> loop: map.entrySet()){
                if (entry.getValue().equals(loop.getValue())){
                    counter++;
                }
            }

            if (counter > previousCounter) {
                previousCounter = counter;
                //The ArrayList is cleared
                returnData.clear();
                //Add the new highest value
                returnData.put(entry.getKey(), entry.getValue());
            }
            else if (counter == previousCounter){
                returnData.put(entry.getKey(), entry.getValue());
            }

            counter = 0;
        }

        //This is just for knowing if it works correctly
        System.out.println("The most repeated grades are: \n");
        returnData.forEach((name, grade) -> System.out.println("Name: " + name + " \t " + grade));
        System.out.println();
        return returnData;
    }
}
