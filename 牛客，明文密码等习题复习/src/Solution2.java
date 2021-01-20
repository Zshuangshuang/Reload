import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //使用map键值对，首先先遍历magazine
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : magazine.toCharArray()){
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                map.put(ch,1);
            }
        }
        //遍历ransomNote
        for (char ch : ransomNote.toCharArray()){
            if (! map.containsKey(ch)){
                return false;
            }else if (map.get(ch) == 0){
                return false;
            }else {
                map.put(ch,map.get(ch)-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aaa", "aa"));
    }
}
