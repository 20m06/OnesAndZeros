/**
 * This class asks you for an array of only 1s and 0s.
 * After this it return the min number of adjacent swaps required to have all 0s on one side.
 * 
 * @author Mykhailo Kosenko
 * @version 12/01/2022
 */
import java.util.*;

public class OnesAndZeros{
    private static int swaps = 0;//count adjacent swaps in array
    public static void main(String[] args){
        Scanner kboard = new Scanner(System.in);
        System.out.println("Enter your array of ones and zeros: ");
        String input = kboard.nextLine();
        String numbers = "";//empty string for next loop
        for(int i = 0;i < input.length();i++){
            char ch = input.charAt(i);
            if(ch == '0' || ch == '1'){//add 1 or 0 to the string, and ignore other characters
                numbers += ch;
            }
        }
        System.out.println("Your array is: " + numbers);//display an array of the user after "filter"
        Integer nums[] = new Integer[numbers.length()];
        for(int i = 0;i < numbers.length();i++){//transform the string of 0s and 1s to an array
            char ch = numbers.charAt(i);
            int a = Character.getNumericValue(ch);
            nums[i] = a;
        }
        //The most important loop, moves all zeros to the beggining
        // and count amount of adjacent swaps requires for it
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == 1){
                int k = swaps;//memorize amount of swaps in case if work done, but loop continues execution
                int a = i;//memorize position of an one
                while(nums[i] != 0 && i < nums.length - 1){
                    i++;//serching position of a next zero
                    swaps++;//count amount of adjacent swaps that will needed
                }
                if(nums[i] != 1){
                    int b = nums[i];//memorize the zero
                    int c = nums[a];//memorize the one
                    nums[a] = b;//assign former place of the one to the zero
                    nums[i] = c;//assign former place of the zero to the one
                    i = a;//go back
                }
                if(nums[i] == 1){
                    swaps = k;//returns amount of swaps in the start of the execution if work already done
                }
            }
        }
        System.out.println("Your array after execution: " + Arrays.toString(nums));
        System.out.println("It took " + swaps + " adjacent swaps to have all 0s on one side");
        kboard.close();
    }
}