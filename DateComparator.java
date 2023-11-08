package Programming_CA.Programming_CA;

import java.util.Comparator;

public class DateComparator implements Comparator<Activity> {
    @Override
    public int compare(Activity a1, Activity a2) {

        int a1Date[] = parseDate(a1.getDate());
        int a2Date[] = parseDate(a2.getDate());

        if(a1Date[2] == a2Date[2])
        {
            if(a1Date[1] == a2Date[1])
            {
                return a1Date[0] - a2Date[0];
            }
            return a1Date[1] - a2Date[1];
        }
        return a1Date[2] - a2Date[2];
    }

    public int[] parseDate(String s)
    {
        int[] d = new int[3];
        String[] date = s.split("/");
        for(int i =0; i < date.length;i++)
        {
            d[i] = Integer.parseInt(date[i].trim());
        }
        return d;
    }
}



