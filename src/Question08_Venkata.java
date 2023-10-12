package src;

import java.util.Date;

public class Question08_Venkata {
	public static void main(String[] args) {
		String[] team1Players = {
				"Rohit Sharma", "Shubman Gill", "Virat Kohli", "KL Rahul", "Ishan Kishan",
				"Hardik Pandya", "Ravindra Jadeja", "Washington Sundar", "Kuldeep Yadav",
				"Mohammed Siraj", "Jasprit Bumrah"
		};

		String[] team2Players = {
				"Pathum Nissanka", "Kusal Perera", "Kusal Mendis", "Sadeera Samarawickrama",
				"Charith Asalanka", "Dhananjaya de Silva", "Dasun Shanaka", "Dunith Wellalage",
				"Dushan Hemantha", "Pramod Madushan", "Matheesha Pathirana"
		};

		Team team1 = new Team("India", team1Players);
		Team team2 = new Team("Sri Lanka", team2Players);

		// Simulate the toss
		double toss = Math.random() * 10;
		if (toss < 1) {
			System.out.println("Toss Won By SL (src.Team 0)");
			playMatch(team2, team1);
		} else {
			System.out.println("Toss Won By India (src.Team 1)");
			playMatch(team1, team2);
		}
	}

	private static void playMatch(Team battingTeam, Team bowlingTeam) {
		System.out.println(battingTeam.getName() + " - Batting Scoresheet");
		battingTeam.playInnings();

		System.out.println("\n" + bowlingTeam.getName() + " — Batting Scoresheet");
		bowlingTeam.playInnings();

		String matchResult = battingTeam.getTotalScore() > bowlingTeam.getTotalScore()
				? battingTeam.getName()
				: (battingTeam.getTotalScore() < bowlingTeam.getTotalScore() ? bowlingTeam.getName() : "Match Tied");
		int runDifference = Math.abs(battingTeam.getTotalScore() - bowlingTeam.getTotalScore());
		System.out.println("\nMatch Result: " + matchResult + " Won By " + runDifference + " Runs");
		System.out.println("Today's Date: " + new Date());
	}
}

class Team {
	private String name;
	private String[] players;
	private int totalScore;

	public Team(String name, String[] players) {
		this.name = name;
		this.players = players;
		this.totalScore = 0;
	}

	public String getName() {
		return name;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void playInnings() {
		int totalBalls = 0;
		int totalExtras = 0;
		for (String player : players) {
			Player p = new Player(player);
			p.playInnings();
			totalScore += p.getTotalRuns();
			totalBalls += p.getBallsBowled();
			totalExtras += p.getExtras();
			p.displayScore();
		}

		double totalOvers = totalBalls / 6;
		System.out.println("Extras " + totalExtras);
		System.out.println("Total Score " + totalScore + " in " + totalOvers + " overs");
	}
}

class Player {
	private String playerName;
	private int totalRuns;
	private int extras;
	private int ballsBowled;
	private int[] runsPerBall;

	public Player(String playerName) {
		this.playerName = playerName;
		this.totalRuns = 0;
		this.extras = 0;
		this.ballsBowled = 0;
		this.runsPerBall = new int[60];
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public int getExtras() {
		return extras;
	}

	public int getBallsBowled() {
		return ballsBowled;
	}

	public void playInnings() {
		int ballsBowled = 0;
		int extras = 0;
		int totalRuns = 0;

		for (int i = 0; i < 60; i++) {
			int run = (int) (Math.random() * 10) % 8;
			ballsBowled++;
			totalRuns += run;

			if (run == 7) {
				extras++;
				run = 1;  // Convert a 7 into a 1
			} else if (run == 0) {
				break;
			}

			runsPerBall[i] = run;
		}

		this.ballsBowled = ballsBowled;
		this.extras = extras;
		this.totalRuns = totalRuns;
	}

	public void displayScore() {
		System.out.print(playerName + " " + ballsBowled + " (");
		for (int i = 0; i < runsPerBall.length; i++) {
			System.out.print(runsPerBall[i]);
			if (runsPerBall[i] == 0) {
				break;
			}
			System.out.print(", ");
		}
		System.out.println(") = " + totalRuns + " (" + extras + " extra)");
	}
}
