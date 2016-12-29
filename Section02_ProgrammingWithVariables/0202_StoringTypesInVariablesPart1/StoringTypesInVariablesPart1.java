/**
 * Storing Types in Variables Part 1.
 * @author Brian
 */
public class StoringTypesInVariablesPart1 
{
    public static void main(String[] args)
    {
        System.out.println("Types in Variables:");
        System.out.println("****************************");
        System.out.println("Integers");
        
        int index = 32;
        System.out.printf("Index = %d\n", index);
        index = 10;
        System.out.printf("Index = %d\n", index);
        
        index = index + 1;
        System.out.printf("Index = %d\n", index);
        index++;
        System.out.printf("Index = %d\n", index);
        index+=1;
        System.out.printf("Index = %d\n", index);
        index+=30;
        System.out.printf("Index = %d\n", index);
        
        index = index - 1;
        System.out.printf("Index = %d\n", index);
        index--;
        System.out.printf("Index = %d\n", index);
        index-=1;
        System.out.printf("Index = %d\n", index);
        index-=30;
        System.out.printf("Index = %d\n", index);
        
        index*=3;
        System.out.printf("Index = %d\n", index);
        index/=3;
        System.out.printf("Index = %d\n", index);
        
        //Integer
        Integer x = 32;
        System.out.printf("x = %d\n", x);
        x+=25;
        System.out.printf("x = %d\n", x);
        x+=x;
        
        //remember, max value of int is 2,147,483,647 - so this won't work!
        //int bigNumber = 999999999999;
        System.out.println("****************************");
        
        
        /************** LONGS **************************/
        /*
        System.out.println("Longs");
        
        long i2 = 999999999999l;  
        long i3 = index + i2;
        System.out.println(i3);
        
        Long l2 = 999999999999l;
        System.out.printf("What is the value of l2: %d\n"
        					, l2);
        
        *
        */
        
        /************* FLOATS AND DOUBLES *****************/
        /*
        System.out.println("****************************");
        System.out.println("Floats and Doubles");
        
        //float
        float f1 = 2.99f;
        System.out.printf("f1 = %f\n", f1);
        System.out.printf("f1 = $%.2f\n", f1);
        Float f2 = 4.15f;
        System.out.printf("f2 = %f\n", f2);
        System.out.printf("f2 = $%.2f\n", f2);
        
        //double
        double d1 = 2.99;
        System.out.printf("d1 = %.2f\n", d1);
        
        //precision casting
        float f3 = (float)2.99; //f3 = 2.99f;
        double d2 = f3; //d2 = 2.99;
        int roundOrTruncate = (int)d2; //2.99 --> 2 or 3?
        System.out.printf("roundOrTruncate = %d\n", roundOrTruncate);
        
        //float vs double
        float piF = 3.1415926535897932384626433f;
        double piD = 3.1415926535897932384626433;
        System.out.printf("pif] %f\n", piF);
        System.out.printf("piD] %f\n", piD);
        
        System.out.printf("pif - 4] %.4f\n", piF);
        System.out.printf("piD - 4] %.4f\n", piD);
        
        System.out.printf("pif - 5] %.5f\n", piF);
        System.out.printf("piD - 5] %.5f\n", piD);
        
        System.out.printf("pif - 6] %.6f\n", piF);
        System.out.printf("piD - 6] %.6f\n", piD);
        
        System.out.printf("pif - 7] %.7f\n", piF);
        System.out.printf("piD - 7] %.7f\n", piD);
        
        System.out.printf("pif - 8] %.8f\n", piF);
        System.out.printf("piD - 8] %.8f\n", piD);
        
        System.out.printf("pif - 9] %.9f\n", piF);
        System.out.printf("piD - 9] %.9f\n", piD);
        
        System.out.printf("pif - 10] %.10f\n", piF);
        System.out.printf("piD - 10] %.10f\n", piD);
        
        System.out.printf("pif - 25] %.25f\n", piF);
        System.out.printf("piD - 25] %.25f\n", piD);
        
        */
    }
}
