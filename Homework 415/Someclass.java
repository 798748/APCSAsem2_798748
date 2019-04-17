import java.util.*;
/**
 * I bubble sorted this thing
 *
 * @Cameron Snyder
 * @415
 */
public class Someclass{
    public ArrayList<String> stringList;

    public Someclass(){
        stringList = new ArrayList<String>();
    }

    public void sortStrings(ArrayList<String> names){
        String temp = "";
        for(int i = 0; i < names.size() - 1; i++){
            for(int j = 0; j < names.size() - i - 1; j++){
                if(names.get(j).compareTo(names.get(j + 1)) <= 0){
                    temp = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp);
                }
            }
        }
    }

    public void shuffleStrings(ArrayList<String> names){
        for(int i = names.size() - 1; i > 0; i--) {
            int total = i + 1;
            int start = 0;
            int rando = (int) (Math.random() * total) + start;
            String temp = names.get(i);
            names.set(i, names.get(rando));
            names.set(rando, temp);
        }
    }

    public void insertString(String word){
        for (int i = 0; i < stringList.size() - 1; i++){
            if (word.compareTo(stringList.get(i)) <= 0){
                stringList.add(i, word);
                return;
            }
        }
        stringList.add(word);
    }
}
