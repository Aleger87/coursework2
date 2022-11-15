import Enum.Type;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DailyTask extends Task {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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
