package com.mjc813;

public class Chapter05 {
    // p.150
    public void ReferenceVariableCompareExample() {
        int[] arr1;    // 배열 변수 arr1 선언
        int[] arr2;    // 배열 변수 arr2 선언
        int[] arr3;    // 배열 변수 arr3 선언

        arr1 = new int[]{1, 2, 3,};  // 배열 { 1, 2, 3 }을 생성하고 arr1 변수에 대입
        arr2 = new int[]{1, 2, 3,};  // 배열 { 1, 2, 3 }을 생성하고 arr2 변수에 대입
        arr3 = arr2;    // 배열 변수 arr2의 값을 배열 변수 arr3에 대입

        System.out.println(arr1 == arr2);   // arr1과 arr2 변수가 같은 배열을 참조하는지 검사
        System.out.println(arr2 == arr3);   // arr2와 arr3 변수가 같은 배열을 참조하는지 검사
    }

    //p.153
    public void NullPointerExceptionExample() {
        int[] intArray = null;
        // intArray[0] = 10; //NullPointerException
        // intArray가 참조하는 배열 객체가 없기때문에 10을 저장할 수 없다.

        String str = null;
        // System.out.println("총 문자 수: " + str.length());//NullPointerException
        // str 변수가 참조하는 String 객체가 없으므로 문자열의 길이를 구할 수 없다.
    }

    // p.155
    public void GarbageObjectExample() {
        String hobby = "여행";
        hobby = null;   // "여행"에 해당하는 String 객체를 쓰레기로 만듦

        String kind1 = "자동차";
        String kind2 = kind1;   //kind1 변수에 저장되어 있는 번지를 kind2변수에 대입
        kind1 = null;    //"자동차"에 해당하는 String 객체 쓰레기가 아님
        System.out.println("kind2: " + kind2);
    }
}
