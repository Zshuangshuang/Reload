import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        //要先判断magazine,在判断赎金信
        //(1)创建一个map用来保存magazine中的元素以及出现的次数
        Map<Character,Integer> map = new HashMap<>();
        //(2)遍历magazine的元素
        for (char ch : magazine.toCharArray()){
            // 如果已经出现，就给它的次数的基础上在加1
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else {
                //如果map当前没有该元素就给它加进去，并且将出现次数置为1
                map.put(ch,1);
            }
        }

        //(3)遍历ransomNote
        for (char ch: ransomNote.toCharArray()){
            //先看看map中是否有该元素，没有直接返回false
            if (! map.containsKey(ch)){
                return false;
            }
            // 出现次数==0也返回false(字母个数不够)
            if (map.get(ch) == 0){
                return false;
            }
            //其他情况就把ransomNote加进map，并将该元素出现的次数-1
            map.put(ch,map.get(ch)-1);
        }
        // 遍历结束，最终返回true
        return true;
    }

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "aab";
        boolean ret = canConstruct(str1,str2);
        System.out.println(ret);
    }
}