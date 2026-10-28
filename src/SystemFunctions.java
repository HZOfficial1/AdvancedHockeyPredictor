// This class is all about setting values and other miscellaneous system functions.
// Not much data manipulation will happen here.


import java.util.Arrays;
import java.util.Comparator;

public class SystemFunctions {
    // Prints the changelog.
    public static void changeLog(){
        IO.println("\n\t- - - - -\nHockey Predictor version 2.2.0\n\tWhat's new:\n- Project now on GitHub!.");
        IO.println("\n\t- - - - -\nHockey Predictor version 2.1.1\n\tWhat's new:\n- Fixed TeamBoost percentage applied incorrectly.");
        IO.println("\n\t- - - - -\nHockey Predictor version 2.1.0\n\tWhat's new:\n- New feature: TeamBoost. TeamBoost allows you to \" boost \" default teams by adding a percentage to their record.\n- Fixed faulty win percentage logic.\n- Removed playoff intro text.");
        IO.println("\n\t- - - - -\nHockey Predictor version 2.0.3\n\tWhat's new:\n- Made user input lines display with more spacing between.\n- Tweaked code order to make a previously unseen line get printed.");
        IO.println("\n\t- - - - -\nHockey Predictor version 2.0.2\n\tWhat's new:\n- Updated playoffs simulation to produce more accurate scores.\n- Tweaked codes comments to reflect the updated wording in selection menus.");
        IO.println("\n\t- - - - -\nHockey Predictor version 2.0.1\n\tWhat's new:\n- Refined regular season simulation to be more realistic.\n- Due to this, the default score multiplier is now 14.\n- Fixed a bug where playoff series scores would display incorrectly.\n- Fixed bad wording in playoffs bumper.");
        IO.println("\n\t- - - - - \nHockey Predictor version 2.0.0\n\tWhat's new:\n- Playoffs now included.\n- More advanced prediction calculations.\n- All teams are here now!\n- Custom teams.\n- New team ranking system.\n- Accurate scheduling! \n- Away teams get their values changed correctly.\n- Lots of under-the-hood improvements.");
    }

    // Loops to create a custom league.
    public static HockeyTeam[] customTeam() {
        int teams = Integer.parseInt(IO.readln("How many teams will you create? New feature: By using a custom team, you can now simulate custom playoffs!\nTeams created ≫ "));
        while (true){
            if (teams>1){
            break;
        } else{
                IO.println("You can't have less than two teams! That'd be silly!");
         teams = Integer.parseInt(IO.readln("How many teams will you create? New feature: By using a custom team, you can now simulate custom playoffs!\nTeams created ≫ "));
}}
        HockeyTeam[] hockeyTeamArray = new HockeyTeam[teams];
        for (int x = 0; x < teams; ++x) {
            String tempName = (IO.readln("What is the name of team " + (x + 1) + "? ≫ "));
            double tempPercent = (Double.parseDouble(IO.readln("What is the winning decimal percent for the " + tempName + "? (0.0-1.0) ≫ ")));
            hockeyTeamArray[x] = new HockeyTeam(0, 0, tempName, 0, tempPercent, 0);
        }
        return hockeyTeamArray;
    }

