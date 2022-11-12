import java.util.Scanner;
import Enum.Type;
import Enum.Periodicity;


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
        Periodicity taskPeriodicity = selectPeriodicityTask(scanner);
        Service.checkData(taskName, taskDescription, taskType, taskPeriodicity);
        Service.createTask(taskName, taskDescription, taskType, taskPeriodicity);
        System.out.println("Задача " + taskName + " создана");
    }

    private static void getTaskForDay(Scanner scanner) {
        if (Service.getTaskList().size() == 0) {
            System.out.println("Задачи отсутствуют");
        }else {
            System.out.println("Введите дату(в формате dd-MM-yyyy):");
            String date =  scanner.next();
            Service.showTask(date);
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
                if (menuTaskId > Service.getTaskSizeList() || menuTaskId < 1) {
                    System.out.println("неверно выбрана задача");
                }else {
                    return menuTaskId;
                }
            }else {
                scanner.next();
                System.out.println("Выберите пункт меню из списка!");
            }

        return 0;
    }

    private static Periodicity selectPeriodicityTask(Scanner scanner) {
        Periodicity periodicity = null;
        System.out.print("Как часто повторять задачу: ");
        printPeriodicityMenu();
        if (scanner.hasNextInt()) {
            int menuType = scanner.nextInt();
            switch (menuType) {
                case 1:
                    periodicity = periodicity.ONE_TIME;
                    break;
                case 2:
                    periodicity = periodicity.DAILY;
                    break;
                case 3:
                    periodicity = periodicity.WEEKLY;
                    break;
                case 4:
                    periodicity = periodicity.MONTHLY;
                    break;
                case 5:
                    periodicity = periodicity.ANNUAL;
                    break;
            }
        }else {
            scanner.next();
            System.out.println("Выберите пункт меню из списка!");
        }
        return periodicity;

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