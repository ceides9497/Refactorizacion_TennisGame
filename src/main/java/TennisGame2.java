
public class TennisGame2 implements TennisGame
{
    private static final int _FORTY = 3;
	private static final int _THIRTY = 2;
	private static final int _FIFTEEN = 1;
	private static final int _LOVE = 0;
	private static final int _MATCHPOINT = 4;
	public int player1Points = 0;
    public int player2Points = 0;
    
    public String convertToLiteralPlayer1Points = "";
    public String convertToLiteralPlayer2Points = "";
    
    public TennisGame2(String player1Name, String player2Name) {}

    public String getScore(){
        String score = "";
        int player1Points2 = player1Points;
		int player2Points2 = player2Points;
		score = tiedAndNotDeuce(score, player1Points2, player2Points2);        
        score = winningPlayer(score, player1Points2, player2Points2);        
        score = winingPlayerIsNotDeuce(score, player1Points2, player2Points2);        
        score = playerAdvantage(score, player1Points2, player2Points2);        
        score = winForPlayer1OrPlayer2(score, player1Points2, player2Points2);
        return score;
    }

	private String winingPlayerIsNotDeuce(String score, int player1Points2, int player2Points2) {
		if (player1Points2>player2Points2 && player1Points2 < _MATCHPOINT)
        {
            score = thirty_forty_or_fifteen_for_player1(player1Points2, player2Points2);
        }
        if (player2Points2>player1Points2 && player2Points2 < _MATCHPOINT)
        {
            score = thirty_forty_or_fifteen_for_player2(player1Points2,	player2Points2);
        }
		return score;
	}

	private String thirty_forty_or_fifteen_for_player2(int player1Points2, int player2Points2) {
		String score;
		if (player2Points2==_THIRTY)
		    convertToLiteralPlayer2Points="Thirty";
		if (player2Points2==_FORTY)
		    convertToLiteralPlayer2Points="Forty";
		if (player1Points2==_FIFTEEN)
		    convertToLiteralPlayer1Points="Fifteen";
		if (player1Points2==_THIRTY)
		    convertToLiteralPlayer1Points="Thirty";
		score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
		return score;
	}

	private String thirty_forty_or_fifteen_for_player1(int player1Points2, int player2Points2) {
		String score;
		if (player1Points2==_THIRTY)
		    convertToLiteralPlayer1Points="Thirty";
		if (player1Points2==_FORTY)
		    convertToLiteralPlayer1Points="Forty";
		if (player2Points2==_FIFTEEN)
		    convertToLiteralPlayer2Points="Fifteen";
		if (player2Points2==_THIRTY)
		    convertToLiteralPlayer2Points="Thirty";
		score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
		return score;
	}

	private String winningPlayer(String score, int player1Points2, int player2Points2) {
		if (player1Points2 > _LOVE && player2Points2==_LOVE)
        {
            if (player1Points2==_FIFTEEN)
                convertToLiteralPlayer1Points = "Fifteen";
            if (player1Points2==_THIRTY)
                convertToLiteralPlayer1Points = "Thirty";
            if (player1Points2==_FORTY)
                convertToLiteralPlayer1Points = "Forty";
            
            convertToLiteralPlayer2Points = "Love";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
        if (player2Points2 > _LOVE && player1Points2==_LOVE)
        {
            if (player2Points2==_FIFTEEN)
                convertToLiteralPlayer2Points = "Fifteen";
            if (player2Points2==_THIRTY)
                convertToLiteralPlayer2Points = "Thirty";
            if (player2Points2==_FORTY)
                convertToLiteralPlayer2Points = "Forty";
            
            convertToLiteralPlayer1Points = "Love";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
		return score;
	}

	private String tiedAndNotDeuce(String score, int player1Points2, int player2Points2) {
		if (player1Points2 == player2Points2 && player1Points2 < _MATCHPOINT)
        {
            if (player1Points2==_LOVE)
                score = "Love";
            if (player1Points2==_FIFTEEN)
                score = "Fifteen";
            if (player1Points2==_THIRTY)
                score = "Thirty";
            score += "-All";
        }
        if (player1Points2==player2Points2 && player1Points2>=_FORTY)
            score = "Deuce";
		return score;
	}

	private String winForPlayer1OrPlayer2(String score, int player1Points2, int player2Points2) {
		if (player1Points2>=_MATCHPOINT && player2Points2>=0 && (player1Points2-player2Points2)>=_THIRTY)
        {
            score = "Win for player1";
        }
        if (player2Points2>=_MATCHPOINT && player1Points2>=0 && (player2Points2-player1Points2)>=_THIRTY)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String playerAdvantage(String score, int player1Points2, int player2Points2) {
		if (player1Points2 > player2Points2 && player2Points2 >= _FORTY)
        {
            score = "Advantage player1";
        }
        
        if (player2Points2 > player1Points2 && player1Points2 >= _FORTY)
        {
            score = "Advantage player2";
        }
		return score;
	}
    
    public void setPlayer1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player1Scores();
        }
            
    }
    
    public void setPlayer2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            player2Scores();
        }
            
    }
    
    public void player1Scores(){
        player1Points++;
    }
    
    public void player2Scores(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            player1Scores();
        else
            player2Scores();
    }
}