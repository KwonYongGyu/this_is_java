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

}
