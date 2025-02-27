package DesignPatterns.Creational.Prototype.Original;

interface Cloneable<T> {
    public T cloneMe();
}

class Person implements Cloneable<Person> {
    private String name;
    private Integer age;
    private Character gender;

    public Person(String name, Integer age, Character gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(Person person) {
        this.name = person.name;
        this.age = person.age;
        this.gender = person.gender;
    }

    public Person cloneMe() {
        return new Person(this);
    }

    @Override
    public String toString() {
        return name + " " + age + " " + gender;
    }
}

class Employee extends Person {
    private String designation;

    public Employee(String name, Integer age, Character gender, String designation) {
        super(name, age, gender);
        this.designation = designation;
    }

    public Employee(Employee employee) {
        super(employee);
        this.designation = employee.designation;
    }

    public Employee cloneMe() {
        return new Employee(this);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.designation;
    }
}

public class Prototype {
    public static void main(String[] args) {
        Person person1 = new Person("Akash", 25, 'M');
        Person person2 = person1.cloneMe();

        System.out.println(person1 == person2);
        System.out.println(person1.toString());
        System.out.println(person2.toString());

        Employee employee1 = new Employee("Archi", 21, 'F', "Intern");
        Employee employee2 = employee1.cloneMe();

        System.out.println(employee1 == employee2);
        System.out.println(employee1.toString());
        System.out.println(employee2.toString());
    }
}
