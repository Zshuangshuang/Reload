

class Solution1 {
    public  String toLowerCase(String str) {
        //首先判断参数的合法性
        if (str == null || str.length() == 0){
            return str;
        }
        //创建一个可变字符串，用来拼接结果
        StringBuilder stringBuilder = new StringBuilder();
        //遍历参数的每一位
        for (char ch : str.toCharArray()){
            if (ch >='A' && ch <= 'Z'){
                ch = (char)(ch+32);
                stringBuilder.append(ch);
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }


}