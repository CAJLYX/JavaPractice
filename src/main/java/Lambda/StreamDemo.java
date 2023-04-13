package Lambda;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Stream使用的是函数式编程模式，对集合和数组做链状流式操作。
    中间操作：
    filter：是对流中的元素做过滤操作
    map:是对流中的元素做计算或类型的转换
    distinct:可以去除流中的重复元素
    sorted 可以对流中的元素做排序  若调用空参的sorted()方法 需要流中元素实现Comparable;若调用有参,则直接在方法中实现比较逻辑
    limit  可以设置流的最大长度 超出部分会被抛弃
    skip 跳过流中的前n个元素，返回剩余元素
    flatMap map只能对一个对象转化成一个对象作为流中的元素 但是flatMap可以把一个对象转换成多个对象作为流中的元素(用于集合中有集合的场景)
    终结操作：
    foreach 对流中的元素做操作，对传入的参数做什么操作  （比如遍历操作）
    count 可以获取当前流中元素的个数
    max min  获取流中元素的最值  返回值是optional
    collect 把当前流转换成一个集合
    查找和匹配
    anyMatch 用来判断是否有任意符合匹配条件的元素，结果为Boolean
    allMatch 用来判断是否都符合条件，结果为Boolean
    noneMatch 用来判断是否都不符合条件 ，都不符合为true  否则为false
    findAny 获取流中的任意一个元素，没发保证获取的是流中的第一个元素  返回值是optional
    findFirst 获取流中的第一个元素  返回值是optional
    reduce操作：对流中的数据按照指定的计算方式计算出一个结果 （缩减操作）
        是把stream中的元素组合起来 传入一个初始值 按照我们的计算方式依次拿流中的元素和初始化值进行计算  计算结果再和后面的元素计算  （类似于对数组元素求和场景）

   注意事项：
   惰性求值：若没有终结操作 中间操作是不会执行的
   流是一次性的： 一旦流经过一个终结操作后 这个流不能再被使用
   不会影响原数据的 正常情况不会影响原来的元素 这也是期望的
 */


public class StreamDemo {

    public static void main(String[] args) {
//        List<Author> authors = getAuthors();
//        test01(authors);
//        test02(authors);
//        test03(authors);
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
//        test23();
//        test24();
//        test25();
//        test26();

        //FunctionInterface
//        test27();
//        testOr();
//        testNegate();
//        testData();
        test28();
    }

