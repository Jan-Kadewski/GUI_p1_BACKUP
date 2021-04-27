import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
    double totalCostForRents;
    static final AtomicLong personIdGenerator = new AtomicLong();
    static List<Person> listOfPersons = new ArrayList<>();
    List<TenantAlert> listOfTenantAlert = new ArrayList<>();
    List<ConsumerWarehouse> listOfRentedArea;
    static List<ParkingSpace> listOfParkingForPerson;
    public  static List<Item> listOfItem;

    public Person(String name, String lastName, String address, int birthdayYear, int birthdayMonth, int birthdayDay,
                  long pesel, Long id, boolean isAllowedToOpenAndPutOrTakeIntoSpace, int firstDayOfRent,
                  int firstMonthOfRent, int firstYearOfRent, List<TenantAlert> listOfTenantAlert, List<ConsumerWarehouse> listOfRentedArea, List<Item> listOfItem, List<ParkingSpace> listOfParkingForPersons) {
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
        Person.listOfItem = new ArrayList<>();
        this.isAllowedToOpenAndPutOrTakeIntoSpace = isAllowedToOpenAndPutOrTakeIntoSpace;
        this.listOfRentedArea = listOfRentedArea;
        this.listOfParkingForPerson = listOfParkingForPersons;
    }

    public List<ConsumerWarehouse> getListOfRentedArea() {
        return listOfRentedArea;
    }

    static void insertSampleOfData() {

        ArrayList<ConsumerWarehouse> listOfRentedAreaForP1 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP2 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP3 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP4 = new ArrayList<ConsumerWarehouse>();
        ArrayList<ConsumerWarehouse> listOfRentedAreaForP5 = new ArrayList<ConsumerWarehouse>();

        listOfRentedAreaForP1.add(new ConsumerWarehouse(25, 2020, 3, 10, 2021, 1, 15, 200, ConsumerWarehouse.idCounter.getAndIncrement(), true));
        listOfRentedAreaForP2.add(new ConsumerWarehouse(10, 2021, 1, 9, 2021, 1, 15, 300, ConsumerWarehouse.idCounter.getAndIncrement(), true));
        listOfRentedAreaForP3.add(new ConsumerWarehouse(78, 2021, 1, 8, 2021, 1, 25, 250, ConsumerWarehouse.idCounter.getAndIncrement(), true));
        listOfRentedAreaForP4.add(new ConsumerWarehouse(43, 2021, 1, 15, 2021, 1, 30, 230, ConsumerWarehouse.idCounter.getAndIncrement(), true));
        listOfRentedAreaForP5.add(new ConsumerWarehouse(120, 2021, 1, 14, 2021, 1, 29, 600, ConsumerWarehouse.idCounter.getAndIncrement(), true));

        Person p1 = new Person("Jan", "Nowak", "ul.Miodowa 10, Szczecin", 1976, 10,
                5, 1761005111, personIdGenerator.getAndIncrement(), true, 10,
                1, 2021, null, listOfRentedAreaForP1,listOfItem, listOfParkingForPerson);
        Person p2 = new Person("Kasia", "Jasiak", "ul.Piosenkarzy 3, Płock", 1990, 4,
                10, 1990063025, personIdGenerator.getAndIncrement(), true, 15, 1,
                2021, null, listOfRentedAreaForP2, listOfItem, listOfParkingForPerson);
        Person p3 = new Person("Kacper", "Kowalczyk", "ul.Tramwajów 51, Warszawa", 1963, 9,
                19, 1963091941, personIdGenerator.getAndIncrement(), true, 21,
                1, 2021, null, listOfRentedAreaForP3, listOfItem, listOfParkingForPerson);
        Person p4 = new Person("Basia", "Nowa", "Starówka 5, Zakopane", 1999, 10,
                4, 1999100410, personIdGenerator.getAndIncrement(), true, 5, 1,
                2021, null, listOfRentedAreaForP4, listOfItem, listOfParkingForPerson);
        Person p5 = new Person("Stanisław", "Wiatr", "Sloneczna 2, Poznań", 1997, 8,
                4, 1999800052, personIdGenerator.getAndIncrement(), false, 3,
                1, 2021, null, listOfRentedAreaForP5, listOfItem, listOfParkingForPerson);
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

    public static void payForRent(Scanner sc) {
        if(Main.choosenPerson.listOfTenantAlert.size() ==0){
            System.out.println("Brak zadłużonych pomieszczeń");
        }
        else {
            System.out.println("Lista zadłużonych mieszkań");
            for (int i = 0; i < Main.choosenPerson.listOfTenantAlert.size(); i++)
                System.out.println(Main.choosenPerson.listOfTenantAlert.get(i));
            System.out.println("Podaj ID za które pomieszczenie chcesz zapłacić");
            int idFromUser = sc.nextInt();
            try {
                Main.choosenPerson.listOfTenantAlert.remove(idFromUser);
                System.out.println("Zapłata przebiegła pomyślnie");
                SubMenu.actionsOfWarehouse();
            } catch (Exception e) {
                System.out.println("Wybrano złe ID. Powrót do menu głównego");
                SubMenu.actionsOfWarehouse();
            }
        }
    }

    public static void setPermissionToOpenSpace(Scanner sc) {
        System.out.println("podaj ID użytkownika");
        Long idFromUser = sc.nextLong();
        System.out.println("Podaj nowe prawa wpisując \" true \" lub \" false\"");
        boolean newPermission = sc.nextBoolean();
        for (Person i : listOfPersons) {
            if (i.id.equals(idFromUser)) {
                i.isAllowedToOpenAndPutOrTakeIntoSpace = newPermission;
                System.out.println("Zmiana uprawnień powiodła się");
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

    public static void getDateOfFirstRentSpace() {

        try {
            if (Main.choosenPerson.dateOfFirstRentArea == null) {
                System.out.println("Nigdy nie wynajmowałeś mieszkania");
            }
        } catch (Exception NeverRentException) {
            NeverRentException.printStackTrace();


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


