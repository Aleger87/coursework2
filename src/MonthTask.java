import Enum.Type;
import java.time.LocalDate;

public class MonthTask extends Task {

    public MonthTask(String heading, String description, Type type) {
        super(heading, description, type);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate dateStart = getLocalDate();
        while(dateStart.isBefore(inputDate)){
            if (inputDate.equals(dateStart.plusMonths(1))) {
                return true;
            }
            dateStart =  dateStart.plusMonths(1);

        }
        return false;
    }


}
