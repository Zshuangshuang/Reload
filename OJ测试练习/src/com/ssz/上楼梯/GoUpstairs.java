package com.ssz.上楼梯;

/**
 * Author:ZouDouble
 * Description:
 * 天气：晴天
 * 目标：Good Offer
 * Date    2021-02-02 21:52
 */
public class GoUpstairs {
    public int countWays(int n) {
        int n1=1;
        int n2=2;
        int n3=4;
        int sum=0;
        if(n<3){
            return n;
        }
        if(n==3){
            return n3;
        }
        for(int i=4;i<=n;i++){
            sum=((n1+n2)%1000000007+n3)%1000000007;
            n1=n2;
            n2=n3;
            n3=sum;
        }
        return sum;
    }
}
