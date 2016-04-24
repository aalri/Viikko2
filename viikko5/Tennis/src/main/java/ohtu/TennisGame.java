package ohtu;

import java.util.Arrays;
import java.util.List;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private static final List<String> scoreText = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else if (playerName.equals(player2Name)) {
            player2Score += 1;
        }
    }

    public String getScore() {
        String score;       
        if (bothScoresEqual()) score = getEvenScore();
        else if (eitherScoreOverForty())score = tieBreakPointInText();
        else score = scoreToText(player1Score) + "-" + scoreToText(player2Score);
        return score;
    }
    
    public String getEvenScore(){
        if(player1Score > 3) return "Deuce"; 
        return scoreToText(player1Score) + "-ALL";
    }

    public boolean bothScoresEqual() {
        return (player1Score == player2Score);
    }

    public boolean eitherScoreOverForty() {
        return (player1Score >= 4 || player2Score >= 4);
    }

    private String tieBreakPointInText() {
        String score;
        int pointGap = player1Score - player2Score;
        if (pointGap == 1) score = "Advantage " + player1Name;
        else if (pointGap == -1) score = "Advantage " + player2Name;
        else if (pointGap >= 2)score = "Win for " + player1Name;
        else score = "Win for " + player2Name;
        return score;
    }

    private String scoreToText(int score) {
        return scoreText.get(score);
    }
}
