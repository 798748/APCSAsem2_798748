import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * MySwingApplication
 *
 * @author Cameron Snyder
 * @version February 11
 */
public class CanvasComponent extends JComponent implements MouseListener, MouseMotionListener, ActionListener, KeyListener{
    public int width;
    public int height;
    int mouseFromX;
    int mouseFromY;
    int rectX = 0;
    int rectY = 0;
    boolean shapeSelected;
    int animationDeltaX = 1;
    int animationDeltaY = 0;
    Timer animationTimer;
    int motionSpeed = 1;

    public CanvasComponent(int w, int h){
        setSize(w, h);
        width = w;
        height = h;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        animationTimer = new Timer(20, this);
        animationTimer.start();
    }

    public void keyTyped(KeyEvent e){
        char keyChar = e.getKeyChar();
        if (keyChar == 'r'){
            rectX = 0;
            rectY = 0;
        }
        if (keyChar == 'q'){
            animationDeltaX = (int)(Math.random() * 3) - 1;
            animationDeltaY = (int)(Math.random() * 3) - 1;
        }
    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

    public void actionPerformed(ActionEvent e){
        Dimension componentSizeDimension = getSize();
        if (rectX + width > getWidth()){
            rectX = getWidth() - width;
            animationDeltaX = 0;
            animationDeltaY = 1;
            rectY += animationDeltaY * motionSpeed;
        }else if (rectY + height > getHeight()){
            rectY = getHeight() - height;
            animationDeltaX = -1;
            animationDeltaY = 0;
            rectX += animationDeltaY * motionSpeed;
        }else if (rectX < 0){
            rectX = 0;
            animationDeltaX = 0;
            animationDeltaY = -1;
            rectY += animationDeltaY * motionSpeed;
        }else if (rectY < 0){
            rectY = 0;
            animationDeltaX = 1;
            animationDeltaY = 0;
            rectY += animationDeltaY * motionSpeed;
        }else{
            rectX += animationDeltaX * motionSpeed;
            rectY += animationDeltaY * motionSpeed;
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.green);
        g.fillRect(rectX, rectY, width, height);
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        if (mouseFromX >= rectX && mouseFromX <= rectX+width && mouseFromY >= rectY && mouseFromY <= rectY+height){
            shapeSelected = true;
        }
    }

    public void mouseReleased(MouseEvent e){
        motionSpeed = 1;
    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mouseDragged(MouseEvent e){
        if(shapeSelected){
            motionSpeed ++;
        }
    }

    public void mouseMoved(MouseEvent e){

    }
}
