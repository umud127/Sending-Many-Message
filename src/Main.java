import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException{
        //creating scanner object
        Scanner sc = new Scanner(System.in);

        //entering text you want to send
        System.out.println("Enter Your Text:  ");
        String text = sc.nextLine();

        //how many message you want send
        System.out.println("How Many Times Do You Want To Send:  ");
        int count = sc.nextInt();

        //scanner must be close
        sc.close();

        //select text for sharing in somewhere you want to use
        StringSelection selector = new StringSelection(text);

        //add text you want to clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selector,null);

        //time for changin application to program you want to write
        Thread.sleep(3000);

        //robot presses ctrl + V for pasting copied message and enters for sending
        Robot robot = new Robot();

        for(int i = 0;i < count;i++){
            //press button
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            //release 'em
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            //send with enter button
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            //wait for sending message
            Thread.sleep(1500);
        }
    }
}