package Programming_CA.Programming_CA;

public class Activity {
    private String ActivityType;
    private String Date;
    private int Duration;
    private double Distance;
    private int AvgHeartRate;

    //Constructor
    public Activity(String activityType, String date, int duration, double distance, int avgHeartRate) {
        ActivityType = activityType;
        Date = date;
        Duration = duration;
        Distance = distance;
        AvgHeartRate = avgHeartRate;
    }

    //getter
    public String getActivityType() {
        return ActivityType;
    }

    public String getDate() {
        return Date;
    }

    public int getDuration() {
        return Duration;
    }

    public double getDistance() {
        return Distance;
    }

    public int getAvgHeartRate() {
        return AvgHeartRate;
    }

    //setter
    public void setActivityType(String activityType) {
        ActivityType = activityType;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public void setDistance(double distance) {
        Distance = distance;
    }

    public void setAvgHeartRate(int avgHeartRate) {
        AvgHeartRate = avgHeartRate;
    }

    //to string
    @Override
    public String toString() {
        return "Activity{" +
                "ActivityType='" + ActivityType + '\'' +
                ", Date='" + Date + '\'' +
                ", Duration=" + Duration +
                ", Distance=" + Distance +
                ", AvgHeartRate=" + AvgHeartRate +
                '}';
    }
    
}
