import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMenu {

    private static final Scanner sc = ScannerManager.getScanner();

    static void chooseUser() {
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Pokaz listę wszystkich użytkowników");
        menu.add("Wybierz użytkownika po ID");
        MenuManager.menuGeneratorAndDisplay("WYBIERZ UŻYTKOWNIKA", menu);
        System.out.print("Wybrana opcja to: ");
        switch (sc.next()) {
            case "1": {
                for (Person p : Person.getAllListOfPersons()) {
                    System.out.println("Użytkownik ID: " + p.id + "; Szczegóły: " + p);
                }
                chooseUser();
            }
            case "2": {
                System.out.print("Podaj ID:");
                String idFromUser = sc.next();
                Main.choosenPerson = Person.getPersonById(idFromUser);
                System.out.println("Wybrałeś użytkownika:" + Main.choosenPerson);
                actionsForChosenUser();
            }
        }
    }

    static void actionsForChosenUser() {
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Podejmij akcje z magazynem");
        menu.add("Podejmij akcje w garażu");
        menu.add("Cofnij do głównego menu");
        menu.add("Zamknij program");

        MenuManager.menuGeneratorAndDisplay("MOŻLIWE OPCJE", menu);
        System.out.print("Wybrana opcja to: ");
        switch (sc.next()) {
            case "1": {
                actionsOfWarehouse();
                break;
            }
            case "2": {
                System.out.println("subMenuActionsOfGarage()");
                break;
            }
            case "3": {
                Menu.showMainMenu();
                break;
            }
            case "4": {
                Menu.exitProgram(sc);
                break;
            }
        }

    }

    static void actionsOfWarehouse() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("Wyświetl obecny stan wynajętych pomieszczeń przez wybranego użytkownika");
        options.add("Wyświetl wolne pomieszczenia");
        options.add("Wynajmij wolne pomieszczenia by ID");
        options.add("Pokaz moje wynajete pomieszczenia");
        options.add("Zapłać za zaległe pomieszczenie");
        options.add("Zmień uprawnienia do pomieszczenia");
        options.add("Włóż nowy przedmiot do pomieszczenia");
        options.add("Wyjmij  przedmiot z pomieszczenia");
        options.add("Cofnij do głównego menu");
        options.add("Zamknij program");

        MenuManager.menuGeneratorAndDisplay("MOŻLIWE OPCJE", options);
        System.out.print("Wybrana opcja: ");
        switch (sc.next()) {
            case "1" -> {
                System.out.println("Obecny stan wynajętych pomieszczeń:");
                System.out.println(Main.choosenPerson.getListOfRentedArea());
                System.out.println();
                System.out.println();
                actionsOfWarehouse();
                break;
            }
            case "2" -> {
                ConsumerWarehouse.showConsumerWarehouseAbleToRent();
                actionsOfWarehouse();
                System.out.println();
                break;
            }
            case "3" -> {
                ConsumerWarehouse.rentSpaceById(sc);
//                ConsumerWarehouse.checkIfRentExpired(sc);
                SubMenu.actionsOfWarehouse();
                //TODO: Wybierz wolne pomieszczenie , które w property czyWynajete ma false podając w param ID
                break;
            }
            case "4" -> {
                Person.getDateOfFirstRentSpace();
                System.out.println("Wynajęte przestrzenie magazynowe przez:" + Main.choosenPerson);
                ConsumerWarehouse.showRentedSpace();
                SubMenu.actionsOfWarehouse();
                break;
            }
            case "5" -> {
                Person.payForRent(sc);
                SubMenu.actionsOfWarehouse();
                break;
            }
            case "6" -> {
                Person.setPermissionToOpenSpace(sc);
                SubMenu.actionsOfWarehouse();
                break;
            }
            case "7" -> {
                ConsumerWarehouse.addItemToRentedSpace(sc);
                SubMenu.actionsOfWarehouse();
                break;
            }
            case "8" -> {
                //TODO: FUNKCJA wyjmij z pomieszczenia
                ConsumerWarehouse.removeItemFromRentedSpace(sc);
                SubMenu.actionsOfWarehouse();
                break;
            }
            case "9" -> {
                Menu.showMainMenu();
            }
            case "10" -> {
                Menu.exitProgram(sc);
            }
            case "11" ->{
               ParkingSpace.rentParkingSpaceById(sc);
            }
            case "12"->{
                ConsumerWarehouse.removeItemFromRentedSpace(sc);
            }
        }

    }
}
