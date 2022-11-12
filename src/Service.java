import java.time.format.DateTimeFormatter;
import java.util.*;
import Enum.*;

public class Service {
    //  Проверка данных
    //  Добавить задачу в список
    //  Удалить задачу
    //  Получить задачу на указанный день

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static Map<Integer, Task> taskList = new HashMap<>();

    public static boolean checkData (String heading, String description, Type type, Periodicity periodicity) {
        List<String> list = List.of(heading, description, String.valueOf(type), String.valueOf(periodicity));
        for (var data : list) {
            if (data == "null" || data.isBlank() || data.isEmpty() ) {
                throw new RuntimeException("Не все данные заполнены верно");
            }
        }
        return true;
    }

    public static void createTask(String taskName, String taskDescription, Type taskType, Periodicity taskPeriodicity) {
        Task task = new Task(taskName,taskDescription,taskType,taskPeriodicity);
        taskList.put(task.getId(), task);

    }

    public static void getTaskListForRemove() {
        for (int i : taskList.keySet()) {
            System.out.println(i + ". Задача " + taskList.get(i).getHeading());
        }
    }

    public static Map<Integer, Task> getTaskList() {
        return taskList;
    }

    public static int getTaskSizeList() {
        return taskList.size();
    }

    public static void removeTask(int id) {
        taskList.remove(id);
        System.out.println("Задача "+id+" удалена!");
    }

    public static void showTask(String date) {
        Set<Task> taskOfDay = new HashSet<>();
        for (int i : Service.getTaskList().keySet()) {
            switch (Service.getTaskList().get(i).getPeriodicity()) {
                case ONE_TIME:
                    taskOfDay.add(Service.getTaskList().get(i));

                case DAILY:
                    if (date.equals(Service.getTaskList().get(i).getLocalDateTime().plusDays(1).format(formatter))) {
                        taskOfDay.add(Service.getTaskList().get(i));
                    }

                case WEEKLY:
                    if (date.equals(Service.getTaskList().get(i).getLocalDateTime().plusWeeks(1).format(formatter))) {
                        taskOfDay.add(Service.getTaskList().get(i));
                    }

                case MONTHLY:
                    if (date.equals(Service.getTaskList().get(i).getLocalDateTime().plusMonths(1).format(formatter))) {
                        taskOfDay.add(Service.getTaskList().get(i));
                    }

                case ANNUAL:
                    if (date.equals(Service.getTaskList().get(i).getLocalDateTime().plusYears(1).format(formatter))) {
                        taskOfDay.add(Service.getTaskList().get(i));
                    }

            }
        }
        System.out.println(taskOfDay);
    }
}
