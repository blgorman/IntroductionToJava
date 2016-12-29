/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author Brian
 */
public class Driver 
{
    public static void main(String[] args)
    {
        //first, we need to create our commanders:
        Commander Kirk = new Commander("James T."
                                        , "Kirk"
                                        , 43
                                        , "Captain"
                                        , "SC937-0176");
        Commander Terrell = new Commander("Clark", "Terrell"
                                            , 53
                                            , "Captain"
                                            , "SC643-8345");
        Commander Pressman = new Commander("Erik", "Pressman"
                                            , 62
                                            , "Admiral"
                                            , "SA463-8461");
        Commander Sisko = new Commander("Benjamin", "Sisko"
                                        , 42
                                        , "Captain"
                                        , "SC353-2626");

        //let's make an array of ships to hold all of our starships
        Starship[] federationShips = new Starship[4];
        federationShips[0] = new Starship(Common.CONSTITUTION_CLASS
                                            , Kirk
                                            , "NCC-1701"
                                            , "USS Enterprise");
        federationShips[1] = new Starship(Common.MIRANDA_CLASS
                                            , Terrell
                                            , "NCC-1864"
                                            , "USS Reliant");
        federationShips[2] = new Starship(Common.OBERTH_CLASS
                                            , Pressman
                                            , "NCC-53847"
                                            , "USS Pegasus");
        federationShips[3] = new Starship(Common.DEFIANT_CLASS
                                            , Sisko
                                            , "NX-74205"
                                            , "USS Defiant");
        
        //Now let's print them out
        for(Starship s : federationShips)
        {
            System.out.println(Common.Stars(50));
            System.out.println(s);
        }
        System.out.println("###########################################");
        
        //but what about sorting?
        //now that we've written comparable, we can sort by starship
        //since the type is starship:
        //[remember that we said to sort by name first in the code
        Arrays.sort(federationShips);
        for(Starship s : federationShips)
        {
            System.out.println(Common.Stars(50));
            System.out.println(s);
        }
        
        //and what if the ships are equal but the commanders aren't?
        Starship[] federationShips2 = new Starship[6];
        federationShips2[0] = federationShips[0];
        federationShips2[1] = federationShips[1];
        federationShips2[2] = federationShips[2];
        federationShips2[3] = federationShips[3];
        
        Commander NotSisko = new Commander("Benjamin", "Thomas"
                                        , 42
                                        , "Captain"
                                        , "SC353-2626");
        Commander NotSiskosAge = new Commander("Benjamin", "Sisko"
                                        , 70
                                        , "Captain"
                                        , "SC353-2626");
        
        //but what if two or more are identical with different commanders:
        federationShips2[4] = new Starship(Common.DEFIANT_CLASS
                                            , NotSisko
                                            , "NX-74205"
                                            , "USS Defiant");
        federationShips2[5] = new Starship(Common.DEFIANT_CLASS
                                            , NotSiskosAge
                                            , "NX-74205"
                                            , "USS Defiant");
        
        System.out.println("###########################################");
        Arrays.sort(federationShips2);
        for(Starship s : federationShips2)
        {
            System.out.println(Common.Stars(50));
            System.out.println(s);
        }
        
        System.out.println("###########################################");
        System.out.println("###########################################");
        //and what about equality?  Now we can tell if two ships/commanders
        //etc are equal thanks to overridden equality
        System.out.printf("%s\nequals\n%s? %b\n"
                , federationShips2[1]
                , federationShips2[2]
                , federationShips2[1].equals(federationShips2[2]));
        
        System.out.printf("%s\nequals\n%s? %b\n"
                , Sisko
                , Kirk
                , Sisko.equals(Kirk));
        
        System.out.printf("%s\nequals\n%s? %b\n"
                , federationShips2[1]
                , federationShips2[1]
                , federationShips2[1].equals(federationShips2[1]));
        
        System.out.printf("%s\nequals\n%s? %b\n"
                , Kirk
                , Kirk
                , Kirk.equals(Kirk));
        
        
    }
}
