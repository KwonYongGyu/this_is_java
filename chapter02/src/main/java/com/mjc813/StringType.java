package com.mjc813;

public class StringType {
    public void useString(){
        String name = "홍길동";
        String job = "프로그래머";
        System.out.println(name);
        System.out.println(job);

        String str ="나는 \"자바\"를 배웁니다.";
        System.out.println(str);

        str = "번호\t이름\t직업 ";
        System.out.println(str);

        System.out.print("나는\n");
        System.out.print("자바를\n");
        System.out.print("배웁니다.");

        String str1 ="" +
                "{\n" +
                "\t\"id\":\"winter\",\n" +
                "\t\"name\":\"눈송이\"\n" +
                "}";

        String str2 = """
                {
                "id" :"winter",
                "name":눈송이"
                }
                """;

        System.out.println(str1);
        System.out.println("----------------------------");
        System.out.println(str2);
        System.out.println("----------------------------");
        String str3 = """
                나는 자바를 \
                학습합니다.
                나는 자바 고수가 될 겁니다.
                """;
        System.out.println(str3);

    }
}
