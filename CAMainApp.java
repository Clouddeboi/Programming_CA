package Programming_CA.Programming_CA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CAMainApp {
    public static void main(String[] args) {

        String file = "src\\activity_data_50.csv";

        BufferedReader reader = null;

        String line = "";

        try
        {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null)
            {
                String[] row = line.split(",");

                for(String index : row)
                {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

}


