import java.io.IOException;
import java.util.ArrayList;

public class MenuManager {

    public static void menuGeneratorAndDisplay(String title, ArrayList<String> options) {
        System.out.println("====> " + title + " <=====");
        int i = 1;
        for (String option : options) {
            System.out.println(i + ". " + option);
            i++;
        }
    }


}
