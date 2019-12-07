package EnhancingDate;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date(2,28,2020);
        for (int i = 0; i < 365; i++){
            date.nextDay();
            System.out.println(date);
        }
    }
}
