class Solution {
    public static  String reverseOnlyLetters(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int right = S.length()-1;
        for (int left = 0; left < S.length(); left++) {
            if (Character.isLetter(S.charAt(left))){
                while(!Character.isLetter(S.charAt(right))){
                    right--;
                }
                stringBuilder.append(S.charAt(right--));
            }else {
                stringBuilder.append(S.charAt(left));
            }
        }
        return stringBuilder.toString();
    }
}

