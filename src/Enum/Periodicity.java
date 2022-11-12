package Enum;

import java.time.LocalDateTime;

public enum Periodicity {
    ONE_TIME("однократная"),
    DAILY("ежедневная"),
    WEEKLY("еженедельная"),
    MONTHLY("ежемесячная"),
    ANNUAL("ежегодная");

    private String periodicity;


    Periodicity(String periodicity) {
        this.periodicity = periodicity;

    }


    public String getPeriodicity() {
        return periodicity;
    }
}
