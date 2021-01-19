import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String a = scanner.nextLine();
            char[] b = a.toCharArray();
            for (int i = 0; i < b.length; i++) {
                char ch = b[i];
                if (ch >= 'A'){
                    ch = (char)(ch > 'E' ? (ch-5) : (ch+21));
                    b[i] = ch;
                }
            }
            System.out.println(new String(b));
        }
    }
}
