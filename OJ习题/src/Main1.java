import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String strByBoss = scanner.nextLine();//老板有的珠子
            String strByCostumer = scanner.nextLine();//小红要的珠子
            Map<Character,Integer> boss = new HashMap<>();
            //遍历老板的珠子，并且计算每个珠子出现的次数
            for (char ch : strByBoss.toCharArray()){
                if (boss.containsKey(ch)){
                    boss.put(ch, boss.get(ch)+1);
                }else {
                    boss.put(ch,1);
                }
            }
            //遍历小红的珠子
            Map<Character,Integer> cm = new HashMap<>();
            for (char ch :strByCostumer.toCharArray()) {
                if (cm.containsKey(ch)){
                    cm.put(ch,cm.get(ch)+1);
                }else {
                    cm.put(ch,1);
                }
            }
            boolean ret = true;//表示不缺少珠子
            int lack = 0;//表示缺少珠子的个数
            for (Map.Entry<Character,Integer> entry : cm.entrySet()){
                char key = entry.getKey();
                int value = entry.getValue();
                if (boss.containsKey(key) && boss.get(key) < value){
                    ret = false;
                    lack = lack+value-boss.get(key);
                }else if (!boss.containsKey(key)){
                    ret = false;
                    lack = lack+value;
                }
            }
            if (ret){
                System.out.println("Yes "+(strByBoss.length()-strByCostumer.length()));
            }else {
                System.out.println("No "+lack);
            }

        }


    }
}
