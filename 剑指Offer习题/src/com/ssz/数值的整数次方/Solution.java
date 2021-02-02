package com.ssz.数值的整数次方;


public class Solution {
    public double Power(double base, int exponent) {
        if (exponent < 0){
            base = 1/base;
            exponent = -exponent;
        }
        double total = 1.0d;
        if (exponent > 0){
            for (; exponent >= 1; exponent--) {
                total *= base;
            }
        }
        return total;
    }
}
