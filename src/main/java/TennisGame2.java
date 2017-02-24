
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Points = 0;
    
    public String convertToLiteralPlayer1Points = "";
    public String convertToLiteralPlayer2Points = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (player1Points == player2Points && player1Points < 4)
        {
            if (player1Points==0)
                score = "Love";
            if (player1Points==1)
                score = "Fifteen";
            if (player1Points==2)
                score = "Thirty";
            score += "-All";
        }
        if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
        
        if (player1Points > 0 && player2Points==0)
        {
            if (player1Points==1)
                convertToLiteralPlayer1Points = "Fifteen";
            if (player1Points==2)
                convertToLiteralPlayer1Points = "Thirty";
            if (player1Points==3)
                convertToLiteralPlayer1Points = "Forty";
            
            convertToLiteralPlayer2Points = "Love";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
        if (player2Points > 0 && player1Points==0)
        {
            if (player2Points==1)
                convertToLiteralPlayer2Points = "Fifteen";
            if (player2Points==2)
                convertToLiteralPlayer2Points = "Thirty";
            if (player2Points==3)
                convertToLiteralPlayer2Points = "Forty";
            
            convertToLiteralPlayer1Points = "Love";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
        
        if (player1Points>player2Points && player1Points < 4)
        {
            if (player1Points==2)
                convertToLiteralPlayer1Points="Thirty";
            if (player1Points==3)
                convertToLiteralPlayer1Points="Forty";
            if (player2Points==1)
                convertToLiteralPlayer2Points="Fifteen";
            if (player2Points==2)
                convertToLiteralPlayer2Points="Thirty";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
        if (player2Points>player1Points && player2Points < 4)
        {
            if (player2Points==2)
                convertToLiteralPlayer2Points="Thirty";
            if (player2Points==3)
                convertToLiteralPlayer2Points="Forty";
            if (player1Points==1)
                convertToLiteralPlayer1Points="Fifteen";
            if (player1Points==2)
                convertToLiteralPlayer1Points="Thirty";
            score = convertToLiteralPlayer1Points + "-" + convertToLiteralPlayer2Points;
        }
        
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
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