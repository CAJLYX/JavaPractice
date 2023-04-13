package Lambda;

import java.util.List;
import java.util.Optional;

/*
    Optional
   概述：Optional
   创建对象：optional就好像是包装类,把具体的数据封装Optional对象内部，然后使用optional封装好的方法操作封装进去的数据就可以非常优雅的避免空指针异常
            1. 使用Optional的静态方法ofNullable 封装成一个optional对象
            2. 若确定一个对象不是空的  可以使用静态方法of封装成一个optional对象 否则也会报空指针异常
            3. 将null封装成optional返回 这是可以使用Optional的静态方法empty来进行封装 Optional.empty()
   安全消费值：ifPresent OPtional.ifPresent()
   获取值： OPtional.get() 不推荐 容容易抛异常
   安全获取值：optional.orElseGet  获取数据并设置数据为空时的默认值 若为空则返回默认值
              optional.orElseThrow 获取数据并设置数据为空时的默认异常报错  若为空则进行异常报错

    过滤：可以使用filter方法对数据进行过滤。如果原本有数据，但是不符合判断，也会变成一个无数据的Optional对象 内部有判空处理
    判断：isPresent  是否存在数据的判断
    数据转换：map 对数据进行转换，并且转换后的数据也还是被OPtional包装好的   内部有判空处理
 */
public class OptionalDemo {
    public static void main(String[] args) throws Throwable {
        Optional<Author> authorOptional = getAuthorOptional();
//        authorOptional.ifPresent(author -> System.out.println(author.getName()));
//        authorOptional.get();
//        authorOptional.orElseGet(() -> new Author());
//        authorOptional.orElseThrow(() -> new RuntimeException("Author为空"));
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
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
    }
}
