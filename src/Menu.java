import java.awt.*;
import java.util.Scanner;

public class Menu {
  private static  Scanner sc = new Scanner(System.in);

    public static void mainMenu(){
        System.out.println("(1)Wybierz Którą jesteś osobą wpisując Id klienta od 1 do 3");
        System.out.println("(2)Wypisz swoje dane łącznie z wynajętymi pomieszczeniami");
        System.out.println("(3)Wyświetl wolne pomieszczenia");
        System.out.println("(4)Wynajmij wolne pomieszczenie");
        System.out.println("(5)WWybierz pomieszczenie, które wynajmuje dana osoba oraz wyświetl zawartość pomieszczenia");
        System.out.println("(6)Zaparkuj/włóż nowych przedmiot/pojazd");
        System.out.println("(7)Wyjmij przedmiot lub pojazd");
        System.out.println("(8)Rozpocznij zgłoszenie serwisowe w wybranym trybie");
        System.out.println("(9)Rozpoczecie naprawy");
        System.out.println("(10)Zapisz aktualny stan do pliku");
        System.out.println("(11)Zamknij aplikacje");
    }

    
    public static void exitApp(Scanner sc){
       String exit = sc.next();
       if(exit.equals("yes")){
           System.exit(0);
       }
       else{
           Menu.mainMenu();
       }
    }


    public static  void generateMenu(){
        chooseUser(Menu.sc);
//        getUserData();
//        showFreeAreas();
    }


   public static void chooseUser(Scanner sc){
       System.out.println("wybierz usera");
       System.out.println("1. Tomek");
       System.out.println("2. adam");
       System.out.println("3. Stach");
       System.out.println("z. Powrót do menu");
       String str = sc.next();
       switch(str){
           case "1":{
               System.out.println("wybrano 1");
               generateMenu();
           }
           case "2":{

           }
           case "3":{

           }
           case "z":{
                generateMenu();
           }

       }
    }
































//    public void menu() {
//        System.out.println("Welcome in Johny's Garage ! ");
//        System.out.println("Please, choose an option");
//        System.out.println("Who you are?");
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        do {
//            switch (i) {
//                case 1: {
//                    System.out.println("wybrano 1");
//                    Person.insertSampleOfData();
//                    System.out.println(Person.getAllListOfPersons());
//                    Person.setPermissionToOpenSpace(1,true);
//                    System.out.println(Person.getAllListOfPersons());
//                    break;
//                }
//                case 2: {
//                    System.out.println("wybrano 2");
//                    break;
//
//                }
//                case 3: {
//                    System.out.println("wybrano 3");
//                    break;
//                }
//                case 4: {
//                    System.out.println("wybrano 4");
//                    break;
//                }
//                case 5: {
//                    System.out.println("wybrano 5");
//                    break;
//                }
//
//
//            }
//        }while(i ==0);
//
//    }

    }
