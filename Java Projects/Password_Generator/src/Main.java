import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("How many random passwords do you want generated ");
        int n= scanner.nextInt();
        System.out.print("How many character long do you want your random password to be? ");
        int length= scanner.nextInt();
        String [] randomPasswords=new String[n];
        for (int i = 0; i <n ; i++) {
            String randomPassword="";
            for (int j = 0; j <length ; j++) {
                randomPassword+=randomCharacter();
            }
            randomPasswords[i]=randomPassword;
        }
        printPasswords(randomPasswords);
        System.out.println(getPasswordStrength(length));
    }
    //using number from ASCII
    //62, because 10 numbers(0-9) + 26(A-Z) +26(A-Z)=62
    public static char randomCharacter(){
        int rand= (int) (Math.random()*62);

        if(rand<=9){
            rand+=48;
            return (char) rand;
        }
        else if (rand<=35){
            rand+=55;
            return (char) rand;
        }
        else{
            rand+=61;
        return (char) rand;
        }
    }
    public static void printPasswords(String [] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]);
        }
    }
    public static String getPasswordStrength(int length){
        if(length<5){
            return "weak";
        } else if (length<10) {
            return "medium";
        }
        return "strong";
    }
}