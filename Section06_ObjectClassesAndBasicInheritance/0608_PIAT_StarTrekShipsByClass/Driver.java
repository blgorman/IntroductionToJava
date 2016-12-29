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
        Commander Kirk = new Commander("James T. Kirk"
                                        , 43
                                        , "Captain"
                                        , "SC937-0176");
        Commander Terrell = new Commander("Clark Terrell"
                                            , 53
                                            , "Captain"
                                            , "SC643-8345");
        Commander Pressman = new Commander("Erik Pressman"
                                            , 62
                                            , "Admiral"
                                            , "SA463-8461");
        Commander Sisko = new Commander("Benjamin Sisko"
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
        //but what about sorting?
        //we'll have to wait until later to learn how to sort these
        //complex objects.
    }
}
