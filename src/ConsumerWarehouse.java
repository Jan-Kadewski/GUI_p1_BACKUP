import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class ConsumerWarehouse implements Runnable {
    public static final AtomicLong idCounter = new AtomicLong();
    double width;
    double length;
    double height;
    double usableArea;
    int startRentYear;
    int startRentMonth;
    int startRentDay;
    int endRentYear;
    int endRentMonth;
    int endRentDay;
    static LocalDate startRentDate;
    static LocalDate endOfRentDate;
    double costOfRentSpace;
    Long id;
    boolean isRented;
    static List<ConsumerWarehouse> listOfAllConsumerWarehouses = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ConsumerWarehouse(double width, double length, double height, int startRentYear,
                             int startRentMonth, int startRentDay, int endRentDay, int endRentMonth, int endRentYear,
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
        this.endRentDay = endRentDay;
        this.endRentMonth = endRentMonth;
        this.endRentYear = endRentYear;
        endOfRentDate = LocalDate.of(endRentYear, endRentMonth, endRentMonth);
        this.isRented = isRented;
    }

    public ConsumerWarehouse(double usableArea, int startRentYear, int startRentMonth, int startRentDay, int endRentDay, int endRentMonth, int endRentYear,
                             double costOfRentSpace, Long id, boolean isRented) {
        this.usableArea = usableArea;
        this.startRentYear = startRentYear;
        this.startRentMonth = startRentMonth;
        this.startRentDay = startRentDay;
        startRentDate = LocalDate.of(startRentYear, startRentMonth, startRentDay);
        this.costOfRentSpace = costOfRentSpace;
        this.id = id;
        this.isRented = isRented;
        this.endRentDay = endRentDay;
        this.endRentMonth = endRentMonth;
        this.endRentYear = endRentYear;
        endOfRentDate = LocalDate.of(endRentYear, endRentMonth, endRentMonth);
    }

    public static void checkIfRentExpired(Scanner sc) {
        System.out.println("Weryfikacja  zadluzenia, podaj ID obecnie wynajmowanego pomieszczenia");
        for (int i = 0; i < Main.choosenPerson.listOfTenantAlert.size(); i++) {
            System.out.println(Main.choosenPerson.listOfTenantAlert.get(i));
        }
        Long idFromUser = sc.nextLong();
        for (ConsumerWarehouse cw : listOfAllConsumerWarehouses) {
            if (cw.id.equals(idFromUser)) {
                //TODO: Dodawac co 5 sekund metoda daysToAdd 1 dzien i sprawdzac czy wszystko sie zgadza
                System.out.println("start" + startRentDate);
                System.out.println(startRentDate.plusDays(100));
                System.out.println("end" + endOfRentDate);
                System.out.println(startRentDate.isAfter(endOfRentDate));
                if (startRentDate.plusDays(100).isAfter(endOfRentDate)) {
                    Person p = Main.choosenPerson;
                    Main.choosenPerson.listOfTenantAlert.add(new TenantAlert(p.name, p.lastName, p.id, cw.costOfRentSpace));
                    System.out.println("Przykro mi, czas na płatność minął, pismo zostało wystosowane");
                    System.out.println(Main.choosenPerson.listOfTenantAlert);
                    if (Main.choosenPerson.listOfTenantAlert.size() >= 3) {
                        //TODO: Tu napisać logikę, co zrobić, gdy ktoś ma 3 zadłużenia, połowa II strony
                    }

                } else {
                    System.out.println("Wszystko w porządku, nie zalegasz z płatnością za to pomieszczenie");
                }
            }
        }
    }

    public static void insertSampleOfConsumerWarehouse() {
        ConsumerWarehouse cw5 = new ConsumerWarehouse(50, 2021, 1, 20, 30, 1, 2021, 350, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw6 = new ConsumerWarehouse(10, 2021, 1, 9, 30, 1, 2021, 300, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw7 = new ConsumerWarehouse(78, 2021, 1, 8, 25, 3, 2021, 250, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw8 = new ConsumerWarehouse(43, 2021, 1, 15, 1, 2, 2021, 230, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw9 = new ConsumerWarehouse(120, 2021, 1, 14, 16, 2, 2021, 600, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw10 = new ConsumerWarehouse(98, 2021, 1, 12, 10, 2, 2021, 500, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw11 = new ConsumerWarehouse(30, 2021, 1, 10, 2, 1, 2021, 300, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw12 = new ConsumerWarehouse(43, 2021, 1, 24, 25, 2, 2021, 400, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw13 = new ConsumerWarehouse(16, 2021, 1, 10, 15, 2, 2021, 150, idCounter.getAndIncrement(), true);
        ConsumerWarehouse cw14 = new ConsumerWarehouse(10, 2021, 1, 10, 28, 2, 2021, 100, idCounter.getAndIncrement(), false);
        ConsumerWarehouse cw15 = new ConsumerWarehouse(76, 2021, 1, 10, 22, 2, 2021, 450, idCounter.getAndIncrement(), false);
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

    @Override
    public void run() {
        while (true) {
            System.out.println("Wykonuje sie co 5 sekund");
            checkIfRentExpired(sc);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
