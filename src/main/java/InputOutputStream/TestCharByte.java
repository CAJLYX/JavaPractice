package InputOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    TODO: ����InputStrem  Reader������
 */
public class TestCharByte {
    public static void main(String[] args) throws IOException {
        File testInput = new File("D:\\test.txt");
        File testReader = new File("D:\\testchar.txt");

        //���Ժ����ļ����Ұ��й��� ���ֽ�����ȡ �� �ַ�����ȡ�Ĳ�ͬ
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
