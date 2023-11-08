package Programming_CA.Programming_CA;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class CAMainApp {
    public static void main(String[] args) throws IOException {

        String userFileSelect = "";
        boolean ascendingOrder = true;

        System.out.println("Welcome to the Activity Tracker!");
        System.out.println("Enter File Name Here:");

        Scanner kb = new Scanner(System.in);
        userFileSelect = kb.nextLine();

        ArrayList<Activity> stats = new ArrayList<Activity>();

        readFile("src/Programming_CA/Programming_CA/TestStats/" + userFileSelect, stats);

        boolean Exit = false;
        while (!Exit) {
            System.out.println("\nMain Menu:");
            System.out.println("----------------------");
            System.out.println("0. Exit");
            System.out.println("1. View Activities");
            System.out.println("2. View Specific fields");
            System.out.println("3. View Statistics");
            System.out.println("4. Binary Search");
            System.out.println("----------------------");

            int userInput = kb.nextInt();
            kb.nextLine();

            if (userInput == 0){
                Exit = true;
            }
            else if (userInput == 1)
            {
                menu1(kb, stats, ascendingOrder);
            }
            else if (userInput == 2)
            {
                menu2(kb, stats);
            }
            else if (userInput == 3){
                menu3(kb, stats);
            }
            else if (userInput == 4){
                System.out.println("Enter the activity name:");
                String actName = kb.nextLine();
                kb.nextLine();

                //call method for binary
            }
            else{
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static Activity parseLine2(String line, ArrayList<Activity> stats)
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

        Activity activity = new Activity(ActivityType,Date,Duration,Distance,AvgHeartRate);
        if(stats.contains(activity))
        {
            stats.add(activity);
        }

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
            Activity a = parseLine2(line, stats);
            stats.add(a);
        }
    }

    public static void menu1(Scanner kb, ArrayList<Activity> stats, boolean ascendingOrder){
        System.out.println("\n Sort by:");
        System.out.println("----------------------");
        System.out.println("1. Calories Burned");
        System.out.println("2. Date");
        System.out.println("3. Activity Duration");
        System.out.println("4. Type of Activity");
        System.out.println("5. Distance");
        System.out.println("----------------------");

        int choice = kb.nextInt();
        kb.nextLine();

        System.out.println("Would you like to sort in Ascending (1) or Descending (2) order?");
        int orderChoice = kb.nextInt();
        kb.nextLine();

        if(choice == 1)
        {
            if(orderChoice == 1){
                sortCalsBurned(stats, ascendingOrder);
            }
            else if(orderChoice == 2){
                sortCalsBurned(stats, !ascendingOrder);
            }
        }

        else if(choice == 2)
        {
            if(orderChoice == 1){
                sortDate(stats, ascendingOrder);
            }
            else if(orderChoice == 2){
                sortDate(stats, !ascendingOrder);
            }
        }
        else if(choice == 3)
        {
            if(orderChoice == 1){
                sortDuration(stats, ascendingOrder);
            }
            else if(orderChoice == 2){
                sortDuration(stats, !ascendingOrder);
            }
        }
        else if(choice == 4)
        {
            if(orderChoice == 1){
                sortActType(stats, ascendingOrder);
            }
            else if(orderChoice == 2){
                sortActType(stats, !ascendingOrder);
            }
        }
        else if(choice == 5)
        {
            if(orderChoice == 1){
                sortDistance(stats, ascendingOrder);
            }
            else if(orderChoice == 2){
                sortDistance(stats, !ascendingOrder);
            }
        }
        else{
            System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void menu2(Scanner kb, ArrayList<Activity> stats){
        System.out.println("\nSpecific fields:");
        System.out.println("----------------------");
        System.out.println("1. Activity type");
        System.out.println("2. Above a minimum distance");
        System.out.println("3. Type of energy expended");
        System.out.println("4. Above a minimum duration");
        System.out.println("----------------------");

        int choice = kb.nextInt();
        kb.nextLine();

        if(choice == 1){
            System.out.printf("%-20s", "Activity Type");
            for (Activity a: stats)
            {
                System.out.printf("\n%-20s",a.getActivityType());
            }
        }
        else if(choice == 2){
            double UserMinDistance = 0;
            System.out.println("What's your minimum distance?(enter as Double): ");
            UserMinDistance = kb.nextDouble();
            System.out.printf("\n%-20s %-20s", "Activity type","Distance");
            for(Activity a: stats)
            {
                if(UserMinDistance < a.getDistance())
                {
                    System.out.printf("\n%-20s %-20.1f", a.getActivityType(), a.getDistance());
                }
            }
            System.out.println("\n");
        }
        else if(choice == 3){
            int userChoiceIntensity = 0;

            System.out.println("""
                   1.VERY LIGHT
                   2.LIGHT
                   3.MODERATE
                   4.VIGOROUS
                   5.VERY VIGIOROUS
                    """);

            userChoiceIntensity = kb.nextInt();

            if(userChoiceIntensity == 1)
            {
                viewIntensity(stats, Intensity.VERY_LIGHT);
            }
            else if(userChoiceIntensity == 2)
            {
                viewIntensity(stats, Intensity.LIGHT);
            }
            else if(userChoiceIntensity == 3)
            {
                viewIntensity(stats, Intensity.MODERATE);
            }
            else if(userChoiceIntensity == 4)
            {
                viewIntensity(stats, Intensity.VIGOROUS);
            }
            else if(userChoiceIntensity == 5)
            {
                viewIntensity(stats, Intensity.VERY_VIGOROUS);
            }
        }
        else if(choice == 4){
            //call Above a minimum duration
            int UserMinDuration = 0;
            System.out.println("What's your minimum duration?: ");
            UserMinDuration = kb.nextInt();
            System.out.printf("\n%-20s %-20s", "Activity type","Duration");
            for(Activity a: stats)
            {
                if(UserMinDuration  < a.getDuration())
                {
                    System.out.printf("\n%-20s %-20d", a.getActivityType(),a.getDuration());
                }
            }
        }
        else{
            System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void menu3(Scanner kb, ArrayList<Activity> stats){
        System.out.println("\nStatistics:");
        System.out.println("----------------------");
        System.out.println("1. Average distance per activity");
        System.out.println("1. Average calories burned");
        System.out.println("----------------------");

        int choice = kb.nextInt();
        kb.nextLine();

        if(choice == 1){
            //call Average distance per activity

            double AvgDistanceCycling = 0.0;
            double AvgDistanceSwimming= 0.0;
            double AvgDistanceRunning= 0.0;
            int countCycling = 0;
            int countSwimming = 0;
            int countRunning = 0;
            int AvgDistanceChoice = 0;

            System.out.println("""
                    1.Cycling
                    2.Swimming
                    3.Running
                    """);
            AvgDistanceChoice = kb.nextInt();
            kb.nextLine();

            for(Activity a: stats)
            {
                if(a.getActivityType().equals("Cycling"))
                {
                    countCycling = countCycling +1;
                    AvgDistanceCycling = AvgDistanceCycling + a.getDistance();
                }
                else if(a.getActivityType().equals("Swimming"))
                {
                    countSwimming = countSwimming +1;
                    AvgDistanceSwimming = AvgDistanceSwimming + a.getDistance();
                }
                else if(a.getActivityType().equals("Running"))
                {
                    countRunning= countRunning +1;
                    AvgDistanceRunning = AvgDistanceRunning + a.getDistance();
                }
            }
            AvgDistanceCycling = (AvgDistanceCycling) / countCycling;
            AvgDistanceSwimming= (AvgDistanceSwimming) / countSwimming;
            AvgDistanceRunning= (AvgDistanceRunning) / countRunning;

            if(AvgDistanceChoice == 1)
            {
                System.out.println("Average Cycling Distance:");
                System.out.println(AvgDistanceCycling);
            }
            else if(AvgDistanceChoice == 2)
            {
                System.out.println("Average Swimming Distance:");
                System.out.println(AvgDistanceSwimming);
            }
            else if(AvgDistanceChoice == 3)
            {
                System.out.println("Average Running Distance:");
                System.out.println(AvgDistanceRunning);
            }

        }
        else if(choice == 2){
            //call Average calories burned

            int countCalsBurnedCount = 0;
            double avgCalsBurned = 0;
            for(Activity a: stats)
            {
                countCalsBurnedCount = countCalsBurnedCount +1;
                avgCalsBurned = avgCalsBurned + a.getCalsBurned();
            }
            avgCalsBurned = (avgCalsBurned) / countCalsBurnedCount;
            System.out.println("Average Calories Burned:\n"+avgCalsBurned);
        }
        else{
            System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void displayStats(ArrayList<Activity> stats){
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Activity Type", "Date", "Duration", "Distance", "Avg Heart Rate","Calories Burned");
        for (Activity a : stats) {
            System.out.printf("%-20s %-20s %-20d %-20.1f %-20d %-20.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAvgHeartRate(), a.getCalsBurned());
        }
    }
    public static void sortCalsBurned(ArrayList<Activity> stats, boolean ascendingOrder){
        Comparator<Activity> CalComp = new CaloriesBurnedComparator();

        if (!ascendingOrder) {
            CalComp = Collections.reverseOrder(CalComp);
        }

        Collections.sort(stats, CalComp);

        System.out.println("\nSorted by calories");
        displayStats(stats);
    }
    public static void sortDate(ArrayList<Activity> stats, boolean ascendingOrder){
        Comparator<Activity> DateComp = new DateComparator();

        if (!ascendingOrder) {
            DateComp = Collections.reverseOrder(DateComp);
        }

        Collections.sort(stats, DateComp);

        System.out.println("\nSorted by Date");
        displayStats(stats);
    }
    public static void sortDuration(ArrayList<Activity> stats, boolean ascendingOrder){
        Comparator<Activity> DurComp = new DurationComparator();

        if (!ascendingOrder) {
            DurComp = Collections.reverseOrder(DurComp);
        }

        Collections.sort(stats, DurComp);

        System.out.println("\nSorted by Duration");
        displayStats(stats);
    }

    public static void sortActType(ArrayList<Activity> stats, boolean ascendingOrder){
        Comparator<Activity> ActTypeComp = new ActivityTypeComparator();

        if (!ascendingOrder) {
            ActTypeComp = Collections.reverseOrder(ActTypeComp);
        }

        Collections.sort(stats, ActTypeComp);

        System.out.println("\nSorted by Activity Type");
        displayStats(stats);
    }
    public static void sortDistance(ArrayList<Activity> stats, boolean ascendingOrder){
        Comparator<Activity> DistComp = new DistanceComparator();

        if (!ascendingOrder) {
            DistComp = Collections.reverseOrder(DistComp);
        }

        Collections.sort(stats, DistComp);

        System.out.println("\nSorted by Distance");
        displayStats(stats);
    }

    public static void viewIntensity(ArrayList<Activity> stats, Intensity intensity)
    {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Activity Type", "Date", "Duration", "Distance", "Avg Heart Rate","Calories Burned");

        for(Activity a: stats)
        {
            if(a.getIntensity() == intensity)
            {
                System.out.printf("%-20s %-20s %-20d %-20.1f %-20d %-20.1f\n", a.getActivityType(), a.getDate(), a.getDuration(), a.getDistance(), a.getAvgHeartRate(), a.getCalsBurned());
            }
        }
    }
    public static void binarySearch (String actName)
    {

    }

}