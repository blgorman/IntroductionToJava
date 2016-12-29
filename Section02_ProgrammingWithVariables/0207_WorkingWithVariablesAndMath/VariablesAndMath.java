import java.util.*;

public class VariablesAndMath {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        double n1;
        double n2;
        
        System.out.println("Please enter a number: ");
        n1 = input.nextDouble();
        
        System.out.println("Please enter a number: ");
        n2 = input.nextDouble();
        
        double addResult;
        double subResult;
        double multResult;
        double divResult;
        
        addResult = n1 + n2;
        subResult = n1 - n2;
        multResult = n1 * n2;
        divResult = n1 / n2;
        
        //add
        System.out.printf("The result of adding %f to %f is %f\n"
                            , n1
                            , n2
                            , addResult);
        
        //sub
        System.out.printf("The result of subtracting %f from %f is %f\n"
                            , n2
                            , n1
                            , subResult);
        
        //mult
        System.out.printf("The result of multiplying %f and %f is %f\n"
                            , n1
                            , n2
                            , multResult);
        
        //div
        System.out.printf("The result of dividing %f by %f is %f\n"
                            , n1
                            , n2
                            , divResult);
        
        input.close();
    }
}