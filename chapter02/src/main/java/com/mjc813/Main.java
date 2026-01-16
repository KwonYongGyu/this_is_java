package com.mjc813;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[]args) {
        Variable01 v1 = new Variable01();
        v1.howToUseVariable();

        IntegerType it = new IntegerType();
        it.useInteger();

        CharType ct = new CharType();
        ct.useChar();

        FDType ft = new FDType();
        ft.useFloatDouble();

        BooleanType bt = new BooleanType();
        bt.useBoolean();

        StringType st = new StringType();
        st.useString();

        AutoTranslate at = new AutoTranslate();
        at.useAuto();

        // 1/16일 오전수업 예제 2-9, 2-10호출
        TranslateType tt = new TranslateType();
        tt.useTranslate();
    }
}

