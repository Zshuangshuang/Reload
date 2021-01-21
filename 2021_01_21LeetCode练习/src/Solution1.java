import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int tmp : nums){
            if (map.containsKey(tmp)){
                map.put(tmp,map.get(tmp)+1);
            }else {
                map.put(tmp,1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if (value >= 2){
                return true;
            }
        }
        return false;
    }
}