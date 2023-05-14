import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class timezone {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        String[] ids = TimeZone.getAvailableIDs();

        for(String id:ids){
            System.out.println("The available timezones are:"+id);
        }

        // finding local time zone
        System.out.print("Enter your local time zone: ");
        String localTime = cs.nextLine();
        ZoneId local = ZoneId.of(localTime);

        // finding the country time zone which user wants to convert in
        System.out.print("Enter the country time zone which you want to convert into: ");
        String thatTime = cs.nextLine();
        ZoneId international = ZoneId.of(thatTime);

        // Convert local time to the time of the zone which user has given
       LocalDateTime localDateTime = LocalDateTime.now(local);
        LocalDateTime countryDateTime = localDateTime.atZone(local).withZoneSameInstant(international).toLocalDateTime();

        // Formating Date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         String presentTime = formatter.format(localDateTime);
          String internationalTime = formatter.format(countryDateTime);


        // Showing output
        System.out.println("Present time of your current zone: (" + local + "): " + presentTime);
        System.out.println("Time  of the zone(" + international + "): " + internationalTime);
    }
}

