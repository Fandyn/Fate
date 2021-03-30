package com.typemoon.fate.javademo;

public class demo1 {
    public static void main(String[] args) {
        //0,1,2,3
        //1，3，5，7，9，11，13，15，17，19
        //1,5,9
        //3,7,11
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.println("白"+i);
            } else {
                if (i % 3 != 0) {
                    System.out.println("蓝" + (i));
                } else {
                    System.out.println("紫" + (i));
                }
            }
        }
    }
}
