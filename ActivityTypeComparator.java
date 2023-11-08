package Programming_CA;

import java.util.Comparator;
    public class ActivityTypeComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return a2.getActivityType().compareTo(a1.getActivityType());
        }
    }

