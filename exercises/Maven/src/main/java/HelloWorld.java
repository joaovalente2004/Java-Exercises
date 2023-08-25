import java.net.SecureCacheResponse;
import java.util.Scanner;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;


public class HelloWorld {

    public static <GUIScreen> void main(String[] args) {

        Object TerminalFacade = null;
        GUIScreen gui = TerminalFacade.createGUIScreen();

        Scanner sc = new Scanner(System.in);


        System.out.println("Digit first number: ");
        int n1 = sc.nextInt();

        System.out.println("Digit second number: ");
        int n2 = sc.nextInt();

        System.out.println("Sum: " + (n1 + n2));
    }
}
