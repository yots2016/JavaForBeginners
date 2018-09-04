package special_tasks1.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String inputString = "dfdsfdksnfdgnfsdkj;gnkjsdfgsdfkgnksdfg";

        System.out.println(countLettersByCollections(inputString));
        System.out.println(countLettersByStream(inputString));

    }

    public static Map<Character, Integer> countLettersByCollections(String inputString) {
        Map<Character, Integer> charactersMap = new HashMap<>();

        for (char element : inputString.toCharArray()){
            charactersMap.merge(element, 1, Integer::sum);
        }
        return charactersMap;
    }

    public static Map<Object, Long> countLettersByStream(String inputString) {
        return inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
