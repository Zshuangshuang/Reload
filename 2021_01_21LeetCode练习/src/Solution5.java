class Solution5 {
    public String toLowerCase(String str) {

        if (str.length() == 0 || str == null){
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : str.toCharArray()){
            if (ch >= 'A' && ch <= 'Z'){
                ch = (char)(ch+32);
                stringBuilder.append(ch);
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}