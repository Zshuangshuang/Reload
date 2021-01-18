/**
 *
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * */

class Solution4 {
    public String toLowerCase(String str) {
        //(1)有参数的要先判断参数的合法性
        if (str == null || str.length() ==0 ){
            return str;
        }
        //(2)创建一个StringBuilder对象，用来拼装最后的结果
        StringBuilder stringBuilder = new StringBuilder();
        //(3)将str转化为字符数组，依次遍历
        for (char ch : str.toCharArray()){
            //判断ch是不是大写字母，如果是就把它转成小写
            if(ch >= 'A' && ch <= 'Z'){
                //A-Z：65-90
                //a-z:97-122
                ch = (char)(ch+32);
                stringBuilder.append(ch);
            }else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}