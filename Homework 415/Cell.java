import java.util.*;
/**
 * Did a cell
 *
 * @Cameron Snyder
 * @415
 */
public class Cell{
    private boolean occupied;
    private int id;
    private List<Cell> neighbors;

    public Cell(){
        neighbors = new ArrayList<Cell>();
    }

    public void setOccupied(boolean yesNo){
        occupied = yesNo;
    }

    public boolean getOccupied(){
        return occupied;
    }

    public List<Cell> getNeighbors(){
        return neighbors;
    }
}
