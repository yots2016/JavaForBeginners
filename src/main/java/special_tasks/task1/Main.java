package special_tasks.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String inputString = "dfdsfdksnfdgnfsdkj;gnkjsdfgsdfkgnksdfg";

        System.out.println(countLettersByCollections(inputString).toString());
        System.out.println(countLettersByStream(inputString).toString());

    }

    public static Map<Character, Integer> countLettersByCollections(String inputString) {
        Map<Character, Integer> charactersMap = new HashMap<>();

        for (int i = 0; i < inputString.length(); i++) {
            Integer number = charactersMap.get(inputString.charAt(i));

            if (number == null) {
                charactersMap.put(inputString.charAt(i), 1);
            } else {
                charactersMap.put(inputString.charAt(i), ++number);
            }
        }

        return charactersMap;
    }

    public static Map<Object, Long> countLettersByStream(String inputString) {
        return inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
