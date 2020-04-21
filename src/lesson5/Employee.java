package lesson5;

/*
* Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
        * Конструктор класса должен заполнять эти поля при создании объекта;
        * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
*/
public class Employee {
    private String fullName;
    private String position;
    private String telephone;
    private int age;
    private int salary;

    public Employee() {
        this("noname");
    }

    public Employee(String fullName) {
        this.fullName = fullName;
        this.position="кандидат";
    }

    public Employee(String fullName, String position, String telephone, int age, int salary) {
        this.fullName = fullName;
        this.position = position;
        this.telephone = telephone;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Выводит информацию по сотруднику.
     */
    public void info(){
        System.out.printf("Сотрудник: %s, должность: %s, телефон: %s, возраст: %s, зарплата: %s",fullName,position,telephone,age,salary);
        System.out.println();
    }

    /**
     * Возвращает возраст сотрудника.
     * @return
     */
    public int getAge() {
        return age;
    }
}
