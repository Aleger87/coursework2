import Enum.Type;
import java.time.LocalDate;

public class DailyTask extends Task {

    public DailyTask(String heading, String description, Type type) {
        super(heading, description, type);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate dateStart = getLocalDate();
        while(dateStart.isBefore(inputDate)){
            if (inputDate.equals(dateStart.plusDays(1))) {
               return true;
           }
         dateStart =  dateStart.plusDays(1);

        }
        return false;
    }


}
