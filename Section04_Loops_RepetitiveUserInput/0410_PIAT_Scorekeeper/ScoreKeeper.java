import java.util.*;

/**
 * The ScoreKeeper program keeps score for the card game 500.
 * @author Brian
 */
public class ScoreKeeper {
    public static String teamName1;
    public static String teamName2;
    public static int teamOneScore;
    public static int teamTwoScore;
    public static Scanner input;

    /**
    * The main program drives the base algorithm.
    * However, the scoring and gameplay algorithm is 
    * passed to the RunGame method.
    * @param args -- not used.
    */
    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        boolean changeTeamNames = true;
        boolean shouldContinue = true;
        String winningTeam = "";
        int teamOneWins = 0;
        int teamTwoWins = 0;

        while (shouldContinue)
        {
            if (changeTeamNames)
            {
                //gather team names:
                System.out.println("What is the name of Team One?");
                teamName1 = input.nextLine();
                teamOneWins = 0;

                System.out.println("What is the name of Team Two?");
                teamName2 = input.nextLine();
                teamTwoWins = 0;
                changeTeamNames = false;
            }

            //set (or re-set) the team scores:
            teamOneScore = 0;
            teamTwoScore = 0;

            //print out the table at open:
            System.out.print(GetScoreTable());

            //run the game
            RunGame();

            //increment team win count
            if (teamOneScore > 500)
            {
                winningTeam = teamName1;
                teamOneWins += 1;
            }
            else
            {
                winningTeam = teamName2;
                teamTwoWins += 1;
            }
            
            /* output at end of game */
            System.out.printf("%s has won the game!\n", winningTeam); 
            // teamOneScore > 500 ? teamName1 : teamName2);
            System.out.printf("Overall, %s has won %d games, "
                                + "and %s has won %s games\n"
                                , teamName1, teamOneWins
                                , teamName2, teamTwoWins);
            System.out.println("Thanks for playing!");
            System.out.println(Stars(50));
            shouldContinue = ValidateYN("Would you like to play "
                                            + "another game [y/n]?");
            if (shouldContinue)
            {
                changeTeamNames = ValidateYN("Do you want to change "
                                        + "team names [y/n]?");
            }
        }
        
