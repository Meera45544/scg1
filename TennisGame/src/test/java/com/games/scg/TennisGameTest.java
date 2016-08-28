package com.games.scg;

import org.junit.Assert;
import org.junit.Test;

import com.scg.tennis.TennisGame;

public class TennisGameTest {
	
	private static final String PLAYER2_NAME = "Player2";
	private static final String PLAYER1_NAME = "Player1";

	@Test
	public void setLoveOnGameStart() {
		TennisGame game = new TennisGame();
		Assert.assertEquals("Player1:Love, Player2:Love", game.getScore());		
	}
	
	@Test
	public void setPlayerNames() {
		TennisGame game = new TennisGame();
		game.setPlayerNames("Meera", "General");
		Assert.assertEquals("Meera:Love, General:Love", game.getScore());		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidPlayerNameWonPoint() {
		TennisGame game = new TennisGame();	
		game.wonPoint("Player3");
	}
	
	
	@Test
	public void Player1WonPointDisplayFifteen() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		Assert.assertEquals("Player1:Fifteen, Player2:Love", game.getScore());		
	}
	
	@Test
	public void Player1WonTwoPointDisplayThirty() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		Assert.assertEquals("Player1:Thirty, Player2:Love", game.getScore());		
	}
	
	@Test
	public void Player1WonThreePointDisplayForty() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		Assert.assertEquals("Player1:Forty, Player2:Love", game.getScore());		
	}

	@Test
	public void Player2WonPointDisplayFifteen() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Player1:Love, Player2:Fifteen", game.getScore());		
	}
	
	@Test
	public void Player2WonTwoPointDisplayThirty() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Player1:Love, Player2:Thirty", game.getScore());		
	}
	

	@Test
	public void Player2WonThreePointDisplayForty() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Player1:Love, Player2:Forty", game.getScore());		
	}
	
	
	
	@Test
	public void showDueceIfBothPlayerScoreEqualsAndScoreGraterthan3() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Deuce", game.getScore());		
	}
	
	@Test
	public void showAdvantagePlayer1PointsDiffernceIsOneAndGraterthan3() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Advantage Player1", game.getScore());		
	}
	
	@Test
	public void showAdvantagePlayer2PointsDiffernceIsOneAndGraterthan3() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Advantage Player2", game.getScore());		
	}
	
	@Test
	public void WonGamePlayersPointsDiffernceIsGraterThan2AndMinimumPointsGraterThan4() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Win for Player1", game.getScore());		
	}
	
	@Test
	public void WonGamePlayer2If2PointsMoreThanPlayer1Andplayer2PointsGraterThan4() {
		TennisGame game = new TennisGame();
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER1_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		game.wonPoint(PLAYER2_NAME);
		Assert.assertEquals("Win for Player2", game.getScore());		
	}
}
