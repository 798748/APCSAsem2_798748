
/**
 * Did a grid test
 *
 * @Cameron Snyder
 * @415
 */
public class GridTester{
    private Cell[][] cellGrid;

    public GridTester(int rows, int columns){
        cellGrid = new Cell[rows][columns];
        for(int r = 0; r < cellGrid.length; r++){
            for(int c = 0; c < cellGrid[r].length; c++){
                cellGrid[r][c] = new Cell();
            }
        }
    }

    public void loadOccupied(){
        for(int i = 0; i < cellGrid.length; i++){
            for(int j = 0; j < cellGrid[i].length; j++){
                if((int)(Math.random() * 10) > 6){
                    cellGrid[i][j].setOccupied(true);
                }else{
                    cellGrid[i][j].setOccupied(false);
                }
            }
        }
    }

    public void loadNeigbors(){
        for(int i = 0; i < cellGrid.length; i++){
            for(int j = 0; j < cellGrid[i].length; j++){
                if (i < cellGrid.length - 1 && !cellGrid[i + 1][j].getOccupied()){
                    cellGrid[i][j].getNeighbors().add(cellGrid[i + 1][j]);
                }
                if (i > 0 && !cellGrid[i - 1][j].getOccupied()){
                    cellGrid[i][j].getNeighbors().add(cellGrid[i - 1][j]);
                }
                if (j < cellGrid[i].length - 1 && !cellGrid[i][j + 1].getOccupied()){
                    cellGrid[i][j].getNeighbors().add(cellGrid[i][j + 1]);
                }
                if (j > 0 && !cellGrid[i][j - 1].getOccupied()){
                    cellGrid[i][j].getNeighbors().add(cellGrid[i][j - 1]);
                }
            }
        }
    }
}
