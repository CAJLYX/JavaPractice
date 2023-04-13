package InputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    TODO: 测试InputStrem  Reader的区别
 */
public class TestCharByte {
    public static void main(String[] args) throws IOException {
        File testInput = new File("D:\\test.txt");
        File testReader = new File("D:\\testchar.txt");

        //测试汉字文件（我爱中国） 用字节流读取 和 字符流读取的不同
        byte[] bytes1 = new byte[30];
        char[] bytes2 = new char[30];
        FileInputStream fileInputStream = new FileInputStream(testReader);
        fileInputStream.read(bytes1);
        String s = new String(bytes1,"GBK");

        s.getBytes();

        FileInputStream fileInputStream2 = new FileInputStream(testReader);
        InputStreamReader inputReader = new InputStreamReader(fileInputStream2, "GBK");
        inputReader.read(bytes2);
    }
}
