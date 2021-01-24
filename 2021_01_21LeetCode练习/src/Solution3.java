import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums){
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else {
                map.put(x,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if (value >= 2){
                return true;
            }
        }
        return false;
        
    }
}