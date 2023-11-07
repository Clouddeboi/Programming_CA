package Programming_CA.Programming_CA;

public class Activity {
    private String ActivityType;
    private String Date;
    private int Duration;
    private double Distance;
    private int AvgHeartRate;


    private Intensity intensity;
    private double CalsBurned;

    public enum Intensity
    {
        VERY_LIGHT,
        LIGHT,
        MODERATE,
        VIGOROUS,
        VERY_VIGOROUS
    };

    //Constructor
    public Activity(String activityType, String date, int duration, double distance, int avgHeartRate) {
        ActivityType = activityType;
        Date = date;
        Duration = duration;
        Distance = distance;
        AvgHeartRate = avgHeartRate;

        double KPH = Distance/(Duration/60);

        if(this.getActivityType().equals("Cycling"))
        {
            this.CalsBurned = Duration *2;
            if(KPH > 16)
            {
                this.intensity = Intensity.LIGHT;
                this.CalsBurned = Duration * 5;

                if(KPH > 25)
                {
                    this.intensity = Intensity.MODERATE;
                }
            }
        }
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

    public double getCalsBurned() {
        return CalsBurned;
    }

    public void setCalsBurned(double calsBurned) {
        CalsBurned = calsBurned;
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
