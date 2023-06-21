package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    Map<Team, Integer> teamMap = new LinkedHashMap<>();

    teams.forEach(team -> {
      teamMap.put(team, team.sumTotalScore());
    });

    List<Map.Entry<Team, Integer>> sortedList = new ArrayList<>(teamMap.entrySet());
    sortedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

    Map<Team, Integer> sortedMap = new LinkedHashMap<>();
    for (Map.Entry<Team, Integer> entry : sortedList) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    
    if(teams.isEmpty()){
      System.out.println("The game hasn't started yet.");
    }else if(teams.get(0).getScores().isEmpty() &&
            teams.get(1).getScores().isEmpty() &&
            teams.get(2).getScores().isEmpty()){
            System.out.println("The game hasn't started yet.");

    }
    
    else{

      for(int i = 0; i < sortedList.size(); i++){
        int teamAPoints = sortedList.get(i).getValue();
        Team teamA = sortedList.get(i).getKey();

        if( i == 0 && (sortedList.get(i).getValue() > sortedList.get(i+1).getValue())){
          System.out.println("Now for the results, the WINNER is...");
          System.out.println("With "+teamAPoints+ " points, it's team "+ teamA.getPlayer1()+ " and "+ teamA.getPlayer2() +"!");
          System.out.println();
          
        }    

        if(i == 0  && (sortedList.get(i).getValue() ==  sortedList.get(i+1).getValue())){
         
          System.out.println("Now for the results, the WINNER is...");
          
            int teamBPoints = sortedList.get(i+1).getValue();
            Team teamB = sortedList.get(i+1).getKey();

            System.out.println("It's a TIE!");
            System.out.println("With "+teamAPoints+ " points, it's team "+ teamA.getPlayer1()+ " and "+ teamA.getPlayer2()+"!");
            System.out.println("With "+teamBPoints+ " points, it's team "+ teamB.getPlayer1()+ " and "+ teamB.getPlayer2()+"!");
            System.out.println();
            i+=2;

            if(i == 2 && teamBPoints > sortedList.get(2).getValue() ){
                System.out.println("Then we have... ");
                System.out.println("With "+sortedList.get(2).getValue()+ " points, it's team "+
                            sortedList.get(2).getKey().getPlayer1()+ " and "+
                            sortedList.get(2).getKey().getPlayer2()+"!\n");

            }
        }

        if( i==1 && (sortedList.get(i).getValue() >  sortedList.get(i+1).getValue())){
          int teamBPoints = sortedList.get(i+1).getValue();
          Team teamB = sortedList.get(i+1).getKey();
          System.out.println("Then we have... ");
          System.out.println("With "+teamAPoints+ " points, it's team "+ teamA.getPlayer1()+ " and "+ teamA.getPlayer2()+"!");
          System.out.println();
          System.out.println("Then we have... ");
          System.out.println("With "+teamBPoints+ " points, it's team "+ teamB.getPlayer1()+ " and "+ teamB.getPlayer2()+"!");
          System.out.println();
          
        }

          if( (i==1) && (sortedList.get(i).getValue() ==  sortedList.get(i+1).getValue())){
          int teamBPoints = sortedList.get(i+1).getValue();
          Team teamB = sortedList.get(i+1).getKey();
          System.out.println("Then we have... ");
          System.out.println("It's a TIE!");
          System.out.println("With "+teamAPoints+ " points, it's team "+ teamA.getPlayer1()+ " and "+ teamA.getPlayer2()+"!");
          System.out.println("With "+teamBPoints+ " points, it's team "+ teamB.getPlayer1()+ " and "+ teamB.getPlayer2()+"!");      
          System.out.println();
        }

        
      }

    }

  }
}