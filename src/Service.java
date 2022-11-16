import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Service {
    //  Проверка данных
    //  Добавить задачу в список
    //  Удалить задачу
    //  Получить задачу на указанный день

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static Map<Integer, Task> taskList = new HashMap<>();

    public static void addTask(Task task) {
        taskList.put(task.getId(), task);
    }

    public static void getTaskListForRemove() {
        for (int i : taskList.keySet()) {
            System.out.println(taskList.get(i).getId() + ". Задача " + taskList.get(i).getHeading());
        }
    }

    public static Map<Integer, Task> getTaskList() {
        return taskList;
    }

    public static int getTaskSizeList() {
        return taskList.size();
    }

    public static void removeTask(int id)  {
        if (!taskList.containsKey(id)) {
            throw new RuntimeException("Неверно указан ID");
        }
        taskList.remove(id);
        System.out.println("Задача "+id+" удалена!");
    }

    public static List<Task> checkTask(LocalDate date) {
        List<Task> tasksOfDay = new ArrayList<>();
        for (int t: taskList.keySet()) {
            if (taskList.get(t).isAvailable(date)) {
                tasksOfDay.add(taskList.get(t));
            }
        }

        return tasksOfDay;
    }

}
