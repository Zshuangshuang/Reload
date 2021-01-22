import java.util.Stack;

class Solution3 {
    public String reverseOnlyLetters(String S) {
       if (S == null){
           return null;
       }
       Stack<Character> stack = new Stack<>();
       for (char ch : S.toCharArray()){
           if (Character.isLetter(ch)){
               stack.push(ch);
           }
       }
       StringBuilder stringBuilder = new StringBuilder();
       for (char ch : S.toCharArray()){
           if (Character.isLetter(ch)){
               stringBuilder.append(stack.pop());
           }else {
               stringBuilder.append(ch);
           }
       }
       return stringBuilder.toString();
    }
}