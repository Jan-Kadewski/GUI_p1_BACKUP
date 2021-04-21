import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = ScannerManager.getScanner();
    static void showMainMenu() {
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Wybierz/zmień użytkownika");
        menu.add("Stwórz użytkownika");
        menu.add("Zamknij program");
        MenuManager.menuGeneratorAndDisplay("GŁÓWNE MENU", menu);
        System.out.print("Wybrana opcja to: ");
        switch (sc.next()) {
            case "1": {
                SubMenu.chooseUser();
                break;
            }
            case "2": {
                System.out.println("subMenuForCreationUser()");
                break;
            }
            case "3": {
                exitProgram(sc);
                break;
            }
        }
    }

    public static void exitProgram(Scanner sc) {
        System.out.print("Aby opuścić program, wpisz \"yes\" : ");
        String exit = sc.next();
        if (exit.equals("yes")) {
            System.exit(0);
        }
    }
}


