    // Returns array of default NHL teams with 2025-2026 season win percentages
    public static HockeyTeam[] defaultTeam() {

        HockeyTeam[] hockeyTeamArray = new HockeyTeam[32];
        hockeyTeamArray[0] = new HockeyTeam(0, 0, "Colorado Avalanche", 0, .738, 0);
        hockeyTeamArray[1] = new HockeyTeam(0, 0, "Carolina Hurricanes", 0, .689, 0);
        hockeyTeamArray[2] = new HockeyTeam(0, 0, "Dallas Stars", 0, .683, 0);
        hockeyTeamArray[3] = new HockeyTeam(0, 0, "Buffalo Sabres", 0, .665, 0);
        hockeyTeamArray[4] = new HockeyTeam(0, 0, "Montréal Canadiens", 0, .646, 0);
        hockeyTeamArray[5] = new HockeyTeam(0, 0, "Tampa Bay Lightning", 0, .646, 0);
        hockeyTeamArray[6] = new HockeyTeam(0, 0, "Minnesota Wild", 0, .634, 0);
        hockeyTeamArray[7] = new HockeyTeam(0, 0, "Boston Bruins", 0, .610, 0);
        hockeyTeamArray[8] = new HockeyTeam(0, 0, "Ottawa Senators", 0, .604, 0);
        hockeyTeamArray[9] = new HockeyTeam(0, 0, "Philadelphia Flyers", 0, .598, 0);
        hockeyTeamArray[10] = new HockeyTeam(0, 0, "Pittsburgh Penguins", 0, .598, 0);
        hockeyTeamArray[11] = new HockeyTeam(0, 0, "Washington Capitals", 0, .579, 0);
        hockeyTeamArray[12] = new HockeyTeam(0, 0, "Vegas Golden Knights", 0, .579, 0);
        hockeyTeamArray[13] = new HockeyTeam(0, 0, "Edmonton Oilers", 0, .567, 0);
        hockeyTeamArray[14] = new HockeyTeam(0, 0, "Detroit Red Wings", 0, .561, 0);
        hockeyTeamArray[15] = new HockeyTeam(0, 0, "Anaheim Ducks", 0, .561, 0);
        hockeyTeamArray[16] = new HockeyTeam(0, 0, "Columbus Blue Jackets", 0, .561, 0);
        hockeyTeamArray[17] = new HockeyTeam(0, 0, "Utah Mammoth", 0, .561, 0);
        hockeyTeamArray[18] = new HockeyTeam(0, 0, "New York Islanders", 0, .555, 0);
        hockeyTeamArray[19] = new HockeyTeam(0, 0, "Los Angeles Kings", 0, .549, 0);
        hockeyTeamArray[20] = new HockeyTeam(0, 0, "New Jersey Devils", 0, .530, 0);
        hockeyTeamArray[21] = new HockeyTeam(0, 0, "Nashville Predators", 0, .524, 0);
        hockeyTeamArray[22] = new HockeyTeam(0, 0, "St. Louis Blues", 0, .524, 0);
        hockeyTeamArray[23] = new HockeyTeam(0, 0, "San Jose Sharks", 0, .524, 0);
        hockeyTeamArray[24] = new HockeyTeam(0, 0, "Florida Panthers", 0, .512, 0);
        hockeyTeamArray[25] = new HockeyTeam(0, 0, "Winnipeg Jets", 0, .500, 0);
        hockeyTeamArray[26] = new HockeyTeam(0, 0, "Seattle Kraken", 0, .482, 0);
        hockeyTeamArray[27] = new HockeyTeam(0, 0, "Toronto Maple Leafs", 0, .476, 0);
        hockeyTeamArray[28] = new HockeyTeam(0, 0, "New York Rangers", 0, .470, 0);
        hockeyTeamArray[29] = new HockeyTeam(0, 0, "Calgary Flames", 0, .470, 0);
        hockeyTeamArray[30] = new HockeyTeam(0, 0, "Chicago Blackhawks", 0, .439, 0);
        hockeyTeamArray[31] = new HockeyTeam(0, 0, "Vancouver Canucks", 0, .354, 0);





        return hockeyTeamArray;
    }
    // Sorts teams by wins and displays final standings
    public static HockeyTeam[] sort(HockeyTeam[] input, int gameToPlay) {
        Arrays.sort(input, Comparator.comparing(HockeyTeam::getWon).reversed());
        for (int x = 0; x < input.length; ++x) {
            input[x].setRanking(x + 1);
            double winPercent = (double) input[x].getWon() /input[x].getGamesPlayed();
            IO.println("\n" + input[x].getRanking() + ". " + input[x].getName() + "\n\tWinning percentage: " + (winPercent) + "\n\tGames played: " + input[x].getGamesPlayed() + "\n\tWins: " + input[x].getWon() + "\n\tLosses: " + input[x].getLost());

    }

        return input;
    }
    // Prepares top teams for playoffs by resetting their stats
    public static HockeyTeam[] convertToPlayoffs(HockeyTeam[] inputArray, int numInPlayoffs) {
      HockeyTeam[] playoffArray = new HockeyTeam[numInPlayoffs];
      HockeyTeam[] tempArray = inputArray;

        for (int x=0; x<numInPlayoffs; ++x){
            tempArray[x].setWon(0);
            tempArray[x].setLost(0);
            tempArray[x].setGamesPlayed(0);
            playoffArray[x] = tempArray [x];
      }
        return playoffArray;
    }

    // Display the playoff bracket
    public static void displayBracket(java.util.ArrayList<HockeyTeam> currentRound, int round) {
        if (round > 1) {
            IO.println("\n" + "═".repeat(60));
            IO.println("BRACKET FOR ROUND " + round);
            IO.println("═".repeat(60));
            for (int i = 0; i < currentRound.size(); i++) {
                IO.println("  " + (i + 1) + ". " + currentRound.get(i).getName());
            }
        }
    }

    public static void sleepForAWhile (){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static HockeyTeam[] teamBoost(HockeyTeam[] teamsArray) {
        IO.println("\n\n\n\n\n\n\n\n\n\t⚡️ TeamBoost ⚡️");
        printLeagueNames(teamsArray);
        int teamId= Integer.parseInt(IO.readln("Please enter the ID of the team you want to boost (1-32) ≫ "));
        double boost = Double.parseDouble(IO.readln("Please enter the boost percentage (%) ≫ "));
        teamsArray[teamId - 1].setPercent(teamsArray[teamId - 1].getPercent() + ((teamsArray[teamId - 1].getPercent() ) * (boost/100)));
        IO.println("TeamBoost applied! The " + teamsArray[teamId - 1].getName() + " now have a winning percentage of " + teamsArray[teamId - 1].getPercent());
        return teamsArray;
    }

    public static void printLeagueNames(HockeyTeam[] hockeyTeamArray) {
        for (int x = 0; x < hockeyTeamArray.length; x++) {
            IO.println((x + 1) + ": " + hockeyTeamArray[x].getName());
        }
    }
}