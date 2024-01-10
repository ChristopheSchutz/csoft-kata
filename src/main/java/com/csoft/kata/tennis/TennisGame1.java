package com.csoft.kata.tennis;

public class TennisGame1 implements TennisGame {

    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";
    private static final String DASH = "-";
    private static final String ADVANTAGE = "Advantage ";
    private static final String WIN_FOR = "Win for ";
    private static final String FORTY = "Forty";

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score++;
        else
            player2Score++;
    }

    public String getScore() {
        if (isDraw())
        {
            return getDrawScore();
        }
        else if (winnerOrAdvantage())
        {
            return getWinnerOrAdvantageScore();
        }
        else
        {
            return getOtherScore();
        }
    }

    private boolean isDraw() {
        return player1Score == player2Score;
    }

    private String getDrawScore() {
        String score;
        switch (player1Score)
        {
            case 0:
                score = LOVE + DASH + ALL;
                break;
            case 1:
                score = FIFTEEN + DASH + ALL;
                break;
            case 2:
                score = THIRTY + DASH + ALL;
                break;
            default:
                score = DEUCE;
                break;

        }
        return score;
    }

    private boolean winnerOrAdvantage() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getWinnerOrAdvantageScore() {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult==1) score = ADVANTAGE + player1Name;
        else if (minusResult ==-1) score = ADVANTAGE + player2Name;
        else if (minusResult>=2) score = WIN_FOR + player1Name;
        else score = WIN_FOR + player2Name;
        return score;
    }

    private String getOtherScore() {
        int tempScore;
        String score = "";
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = player1Score;
            else {
                score += DASH; tempScore = player2Score;
            }
            switch(tempScore)
            {
                case 0:
                    score += LOVE;
                    break;
                case 1:
                    score += FIFTEEN;
                    break;
                case 2:
                    score += THIRTY;
                    break;
                case 3:
                    score += FORTY;
                    break;
            }
        }
        return score;
    }
}