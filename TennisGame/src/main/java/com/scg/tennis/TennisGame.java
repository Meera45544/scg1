package com.scg.tennis;

import java.util.Arrays;
import java.util.List;

/**
 * Two Player TennisGame class
 * Default player names "Player1", "Player2" 
 * @author Meera
 *
 */
public class TennisGame {
	
	private List<String> pointsDescription = Arrays.asList("Love", "Fifteen", "Thirty", "Forty");
	private Player player1;
	private Player player2;
	
	
	public TennisGame() {	
		this.player1 = new Player("Player1");
	    this.player2 = new Player("Player2");
	}
	
	/**
	 * Set the player names 
	 * @param player1Name :Name of the first player
	 * @param player2Name :Name of the second player
	 */
    public void setPlayerNames(String player1Name, String player2Name){
    	player1.setName(player1Name);
    	player2.setName(player2Name);
    }
	
	/**
	 * Player owns a point by name.
	 * 
	 * @param playerName : player name (If no names set, Default names of players is
	 *                                  "Player1" and "Player2")
	 */
	public void wonPoint(String playerName){		
		if(playerName.equals(player1.getName())){
			player1.wonPoint();			
		} else if(playerName.equals(player2.getName())) {
			player2.wonPoint();
		} else {
			throw new IllegalArgumentException("Player is not available in game");
		}			
	}

	/**
	 * Gets score board 
	 *  
	 * @return score : Deuce(both equal and at least 4 points total) , Advantage(difference 1 and minimum 3 points) and win or (player1 score , player2 score).
	 */
	 public String getScore() {
		String score = null;
		if (player1.getScore() >= 3 && player2.getScore() >= 3) {
			if (player1.getScore() == player2.getScore()) {
				score = "Deuce";
			} else if (Math.abs(player2.getScore() - player1.getScore()) == 1) {
				score = "Advantage " + getLeadPlayerName();
			} else {
				score = "Win for " + getLeadPlayerName();
			}
		} else {
			score = player1.getName() + ":" + getDescription(player1) + ", " + player2.getName() + ":" + getDescription(player2);
		}
		return score;
	}


	private String getDescription(Player player) {
		if(player.getScore() <= 3)
		return pointsDescription.get(player.getScore());
		else {
			return  String.valueOf(player.getScore());
		}
	}

	private String getLeadPlayerName() {
		return (player1.getScore() > player2.getScore()) ? player1.getName() : player2.getName();
	}
	
	


}
