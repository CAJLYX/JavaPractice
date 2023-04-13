package Lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Author implements Comparable<Author> {
    //id
    private Long id;
    //����
    private String name;
    //����
    private Integer age;
    //���
    private String intro;
    //��Ʒ
    private List<Book> books;

    @Override
    public int compareTo(Author o) {
        return o.getAge()-this.getAge();
    }
}
