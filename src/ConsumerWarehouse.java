import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ConsumerWarehouse  {
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
    static List<ConsumerWarehouse> listOfAllConsumerWarehouses = new ArrayList<>();


    public ConsumerWarehouse(double width, double length, double height, int startRentYear,
                             int startRentMonth, int startRentDay,
                             double costOfRentSpace, Long id) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.usableArea = width * length * height;
        this.startRentYear = startRentYear;
        this.startRentMonth = startRentMonth;
        this.startRentDay = startRentDay;
        this.startRentDate = LocalDate.of(startRentYear, startRentMonth, startRentDay);
        this.costOfRentSpace = costOfRentSpace;
        this.id = id;
        this.endOfRentDate = setEndRentDate(2021, 1, 10);
    }

    public ConsumerWarehouse(double usableArea, int startRentYear, int startRentMonth, int startRentDay,
                             double costOfRentSpace, Long id) {
        this.usableArea = usableArea;
        this.startRentYear = startRentYear;
        this.startRentMonth = startRentMonth;
        this.startRentDay = startRentDay;
        this.startRentDate = LocalDate.of(startRentYear, startRentMonth, startRentDay);
        this.costOfRentSpace = costOfRentSpace;
        this.id = id;
        this.endOfRentDate = setEndRentDate(2021, 1, 20);
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

        ConsumerWarehouse cw = new ConsumerWarehouse(50, 2021, 1, 10, 350, idCounter.getAndIncrement());
        ConsumerWarehouse cw1 = new ConsumerWarehouse(10, 2021, 1, 9, 300, idCounter.getAndIncrement());
        ConsumerWarehouse cw2 = new ConsumerWarehouse(78, 2021, 1, 8, 250, idCounter.getAndIncrement());
        ConsumerWarehouse cw3 = new ConsumerWarehouse(43, 2021, 1, 15, 230, idCounter.getAndIncrement());
        ConsumerWarehouse cw4 = new ConsumerWarehouse(120, 2021, 1, 14, 600, idCounter.getAndIncrement());
        ConsumerWarehouse cw5 = new ConsumerWarehouse(98, 2021, 1, 12, 500, idCounter.getAndIncrement());
        ConsumerWarehouse cw6 = new ConsumerWarehouse(30, 2021, 1, 15, 300, idCounter.getAndIncrement());
        ConsumerWarehouse cw7 = new ConsumerWarehouse(43, 2021, 1, 24, 400, idCounter.getAndIncrement());
        ConsumerWarehouse cw8 = new ConsumerWarehouse(16, 2021, 1, 10, 150, idCounter.getAndIncrement());
        ConsumerWarehouse cw9 = new ConsumerWarehouse(10, 2021, 1, 10, 100, idCounter.getAndIncrement());
        ConsumerWarehouse cw10 = new ConsumerWarehouse(76, 2021, 1, 10, 450, idCounter.getAndIncrement());
        listOfAllConsumerWarehouses.add(cw);
        listOfAllConsumerWarehouses.add(cw1);
        listOfAllConsumerWarehouses.add(cw2);
        listOfAllConsumerWarehouses.add(cw3);
        listOfAllConsumerWarehouses.add(cw4);
        listOfAllConsumerWarehouses.add(cw5);
        listOfAllConsumerWarehouses.add(cw6);
        listOfAllConsumerWarehouses.add(cw7);
        listOfAllConsumerWarehouses.add(cw8);
        listOfAllConsumerWarehouses.add(cw9);
        listOfAllConsumerWarehouses.add(cw10);
    }

    static List<ConsumerWarehouse> getAllConsumerWarehouses(){
        return listOfAllConsumerWarehouses;
    }





//
//    void addItem(Item item) {
//        //TODO: add method to validation of capacity
//        try {
//            validateItem(item);
//            this.listOfItems.add(item);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        if (volume > usableArea) {
////            System.out.println("Tu wstawić wyjątek TooManyThingsException");
////        } else {
////            // dodać Item do listy, do konkretnego uzytkownika
////            usableArea = usableArea - volume;
////        }
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
//
//    void removeItem() {
//        // nie wiem jak zaimplementować
//    }

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
                ", listOfItems="  +
                '}';
    }
}
