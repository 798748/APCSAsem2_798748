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
        //makes the square
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
        //resets the square if it gets too crazy
        if (keyChar == 'r'){
            rectX = 0;
            rectY = 0;
        }
        //makes the square go in a random direction
        if (keyChar == 'q'){
            animationDeltaX = (int)(Math.random() * 3) - 1;
            animationDeltaY = (int)(Math.random() * 3) - 1;
        }
        //makes the square to stop
        if (keyChar == 's'){
            motionSpeed = 0;
        }
        //makes the square to speed up or reset if it's too fast
        if (keyChar == 'w'){
            if(motionSpeed == 1){
                motionSpeed = 25;  
            }else if(motionSpeed == 25){
                motionSpeed = 50;
            }else{
                motionSpeed = 1;
            }
        }
    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

    public void actionPerformed(ActionEvent e){
        //makes the square move around the edge of the box
        Dimension componentSizeDimension = getSize();
        /*if (rectY + height > getHeight()){
            rectY = getHeight() - height;
            animationDeltaX = -1;
            animationDeltaY = 0;
            rectX += animationDeltaY * motionSpeed;
        }else if (rectX + width > getWidth()){
            rectX = getWidth() - width;
            animationDeltaX = 0;
            animationDeltaY = 1;
            rectY += animationDeltaY * motionSpeed;
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
        }*/
        if (rectY + height > getHeight()){
            rectY = getHeight() - height;
            animationDeltaX = -1;
            animationDeltaY = 0;
            rectX += -animationDeltaY * motionSpeed;
        }else if (rectX + width > getWidth()){
            rectX = getWidth() - width;
            animationDeltaX = 0;
            animationDeltaY = 1;
            rectY += -animationDeltaY * motionSpeed;
        }else if (rectX < 0){
            rectX = 0;
            animationDeltaX = 0;
            animationDeltaY = -1;
            rectY += -animationDeltaY * motionSpeed;
        }else if (rectY < 0){
            rectY = 0;
            animationDeltaX = 1;
            animationDeltaY = 0;
            rectY += -animationDeltaY * motionSpeed;
        }else{
            rectX += animationDeltaX * motionSpeed;
            rectY += animationDeltaY * motionSpeed;
        }
        repaint();
    }

    public void paintComponent(Graphics g){
        //colors the square
        g.setColor(Color.green);
        g.fillRect(rectX, rectY, width, height);
    }

    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){
        //checks if the cursor is on the square
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        if (mouseFromX >= rectX && mouseFromX <= rectX+width && mouseFromY >= rectY && mouseFromY <= rectY+height){
            shapeSelected = true;
        }
    }

    public void mouseReleased(MouseEvent e){
        //lets the square stop being crazy
        motionSpeed = 1;
    }

    public void mouseEntered(MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mouseDragged(MouseEvent e){
        //lets the square go crazy if you hold it
        if (shapeSelected){
            motionSpeed ++;
        }
    }

    public void mouseMoved(MouseEvent e){

    }
}
