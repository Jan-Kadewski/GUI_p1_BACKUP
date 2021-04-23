import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Person {
    String name;
    String lastName;
    String address;
    LocalDate birthday;
    int birthdayYear;
    int birthdayMonth;
    int birthdayDay;
    LocalDate dateOfFirstRentArea;
    long pesel;
    Long id;
    int firstDayOfRent;
    int firstMonthOfRent;
    int firstYearOfRent;
    boolean isAllowedToOpenAndPutOrTakeIntoSpace;
    static final AtomicLong personIdGenerator = new AtomicLong();
    static List<Person> listOfPersons = new ArrayList<>();
    static List<TenantAlert> listOfTenantAlert = new ArrayList<>();
    List<ConsumerWarehouse> listOfRentedArea;
    static List<Item> listOfItem = new ArrayList<>();

    public Person(String name, String lastName, String address, int birthdayYear, int birthdayMonth, int birthdayDay,
                  long pesel, Long id, boolean isAllowedToOpenAndPutOrTakeIntoSpace, int firstDayOfRent,
                  int firstMonthOfRent, int firstYearOfRent, List<TenantAlert> listOfTenantAlert, List<ConsumerWarehouse> listOfRentedArea, List<Item> listOfItem) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.birthdayYear = birthdayYear;
        this.birthdayMonth = birthdayMonth;
        this.birthdayDay = birthdayDay;
        this.birthday = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);
        this.firstDayOfRent = firstDayOfRent;
        this.firstMonthOfRent = firstMonthOfRent;
        this.firstYearOfRent = firstYearOfRent;
        dateOfFirstRentArea = LocalDate.of(firstYearOfRent, firstMonthOfRent, firstDayOfRent);
        this.pesel = pesel;
        this.id = id;
        this.isAllowedToOpenAndPutOrTakeIntoSpace = isAllowedToOpenAndPutOrTakeIntoSpace;
        this.listOfRentedArea = listOfRentedArea;
        this.listOfItem = listOfItem;

    }

    public List<ConsumerWarehouse> getListOfRentedArea() {
        return listOfRentedArea;
    }

    static void insertSampleOfData() {

        ArrayList<Item> listOfAddedItem = new ArrayList<>();
        ArrayList<Item> listOfAddedItem1 = new ArrayList<>();
        ArrayList<Item> listOfAddedItem2 = new ArrayList<>();
        ArrayList<Item> listOfAddedItem3 = new ArrayList<>();
        ArrayList<Item> listOfAddedItem4 = new ArrayList<>();

        ArrayList<ConsumerWarehouse> listOfRentedAreaForP1 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP2 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP3 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP4 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP5 = new ArrayList<ConsumerWarehouse>();

        listOfRentedAreaForP1.add(new ConsumerWarehouse(1, 2020, 3, 10, 10, ConsumerWarehouse.idCounter.getAndIncrement(),true));
        listOfRentedAreaForP2.add(new ConsumerWarehouse(10, 2021, 1, 9, 300, ConsumerWarehouse.idCounter.getAndIncrement(),true));
        listOfRentedAreaForP3.add(new ConsumerWarehouse(78, 2021, 1, 8, 250, ConsumerWarehouse.idCounter.getAndIncrement(),true));
        listOfRentedAreaForP4.add(new ConsumerWarehouse(43, 2021, 1, 15, 230, ConsumerWarehouse.idCounter.getAndIncrement(),true));
        listOfRentedAreaForP5.add(new ConsumerWarehouse(120, 2021, 1, 14, 600, ConsumerWarehouse.idCounter.getAndIncrement(),true));

        Person p1 = new Person("Jan", "Nowak", "ul.Miodowa 10, Szczecin", 1976, 10,
                5, 1761005111, personIdGenerator.getAndIncrement(), true, 10,
                1, 2021, null, listOfRentedAreaForP1,listOfAddedItem);
        Person p2 = new Person("Kasia", "Jasiak", "ul.Piosenkarzy 3, Płock", 1990, 4,
                10, 1990063025, personIdGenerator.getAndIncrement(), false, 15, 1,
                2021, null, listOfRentedAreaForP2,listOfAddedItem1);
        Person p3 = new Person("Kacper", "Kowalczyk", "ul.Tramwajów 51, Warszawa", 1963, 9,
                19, 1963091941, personIdGenerator.getAndIncrement(), true, 21,
                1, 2021, null, listOfRentedAreaForP3,listOfAddedItem2);
        Person p4 = new Person("Basia", "Nowa", "Starówka 5, Zakopane", 1999, 10,
                4, 1999100410, personIdGenerator.getAndIncrement(), false, 5, 1,
                2021, null, listOfRentedAreaForP4,listOfAddedItem3);
        Person p5 = new Person("Stanisław", "Wiatr", "Sloneczna 2, Poznań", 1997, 8,
                4, 1999800052, personIdGenerator.getAndIncrement(), false, 3,
                1, 2021, null, listOfRentedAreaForP5,listOfAddedItem4);
        listOfPersons.add(p1);
        listOfPersons.add(p2);
        listOfPersons.add(p2);
        listOfPersons.add(p3);
        listOfPersons.add(p4);
        listOfPersons.add(p5);
    }

    static List<Person> getAllListOfPersons() {
        return listOfPersons;
    }

   public static void setPermissionToOpenSpace(long idFromUser, boolean newPermission) {
        for (Person i : listOfPersons) {
            if (i.id == idFromUser) {
//               System.out.println(i.isAllowedToOpenAndPutOrTakeIntoSpace);
                i.isAllowedToOpenAndPutOrTakeIntoSpace = newPermission;
//               System.out.println(i.isAllowedToOpenAndPutOrTakeIntoSpace);
                System.out.println("Successfull permission changed");
            }
        }
    }

    public static Person getPersonById(String id) {
        for (Person p : listOfPersons) {
            Long idLong = Long.parseLong(id);
            if (p.id.equals(idLong)) {
                return p;
            }
        }
        return null;
    }

    public static void getDateOfFirstRentSpace(long id) {
        for (Person p : listOfPersons) {
            try {
                if (p.id == id && p.dateOfFirstRentArea == null) {
                    System.out.println("You didn't rent any Space");
                } else {
                    if (p.id == id) {
                        System.out.println(p.dateOfFirstRentArea);
                    }
                }
            } catch (Exception NeverRentException) {
                NeverRentException.printStackTrace();
            }

        }
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", birthdayYear=" + birthdayYear +
                ", birthdayMonth=" + birthdayMonth +
                ", birthdayDay=" + birthdayDay +
                ", dateOfFirstRentArea=" + dateOfFirstRentArea +
                ", pesel=" + pesel +
                ", id=" + id +
                ", firstDayOfRent=" + firstDayOfRent +
                ", firstMonthOfRent=" + firstMonthOfRent +
                ", firstYearOfRent=" + firstYearOfRent +
                ", isAllowedToOpenAndPutOrTakeIntoSpace=" + isAllowedToOpenAndPutOrTakeIntoSpace +
                '}';
    }
}


