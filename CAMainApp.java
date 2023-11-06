package Programming_CA.Programming_CA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CAMainApp {
   public static void main(String[] args) throws IOException {

       String userFileSelect = "";

       Scanner kb = new Scanner(System.in);
       userFileSelect = kb.nextLine();

       ArrayList<Activity> stats = new ArrayList<Activity>();
       readFile("src/Programming_CA/Programming_CA/TestStats/"+userFileSelect, stats);

       for(Activity a: stats)
       {
           System.out.printf("%-20s %-20s %-20d %-20.1f %-20d\n",a.getActivityType(), a.getDate(), a.getDuration(),a.getDistance(),a.getAvgHeartRate() );
       }
   }
    private static Activity parseLine2(String line)
    {
        String ActivityType;
        String Date;
        int Duration;
        double Distance;
        int AvgHeartRate;

        StringTokenizer st = new StringTokenizer(line, ",");
        ActivityType = st.nextToken();
        Date = st.nextToken();
        Duration = Integer.parseInt(st.nextToken().trim());
        Distance = Double.parseDouble(st.nextToken().trim());
        AvgHeartRate = Integer.parseInt(st.nextToken().trim());


        return new Activity(ActivityType,Date,Duration,Distance,AvgHeartRate);
    }

    public static void readFile(String fileName, ArrayList<Activity> stats) throws IOException {
        File f = new File(fileName);
        Scanner fileIn = new Scanner(f);

        boolean firstLine = true;
        String line;

        while (fileIn.hasNextLine()) {
            //This is just to skip over the 5 header strings that are in the CSV for some reason.
            if (firstLine) {
                fileIn.nextLine();
                firstLine = false;
            }

            line = fileIn.nextLine();
            Activity a = parseLine2(line);
            stats.add(a);
        }
    }
}




