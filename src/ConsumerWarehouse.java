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
    int endRentYear;
    int endRentMonth;
    int endRentDay;
    static LocalDate startRentDate;
    static LocalDate endOfRentDate;
    double costOfRentSpace;
    Long id;
    boolean isRented;
    static List<ConsumerWarehouse> listOfAllConsumerWarehouses;
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
        listOfAllConsumerWarehouses = new ArrayList<>();
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
        listOfAllConsumerWarehouses = new ArrayList<>();

    }



    public static void checkIfRentExpired(Scanner sc) throws ProblematicTenantException {
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
                        throw new ProblematicTenantException("Osoba" + Main.choosenPerson.name+ " " + Main.choosenPerson.lastName + " posiadała już najem pomieszczeń" +Main.choosenPerson.listOfRentedArea  + "\n"+ Person.listOfParkingForPerson +    "\n" + "wysokosc zadlużenia" + Person.totalCostForRents );
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

    public static void showRentedSpace()  {

        for (int i = 0; i < Main.choosenPerson.listOfRentedArea.size(); i++) {
            System.out.println(Main.choosenPerson.listOfRentedArea.get(i));
        }
        for(int i=0;i<Person.listOfParkingForPerson.size();i++){
            System.out.println("Miejsce parkingowe o id nr:" +Person.listOfParkingForPerson.get(i).id +" Kwocie zadłużenia "
                    + Person.listOfParkingForPerson.get(i).price);
        }
        for(Person p:Person.listOfPersons){
          if(p.firstDayOfRent >0 && p.firstDayOfRent <=31){

          }
         else{
              try {
                  throw new NeverRentException("Nigdy nie wynajęto pomieszczenia");
              } catch (NeverRentException e) {
                  e.printStackTrace();
              }
          }
        }

    }


    public static void rentSpaceById(Scanner sc) {
        System.out.println("wprowadz ID pomieszczenia");
        long id = sc.nextLong();
        if (Main.choosenPerson.isAllowedToOpenAndPutOrTakeIntoSpace) {
            for (ConsumerWarehouse cw : listOfAllConsumerWarehouses) {

                if (cw.id == id && cw.isRented == false) {
                    System.out.println(Main.choosenPerson.listOfRentedArea);
                    Main.choosenPerson.listOfRentedArea.add(cw);
                    System.out.println("Pomyślnie wynajęto nową przestrzeń magazynową");
                    cw.isRented = true;
                    System.out.println("Obecne wynajętę przez Ciebie przestrzenie magazynowe " + Main.choosenPerson.listOfRentedArea);
                }
            }
        } else {
            System.out.println("Posiadasz zadłużenie na kwotę " +Person.totalCostForRents + " Odmowa wynajęcia");
            try {
                SubMenu.actionsOfWarehouse();
            } catch (NeverRentException e) {
                e.printStackTrace();
            } catch (TooManyThingsException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addItemToRentedSpace(Scanner sc) throws NeverRentException, TooManyThingsException {
        System.out.println(Main.choosenPerson.listOfRentedArea);
        System.out.println("Wybierz do którego pomieszczenia chcesz włożyć przedmiot podająć ID pomieszczenia");
        long idFromUser = sc.nextInt();
        for (ConsumerWarehouse cw : Main.choosenPerson.listOfRentedArea) {
            System.out.println(cw.id == idFromUser);
            System.out.println(Main.choosenPerson.listOfRentedArea.get((int)idFromUser));
            System.out.println(cw.id);
            System.out.println(idFromUser);
            if (cw.id == idFromUser) {
                Item.itemMenu(sc);
            } else {
                try {
                    throw new TooManyThingsException("remove some old items to insert a new item");
                } catch (TooManyThingsException e) {
                    e.printStackTrace();
                }

            }
            SubMenu.actionsOfWarehouse();
        }
    }

    public static void removeItemFromRentedSpace(Scanner sc) throws TooManyThingsException {
        for (int i = 0; i < Person.listOfItem.size(); i++) {
            System.out.println(Person.listOfItem.get(i));
        }
        System.out.println("Podaj ID przedmiotu do wyjęcia");
        long id = sc.nextLong();
            for (Item i : Person.listOfItem) {
                if (i.id == id) {
                    for (ConsumerWarehouse cw : Main.choosenPerson.listOfRentedArea) {
                        System.out.println(cw.usableArea);
                        cw.usableArea = cw.usableArea + Person.listOfItem.get(Math.toIntExact(id)).volume;
                        System.out.println(cw.usableArea);
                    }
                    Person.listOfItem.remove((int) id);
                    if(Person.listOfItem.size() ==0){
                        System.out.println("Brak przedmiotów, powrót do głównego menu");
                        try {
                            SubMenu.actionsOfWarehouse();
                        } catch (NeverRentException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Podano złe ID");
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
                ", endRentYear=" + endRentYear +
                ", endRentMonth=" + endRentMonth +
                ", endRentDay=" + endRentDay +
                ", costOfRentSpace=" + costOfRentSpace +
                ", id=" + id +
                ", isRented=" + isRented +

                '}';
    }
}
