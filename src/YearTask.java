import Enum.Type;
import java.time.LocalDate;

public class YearTask extends Task {
    public YearTask(String heading, String description, Type type) {
        super(heading, description, type);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate dateStart = getLocalDate();
        while(dateStart.isBefore(inputDate)){
            if (inputDate.equals(dateStart.plusYears(1))) {
                return true;
            }
            dateStart =  dateStart.plusYears(1);

        }
        return false;
    }


}
