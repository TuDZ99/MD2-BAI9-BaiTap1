import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;

public class NextDayCalculator {
    public static void main(String[] args) throws ParseException {
        System.out.println(NextDay(31,12,2021));
    }
    public static String NextDay(int ngay, int thang, int nam) throws ParseException {
        if (!isDateValid(ngay,thang,nam)) return "Invalid Date";
        String ngayInString = ngay + "-" + thang + "-" + nam;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-dd-yyy");
        Date date = dateFormat.parse(ngayInString);
        Date NextDay = new Date(date.getTime()+ 24 * 60 * 60 * 1000);

        String nextNgayInString = dateFormat.format(NextDay);
        if (ngay == 31 && thang == 12) System.out.println("Happy New Year");
        return nextNgayInString;
    }
    public static boolean isDateValid(int nam, int thang, int ngay){
        try {
            LocalDate.of(nam, thang, ngay);
        } catch (DateTimeException e){
            return false;
        }
        return false;
    }
}