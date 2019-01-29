
/**
 * Write a description of class Character here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Character{
    public String catchphrase = "";
    public int speed = 0;
    
    /**
     * Constructor for objects of class Character
     */
    public Character(String catchphrase, int speed){
        catchphrase = getCatchphrase();
        speed = getSpeed();
    }
    
    public void setCatchphrase(){
        
    }
    
    public String getCatchphrase(){
        return catchphrase;
    }
    
    public void setSpeed(){
        
    }
    
    public int getSpeed(){
        return speed;
    }
}
