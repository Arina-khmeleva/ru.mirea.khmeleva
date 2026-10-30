package pr2;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() { return name; }// получаем имя
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }// изменить почту
    public char getGender() { return gender; }

    @Override
    public String toString() {
        String g;
        if (gender == 'M' || gender == 'm') g = "m";
        else if (gender == 'F' || gender == 'f') g = "f";
        else g = "u";
        return name + " (" + g + ") at " + email;
    }
}
