package InputOutputStream;

import java.io.*;

/*
    初识输入流和输出流的概念
    TODO: 输入字节流每执行一次read 指针就会往后走一次
            in.read()  走一个  返回值是 该字节的ASCII
            in.read(bytes)  走bytes的长度(前提是bytes的长度小于待读的数据)  返回值是读取的长度。
            若已经读取完 再执行read,返回值是 -1.
 */
public class TestStream {
    public static void main(String[] args) {
        //1.新建一个文件
        File file = new File("D:\\test.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //2.向文件写入内容 输出流 (以程序为核心  数据写入到文件中 就是输出 相关的概念是output write)
        String str = "ABCD1234";
        try {
            byte[] bytes = str.getBytes("utf-8");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从文件中读出内容  输入流 (以程序为核心  从文件读入数据 就是输入 相关的概念是input read)
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
            byte[] data = new byte[8];
            int read = fileInputStream.read();
            System.out.write(read);
            System.out.println(read);
            int read1 = fileInputStream.read(data);
            int read3 = fileInputStream.read(data);
            int read2 = fileInputStream.read();
            String s = new String(data);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
