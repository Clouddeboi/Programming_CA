package Programming_CA.Programming_CA;

import java.util.Comparator;

public class CaloriesBurnedComparatorDesc implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {
        return Double.compare(a2.getCalsBurned(), a1.getCalsBurned());
    }
}
