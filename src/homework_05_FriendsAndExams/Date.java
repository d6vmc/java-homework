package homework_05_FriendsAndExams;

import java.util.Objects;

public class Date {
    int startDate;
    int endDate;

    public Date(int startDate, int endDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Date{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

   public boolean intersects(Date date) {
       return startDate <= date.endDate && date.startDate <= endDate;
   }
}
