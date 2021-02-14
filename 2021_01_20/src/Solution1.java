
/**
 * 题目描述:给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *如果不存在最后一个单词，请返回 0 。
 *说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

 * */

class Solution {
    public int lengthOfLastWord(String s) {
        //(1)判断参数的合法性
        if (s == null || s.length() == 0 || " ".equals(s)){
            return 0;
        }
        //(2)设置一个end变量，找到s最后一个单词的末位置
        //这里 s.charAt(end) == ' '的判断是为了“去除”s后面的空格
        int end = s.length()-1;
        while(end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        //(3)设置一个start变量，找到s最后一个单词的开始位置
        int start = end;
        while(start >= 0 && s.charAt(start) != ' '){
            start--;
        }
        return end-start;
    }


}