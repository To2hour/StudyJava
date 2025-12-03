package function.lamdba;


import java.util.Objects;

/**
 * @author TwoHour
 * @version 1.0
 * @描述: todo
 * @since 2025-12-03 19:28
 **/
public class Stu {
    int age;
    String name;

    public Stu() {
    }

    public Stu(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Stu stu = (Stu) o;
        return this.getName().length() == ((Stu) o).getName().length();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.length());
    }
}
