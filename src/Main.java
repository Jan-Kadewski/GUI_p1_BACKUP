import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsumerWarehouse.insertSampleOfConsumerWarehouse();
        Person.insertConsumerHouse();




//
//        Item item1 = new Item("item1",10,p);
//        Item item2 = new Item("item2",17,p);
//
//        cw.addItem(item1);
//        cw.addItem(item2);

//        Person.insertSampleOfData();
//        ConsumerWarehouse.insertSampleOfConsumerWarehouse();
//        System.out.println(Person.listOfPersons);
        Menu.mainMenu();

        Scanner sc = new Scanner(System.in);
        int mainMenuChoose = sc.nextInt();
        Person choosenPerson = null;

        switch (mainMenuChoose) {
            case 1: {
                Person.insertSampleOfData();
                System.out.println("Wybierz numer klienta");
                System.out.println( Person.getAllListOfPersons());
                int setPerson =sc.nextInt();
                choosenPerson =  Person.listOfPersons.get(setPerson);
                System.out.println(choosenPerson);
                Menu.mainMenu();
                break;
            }
            case 2: {
                if(choosenPerson == null){
                    System.out.println("Firstly set the person who you are");
                }
                else{
                System.out.println("2");
                }
                break;
            }
            case 3: {
                System.out.println("3");
                break;
            }
            case 4: {
                System.out.println("4");
                break;
            }
            case 5: {
                System.out.println("5");
                break;
            }
            case 6: {
                System.out.println("6");
                break;
            }
            case 7: {
                System.out.println("7");
                break;
            }
            case 8: {
                System.out.println("8");
                break;
            }
            case 9: {
                System.out.println("9");
                break;
            }
            case 10: {
                System.out.println("10");
                break;
            }
            case 11: {
                System.out.println("Do you want to exit app? Tap  \"yes\"  to continue");
                Menu.exitApp(sc);
            }
        }


    }
}
