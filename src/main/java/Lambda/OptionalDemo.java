package Lambda;

import java.util.List;
import java.util.Optional;

/*
    Optional
   ������Optional
   ��������optional�ͺ����ǰ�װ��,�Ѿ�������ݷ�װOptional�����ڲ���Ȼ��ʹ��optional��װ�õķ���������װ��ȥ�����ݾͿ��Էǳ����ŵı����ָ���쳣
            1. ʹ��Optional�ľ�̬����ofNullable ��װ��һ��optional����
            2. ��ȷ��һ�������ǿյ�  ����ʹ�þ�̬����of��װ��һ��optional���� ����Ҳ�ᱨ��ָ���쳣
            3. ��null��װ��optional���� ���ǿ���ʹ��Optional�ľ�̬����empty�����з�װ Optional.empty()
   ��ȫ����ֵ��ifPresent OPtional.ifPresent()
   ��ȡֵ�� OPtional.get() ���Ƽ� ���������쳣
   ��ȫ��ȡֵ��optional.orElseGet  ��ȡ���ݲ���������Ϊ��ʱ��Ĭ��ֵ ��Ϊ���򷵻�Ĭ��ֵ
              optional.orElseThrow ��ȡ���ݲ���������Ϊ��ʱ��Ĭ���쳣����  ��Ϊ��������쳣����

    ���ˣ�����ʹ��filter���������ݽ��й��ˡ����ԭ�������ݣ����ǲ������жϣ�Ҳ����һ�������ݵ�Optional���� �ڲ����пմ���
    �жϣ�isPresent  �Ƿ�������ݵ��ж�
    ����ת����map �����ݽ���ת��������ת���������Ҳ���Ǳ�OPtional��װ�õ�   �ڲ����пմ���
 */
public class OptionalDemo {
    public static void main(String[] args) throws Throwable {
        Optional<Author> authorOptional = getAuthorOptional();
//        authorOptional.ifPresent(author -> System.out.println(author.getName()));
//        authorOptional.get();
//        authorOptional.orElseGet(() -> new Author());
//        authorOptional.orElseThrow(() -> new RuntimeException("AuthorΪ��"));
//        testFilter();
//        testIsPresent();
        testMap();

    }

    private static void testMap() {
        Optional<Author> authorOptional = getAuthorOptional();
        Optional<List<Book>> books = authorOptional.map(author -> author.getBooks());
        books.ifPresent(book -> System.out.println(book));
    }

    private static void testIsPresent() {
        Optional<Author> authorOptional = getAuthorOptional();
        if(authorOptional.isPresent()){
            System.out.println(authorOptional.get().getName());
        }
    }

    private static void testFilter() {
        Optional<Author> authorOptional = getAuthorOptional();
        authorOptional.filter(author1 -> author1.getAge() > 18).ifPresent(author1 -> System.out.println(author1.getName()));
    }

    public static Optional<Author> getAuthorOptional(){
        Author author = new Author(1L, "�ɶ�", 33, "һ���Ӳ˵�������������氲��", null);
        return Optional.ofNullable(author);
    }
}
