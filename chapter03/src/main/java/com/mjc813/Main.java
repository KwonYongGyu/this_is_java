package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[]args) {

        chapter03 c3 = new chapter03();
        c3.Third01();
        c3.Third02();
        c3.Third03();
        c3.Third04();
        System.out.println("2x + 8 = 0 의 해, x 는 " + c3.equationFirst(2, 8));
        System.out.println("5x - 30 = 0 의 해, x 는 " + c3.equationFirst(5, -30));
        System.out.println("7x + 49 = 0 의 해, x 는 " + c3.equationFirst(7, 49));
        // p.92
        c3.CompareOperatorExample();
        // p.94
        c3.logicalOperatorExample();
        // p.99
        c3.BitLogicExample();
        // p.101 ~ 102
        c3.BitShiftExample1();
        // p.103
        c3.BitShiftExample2();
        //p.105
        c3.AssignmentOperatorExample();
        // p.106
        c3.ConditionalOperationExample();
        //p.109~p110
        c3.chapter03Test();

    }
}
