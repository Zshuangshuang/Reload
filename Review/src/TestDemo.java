import java.util.HashMap;
import java.util.Map;

/**
 * Author:ZouDouble
 * Description:
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
 * 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。若没有金额超过总数的一半，返回0。
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-19 14:27
 */
public class TestDemo {
    public static int findNums(int[] gifts,int n){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(gifts[i])){
                map.put(gifts[i],map.get(gifts[i])+1);
            }else {
                map.put(gifts[i],1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(gifts[i]) > (n/2)){
                return gifts[i];
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,2,2};
        int ret = findNums(array,5);
        System.out.println(ret);
    }
}
