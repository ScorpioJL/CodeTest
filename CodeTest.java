package com.jasonli;

import java.util.Scanner;

class CodeTest {
    public static void main(String[] args)
    {
        var mode = 0;
        Scanner sc;

        while (mode != 1 && mode != 2 && mode != 3) {
            System.out.println("Welcome to use String Handler, which mode do you want to use?");
            System.out.println("1. Basic Mode");
            System.out.println("2. Advance Mode");
            System.out.println("3. Exit");
            sc = new Scanner(System.in);
            mode = sc.nextInt();
        }

        if(mode != 3) {
            System.out.println("Please input a string:");
            sc = new Scanner(System.in);
            var targetStr = sc.next();
            StringHandler sh = new StringHandler(targetStr);

            if(sh.isAlphabet()) {
                do {
                    if(mode == 1) {
                        sh.handleStrBasic();
                    } else {
                        sh.handleStrAdvance();
                    }
                } while (sh.isValidStr());
            } else {
                System.out.println("String can just contain lower alphabet characters.");
            }
        } else {
            System.out.println("See you next time.");
        }
    }
}
