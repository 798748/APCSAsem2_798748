import javax.swing.*;
/**
 * MySwingApplication
 *
 * @author Cameron Snyder
 * @version February 11
 */
public class MySwingApplication implements Runnable{
    JFrame jFrame;
    CanvasComponent canvasComponent;

    public void run(){
        jFrame = new JFrame("Window");
        jFrame.setSize(800, 400);
        for(int i = 2; i > 0; i--){
            canvasComponent = new CanvasComponent(100, 100);
        }
        jFrame.add(canvasComponent);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.addKeyListener(canvasComponent);
    }

    public static void main(){
        MySwingApplication mySwingApplicationSwing = new MySwingApplication();
        javax.swing.SwingUtilities.invokeLater(mySwingApplicationSwing);
    }
}
