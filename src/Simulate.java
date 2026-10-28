public class Simulate {
    // Simulates a regular season game between two teams
    public static void regGame (HockeyTeam away, HockeyTeam home, double scoreMulti){
        home.setGamesPlayed(home.getGamesPlayed()+1);
        away.setGamesPlayed(away.getGamesPlayed()+1);
        double awaySim = away.getPercent()*Math.random()*away.getPercent();
        double homeSim = home.getPercent()*Math.random()*home.getPercent()*1.005;
        // Times 1.005 to simulate small home advantage
        double difference = Math.abs(awaySim-homeSim);
        int awayScore = (int) (awaySim*scoreMulti);
        int homeScore = (int) (homeSim*scoreMulti);
        if (awayScore==homeScore){
            if (awaySim>homeSim) {
                ++awayScore;
            }
            else{
                ++homeScore;
            }
            }
        if (difference <0.01){
            if (awaySim>homeSim){
                IO.println("\nThe "+home.getName() + " lost to the " + away.getName()+ "\n\tFinal score in shootout: " + awayScore + " - " + homeScore);
            }
            if (homeSim>awaySim){
                IO.println("\nThe "+home.getName() + " beat the " + away.getName()+ "\n\tFinal score in shootout: " + awayScore + " - " + homeScore);
            }
        }
            if (difference <0.05){
                if (awaySim>homeSim){
                    IO.println("\nThe "+home.getName() + " lost to the " + away.getName()+ "\n\tFinal score in overtime: " + awayScore + " - " + homeScore);
                }
                if (homeSim>awaySim){
                    IO.println("\nThe "+home.getName() + " beat the " + away.getName()+ "\n\tFinal score in overtime: " + awayScore + " - " + homeScore);
                }
            }
            else{
                if (awaySim>homeSim){
                    IO.println("\nThe "+home.getName() + " lost to the " + away.getName()+ "\n\tFinal score in regulation: " + awayScore + " - " + homeScore);
                }
                if (homeSim>awaySim){
                    IO.println("\nThe "+home.getName() + " beat the " + away.getName()+ "\n\tFinal score in regulation: " + awayScore + " - " + homeScore);
                }
            }
        if (awaySim>homeSim){
            away.setWon(away.getWon()+1);
            home.setLost(home.getLost()+1);
        }
        if (homeSim>awaySim){
            home.setWon(home.getWon()+1);
            away.setLost(away.getLost()+1);

        }
    }



    // Simulates a playoff series (best of 7) between two teams
    public static void playoffs (HockeyTeam away, HockeyTeam home, double scoreMulti ){
        final int GAMES_TO_PLAY = 7, WINNING_GAMES_WON=4;

        int x=0;
        away.setWon(0);
        home.setWon(0);
        away.setGamesPlayed(0);
        home.setGamesPlayed(0);
        while (x<GAMES_TO_PLAY){
        home.setGamesPlayed(home.getGamesPlayed()+1);
        // The second percent multiplier is omitted to allow for more "comeback-able" playoffs. The 1.5 division is to help make scores more similar to regular season games, without removing the randomness of the playoffs.
        double awaySim = away.getPercent()*Math.random()/1.5;
        double homeSim = home.getPercent()*Math.random()/1.5;
        double difference = Math.abs(awaySim-homeSim);
        int awayScore = (int) (awaySim*scoreMulti);
        int homeScore = (int) (homeSim*scoreMulti);
        if (awayScore==homeScore){
            if (awaySim>homeSim) {
                ++awayScore;
            }
            else{
                ++homeScore;
            }
        }
        if (difference <0.008){
            if (awaySim>homeSim){
                away.setWon(away.getWon()+1);
                IO.println("\nThe "+home.getName() + " lost to the " + away.getName()+ "\n\tFinal score in double overtime: " + awayScore + " - " + homeScore + " Series " + away.getWon() + "-" + home.getWon());
            }
            if (homeSim>awaySim){
                home.setWon(home.getWon()+1);
                IO.println("\nThe "+home.getName() + " beat the " + away.getName()+ "\n\tFinal score in double overtime: " + awayScore + " - " + homeScore + " Series " + away.getWon() + "-" + home.getWon());
            }
        }
        else if (difference <0.06){
            if (awaySim>homeSim){
                away.setWon(away.getWon()+1);
                IO.println("\nThe "+home.getName() + " lost to the " + away.getName()+ "\n\tFinal score in overtime: " + awayScore + " - " + homeScore + " Series " + away.getWon() + "-" + home.getWon());
            }
            if (homeSim>awaySim){
                home.setWon(home.getWon()+1);
                IO.println("\nThe "+home.getName() + " beat the " + away.getName()+ "\n\tFinal score in overtime: " + awayScore + " - " + homeScore + " Series " + away.getWon() + "-" + home.getWon());
            }
        }
        else{
            if (awaySim>homeSim){
                away.setWon(away.getWon()+1);
                IO.println("\nThe "+home.getName() + " lost to the " + away.getName()+ "\n\tFinal score in regulation: " + awayScore + " - " + homeScore + " Series " + away.getWon() + "-" + home.getWon());
            }
            if (homeSim>awaySim){
                home.setWon(home.getWon()+1);
                IO.println("\nThe "+home.getName() + " beat the " + away.getName()+ "\n\tFinal score in regulation: " + awayScore + " - " + homeScore + " Series " + away.getWon() + "-" + home.getWon());
            }
        }
            ++x;
            if ((away.getWon()==WINNING_GAMES_WON) || (home.getWon() == WINNING_GAMES_WON)) {
                break;
            }
        }
    }

}