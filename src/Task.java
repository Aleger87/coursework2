import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import Enum.Type;
import Enum.Periodicity;


public class Task {
    private static int counter=1;
    private int id;
    private final String heading;
    private final String description;
    private final Type type;
    private  Periodicity periodicity;

    private LocalDateTime localDateTime;


    public Task(String heading, String description, Type type, Periodicity periodicity) {
        this.heading = heading;
        this.description = description;
        this.type = type;
        this.periodicity = periodicity;
        id = counter;
        counter++;
        localDateTime = LocalDateTime.now();
    }



    @Override
    public String toString() {
        return "\n----------------------------------------------------------" +
                "\nЗадача:" +
                "  \n№ =" + id +
                ", \nЗаголовок = " + heading + '\'' +
                ", \nОписание = " + description + '\'' +
                ", \nТип = " + type.getType() +
                ", \nпереодичность = " + periodicity.getPeriodicity() +
                ", \nдата/время создания = " + localDateTime +
                ", \n-------------------------------------------------------";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(heading, task.heading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, heading);
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public Type getType() {
        return type;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getId() {
        return id;
    }


}
