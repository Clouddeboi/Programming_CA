package Programming_CA.Programming_CA;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CAMainApp {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int columnNum = 0;

        System.out.println("Which column would you like to read: ");// this is just for testing purposes
        columnNum = kb.nextInt();

        String[] data = ReadCol(columnNum, "src\\activity_data_50.csv", ",");//chooses which column to read

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }

    }

    public static String[] ReadCol(int column, String filepath, String delimeter)
    {
        String data[];
        String currentLine;
        ArrayList<String> colData = new ArrayList<String>();


        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                data = currentLine.split(delimeter);
                colData.add(data[column]);
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

        return colData.toArray(new String[0]);

    }
}


