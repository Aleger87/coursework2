import Enum.Type;
import java.time.LocalDate;

public class WeeklyTask extends Task {

    public WeeklyTask(String heading, String description, Type type) {
        super(heading, description, type);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate dateStart = getLocalDate();
        while(dateStart.isBefore(inputDate)){
            if (inputDate.equals(dateStart.plusWeeks(1))) {
                return true;
            }
            dateStart =  dateStart.plusWeeks(1);

        }
        return false;
    }


}
