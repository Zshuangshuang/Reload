import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String strBoss = scanner.nextLine();
            String strCustomer = scanner.nextLine();
            Map<Character,Integer> have = new HashMap<>();
            for (char ch : strBoss.toCharArray()){
                if (have.containsKey(ch)){
                    have.put(ch,have.get(ch)+1);
                }else {
                    have.put(ch,1);
                }
            }
            Map<Character,Integer> need = new HashMap<>();
            for (char ch : strCustomer.toCharArray()){
                if (need.containsKey(ch)){
                    need.put(ch,need.get(ch)+1);
                }else {
                    need.put(ch,1);
                }
            }
            boolean tmp = true;
            int lack = 0;
            //遍历小红的需求
            for (Map.Entry<Character,Integer> entry : need.entrySet()){
                char key = entry.getKey();
                int value = entry.getValue();
                if (!have.containsKey(key)){
                    tmp = false;
                    lack = lack+value;
                }else if (have.get(key) < value){
                    tmp = false;
                    lack = value-lack;
                }
            }
            if (tmp){
                System.out.println("Yes "+(strBoss.length()-strCustomer.length()));
            }else {
                System.out.println("No "+lack);
            }
        }
    }
}
