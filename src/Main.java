import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Person choosenPerson = null;
    public static void main(String[] args) {

    Person.insertSampleOfData();
    ConsumerWarehouse.insertSampleOfConsumerWarehouse();
    Menu.showMainMenu();

    }
}
