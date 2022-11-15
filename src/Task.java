import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import Enum.Type;


public class Task implements Repeatability {
    private static int counter=1;
    private int id;
    private final String heading;
    private final String description;
    private final Type type;
   // private  Periodicity periodicity;

    private LocalDate localDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Task(String heading, String description, Type type) {
        this.heading = heading;
        this.description = description;
        this.type = type;
        //this.periodicity = periodicity;
        id = counter;
        localDate = LocalDate.now();
        counter++;
    }



    //Однократная задача, бессрочная, будет висеть в списке задач до момента ее выполнения (удаления)
    @Override
    public boolean isAvailable(LocalDate inputDate) {
        return true;
    }

    @Override
    public String toString() {
        return "\n----------------------------------------------------------" +
                "\nЗадача:" +
                "  \n№ =" + id +
                ", \nЗаголовок = " + heading + '\'' +
                ", \nОписание = " + description + '\'' +
                ", \nТип = " + type.getType() +
                ", \nдата создания = " + localDate +
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

  /*  public Periodicity getPeriodicity() {
        return periodicity;
    }*/

    public LocalDate getLocalDate() {
        return localDate;
    }

    public int getId() {
        return id;
    }

}
