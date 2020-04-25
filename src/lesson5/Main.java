package lesson5;

public class Main {
    public static void main(String[] args) {
        
    /*        * Создать массив из 5 сотрудников
        Пример:
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person(...);
            ...
        persArray[4] = new Person(...);

            * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    */

        Employee[] empArray = new Employee[]{
                new Employee(),
                new Employee("Сидоров Петр Иванович"),
                new Employee("Смирнов И.О.", "ген.директор", "8(922)1111111", 45, 50000),
                new Employee("Петров Г.О.", "глав.бухгалтер", "8(922)1111110", 42, 45000),
                new Employee("Васильев Д.В.", "разнорабочий", "нет", 45, 2000),
        };
        printEmployeesOver(40,empArray);
/*        String str="java";
        String b="java";
        System.out.println(str);
        System.out.println(b);
        str="java1";
        System.out.println(str);
        System.out.println(b);
*/
        /*
        for (int i = 0; i <15 ; i++) {
            System.out.println(str);
            System.out.println(b);
            str=""+i;
            b=str;
        }*/
    }

    public static void printEmployeesOver(int age,Employee[] empArray){
        for (Employee employee:empArray){
            if (employee.getAge()>age){
                employee.info();
            }
        }

    }

}

