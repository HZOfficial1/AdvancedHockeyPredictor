 import java.util.ArrayList;

void main() {
    //TO DO:
    //Nothin' much!

    char charTemp;
    int gamesToPlay;
    double scoreConstant;
    HockeyTeam[] teamsArray;
    HockeyTeam[] playoffArray;

    int teamsIn;
    // Main menu loop - handles user input for start, changelog, or quit. You will see similar loops for other user inputs.
    while (true) {
        charTemp = IO.readln("\nWelcome to the new and improved hockey predictor!\nEnter 'c' for changelog, enter 's' to start, and enter 'q' to quit ≫ ").charAt(0);
        charTemp = Character.toLowerCase(charTemp);
        if (charTemp == 'c') {
            SystemFunctions.changeLog();
        } else if (charTemp == 's') {
            break;
        } else if (charTemp == 'q') {
            System.exit(14);
        } else IO.println("\nOff the crossbar! You didn't enter a valid option! Try again.");
    }
    // League selection menu - choose between making a custom league or the preset 2025-2026 NHL teams.
    while (true) {
        charTemp = IO.readln("\n\n\nWould you like to make a custom league, or simulate from values in the 2025-2026 season?\n\tEnter 'c' for a custom league.\n\tEnter 'd' for the preset league.\n\t≫ ").charAt(0);
        charTemp = Character.toLowerCase(charTemp);

// The following calls the appropriate team type.
        if (charTemp == 'c') {
            teamsArray = SystemFunctions.customTeam();
            gamesToPlay = Integer.parseInt(IO.readln("\n\n\nHow many games will each team be playing? ≫ "));
            break;
        } else if (charTemp == 'd') {
            gamesToPlay = 82;
            teamsArray = SystemFunctions.defaultTeam();
                while (true) {
                    charTemp = IO.readln("\n\n\nWould you like to add a TeamBoost?\n\tEnter 'y' for a TeamBoost.\n\tEnter 'n' for the regular values.\n\t≫ ").charAt(0);
                    charTemp = Character.toLowerCase(charTemp);

                        if (charTemp == 'y') {
                            teamsArray = SystemFunctions.teamBoost(teamsArray);
                            break;
                        } else if (charTemp == 'n') {

                            break;
                        } else IO.println("\nOff a fan! You didn't enter a valid option! Try again.");
                }
            break;
        } else IO.println("\nOff the glass! You didn't enter a valid option! Try again.");
    }
    // Score multiplier customization menu
    while (true) {
        charTemp = IO.readln("\n\n\nWould you like to customize the score multiplier constant, or leave it as default?\n\tEnter 'c' for customize.\n\tEnter 'd' for the default (recommended).\n\t≫ ").charAt(0);
        if (charTemp == 'c') {
            scoreConstant = Double.parseDouble((IO.readln("\n\n\nEnter new score constant. (Between 12 and 16 is more realistic). ≫ ")));
            break;
        } else if (charTemp == 'd') {
            scoreConstant = 14;
            break;
        } else IO.println("\nOff the ref! You didn't enter a valid option! Try again.");
    }
    // Create a balanced “round-robin”-like schedule for regular season
    IO.println("\n\n\nCreating balanced regular season schedule...");

    SystemFunctions.sleepForAWhile();


    int gamesPerPairing = gamesToPlay / (teamsArray.length - 1); // Approximate games per opponent pair

    // Generate all possible team pairings using AbstractMap.SimpleEntry to store home/away team indices
    // AbstractMap.SimpleEntry is a simple key-value pair implementation that stores two values together
    // Here: key = home team index, value = away team index
    java.util.List<java.util.AbstractMap.SimpleEntry<Integer, Integer>> schedule = new java.util.ArrayList<>();
    //Translation: this abstract map will have two integers. The first will be the home team index, and the second will be the away team index. This is a new ArrayList.
    for (int i = 0; i < teamsArray.length; i++) {
        for (int j = i + 1; j < teamsArray.length; j++) {
            // Each pair plays multiple games (home/away alternated)
            for (int game = 0; game < gamesPerPairing; game++) {

                // Makes it so that teams aren't always at home using modulus. (Every other game is away).
                if (game % 2 == 0) {
                    schedule.add(new java.util.AbstractMap.SimpleEntry<>(i, j)); // i is home, j is away
                } else {
                    schedule.add(new java.util.AbstractMap.SimpleEntry<>(j, i)); // j is home, i is away
                }
            }
        }
    }

    // Shuffle the schedule for randomness using Collections.shuffle()
    java.util.Collections.shuffle(schedule, new java.util.Random());

    // Simulate the games using the shuffled schedule. This uses an advanced for loop.
    for (java.util.AbstractMap.SimpleEntry<Integer, Integer> game : schedule) {
        int homeIndex = game.getKey();    // Get home team index from the SimpleEntry key
        int awayIndex = game.getValue();  // Get away team index from the SimpleEntry value
        HockeyTeam home = teamsArray[homeIndex];
        HockeyTeam away = teamsArray[awayIndex];
// Simulates the games by calling Simulate.java
        Simulate.regGame(away, home, scoreConstant);
    }

    IO.println("\nSimulation complete! Now sorting teams...");
    SystemFunctions.sleepForAWhile();
    teamsArray = SystemFunctions.sort(teamsArray, gamesToPlay);
    // Playoff decision menu
    while (true) {
        charTemp = IO.readln("\n\nWould you like to simulate playoffs? \n\tEnter 'y' for yes.\n\tEnter 'n' to end the season.\n\t≫ ").charAt(0);
        charTemp = Character.toLowerCase(charTemp);
        if (charTemp == 'y') {
            break;
        } else if (charTemp == 'n') {
            IO.println("Thank you for using the advanced hockey predictor! Your final season results are listed above ↑.");
            System.exit(29);
        } else IO.println("\nGlove save! You didn't enter a valid option! Try again.");
    }
    // Playoff team count validation - must be power of 2
    while (true) {
        teamsIn = Integer.parseInt(IO.readln("\nHow many teams will make it in to the playoffs?\n\tValid values: 2, 4, 8, 16, 32, etc. (must be a power of 2)\n\t≫ "));
        if (teamsIn > teamsArray.length) {
            IO.println("Woah! You only have " + teamsArray.length + " teams! Try again.");
            // Bitwise to determine powers of two.
        } else if (teamsIn <= 0 || (teamsIn & (teamsIn - 1)) != 0) {
            IO.println("The number of playoff teams must be a power of 2 (2, 4, 8, 16, 32, etc.)! Try again.");
        } else {
            break;
        }
    }
    // Now it is time for the playoffs! This code is quite different to the regular season due to complex matchings.
    playoffArray = SystemFunctions.convertToPlayoffs(teamsArray, teamsIn);
    SystemFunctions.sleepForAWhile();

    // Simulate playoff rounds using ArrayList for dynamic arrays
    ArrayList<HockeyTeam> currentRound = new ArrayList<>();
    java.util.Collections.addAll(currentRound, playoffArray); // Collections.addAll() copies array elements to the ArrayList

    int round = 1;
    while (currentRound.size() > 1) {
        IO.println("\n═══════════════════════════════════════");
        IO.println("PLAYOFF ROUND " + round + " - " + currentRound.size() + " teams remaining");
        IO.println("═══════════════════════════════════════");

        ArrayList<HockeyTeam> nextRound = new ArrayList<>(); // Create new ArrayList for advancing teams

        // Pair teams and simulate series
        for (int i = 0; i < currentRound.size(); i += 2) {
            HockeyTeam team1 = currentRound.get(i);
            HockeyTeam team2 = currentRound.get(i + 1);

            // Reset stats for playoff series
            team1.setWon(0);
            team1.setLost(0);
            team1.setGamesPlayed(0);
            team2.setWon(0);
            team2.setLost(0);
            team2.setGamesPlayed(0);

            IO.println("\n\t－－－－－－－\nSeries: " + team1.getName() + " vs " + team2.getName() + "\n\t－－－－－－－");

            // Simulate the playoff series
            Simulate.playoffs(team1, team2, scoreConstant);

            // Determine winner
            HockeyTeam seriesWinner;
            if (team1.getWon() > team2.getWon()) {
                seriesWinner = team1;
                IO.println("\n✓ " + team1.getName() + " won the series!\nSeries score: " + team1.getWon() + " - " + team2.getWon());
            } else {
                seriesWinner = team2;
                IO.println("\n✓ " + team2.getName() + " won the series!\nSeries score: " + team1.getWon() + " - " + team2.getWon());
            }

            nextRound.add(seriesWinner); // ArrayList.add() appends elements to the end of the list
        }

        currentRound = nextRound; // Replace current round with winners for next iteration
        SystemFunctions.displayBracket(currentRound, round + 1);
        round++;
    }

    IO.println("\n═══════════════════════════════════════");
    IO.println("🏆 STANLEY CUP CHAMPION: " + currentRound.getFirst().getName() + "! 🏆");
    IO.println("═══════════════════════════════════════");
    IO.println("\nThank you for using the advanced hockey predictor!");
    System.exit(97);
}