    private static void test28() {
        //串形流
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Integer sum = stream.filter(num -> num > 5)
//                .reduce((result, element) -> result + element)
//                .get();
//        System.out.println(sum);
        //并行流 parallel可以将串行流转换成并行流 也可以通过parallelStream方法
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum1 = stream1.parallel()
                .peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer+Thread.currentThread().getName());
                    }
                })//Stream提供的专门进行调试的方法peek 中间操作 消费数据只是调试数据用，并不会真正消费掉数据
                .filter(num -> num > 5)
                .reduce((result, element) -> result + element)
                .get();
        System.out.println(sum1);
    }

    private static void testData() {
        List<Author> authors = getAuthors();
        //优化前
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
        //优化后
        authors.stream()
                .mapToInt(author -> author.getAge())
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
    }

    private static void testNegate() {
        //打印作家中年龄不大于17岁的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>17;
                    }
                }.negate())
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void testOr() {
        //打印作家年龄大于17或者长度小于2的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge()>17;
                    }
                }.or(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length() < 2;
                    }
                }))
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test27() {
        //打印作家中年龄大于17并且姓名的长度大于1的作家
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 17).and(author -> author.getName().length() >1))
                .forEach(author -> System.out.println(author.getAge()+":::"+author.getName()));

    }

    private static void test26() {
        //使用reduce求所有作者年龄中的最小值
        //reduce一个参数的重载形式内部的计算  注意看下源码  就是把第一个元素看成result
        List<Author> authors = getAuthors();
        Optional<Integer> reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce((result, element) -> result > element ? element : result);
        reduce.ifPresent(age -> System.out.println(age));
    }

    private static void test25() {
        //使用reduce求所有作者年龄中的最小值
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result > element ? element : result);
        System.out.println(reduce);
    }

    private static void test24() {
        //使用reduce求所有作者年龄中的最大值
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(reduce);
    }

    private static void test23() {
        List<Author> authors = getAuthors();
        //使用reduce求所有作者年龄的和
        Integer sum = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(sum);
    }

    private static void test22() {
        List<Author> authors = getAuthors();
        //获取年龄最小的作家 并输出它的姓名
        Optional<Author> first = authors.stream()
                .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
                .findFirst();
        first.ifPresent(author -> author.getName());
    }

    private static void test21() {
        List<Author> authors = getAuthors();
        //获取任意一个年龄大于18的作家，若存在就输出它的名字
        Optional<Author> optionalAuthor = authors.stream()
                .filter(author -> author.getAge() >18)
                .findAny();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test20() {
        List<Author> authors = getAuthors();
        //判断作家是否都没有超过100岁
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);
    }

    private static void test19() {
        List<Author> authors = getAuthors();
        //判断是否所有的作家都是成年人
        boolean b = authors.stream()
                .allMatch(author -> author.getAge() >= 10);
        System.out.println(b);
    }

    private static void test18() {
        //判断是否有年龄在29岁以上的作家
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 46);
        System.out.println(b);
    }

    private static void test17() {
        //获取一个map集合 map的key是作者名  value是List<Book>
        List<Author> authors = getAuthors();
        Map<String, List<Book>> collect = authors.stream().distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(collect);

    }

    private static void test16() {
        List<Author> authors = getAuthors();
        //获取一个所有书名的Set集合
        Set<Book> collect = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        //获取一个存放所有作者名字的List集合
        List<String> collect = authors.stream()
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void test14() {
        //获取这些作家书籍的最高分和最低分 并打印
        List<Author> authors = getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((o1, o2) -> o1 - o2);
        System.out.println(max.get());


        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((o1, o2) -> o1 - o2);
        System.out.println(min.get());
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        //打印这些作家所出书籍的个数
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test11() {
        //打印现有数据的所有分类。要求对分类进行去重，不能出现这种格式 哲学，爱情
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split("、")))
                .distinct()
                .forEach(category -> System.out.println(category));

    }

    private static void test10() {
        //打印所有书籍的名字。要求对重复元素去重
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test09() {
        //打印除了年龄最大的作家外的其他作家，要求不能有重复的元素，对流中的元素按照年龄进行降序
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test08() {
        //对流中的元素按照年龄进行降序，并且要求不能有重复的元素，然后打印其中年龄最大的两个作家的姓名
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        //对流中的元素按照年龄进行降序，并且要求不能有重复的元素。
//        authors.stream()
//                .distinct()
//                .sorted()
//                .forEach(author -> System.out.println(author.getAge()));
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge()-o1.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test06() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test05() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .forEach(s -> System.out.println(s));
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .forEach(age -> System.out.println(age));
    }


    private static void test03(List<Author> authors) {
        //Stream只能对单列集合和数组进行处理 ，对于多列集合如Map，需先转换成单列集合再创建
        Map<String, Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("黑子",17);
        map.put("日向襄阳",16);
        //先转换成单列集合
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();
        stream.filter(stringIntegerEntry -> stringIntegerEntry.getValue()>16)
                .forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry));

    }

    private static void test02(List<Author> authors) {
        Integer[] arr = {1,2,3,4,5};
//        Stream<Integer> stream = Arrays.stream(arr);
        Stream<Integer> stream = Stream.of(arr);
        stream.distinct().forEach(integer -> System.out.println(integer));
    }

    private static void test01(List<Author> authors) {
        //1. 打印所有年龄小于18作家的名字，并且注意去重
        //单列集合
        authors.stream()//把集合转换成流
                .distinct()//去除重复的作家
                .filter(author -> author.getAge()<18)//筛选年龄小于18
                .forEach(author -> System.out.println(author.getName()));//遍历打印名字
    }

    private static List<Author> getAuthors(){
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追不上它的速度", null);
        Author author3 = new Author(3L, "易", 14, "这世界在限制它的思维", null);
        Author author4 = new Author(3L, "易", 14, "这世界在限制它的思维", null);

        //书籍列表
        List<Book>  books1 = new ArrayList<>();
        List<Book>  books2 = new ArrayList<>();
        List<Book>  books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明和黑暗","哲学、爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长、爱情",99,"如何从失败中领悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维领略生命的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维领略生命的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情、个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个舞者能对它的伴侣这么宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        ArrayList<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;


    }
}
