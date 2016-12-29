import java.util.*;

/**
 *
 * @author Brian
 */
public class SwitchAndTernaryOperators {
    //ADVANCED SESSION!
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("THE SWITCH:");
        System.out.println("Pick a number [1-10]:");
        int favoriteNumber = input.nextInt();
        input.nextLine();
        String caseSelected = "";
        //perform different actions 
        switch(favoriteNumber)
        {
            case 1:
                caseSelected = "ONE";
                break;
            case 2:
                caseSelected = "TWO";
                break;
            case 3:
                caseSelected = "THREE";
                break;
            case 4:
            case 5:
            case 6: 
                caseSelected = "FOUR, FIVE, or SIX";
                break;
            case 7:
            case 8:
                caseSelected = "SEVEN or EIGHT";
                break;
            case 9:
                caseSelected = "NINE";
                break;
            default:
                caseSelected = "OTHER";
                break;
        }
        
        System.out.printf("You selected: %s\n", caseSelected);
        
        System.out.println("Ternary Operations");
        //ternary operations allow you to easily do true and false
        //variable sets on one line of code
        
        boolean isMale;
        System.out.println("Are you Male or Female [m/f]?");
        String gender = input.nextLine();
        isMale = gender.toUpperCase().contains("M") ? true : false;
        /* same as:
         * if (gender.toUpperCase().contains("M"))
         * {
         *     isMale = true;
         * }
         * else
         * {
         *     isMale = false;
         * }
         */
        String genderOutput = isMale ? "Male" : "Female";
        /* same as
         * String genderOutput = "";
         * if (isMale)
         * {
         *     genderOutput = "Male";
         * }
         * else
         * {
         *     genderOutput = "Female";
         * }
         */
        System.out.printf("Your selected gender is: %s\n", genderOutput);
    }
}
