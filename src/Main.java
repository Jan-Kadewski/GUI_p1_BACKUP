import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Person choosenPerson = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person.insertSampleOfData();
        ConsumerWarehouse.insertSampleOfConsumerWarehouse();
        Menu.showMainMenu();

    }
}
