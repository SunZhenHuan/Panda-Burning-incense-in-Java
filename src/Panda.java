import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Panda extends JFrame {
    Dimension tool=Toolkit.getDefaultToolkit().getScreenSize();
    final int width = tool.getSize().width;
    final int height = tool.getSize().height;
    int x,y;
    int wid;//100+249
    int hei;//100+249
    int wid1;//300-400
    int hei1;//300-400
    int rand;
    Image[]images=new Image[]{
            Toolkit.getDefaultToolkit().createImage("images//dange.gif"),
            Toolkit.getDefaultToolkit().createImage("images//duoge.gif"),

    };
    final JPanel content= new JPanel();//主题
    public Panda(int ThreadCount)
    {
        setSize(width,height);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(new Color(0,0,0,0));
        setAlwaysOnTop(true);
        setResizable(false);

        //主体
        content.setSize(getSize());
        content.setBorder(BorderFactory.createLineBorder(Color.red));
        content.setLocation(0,0);
        content.setBackground(new Color(0,0,0,0));
        for (int i=0;i<ThreadCount;i++)
        {
            Thread thread=new Thread(()->{
               while (true)
               {
                   JLabel icon=new JLabel();
                   wid=new Random().nextInt(50)+100;//100+249
                   hei=new Random().nextInt(20)+100;
                   wid1=new Random().nextInt(100)+300;
                   hei1=new Random().nextInt(200)+100;
                   x=new Random().nextInt(width);
                   y=new Random().nextInt(height);
                   if (rand%2==0)
                        icon.setIcon(new ImageIcon(images[0].getScaledInstance(wid,hei,0)));
                   else
                       icon.setIcon(new ImageIcon(images[1].getScaledInstance(wid1,hei1,0)));
                   icon.setSize(icon.getIcon().getIconWidth(),icon.getIcon().getIconHeight());
                   icon.setLocation(x,y);
                   content.add(icon);
                   try {
                       Thread.sleep(10);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            });
            thread.start();
        }
        add(content);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.err.println(e.getX()+"\t"+e.getY());
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //每次按下任意一个键都会触发机器人类
                try {
                    new Robt(e);
                } catch (AWTException awtException) {
                    awtException.printStackTrace();
                }
            }
        });
        setVisible(true);
    }
}
