public class HockeyTeam {
    private int won;
    private int lost;
    private String name;
    private int ranking;
    private double percent;
    private int gamesPlayed;

    // Constructor for HockeyTeam
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    // Full constructor with all team stats
    public HockeyTeam(int won, int lost, String name, int ranking, double percent, int gamesPlayed) {
        this.won = won;
        this.lost = lost;
        this.name = name;
        this.ranking = ranking;
        this.percent = percent;
        this.gamesPlayed = gamesPlayed;
    }

    // Get the team's win percentage (0.0 to 1.0)
    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    // Get number of wins
    public int getWon() {

        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    // Get number of losses
    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    // Get team name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Get current ranking/standing
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}