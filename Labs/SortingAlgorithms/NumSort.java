import java.util.*;
public class NumSort{
    static int num = 100;
    static int[] inArray = new int[num];
    static long startTime = 0;
    static long newTime = 0;
    static ArrayList <Integer> numList = new ArrayList <Integer>();
    static long swapCount = 0;
    static long compCount = 0;

    public static void main(){
        initialize();
        numFill();
        startTime = System.currentTimeMillis();
        insertSort(inArray);
        findTime();
        System.out.println("Swaps: " + swapCount);
        System.out.println("Compares: " + compCount);
    }

    public static void initialize(){
        swapCount = 0;
        compCount = 0;
    }

    public static void findTime(){
        newTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time in Milliseconds: " + (newTime - startTime));
    }

    public static int[] numFill(){
        for(int i = 0; i < num; i++){
            inArray[i] = (int)(Math.random() * num) + 1;
        }
        return inArray;
    }

    public static void listFill(){
        for(int i = 0; i < num; i++){
            numList.add((int)(Math.random() * num) + 1);
        }
    }

    public static int[] mySort(int[] inArray){
        int cur = 0;
        int curIndex = 0;
        int[] newArray = new int[num];
        for(int i = 0; i < inArray.length; i++){
            newArray[i] = 0;
        }
        for(int j = 0; j < inArray.length; j++){
            for(int i = 0; i < inArray.length; i++){
                cur = inArray[curIndex];
                if(inArray[curIndex] > inArray[i]){
                    curIndex = i;
                    cur = inArray[i];
                }
            }
            inArray[curIndex] = 2147483647;
            newArray[j] = cur;
        }
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
        return newArray;
    }

    public static int[] selectSort(int[] inArray){
        int cur = 0;
        int curIndex = 0;
        int[] newArray = new int[num];
        for(int i = 0; i < inArray.length; i++){
            newArray[i] = 0;
        }
        for(int j = 0; j < inArray.length; j++){
            for(int i = 0; i < inArray.length; i++){
                cur = inArray[curIndex];
                if(inArray[curIndex] > inArray[i]){
                    curIndex = i;
                    cur = inArray[i];
                }
            }
            inArray[curIndex] = 2147483647;
            newArray[j] = cur;
        }
        for(int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i] + " ");
        }
        return newArray;
    }

    public static int[] bubbleSort(int[] inArray){
        int temp = 0;
        for(int j = 0; j < inArray.length; j++){
            for(int i = 0; i < inArray.length - 1; i++){
                if(inArray[i] > inArray[i + 1]){
                    temp = inArray[i + 1];
                    inArray[i + 1] = inArray[i];
                    inArray[i] = temp;
                    swapCount += 1;
                }
                compCount += 1;
            }
        }
        for(int i = 0; i < inArray.length; i++){
            System.out.print(inArray[i] + " ");
        }
        return inArray;
    }
    
    public static int[] insertSort(int[] inArray){
        int temp = 0;
        int hold = 0;
        for(int j = 0; j < inArray.length; j++){
            for(int i = inArray.length - 1; i > 0; i--){
                if(inArray[i] < inArray[i - 1]){
                    hold = inArray[i];
                    while(inArray[hold] > inArray[hold - 1]){
                        temp = inArray[i - 1];
                        inArray[i - 1] = inArray[i];
                        inArray[i] = temp;
                        swapCount += 1;
                        hold -= 1;
                    }
                }
                compCount += 1;
            }
        }
        for(int i = 0; i < inArray.length; i++){
            System.out.print(inArray[i] + " ");
        }
        return inArray;
    }

    public static void bubbleList(ArrayList<Integer> sortList){
        int temp = 0;
        for(int j = 0; j < sortList.size(); j++){
            for(int i = 0; i < sortList.size() - 1; i++){
                if(sortList.get(i) > sortList.get(i + 1)){
                    temp = sortList.get(i + 1);
                    sortList.set(i + 1, sortList.get(i));
                    sortList.set(i, temp);
                    swapCount += 1;
                }
                compCount += 1;
            }
        }
        for(int i = 0; i < inArray.length; i++){
            System.out.print(sortList.get(i) + " ");
        }
    }
}
