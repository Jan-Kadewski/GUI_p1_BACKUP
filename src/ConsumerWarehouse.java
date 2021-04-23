import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class ConsumerWarehouse {
    public static final AtomicLong idCounter = new AtomicLong();
    double width;
    double length;
    double height;
    double usableArea;
    int startRentYear;
    int startRentMonth;
    int startRentDay;
    static LocalDate startRentDate;
    static LocalDate endOfRentDate;
    double costOfRentSpace;
    Long id;
    boolean isRented;
    static List<ConsumerWarehouse> listOfAllConsumerWarehouses = new ArrayList<>();

    public ConsumerWarehouse(double width, double length, double height, int startRentYear,
                             int startRentMonth, int startRentDay,
                             double costOfRentSpace, Long id, boolean isRented) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.usableArea = width * length * height;
        this.startRentYear = startRentYear;
        this.startRentMonth = startRentMonth;
        this.startRentDay = startRentDay;
        startRentDate = LocalDate.of(startRentYear, startRentMonth, startRentDay);
        this.costOfRentSpace = costOfRentSpace;
        this.id = id;
        endOfRentDate = setEndRentDate(2021, 1, 10);
        this.isRented = isRented;
    }

    public ConsumerWarehouse(double usableArea, int startRentYear, int startRentMonth, int startRentDay,
                             double costOfRentSpace, Long id, boolean isRented) {
        this.usableArea = usableArea;
        this.startRentYear = startRentYear;
        this.startRentMonth = startRentMonth;
        this.startRentDay = startRentDay;
        startRentDate = LocalDate.of(startRentYear, startRentMonth, startRentDay);
        this.costOfRentSpace = costOfRentSpace;
        this.id = id;
        endOfRentDate = setEndRentDate(2021, 1, 20);
        this.isRented = isRented;
    }


    public LocalDate setEndRentDate(int endYearOfRent, int endMonthOfRent, int endDayOfRent) {
        endOfRentDate = LocalDate.of(endYearOfRent, endMonthOfRent, endDayOfRent);
        return endOfRentDate;
    }


    // dokończyć

    public static void checkIfRentExpired() {
        System.out.println("wchodzi1");
        // to działa ale trzeba dodać dołączenie do usera
        if (startRentDate.plusDays(14).isAfter(endOfRentDate)) {
            System.out.println("EXPIRED");

        }
    }

    public static void insertSampleOfConsumerWarehouse() {


        ConsumerWarehouse cw5 = new ConsumerWarehouse(50, 2021, 1, 10, 350, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw6 = new ConsumerWarehouse(10, 2021, 1, 9, 300, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw7 = new ConsumerWarehouse(78, 2021, 1, 8, 250, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw8 = new ConsumerWarehouse(43, 2021, 1, 15, 230, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw9 = new ConsumerWarehouse(120, 2021, 1, 14, 600, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw10 = new ConsumerWarehouse(98, 2021, 1, 12, 500, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw11 = new ConsumerWarehouse(30, 2021, 1, 15, 300, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw12 = new ConsumerWarehouse(43, 2021, 1, 24, 400, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw13 = new ConsumerWarehouse(16, 2021, 1, 10, 150, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw14 = new ConsumerWarehouse(10, 2021, 1, 10, 100, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw15 = new ConsumerWarehouse(76, 2021, 1, 10, 450, idCounter.getAndIncrement(), false);
        listOfAllConsumerWarehouses.add(cw5);
        listOfAllConsumerWarehouses.add(cw6);
        listOfAllConsumerWarehouses.add(cw7);
        listOfAllConsumerWarehouses.add(cw8);
        listOfAllConsumerWarehouses.add(cw9);
        listOfAllConsumerWarehouses.add(cw10);
        listOfAllConsumerWarehouses.add(cw11);
        listOfAllConsumerWarehouses.add(cw12);
        listOfAllConsumerWarehouses.add(cw13);
        listOfAllConsumerWarehouses.add(cw14);
        listOfAllConsumerWarehouses.add(cw15);
    }

    static List<ConsumerWarehouse> getAllConsumerWarehouses() {
        return listOfAllConsumerWarehouses;
    }

    public static void showConsumerWarehouseAbleToRent() {
        for (ConsumerWarehouse cw : listOfAllConsumerWarehouses) {
            if (cw.isRented == false) {
                System.out.println(cw);
            }
        }
    }

    public static void showRentedSpace() {
        for (int i = 0; i < Main.choosenPerson.listOfRentedArea.size(); i++) {
            System.out.println(Main.choosenPerson.listOfRentedArea.get(i));
        }
    }

    public static void rentSpaceById(Scanner sc) {
        System.out.println("wprowadz ID pomieszczenia");
        String id = sc.next();
        if (Main.choosenPerson.isAllowedToOpenAndPutOrTakeIntoSpace) {
            for (ConsumerWarehouse cw : listOfAllConsumerWarehouses) {
                if (cw.id == Long.parseLong(id) && cw.isRented == false) {
                    System.out.println(Main.choosenPerson.listOfRentedArea);
                    Main.choosenPerson.listOfRentedArea.add(cw);
                    System.out.println("Pomyślnie wynajęto nową przestrzeń magazynową");
                    cw.isRented = true;
                    System.out.println("Obecne wynajętę przez Ciebie przestrzenie magazynowe " + Main.choosenPerson.listOfRentedArea);
                    SubMenu.actionsOfWarehouse();
                }
            }
        } else {
            System.out.println("Nie jesteś uprawniony do wynajmowania większej ilości powierzchni");
            SubMenu.actionsOfWarehouse();
        }
    }

    public static void addItemToRentedSpace(Scanner sc) {
        System.out.println(Main.choosenPerson.listOfRentedArea);
        System.out.println("Wybierz do którego pomieszczenia chcesz włożyć przedmiot podająć ID pomieszczenia");
        int idFromUser = sc.nextInt();
        for (ConsumerWarehouse cw : Main.choosenPerson.listOfRentedArea) {
            if (cw.id == Long.parseLong(String.valueOf(idFromUser))) {
                // wybrać czy chce utworzyć przed pp czy przez 3 wymiary
                Item.itemMenu(sc);
                // TODO:zwalidować wybór magazynu i wybranie ITEMU

            } else {
                System.out.println("Błędnie wybrane ID");
                SubMenu.actionsOfWarehouse();
            }
        }
    }

//    public static void addItem(Item i) {
//        for (ConsumerWarehouse cw : ConsumerWarehouse.listOfItem) {
//            if (i.volume > cw.usableArea) {
//                System.out.println("Przedmiot za duży, włożenie nie powiodło się");
//                // wstawic wyjątek
//            } else {
//                ConsumerWarehouse.listOfItem.add(i);
//                cw.usableArea = cw.usableArea - i.volume;
//                System.out.println("W magazynie pozostało" + cw.usableArea + "wolnej przestrzeni");
//                System.out.println(ConsumerWarehouse.listOfItem);
//            }
//        }
//    }


//
//      static  void addItem(Item item) {
//        //TODO: add method to validation of capacity
//        try {
//            validateItem(item);
//            this.listOfItems.add(item);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        if (volume > usableArea) {
//            System.out.println("Tu wstawić wyjątek TooManyThingsException");
//        } else {
//            // dodać Item do listy, do konkretnego uzytkownika
//            usableArea = usableArea - volume;
//        }
//    }
//
//    void validateItem(Item item) throws Exception {
//        if (item.volume > 20) { //FIXME: pobierz ze stalych z magazynu
//            throw new Exception("Za duze volume");
//        }
//    }
//
//    public List<Item> showItems() {
//        return listOfItems;
//    }
//
//    void AddItem(String name, double width, double length, double height) {
//        double volume = width * length * height;
//        if (volume > usableArea) {
//            System.out.println("Tu wstawić wyjątek TooManyThingsException");
//        } else {
//            usableArea = usableArea - volume;
//            // dodać Item do listy, do konkretnego uzytkownika
//        }
//    }

    void removeItem() {
        // nie wiem jak zaimplementować
    }

    @Override
    public String toString() {
        return "ConsumerWarehouse{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", usableArea=" + usableArea +
                ", startRentYear=" + startRentYear +
                ", startRentMonth=" + startRentMonth +
                ", startRentDay=" + startRentDay +
                ", costOfRentSpace=" + costOfRentSpace +
                ", id=" + id +
                ", isRented=" + isRented +
                '}';
    }
}
