
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import Enum.Type;



public class Main {
    public static void main(String[] args) {
        startAddTask();
    }

    private static void startAddTask() {

        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);  //добавить задачу
                            break;
                        case 2:
                            removeTask(scanner); //удалить задачу
                            break;
                        case 3:
                            getTaskForDay(scanner); //Получить задачу на указанный день
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        Type taskType = selectTypeTask(scanner);
        printPeriodicityMenu();
        //Periodicity taskPeriodicity = selectPeriodicityTask(scanner);
        createTask(taskName, taskDescription, taskType, scanner);
        //Service.checkData(taskName, taskDescription, taskType, taskPeriodicity);
        //Service.createTask(taskName, taskDescription, taskType, taskPeriodicity);
        System.out.println("Задача " + taskName + " создана");
    }

    private static void createTask(String taskName, String taskDescription, Type taskType, Scanner scanner) {
        switch (scanner.nextInt()) {
            case 1:
                Service.addTask(new Task(taskName, taskDescription, taskType));
                break;
            case 2:
                Service.addTask(new DailyTask(taskName, taskDescription, taskType));
                break;
            case 3:
                Service.addTask(new WeeklyTask(taskName, taskDescription, taskType));
                break;
            case 4:
                Service.addTask(new MonthTask(taskName, taskDescription, taskType));
                break;
            case 5:
                Service.addTask(new YearTask(taskName, taskDescription, taskType));
                break;
            default:
                throw new RuntimeException("Нет номера в списке меню");
        }
    }


    private static void getTaskForDay(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        if (Service.getTaskList().size() == 0) {
            System.out.println("Задачи отсутствуют");
        }else {
            System.out.println("Введите дату(в формате dd.MM.yyyy):");
            LocalDate date = LocalDate.from(LocalDate.parse(scanner.next(), formatter).atStartOfDay());
            Set<Task> taskListOfDay = new HashSet<>(Service.checkTask(date));
            System.out.println(taskListOfDay);
        }
    }

    private static void removeTask(Scanner scanner) {
        if (Service.getTaskList().size() == 0) {
            System.out.println("Задачи отсутствуют");
        }else {
            System.out.println("Выберете задачу для удаления:");
            int id = selectTaskForRemove(scanner);
            Service.removeTask(id);
        }
    }

    private static int selectTaskForRemove(Scanner scanner) {
        Service.getTaskListForRemove();
            if (scanner.hasNextInt()) {
                int menuTaskId = scanner.nextInt();
                return menuTaskId;
            }
        return 0;
    }


    private static void printPeriodicityMenu() {
        System.out.println(
                "      \n1- однократная," +
                "      \n2- ежедневная," +
                "      \n3- еженедельная," +
                "      \n4- ежемесячная," +
                "      \n5- ежегодная");
    }

    private static Type selectTypeTask(Scanner scanner) {
        Type type = null;
        System.out.print("Укажите тип задачи: ");
        printTypeMenu();
        if (scanner.hasNextInt()) {
            int menuType = scanner.nextInt();
            switch (menuType) {
                case 1:
                    type = type.PERSONAL;
                    break;
                case 2:
                    type = type.WORKER;
                    break;
            }
        }else {
            scanner.next();
            System.out.println("Выберите пункт меню из списка!");
        }
        return type;
    }

    private static void printTypeMenu() {
        System.out.println(
                        "\n1. Личная"+
                        "\n2. Рабочая"
        );
    }

    private static void printMenu() {
        System.out.println(
                        "1. Добавить задачу"+
                        "\n2. Удалить задачу"+
                        "\n3. Получить задачу на указанный день"+
                        "\n0. Выход"
        );

    }
}