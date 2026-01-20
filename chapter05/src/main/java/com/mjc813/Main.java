package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        IO.println(String.format("Hello and welcome!"));
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            IO.println("i = " + i);
        Chapter05 ct05 = new Chapter05();
        ct05.ReferenceVariableCompareExample();
        ct05.NullPointerExceptionExample();
        ct05.GarbageObjectExample();
        ct05.EqualsExample();
        ct05.EmptyStringExample();
        ct05.CharAtExample();
        ct05.LengthExample();
        ct05.ReplaceExample();
        ct05.SubStringExample();
        ct05.IndexOfContainsExample();
        ct05.SplitExample();
        ct05.ArrayCreateByValueListExample1();
        ct05.ArrayCreateByValueListExample2();
        ct05.ArrayCreateByNewExample();
        ct05.ArrayLengthExample();
        ct05.MultidimensionalArrayByValue();
        ct05.MultidimensionalArrayByNewExample();
    }
}
