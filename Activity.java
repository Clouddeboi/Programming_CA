package Programming_CA.Programming_CA;

public class Activity implements Comparable<Activity> {
    private String ActivityType;
    private String Date;
    private int Duration;
    private double Distance;
    private int AvgHeartRate;

    private Intensity intensity;
    private double CalsBurned;

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

    public double getCalsBurned() {
        setIntensity();
        return CalsBurned;
    }

    public void setCalsBurned(double calsBurned) {
        CalsBurned = calsBurned;
    }

    public Intensity getIntensity() {
        setIntensity();
        return intensity;
    }
    public void setIntensity() {
        this.intensity = intensity;

        double KPH = Distance/(Duration/60);

        if(this.getActivityType().equalsIgnoreCase("Cycling"))
        {
            this.CalsBurned = Duration *2;
            if(KPH > 16)
            {
                this.intensity = Intensity.LIGHT;
                this.CalsBurned = Duration * 5;

                if(KPH > 25)
                {
                    this.intensity = Intensity.MODERATE;
                    this.CalsBurned = Duration * 7;
                }
                if(KPH > 33)
                {
                    this.intensity = Intensity.VIGOROUS;
                    this.CalsBurned = Duration * 13;
                }
                if(KPH > 40)
                {
                    this.intensity = Intensity.VERY_VIGOROUS;
                    this.CalsBurned = Duration * 15;
                }
            }
        }

        if(this.getActivityType().equalsIgnoreCase("Running"))
        {
            this.CalsBurned = Duration *4.1;
            if(KPH > 8)
            {
                this.intensity = Intensity.LIGHT;
                this.CalsBurned = Duration * 7.2;

                if(KPH > 12)
                {
                    this.intensity = Intensity.MODERATE;
                    this.CalsBurned = Duration * 10;
                }
                if(KPH > 16)
                {
                    this.intensity = Intensity.VIGOROUS;
                    this.CalsBurned = Duration * 15.5;
                }
                if(KPH > 24)
                {
                    this.intensity = Intensity.VERY_VIGOROUS;
                    this.CalsBurned = Duration * 20.8;
                }
            }
        }

        if(this.getActivityType().equalsIgnoreCase("Swimming"))
        {
            this.CalsBurned = Duration *5;
            if(KPH > 1.25)
            {
                this.intensity = Intensity.LIGHT;
                this.CalsBurned = Duration * 6.3;

                if(KPH > 2)
                {
                    this.intensity = Intensity.MODERATE;
                    this.CalsBurned = Duration * 7.6;
                }
                if(KPH > 2.75)
                {
                    this.intensity = Intensity.VIGOROUS;
                    this.CalsBurned = Duration * 8.9;
                }
                if(KPH > 3.5)
                {
                    this.intensity = Intensity.VERY_VIGOROUS;
                    this.CalsBurned = Duration * 10.2;
                }
            }
        }
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

    @Override
    public int compareTo(Activity other) {
        Comparator<Activity> DateComp = new DateComparator();

        if(this.getActivityType().compareTo(other.getActivityType()) == 0){

            if(DateComp.compare(this, other) == 0){

                if(Double.compare(this.getDuration(), other.getDuration()) == 0){

                    if(Double.compare(this.getDistance(), other.getDistance()) == 0){

                        if(Double.compare(this.getCalsBurned(), other.getCalsBurned()) == 0){
                            return 0;
                        }
                        return Double.compare(this.getCalsBurned(), other.getCalsBurned());
                    }
                    return Double.compare(this.getDistance(), other.getDistance());
                }
                return Double.compare(this.getDuration(), other.getDuration());
            }
            return DateComp.compare(this, other);
        }
        return this.getActivityType().compareTo(other.getActivityType());
    }
}
