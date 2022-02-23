package HashMap;


import java.util.*;

public class MapTest {


  public static void main(String[] args){

      HashMap<String, Integer[]> stringHashMap = new HashMap<>();
      //Integer []ss={1,2,3,4,5};
      //stringHashMap.put("sjy",ss);
      System.out.println(stringHashMap.get("sjy")==null);
      System.out.println(stringHashMap.get("s")==null);



      HashMap<String, Integer> map = new HashMap<String, Integer>();
      map.put("语文", 1);
      map.put("数学", 2);
      map.put("英语", 3);
      map.put("历史", 4);
      map.put("政治", 5);
      map.put("地理", 6);
      map.put("生物", 7);
      map.put("化学", 8);
      for(Map.Entry<String, Integer> entry : map.entrySet()) {
          System.out.println(entry.getKey() + ": " + entry.getValue());
      }

      System.out.println(15>>>16);

      HashMap<String, Object> hashmap = new HashMap<>();
      hashmap.put("a","sting1");
      hashmap.put("b","sting2");
      hashmap.put("c","sting3");
      hashmap.put("d","sting4");
      hashmap.put("e","sting5");
      hashmap.put("f","sting6");
      hashmap.put("g","sting7");

      //遍历 获取map 获取Key 值

      Set<String> strings = hashmap.keySet();
      for(String stirng: strings){
          System.out.println(stirng);
      }



      //遍历直接获取map 的值

      Collection<Object> values = hashmap.values();
      for (Object o : values){
          System.out.println(o.toString());
      }

      //通过key 获取 map 的value

      Set<String> strings1 = hashmap.keySet();
      for (String string:strings1)
      {
          System.out.println(string+"==>"+hashmap.get(string));
      }

      //删除

      System.out.println( hashmap.remove("a"));
      System.out.println(hashmap.isEmpty());
      System.out.println(hashmap);

      /*
      *map是否包含  sting2 值
       */
      System.out.println(hashmap.containsValue("sting2"));

      /*
       *map 是否包含  a key
       */
      System.out.println(hashmap.containsKey("a"));

      /**
       *  修改map固定key的值
       *  返回 oldValue
       */
      System.out.println(hashmap.replace("c","ss"));

      System.out.println(hashmap);

      /**
       * 当 key value都正确的时候 才能修改值
       */
      System.out.println(hashmap.replace("c","sss","sssS"));
      System.out.println(hashmap);

      HashMap<String, Set<String>> map1=new HashMap<>();
      HashSet<String> objects = new HashSet<>();
      objects.add("1");
      objects.add("2");
      map1.put("s",objects);

      Set<String> s = map1.get("s");
        s.remove("1");
        System.out.println(map1);

  }
}
