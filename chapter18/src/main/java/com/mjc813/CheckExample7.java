package com.mjc813;

import java.io.BufferedReader;
import java.io.FileReader;

public class CheckExample7 {
    public static void main(String [] args) throws Exception {
        String filePath = "C:/github/this_is_java/chapter18/src/main/java/com/mjc813/VariableUseExample.java";

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        int rowNumber = 0;
        String rowData;

        while(true) {
            // 여기에 코드를 작성하세요
            // 한 줄씩 읽기
            rowData = br.readLine();

            // 파일 끝에 도달하면 반복문 탈출
            if(rowData == null) break;

            // 행 번호 증가 및 출력
            rowNumber++;
            System.out.println(rowNumber + ": " + rowData);

        }


        br.close();
        fr.close();
    }
}
