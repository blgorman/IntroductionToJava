/**
 * Storing Types in Variables Part 2.
 * @author Brian
 */
public class StoringTypesInVariablesPart2 {

    public static void main(String[] args)
    {
        System.out.println("Types in Variables:");
        System.out.println("****************************");
        System.out.println("Characters");
        //char 
        char one = 'a';
        char two = '2';
        char three = 'A';
        char four = '@';
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(four);
        
        //String s2 = one + two + three + four;
        
        //String s2 = one.toString() + two.toString() 
        //            + three.toString() + four.toString();
        //System.out.println(s2);
        
        String finalString = String.format("%c%c%c%c", one, two, three, four);
        System.out.println(finalString);
        
        //full Character de-referencing
        Character oneFull = 'a';
        Character twoFull = '2';
        Character threeFull = 'A';
        Character fourFull = '@';
        String s4 = oneFull.toString() + twoFull.toString()
                        + threeFull.toString() + fourFull.toString();
        System.out.println(s4);
        
        //String s5 = one.toString() + two.toString()
        //			+ three.toString() + four.toString();
         
        String s5 = ((Character)one).toString() + 
                    ((Character)two).toString() +
                    ((Character)three).toString() +
                    ((Character)four).toString();
        System.out.println(s5);
        
        /*********** STRINGS ******************************/
        /*
        System.out.println("****************************");
        System.out.println("Strings");
        
        int index = 1;
        String outputString = "%d]:";
        String tempOutputString = String.format(outputString, index);
        System.out.println(tempOutputString);
        //remember this?
        System.out.print(index + "]\n");
        //now we know the better way to do it!
        
        //yes, you can concatenate Strings with a + sign:
        String s = "This is a String!";
        String t = "So is this!";
        String u = s + t;
        System.out.println(u);
        
        //A "better" way to do this:
        String u2 = String.format("%s%s", s, t);
        System.out.println(u2);
        */
        
        /***************** BOOLEANS *************************/
        /*
        //boolean
        System.out.println("****************************");
        System.out.println("Booleans");
        
        boolean b1 = true;
        boolean b2 = false;
        System.out.printf("B1 is %b\n", b1);
        //System.out.printf("B2 is %s\n", b2.toString());
        System.out.printf("B2 is %s\n", ((Boolean)b2).toString());
        
        System.out.println("****************************");
        System.out.println("DONE");
        */
    }
}
