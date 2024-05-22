/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package climbingtheleaderboard;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Slime nightmare
 */
public class ClimbingTheLeaderboard {
 public static int[] climbingLeaderboard(int[] ranked, int[] player) {
    // Write your code here
        int[]result = new int[player.length];        
        
        TreeSet<Integer> scoresSet = new TreeSet<>();
        
        Integer[] integerRanked = Arrays.stream(ranked).boxed().toArray(Integer[]::new);
        scoresSet.addAll(Arrays.asList(integerRanked));
        for(int i = 0; i< player.length; i++){
            int playerScore = player[i];
            scoresSet.add(playerScore);
            int rankOfPlayer = scoresSet.tailSet(playerScore).size();
            result[i] = rankOfPlayer;
        }
       
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        
        int m = scanner.nextInt();
        int[] alice = new int[m];
        for (int i = 0; i < m; i++) {
            alice[i] = scanner.nextInt();
        }
        
        int[] result = climbingLeaderboard(scores, alice);
        for (int rank : result) {
            System.out.println(rank);
        }
        
        scanner.close();
    }
    
}
