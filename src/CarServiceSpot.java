import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CarServiceSpot {
    double width;
    double length;
    double height;
    double price;
    long id;
    int randomTimeRepair;
    boolean isRented;
    public static final AtomicLong idCounter = new AtomicLong();
    static List<CarServiceSpot> listOfAllCarServiceSpots;
    static List<Person> listForWaitingForCarServiceSpot;
    public CarServiceSpot(double width, double length, double height, double price,long id,int randomTimeRepair,boolean isRented) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.price = price;
        this.id = id;
        listOfAllCarServiceSpots = new ArrayList<>();
        this.randomTimeRepair =randomTimeRepair;
        this.isRented = isRented;
    }

    static void sampleCarServiceSpots(){
        CarServiceSpot css = new CarServiceSpot(2,2,2,50,idCounter.getAndIncrement(), (int) Math.floor(Math.random()*4)+1,false);
        CarServiceSpot css1 = new CarServiceSpot(1,5,4,150,idCounter.getAndIncrement(),(int) Math.floor(Math.random()*4)+1,false);
        CarServiceSpot css2 = new CarServiceSpot(3,3,6,250,idCounter.getAndIncrement(),(int) Math.floor(Math.random()*4)+1,false);
        CarServiceSpot css3 = new CarServiceSpot(3,5,7,150,idCounter.getAndIncrement(),(int) Math.floor(Math.random()*4)+1,false);
        listOfAllCarServiceSpots.add(css);
        listOfAllCarServiceSpots.add(css1);
        listOfAllCarServiceSpots.add(css2);
        listOfAllCarServiceSpots.add(css3);
    }

     public static List<CarServiceSpot> getAllOfCarServiceSpot(){
        return listOfAllCarServiceSpots;
     }

     static void addClientToWaitingList(){
        for(int i=0;i<listOfAllCarServiceSpots.size();i++){
            if(listOfAllCarServiceSpots.get(i).isRented){
                listForWaitingForCarServiceSpot.add(Main.choosenPerson);

            }

        }
     }

     static void rentCarServiceSpot(){

     }

    @Override
    public String toString() {
        return "CarServiceSpot{" +
                "width=" + width +
                ", length=" + length +
                ", height=" + height +
                ", price=" + price +
                ", id=" + id +
                ", randomTimeRepair=" + randomTimeRepair +
                ", isRented=" + isRented +
                '}';
    }
}
