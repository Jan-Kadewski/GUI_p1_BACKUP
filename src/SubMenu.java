import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubMenu {

    private static Scanner sc = ScannerManager.getScanner();

    static void chooseUser(){
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Pokaz listę wszystkich użytkowników");
        menu.add("Wybierz użytkownika po ID");
        MenuManager.menuGeneratorAndDisplay("WYBIERZ UŻYTKOWNIKA",menu);

        switch(sc.next()){
            case "1":{
                for(Person p:Person.getAllListOfPersons()){
                    System.out.println("Użytkownik ID: " + p.id + "; Szczegóły: " + p);
                }
            }
            case "2":{
                System.out.print("Podaj ID:");
                String idFromUser = sc.next();
                Main.choosenPerson =  Person.getPersonById(idFromUser);
                System.out.println("Wybrałeś użytkownika:"+Main.choosenPerson);
            }
        }
    }

    static void actionsForChosenUser() {
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Podejmij akcje z magazynem");
        menu.add("Podejmij akcje w garażu");
        menu.add("Cofnij do głównego menu");
        menu.add("Zamknij program");

        MenuManager.menuGeneratorAndDisplay("MOŻLIWE OPCJE",menu);
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

    static void actionsOfWarehouse(){
        ArrayList<String> options = new ArrayList<String>();
        options.add("Wyświetl obecny stan wynajętych pomieszczeń");
        options.add("Wyświetl wolne pomieszczenia");
        options.add("Wynajmij wolne pomieszczenia by ID");
        options.add("Pokaz moje wynajete pomieszczenia");
        options.add("Włóż nowy przedmiot do pomieszczenia");
        options.add("Wyjmij  przedmiot z pomieszczenia");
        options.add("Cofnij do głównego menu");
        options.add("Zamknij program");

        MenuManager.menuGeneratorAndDisplay("MOŻLIWE OPCJE", options);

        switch(sc.next()){
            case "1":{

            }
        }

    }
}
