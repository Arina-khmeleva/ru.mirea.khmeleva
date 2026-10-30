package pr2;

public class MainAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'M');
        Author a2 = new Author("Sue Grant", "suGrant@somewhere.com", 'F');

        System.out.println(a1);   // Tan Ah Teck (m) at ahTeck@somewhere.com
        System.out.println(a2);   // Sue Grant (f) at suGrant@somewhere.com

        a1.setEmail("new@mail.com");  // email менять можно
        System.out.println(a1.getEmail());
        System.out.println(a1.getName());
        System.out.println(a1.getGender());
    }
}
