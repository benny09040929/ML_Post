package CSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Benny on 17/3/7.
 */
public class Import {

    public static void main(String[] args) {

        String csvFile = "/Users/Benny/Desktop/SELECT_dbo_MemberShip_member_id_dbo_MemberShip_identifier_explai_201703071349.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                System.out.println(country[0]+ "," + country[1] + "," + country[2] + "," + country[3] + "," +country[4] + "," + country[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
