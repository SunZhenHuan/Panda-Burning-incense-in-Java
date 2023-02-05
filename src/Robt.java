import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author "机器人类"
 */
public class Robt extends Robot {
    public Robt(KeyEvent e) throws AWTException {
        System.err.println("执行了一个按键"+e.getKeyChar());
        delay(1);
        keyPress(KeyEvent.VK_WINDOWS);
        keyPress(KeyEvent.VK_D);
        keyRelease(KeyEvent.VK_WINDOWS);
        keyRelease(KeyEvent.VK_D);
        System.err.println("释放成功！");
    }
}
