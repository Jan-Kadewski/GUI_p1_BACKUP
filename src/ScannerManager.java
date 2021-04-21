import java.util.Scanner;

public class ScannerManager {

    private static Scanner sc = null;

    public static Scanner getScanner(){
        if(sc == null){
            sc = new Scanner(System.in);
        }
        return sc;
    }
}
