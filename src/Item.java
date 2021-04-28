import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class Item {
    String name;
    double width;
    double length;
    double height;
    Double volume;
    Scanner sc = new Scanner(System.in);
    long id;
    public static final AtomicLong idCounter = new AtomicLong();

    public Item(String name, double width, double length, double height, long id) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
        this.volume = width * length * height;
        this.id = id;
    }

    public Item(String name, double volume, long id) {
        this.name = name;
        this.volume = volume;
        this.id = id;
    }


    public static void itemMenu(Scanner sc) throws NeverRentException, TooManyThingsException {
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
                System.out.println(Main.choosenPerson.listOfRentedArea);
                for (ConsumerWarehouse cw : Main.choosenPerson.listOfRentedArea) {
                    try {
                        if (cw.usableArea >= itemArea) {
                            Person.listOfItem.add(new Item(itemName, itemArea, idCounter.getAndIncrement()));
                            System.out.println(Person.listOfItem);
                            cw.usableArea = cw.usableArea - itemArea;
                            System.out.println("Pozostała przestrzeń w magazynie " + cw.usableArea);
                            System.out.println("Podano przedmiot o nazwie: " + itemName + " o polu powierzchni " + itemArea);
                            System.out.println("Przedmiot został pomyślnie dodany");
                            SubMenu.actionsOfWarehouse();
                        }
                    } catch (Exception TooManyThingsException) {

                        try {
                            SubMenu.actionsOfWarehouse();
                        } catch (NeverRentException | TooManyThingsException e) {
                            e.printStackTrace();
                        }

                    }

                }
                break;
            }
            case "2": {
                System.out.print("Podaj nazwę przedmiotu");
                String itemName = sc.next();
                System.out.println("Podaj Szerokość");
                double width = sc.nextDouble();
                System.out.println("Podaj długość");
                double length = sc.nextDouble();
                System.out.println("Podaj wysokość");
                double height = sc.nextDouble();

                for (ConsumerWarehouse cw : Main.choosenPerson.listOfRentedArea) {
                    if (cw.usableArea > (width * length * height)) {
                        Person.listOfItem.add(new Item(itemName, width, length, height, idCounter.getAndIncrement()));
                        System.out.println(Person.listOfItem);
                        cw.usableArea = cw.usableArea - width * length * height;
                        System.out.println(cw.usableArea);
                        System.out.println("Podano przedmiot o nazwie: " + itemName + " o polu powierzchni " + width * length * height);
                        System.out.println("Przedmiot został pomyślnie dodany");
                        try {
                            SubMenu.actionsOfWarehouse();
                        } catch (NeverRentException | TooManyThingsException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Przedmiot jest za duży i nie mieści się w magazynie");
                        try {
                            SubMenu.actionsOfWarehouse();
                        } catch (NeverRentException | TooManyThingsException e) {
                            e.printStackTrace();
                        }

                    }

                    System.out.println("Podano przedmiot o nazwie: " + itemName + " Szerokości: " + width + " długości: " + length +
                            " wysokości: " + height + "Zajmujący: " + height * width * length + " pola powierzchni");
                    SubMenu.actionsOfWarehouse();
                    break;

                }

            }
            case "3": {
                SubMenu.actionsOfWarehouse();
            }
            case "4": {
                Menu.exitProgram(sc);
            }
        }
    }


    @Override
    public String toString() {
        return "Item{" +
                ", ID przedmiotu " + id +
                " name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", volume=" + volume +
                '}';
    }
}
