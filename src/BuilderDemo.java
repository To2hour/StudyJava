public class BuilderDemo {
    public static void main(String[] args) {
        EmployeeBuilder alice = new EmployeeBuilder()
                .name("Alice");

        System.out.println(alice.toString());
    }
}

/* 产品类：Person */
class Person {
    final String name;
    final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name=" + name + ", age=" + age + "}";
    }
}

/* 扩展产品：Employee */
class Employee extends Person {
    final String company;
    Employee(String name, int age, String company) {
        super(name, age);
        this.company = company;
    }

    @Override
    public String toString() {
        return "Employee{name=" + name + ", age=" + age + ", company=" + company + "}";
    }
}

/* 抽象 builder，关键点：SELF 自绑定 */
abstract class PersonBuilder<SELF extends PersonBuilder> {
    protected String name;
    protected int age;

    // 父类链式方法都返回 SELF
    public SELF name(String name) {
        this.name = name;
        return self();
    }

    public SELF age(int age) {
        this.age = age;
        return self();
    }

    // 子类必须实现，返回具体的 this（无 cast 警告）
    protected abstract SELF self();

    // 默认构建 Person（子类可以 override 返回更具体类型）
    public Person build() {
        return new Person(name, age);
    }
}

/* 具体 builder：EmployeeBuilder 指定 SELF 为 EmployeeBuilder */
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    private String company;

    public EmployeeBuilder company(String c) {
        this.company = c;
        return this; // 这里直接返回 EmployeeBuilder，编译器知道 SELF = EmployeeBuilder
    }

    @Override
    protected EmployeeBuilder self() { return this; }

    @Override
    public Employee build() {
        return new Employee(name, age, company);
    }
}
