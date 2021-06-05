import java.util.*;
import java.util.stream.Stream;

public class Statistics {
    private Stream min;

    public void minGrade (LinkedHashMap<String, String> studentData){
        /*studentData.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        min = studentData.entrySet().iterator().next();
        return min;
         */
        Map<String, Double> map = new HashMap<>();
        for (Map.Entry<String, String> element: studentData.entrySet()){
            if (element.getKey().equals("email")){
                System.out.println("This element is not going to be counted");
            }
            else{
                map.put(element.getKey(), Double.parseDouble(element.getValue()));
            }
        }

        min = map.entrySet().stream().sorted(Map.Entry.comparingByValue());


    }
}
