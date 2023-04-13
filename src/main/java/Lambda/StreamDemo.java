package Lambda;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Streamʹ�õ��Ǻ���ʽ���ģʽ���Լ��Ϻ���������״��ʽ������
    �м������
    filter���Ƕ����е�Ԫ�������˲���
    map:�Ƕ����е�Ԫ������������͵�ת��
    distinct:����ȥ�����е��ظ�Ԫ��
    sorted ���Զ����е�Ԫ��������  �����ÿղε�sorted()���� ��Ҫ����Ԫ��ʵ��Comparable;�������в�,��ֱ���ڷ�����ʵ�ֱȽ��߼�
    limit  ��������������󳤶� �������ֻᱻ����
    skip �������е�ǰn��Ԫ�أ�����ʣ��Ԫ��
    flatMap mapֻ�ܶ�һ������ת����һ��������Ϊ���е�Ԫ�� ����flatMap���԰�һ������ת���ɶ��������Ϊ���е�Ԫ��(���ڼ������м��ϵĳ���)
    �ս������
    foreach �����е�Ԫ�����������Դ���Ĳ�����ʲô����  ���������������
    count ���Ի�ȡ��ǰ����Ԫ�صĸ���
    max min  ��ȡ����Ԫ�ص���ֵ  ����ֵ��optional
    collect �ѵ�ǰ��ת����һ������
    ���Һ�ƥ��
    anyMatch �����ж��Ƿ����������ƥ��������Ԫ�أ����ΪBoolean
    allMatch �����ж��Ƿ񶼷������������ΪBoolean
    noneMatch �����ж��Ƿ񶼲��������� ����������Ϊtrue  ����Ϊfalse
    findAny ��ȡ���е�����һ��Ԫ�أ�û����֤��ȡ�������еĵ�һ��Ԫ��  ����ֵ��optional
    findFirst ��ȡ���еĵ�һ��Ԫ��  ����ֵ��optional
    reduce�����������е����ݰ���ָ���ļ��㷽ʽ�����һ����� ������������
        �ǰ�stream�е�Ԫ��������� ����һ����ʼֵ �������ǵļ��㷽ʽ���������е�Ԫ�غͳ�ʼ��ֵ���м���  �������ٺͺ����Ԫ�ؼ���  �������ڶ�����Ԫ����ͳ�����

   ע�����
   ������ֵ����û���ս���� �м�����ǲ���ִ�е�
   ����һ���Եģ� һ��������һ���ս������ ����������ٱ�ʹ��
   ����Ӱ��ԭ���ݵ� �����������Ӱ��ԭ����Ԫ�� ��Ҳ��������
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
        //������
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Integer sum = stream.filter(num -> num > 5)
//                .reduce((result, element) -> result + element)
//                .get();
//        System.out.println(sum);
        //������ parallel���Խ�������ת���ɲ����� Ҳ����ͨ��parallelStream����
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum1 = stream1.parallel()
                .peek(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        System.out.println(integer+Thread.currentThread().getName());
                    }
                })//Stream�ṩ��ר�Ž��е��Եķ���peek �м���� ��������ֻ�ǵ��������ã��������������ѵ�����
                .filter(num -> num > 5)
                .reduce((result, element) -> result + element)
                .get();
        System.out.println(sum1);
    }

    private static void testData() {
        List<Author> authors = getAuthors();
        //�Ż�ǰ
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
        //�Ż���
        authors.stream()
                .mapToInt(author -> author.getAge())
                .map(age -> age+10)
                .filter(age -> age>18)
                .map(age -> age+2)
                .forEach(System.out::println);
    }

    private static void testNegate() {
        //��ӡ���������䲻����17�������
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
        //��ӡ�����������17���߳���С��2������
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
        //��ӡ�������������17���������ĳ��ȴ���1������
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(((Predicate<Author>) author -> author.getAge() > 17).and(author -> author.getName().length() >1))
                .forEach(author -> System.out.println(author.getAge()+":::"+author.getName()));

    }

    private static void test26() {
        //ʹ��reduce���������������е���Сֵ
        //reduceһ��������������ʽ�ڲ��ļ���  ע�⿴��Դ��  ���ǰѵ�һ��Ԫ�ؿ���result
        List<Author> authors = getAuthors();
        Optional<Integer> reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce((result, element) -> result > element ? element : result);
        reduce.ifPresent(age -> System.out.println(age));
    }

    private static void test25() {
        //ʹ��reduce���������������е���Сֵ
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result > element ? element : result);
        System.out.println(reduce);
    }

    private static void test24() {
        //ʹ��reduce���������������е����ֵ
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(reduce);
    }

    private static void test23() {
        List<Author> authors = getAuthors();
        //ʹ��reduce��������������ĺ�
        Integer sum = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(sum);
    }

    private static void test22() {
        List<Author> authors = getAuthors();
        //��ȡ������С������ �������������
        Optional<Author> first = authors.stream()
                .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
                .findFirst();
        first.ifPresent(author -> author.getName());
    }

    private static void test21() {
        List<Author> authors = getAuthors();
        //��ȡ����һ���������18�����ң������ھ������������
        Optional<Author> optionalAuthor = authors.stream()
                .filter(author -> author.getAge() >18)
                .findAny();
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }

    private static void test20() {
        List<Author> authors = getAuthors();
        //�ж������Ƿ�û�г���100��
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(b);
    }

    private static void test19() {
        List<Author> authors = getAuthors();
        //�ж��Ƿ����е����Ҷ��ǳ�����
        boolean b = authors.stream()
                .allMatch(author -> author.getAge() >= 10);
        System.out.println(b);
    }

    private static void test18() {
        //�ж��Ƿ���������29�����ϵ�����
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 46);
        System.out.println(b);
    }

    private static void test17() {
        //��ȡһ��map���� map��key��������  value��List<Book>
        List<Author> authors = getAuthors();
        Map<String, List<Book>> collect = authors.stream().distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(collect);

    }

    private static void test16() {
        List<Author> authors = getAuthors();
        //��ȡһ������������Set����
        Set<Book> collect = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        //��ȡһ����������������ֵ�List����
        List<String> collect = authors.stream()
                .map(author -> author.getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void test14() {
        //��ȡ��Щ�����鼮����߷ֺ���ͷ� ����ӡ
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
        //��ӡ��Щ���������鼮�ĸ���
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test11() {
        //��ӡ�������ݵ����з��ࡣҪ��Է������ȥ�أ����ܳ������ָ�ʽ ��ѧ������
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split("��")))
                .distinct()
                .forEach(category -> System.out.println(category));

    }

    private static void test10() {
        //��ӡ�����鼮�����֡�Ҫ����ظ�Ԫ��ȥ��
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test09() {
        //��ӡ��������������������������ң�Ҫ�������ظ���Ԫ�أ������е�Ԫ�ذ���������н���
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test08() {
        //�����е�Ԫ�ذ���������н��򣬲���Ҫ�������ظ���Ԫ�أ�Ȼ���ӡ�������������������ҵ�����
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        //�����е�Ԫ�ذ���������н��򣬲���Ҫ�������ظ���Ԫ�ء�
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
        //Streamֻ�ܶԵ��м��Ϻ�������д��� �����ڶ��м�����Map������ת���ɵ��м����ٴ���
        Map<String, Integer> map = new HashMap<>();
        map.put("����С��",19);
        map.put("����",17);
        map.put("��������",16);
        //��ת���ɵ��м���
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
        //1. ��ӡ��������С��18���ҵ����֣�����ע��ȥ��
        //���м���
        authors.stream()//�Ѽ���ת������
                .distinct()//ȥ���ظ�������
                .filter(author -> author.getAge()<18)//ɸѡ����С��18
                .forEach(author -> System.out.println(author.getName()));//������ӡ����
    }

    private static List<Author> getAuthors(){
        //���ݳ�ʼ��
        Author author = new Author(1L, "�ɶ�", 33, "һ���Ӳ˵�������������氲��", null);
        Author author2 = new Author(2L, "������", 15, "���Ҳ׷���������ٶ�", null);
        Author author3 = new Author(3L, "��", 14, "����������������˼ά", null);
        Author author4 = new Author(3L, "��", 14, "����������������˼ά", null);

        //�鼮�б�
        List<Book>  books1 = new ArrayList<>();
        List<Book>  books2 = new ArrayList<>();
        List<Book>  books3 = new ArrayList<>();

        books1.add(new Book(1L,"���������ǹ����ͺڰ�","��ѧ������",88,"��һ�ѵ������˰���"));
        books1.add(new Book(2L,"һ���˲�������ͬһ�ѵ���","���˳ɳ�������",99,"��δ�ʧ������������"));

        books2.add(new Book(3L,"�Ƿ紵�����ĵط�","��ѧ",85,"������˼ά���������ľ�ͷ"));
        books2.add(new Book(3L,"�Ƿ紵�����ĵط�","��ѧ",85,"������˼ά���������ľ�ͷ"));
        books2.add(new Book(4L,"���򲻴�","���顢���˴���",56,"һ����ѧ�ҵ�������ע�����Ѱ������ڵ�ʱ�����"));

        books3.add(new Book(5L,"��Ľ������ҵĽ�","����",56,"�޷�����һ�������ܶ����İ�����ô����"));
        books3.add(new Book(6L,"���뽣","���˴���",100,"������ѧ�������������ײ�ἤ�������Ļ��أ�"));
        books3.add(new Book(6L,"���뽣","���˴���",100,"������ѧ�������������ײ�ἤ�������Ļ��أ�"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        ArrayList<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;


    }
}
