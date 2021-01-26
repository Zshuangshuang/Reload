package com.ssz.替换空格;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-01-26 21:39
 */
class Solution {
    public String replaceSpace(String s) {
       StringBuilder stringBuilder = new StringBuilder();
       for (char ch : s.toCharArray()){
           if (ch == ' '){
               stringBuilder.append("%20");
           }else {
               stringBuilder.append(ch);
           }
       }
       return stringBuilder.toString();
    }
}