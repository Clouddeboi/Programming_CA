package Programming_CA.Programming_CA;

import java.util.Comparator;

public class DurationComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity a1, Activity a2) {
            return Double.compare(a1.getDuration(), a2.getDuration());
        }
    }

