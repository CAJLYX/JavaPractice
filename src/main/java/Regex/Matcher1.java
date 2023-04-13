package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matcher1 {
    public static void main(String[] args) {
        //TODO 学习java的转义字符作用 深刻理解\n \r \t \b
//        studyTransfer();
        //TODO  JAVA的正则表达式使用
        //1. 判断功能
//        studyString_matches();
        //2.分割功能
//        studyString_split();
        //3.替换功能
//        studyString_replaceAll();
        //正则表达式 Pattern与Matcher类详解
//        studyPattern_Matcher_matches();
//        studyPattern_Matcher_find();
//        studyPattern_Matcher_find_start_end_group();
        //TODO \r\n  \r|\n的区别
        test_r_n();
    }

    private static void test_r_n() {
        String str = "aaa\rbbb\nccc\r\n";
        String s_replace = str.replaceAll("\n|\r", "");
        System.out.println(s_replace);
        String str1 = "aaa\rbbb\nccc\r\nddd";
        System.out.println(str1);
    }

    private static void studyPattern_Matcher_find_start_end_group() {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("222bb23");
        System.out.println(m.find());
        int start = m.start();//0
        String group = m.group();//222  group返回匹配到的子字符串
        int end = m.end();//3
        System.out.println(start);
        System.out.println(group);
        System.out.println(end);
    }

    private static void studyPattern_Matcher_find() {
        Pattern p = Pattern.compile("\\.");
        Matcher m = p.matcher("22bb23");
        m.find();// 返回true
        Matcher m2 = p.matcher("aa2223");
        m2.find();// 返回true
        Matcher m3 = p.matcher("aa2223bb");
        m3.find();// 返回true
        Matcher m4 = p.matcher("aabb");
        m4.find();// 返回false
    }

    private static void studyPattern_Matcher_matches() {
        Pattern pattern = Pattern.compile("\\?{2}");//生成正则表达式pattern
        Matcher matcher = pattern.matcher("??");//开始识别 入参是待识别字符串
        //Matcher的matches方法，只有整个字符串完全匹配时才返回真值
        boolean isMatch = matcher.matches();
        System.out.println("isMatch: "+isMatch);
    }

    private static void studyString_replaceAll() {
        String s = "12342jasfkgnas234";
        //把字符串里面的数字替换成*
        String regex = "\\d";
        String ss = "*";
        String result = s.replaceAll(regex,ss);
        System.out.println(result);
    }

    private static void studyString_split() {
        String age = "18-24";//定义年龄范围
        String regex = "-";
        String[] strArr = age.split(regex);//分割成字符串数组

        int startAge = Integer.parseInt(strArr[0]);
        int endAge = Integer.parseInt(strArr[1]);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的年龄：");
        int a = sc.nextInt();
        if (a >= startAge && a <= endAge){
            System.out.println("你就是我想找的");
        }else{
            System.out.println("滚");
        }
    }


    private static void studyString_matches() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的手机号：");
        String s = sc.nextLine();
        String regex = "1[38]\\d{9}";  //手机号的正则表达式
        //String类的matches方法
        boolean isMatch = s.matches(regex);
        System.out.println("isMatch: " + isMatch);
    }

    private static void studyTransfer() {
        // \n 将当前位置移动到下一行开头
        // \r 将当前位置移动到本行开头
        // \t 水平制表 跳到下一个TAB位置
        // \b 退格，将当前位置移到前一列
        String str = "aa\nbb\rcc\tdd\bee";
        System.out.println(str);
        String str1 = "\"name\"";
        System.out.println(str1);
    }
}
