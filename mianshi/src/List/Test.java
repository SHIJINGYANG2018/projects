package List;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args){
       /* HashMap<String, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put("1",2);
        integerIntegerHashMap.put("2",3);
        System.out.println(integerIntegerHashMap);

        System.out.println(integerIntegerHashMap.get("1"));
*/

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            integers.add(i);
        }
        for (int i = 0; i < 10; i++) {
            integers.remove(0);
        }
        System.out.println(integers);

    }
}
