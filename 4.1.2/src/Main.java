import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<Employee>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите информацию о сотруднике (фамилия, имя, возраст, пол, образование, должность, отдел");
            //Сохраните атрибуты в переменные
            String surname = scanner.nextLine();
            String name = scanner.nextLine();
            Integer age = Integer.parseInt(scanner.nextLine());
            String sex = scanner.nextLine();
            String education = scanner.nextLine();
            String position = scanner.nextLine();
            String department = scanner.nextLine();

            Employee employee = new Employee(surname, name, age, sex, education, position, department);
            // Используйте конструктор для создания объекта Employee emp = new Employee(...);

            list.add(employee);

            System.out.println("Если хотите закончить ввод данных, введите end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
        }

        System.out.println("Список сотрудников:\n" +
                "Фамилия\t" +
                "Имя\t" +
                "Возраст\t" +
                "Пол\t" +
                "Образование\t" +
                "Должность\t" +
                "Отдел\t");
        for(Employee line: list){
            System.out.println(line);
        }

    }
}
