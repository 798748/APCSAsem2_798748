
/**
 * Write a description of class ClimbingClubClass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClimbingClubClass
{
    public void addClimb(String peakName, int climbTime){ 
        this.climbList.add(new ClimbInfo(peakName, climbTime));
    } 

    public void addClimb(String peakName, int climbTime){ 
        for (int i = 0; i < this.climbList.size(); i++){ 
            if (peakName.compareTo(this.climbList.get(i).getName()) <= 0){ 
                this.climbList.add(i, new ClimbInfo(peakName, climbTime)); return;
            }
        } 
        this.climbList.add(new ClimbInfo(peakName, climbTime));
    }
    
    //i. No
    //ii. Yes
}