        System.out.println("Thanks for playing! Have a great day!");
    }

    /**
     * Print the score table.
     * @return A string that represents the score table.
     */
    public static String GetScoreTable()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(Stars(50));
        sb.append("\n");
        sb.append(String.format("%25s\t|\t%d\n"
                                , teamName1
                                , teamOneScore));
        sb.append(Dashes(50));
        sb.append("\n");
        sb.append(String.format("%25s\t|\t%d\n"
                                , teamName2
                                , teamTwoScore));
        sb.append(Stars(50));
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Get the point value of the current bid
     * @param numTricks  The number of tricks in the bid
     * @param suit		 The trump suit
     * @return			 The value of the bid based on tricks and suit
     */
    public static int GetBidValue(int numTricks, String suit)
    {
        int bidValue = 0;
        char suitChar = suit.toUpperCase().charAt(0);
        
        //6 bid default values:
        if (suitChar == 'S')
        {
            //spades
            bidValue = 60;
        }
        else if (suitChar == 'C')
        {
            //clubs
            bidValue = 80;
        }
        else if (suitChar == 'D')
        {
            //diamonds
            bidValue = 100;
        }
        else if (suitChar == 'H')
        {
            //hearts
            bidValue = 120;
        }
        else if (suitChar == 'N')
        {
            //no trump
            bidValue = 140;
        }

        switch (numTricks)
        {
            case 7:
                    bidValue += 100;
                    break;
            case 8:
                    bidValue += 200;
                    break;
            case 9:
                    bidValue += 300;
                    break;
            case 10:
                    bidValue += 400;
                    break;
            default:
                    break;
        }
        return bidValue;
    }

    /**
     * Each round of scoring would be repeated until the end of the game.
     */
    public static void RunGame()
    {
        int bidCount;
        
        int bidTeam;
        int bidValue;
        String bidCountPrompt = "What is the current bid count [6-10]?";
        String bidSuitPrompt = "What is the suit of the bid [%s]?";
        String bidSuitValidChars = "S,C,D,H,N";
        
        do
        {
            //reset
            String bidSuitCharString = "";
            String bidSuit = "";
            
            //get the bid count
            bidCount = GetIntWithPrompt(bidCountPrompt
                                        , 6
                                        , 10);

            //get the bid suit
            boolean isValidSuit = false;
            while (!isValidSuit)
            {
                System.out.println(String.format(bidSuitPrompt
                                    ,bidSuitValidChars));
                bidSuit = input.nextLine();
                //get the first char for validation:
                bidSuitCharString = 
                        ((Character)bidSuit.toUpperCase().charAt(0)).toString();
                //validate that the input is one of the matched letters:
                isValidSuit = bidSuitValidChars.contains(bidSuitCharString);
            }
            

            //get the team that placed the bid
            bidTeam = GetIntWithPrompt("Which team placed the bid [1,2]?"
                                        , 1, 2);
            
            bidValue = GetBidValue(bidCount, bidSuitCharString);
            System.out.printf("%s has the bid of %d%s worth %d...\n"
                                    , bidTeam == 1 ? teamName1 : teamName2
                                    , bidCount
                                    , bidSuit
                                    , bidValue);

            //ask if bid was made
            boolean bidWasMade = ValidateYN("Was the bid made [y/n]?");
            

            //get the number of tricks earned by the other team:
            String bidTeamName = (bidTeam == 1 ? teamName2 : teamName1);
            String nOTPrompt = String.format("How many tricks were earned "
                                            + "by %s?"
                                            , bidTeamName);
            int numOpponentTricks = GetIntWithPrompt(nOTPrompt, 0, 10);
            ScoreBid(bidTeam, bidValue, bidWasMade, numOpponentTricks);
            
            //print the score
            System.out.print(GetScoreTable());

        //here we can have an automatic end at 500	
        } while (teamOneScore < 500 && teamTwoScore < 500);
    }
    
    /**
     * Score it.
     * @param bidTeam   the team placing the bid
     * @param bidValue  the value of the bid
     * @param bidMade   was it made?
     * @param numOppTakenTricks number of tricks by opponent team.
     */
    private static void ScoreBid(int bidTeam
                                    , int bidValue
                                    , boolean bidMade
                                    , int numOppTakenTricks)
    {
        int bidScore = 0;
        if (bidMade)
        {
            if (bidValue < 250 && numOppTakenTricks == 0)
            {
                bidScore = 250;
            }
            else
            {
                bidScore = bidValue;
            }
        }
        else
        {
            bidScore -= bidValue;
        }
        
        //10 points per trick taken for non bidding team:
        int oppScore = numOppTakenTricks * 10;
       
        //add the team score to the correct team:
        if (bidTeam == 1)
        {
            teamOneScore += bidScore;
            teamTwoScore += oppScore;
        }
        else
        {
            teamOneScore += oppScore;
            teamTwoScore += bidScore;
        }
    }
    
    /********** HELPER FUNCTIONS *************************************/
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidateNumber(String checkString)
    {
        return ValidateNumber(checkString, false);
    }
    
    /**
     * Make sure user entered only a valid number:
     * @param checkString
     * @return 
     */
    public static boolean ValidateNumber(String checkString
                                        , boolean ignoreDecimalAndHyphen)
    {
        boolean isValid = true;
        //loop on all characters
        for (int i = 0; i < checkString.length(); i++)
        {
            char checkChar = checkString.charAt(i);
            if (ignoreDecimalAndHyphen && (checkChar == 45 || checkChar == 46))
            {
                continue;
            }
            if (checkChar < 48 || checkChar > 57)
            {
                isValid = false;
                System.out.printf("Invalid character in response: %s\n"
                        , checkChar);
                System.out.println("Please enter only numbers");
                break;
            }
        }
        
        //if get to here, all chars are valid
        return isValid;
    }
    
    /**
     * This method will validate a String to see
     *  if it can be parsed as a double
     * @param val the value to parse
     * @return true if can be made into a double, else false;
     */
    private static boolean ValidateDouble(String val)
    {
        return ValidateNumber(val, true);
    }
    
    /**
     * Get an integer with a prompt.
     * @param prompt prompt to the user
     * @param minInt range limiter minimum value
     * @param maxInt range limiter max value
     * @return 
     */
    public static int GetIntWithPrompt(String prompt, int minInt, int maxInt)
    {
        int result = -1;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String val = input.nextLine();
            isValid = ValidateNumber(val);
            if (!isValid)
            {
                continue;
            }
            
            //can parse, but validate by range
            result = Integer.parseInt(val);
            if (result < minInt || result > maxInt)
            {
                isValid = false;
                result = -1;
            }
        }
        return result;
    }
    
    /**
     * Validate a statement with y/n input expected
     * @param prompt Output to user
     * @return true if user response is y, else false
     */
    public static boolean ValidateYN(String prompt)
    {
        boolean isValid = false;
        boolean validated = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String response = input.nextLine();
            String rCharStr = GetFirstCharAsString(response);
            if (rCharStr.toUpperCase().equals("Y"))
            {
                isValid = true; 
                validated = true;
            }
            else if(rCharStr.toUpperCase().equals("N"))
            {
                isValid = true;
                validated = false;
            }
            else
            {
                System.out.println("Invalid response. "
                                        + "Please enter 'Y' or 'N'");
            }
        }
        return validated;
    }
    
    /**
     * Get the first char of a string as a new string
     * @param val The string to get first char as string
     * @return The first char of a String as a String
     */
    public static String GetFirstCharAsString(String val)
    {
        return ((Character)val.charAt(0)).toString();
    }
    
    /**
     * Print out a string of stars based on passed in length
     * @param num
     * @return
     */
    public static String Stars(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("*");
        }
        return sb.toString();
    }

    /**
     * Print out a string of dashes based on passed in length
     * @param num
     * @return
     */
    public static String Dashes(int num)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++)
        {
            sb.append("-");
        }
        return sb.toString();
    }
    /********** END HELPER FUNCTIONS *********************************/
}
