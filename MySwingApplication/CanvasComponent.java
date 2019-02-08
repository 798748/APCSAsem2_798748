import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * MySwingApplication
 *
 * @author Cameron Snyder
 * @version February 4
 */
public class CanvasComponent extends JComponent implements MouseListener, MouseMotionListener
{
    public int width;
    public int height;
    int mouseFromX;
    int mouseFromY;
    int rectX = 0;
    int rectY = 0;
    boolean shapeSelected;

    /**
     * Constructor for objects of class CanvasComponent
     */
    public CanvasComponent(int w, int h)
    {
        setSize(w, h);
        width = w;
        height = h;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(rectX, rectY, width, height);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mouseClicked(MouseEvent e)
    {
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mousePressed(MouseEvent e)
    {
        mouseFromX = e.getX();
        mouseFromY = e.getY();
        if (mouseFromX >= rectX && mouseFromX <= rectX+width && mouseFromY >= rectY && mouseFromY <= rectY+height){
            shapeSelected = true;
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mouseReleased(MouseEvent e)
    {
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mouseExited(MouseEvent e)
    {
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mouseDragged(MouseEvent e)
    {
        if (shapeSelected){
            int mouseToX = e.getX();
            int mouseToY = e.getY();
            rectX = mouseToX-mouseFromX;
            rectY = mouseToY-mouseFromY;
            repaint();
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     */
    public void mouseMoved(MouseEvent e)
    {
        
    }
}
