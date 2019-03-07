
public class CodeWordChecker{
    private static int minLength;
    private static int maxLength;
    private static String notIn;
    
    public static void main(){
        System.out.println(isValid("Stroopwaffle"));
    }
    
    public CodeWordChecker(int minLength, int maxLength, String notIn){
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.notIn = notIn;
    }

    public CodeWordChecker(String notIn){
        this.minLength = 6;
        this.maxLength = 20;
        this.notIn = notIn;
    }

    public static boolean isValid(String str){
        return str.length() >= minLength && str.length() <= maxLength && str.indexOf(notIn) == -1;
    }
}
