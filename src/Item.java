import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Item {
    String name;
    double width;
    double length;
    double height;
    Double volume;
    Scanner sc = new Scanner(System.in);
    public Item(String name, double width, double length, double height) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = width * length * height;
    }

    public Item(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }


    public static void itemMenu(Scanner sc) {
        System.out.println("Co chcesz zrobić?");
        System.out.println("1. Wstaw przedmiot podając jego nazwę i pole powierzchni");
        System.out.println("2. Wstaw przedmiot podając jego nazwę, szerokość X długość X wysokość ");
        System.out.println("3. Wróć do Menu głównego");
        System.out.println("4. Zamknij program");
        String optionFromUser = sc.next();
        switch (optionFromUser) {
            case "1": {
                System.out.print("Podaj nazwę przedmiotu:");
                String itemName = sc.next();
                System.out.println("Podaj pole powierzchni:");
                double itemArea = sc.nextDouble();
                Person.listOfItem.add(new Item(itemName, itemArea));
                System.out.println("Podano przedmiot o nazwie: " + itemName + " o polu powierzchni " + itemArea);
                // dokonczyc
                System.out.println("Przedmiot został pomyślnie dodany");
                SubMenu.actionsOfWarehouse();
                break;
            }
            case "2": {
                System.out.print("Podaj nazwę przedmiotu");
                String itemName = sc.next();
                System.out.println("Podaj Szerokosc");
                double width = sc.nextDouble();
                System.out.println("Podaj długość");
                double length = sc.nextDouble();
                System.out.println("Podaj wysokość");
                double height = sc.nextDouble();
                System.out.println(Person.listOfItem);
                System.out.println("Podano przedmiot o nazwie: " + itemName + " Szerokości: " + width + " długości: " + length +
                        " wysokości: " + height + "Zajmujący: " + height * width * length + " pola powierzchni");
                SubMenu.actionsOfWarehouse();

                break;

            }
            case "3": {
                SubMenu.actionsOfWarehouse();
            }
            case "4": {
                Menu.exitProgram(sc);
            }

        }
        System.out.println("Jak chcesz wstawić przedmiot:");
        System.out.println("Jak chcesz wstawić przedmiot:");
    }







    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", volume=" + volume +
                '}';
    }
}
