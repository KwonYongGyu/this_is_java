package com.mjc813;

import java.io.*;

public class Chapter18 {
    public void WriteExample1() {
        try{
            OutputStream os = new FileOutputStream("C:/Temp/test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriteExample2() {
        try {
            OutputStream os = new FileOutputStream("C:/Temp/test2.db");

            byte[] array = {10, 20, 30};

            os.write(array);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void WriterExample3() {
        try {
            OutputStream os = new FileOutputStream("C:/Temp/test3.db");

            byte[] array = { 10, 20, 30, 40, 50 };

            os.write(array, 1, 3);

            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadExample1() {
        try {
            InputStream is = new FileInputStream("C/Temp.test1.db");

            while(true) {
                int data = is.read();   // 1byte씩 읽기
                if(data == -1) break;
                System.out.println(data);
            }

            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    public void ReadExample2() {
        try {
            InputStream is = new FileInputStream("C/Temp/test2.db");

            byte[] data = new byte[100];

            while(true) {
                int num = is.read(data);
                if(num == -1) break;

                for(int i = 0; i<num; i++) {
                    System.out.println(data[i]);
                }
            }

            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CopyExample() throws IOException {
        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        InputStream is = new FileInputStream(originalFileName); // 입력 스트림 생성
        OutputStream os = new FileOutputStream(targetFileName); // 출력 스트림 생성

        byte[] data = new byte[1024];   // 읽은 바이트를 저장할 배열 생성
        while(true) {
            int num = is.read(data);    // 최대 1024 바이트를 읽고 배열에 저장, 읽은 바이트는 리턴
            if(num == -1) break;    // 파일을 다 읽으면 while문 종료
            os.write(data, 0, num); // 읽은 바이트 수만큼 출력
        }

        os.flush(); // 내부 버퍼 잔류 바이트를 출력하고 버퍼를 비움
        os.close();
        is.close();

        System.out.println("복사가 잘 되었습니다.");
    }

    public void WriteExample4() {
        try {
            // 문자 기반 출력 스트림 생성
            Writer writer = new FileWriter("C/Temp/test.txt");

            // 1 문자씩 출력
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            // char 배열 출력
            char[] arr = { 'C', 'D', 'E' };
            writer.write(arr);

            // 문자열 출력
            writer.write("FGH");

            // 버펑 잔류하고 있는 문자들을 출력하고, 버퍼를 비움
            writer.flush();

            // 출력 스트림을 닫고 메모리 해제
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadExample3(){
        try {
            Reader reader = null;

            // 1문자씩 읽기
            reader = new FileReader("C/Temp/test.txt"); // 텍스트 파일로부터 문자 입력 스트림 생성
            while(true) {
                int data = reader.read();   // 문자를 읽음
                if(data == -1) break;   // 파일을 다 읽으면 while 문 종료
                System.out.println((char)data); // 읽은 문자 출력
            }
            reader.close();
            System.out.println();

            // 문자 배열로 읽기
            reader = new FileReader("C/Temp/test.txt"); // 텍스트 파일로부터 문자 입력 스트림 생성
            char[] data = new char[100];    // 읽은 문자를 저장할 배열 생성
            while(true) {
                int num = reader.read(data);    // 읽은 문자는 배열에 저장, 읽은 문자 수는 리턴
                if(num == -1) break;    // 파일을 다 읽으면 while문 종료
                for(int i = 0; i<num; i++) {
                    System.out.println(data[i]);    // 읽은 문자 수만큼 출력
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CharacterConvertStreamExample() throws Exception {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws Exception {
        // FileOutPutStream에 OutPutStreamWriter 보조 스트림을 연결
        OutputStream os = new FileOutputStream("C/Temp/test.txt");
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str); // 보조 스트림을 이용해서 문자 출력
        writer.flush();
        writer.close();
    }

    public static String read() throws Exception {
        InputStream is = new FileInputStream("C/Temp/test.txt"); // 보조 스트림을 연결
        Reader reader = new InputStreamReader(is, "UTF-8");
        char [] data = new char[100];
        int num = reader.read(data);
        reader.close();
        String str = new String(data, 0, num); // char 배열에서 읽은 문자수만큼 문자열 변환
        return str;
    }

    public void BufferExample() throws Exception{
        // 입출력 스트림 생성
        String originalFilePath1 =
                BufferExample.class.getResource("originalFile1.jpg").getPath();
        String targetFilePath1 = "C/Temp/targetFile1.jpg";

        FiileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        // 입출력 스트림 + 버퍼 스트림 생성
        String originalFilePath2 =
                BufferExample.class.getResource("originalFile2.jpg").getPath();
        String targetFilePath2 = "C/Temp/targetFile2.jpg";
        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 버퍼를 사용하지 않고 복사
        long non BufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용:\t" + nonBufferTime + " ns");

        // 버퍼를 사용하고 복사
        long bufferTime = copy(bis, bos);
        System.out.println("버퍼 사용:\t" + bufferTime + " ns");

        fis.close();
        fos.close();
        bis.close();
        bos.close();

    }

    public static long copy(InputStream is, OutputStream os) throws Exception {
        // 시작 시간 저장
        long start = System.nanoTime();
        // 1 바이트를 읽고 1 바이트를 출력
        while(true) {
            int data = is.read();
            if(data == -1) break;
            os.write(data);
        }
        os.flush();
        // 끝 시간 저장
        long end = System.nanoTime();
        // 복사 시간 리턴
        return (end-start);
    }
}
