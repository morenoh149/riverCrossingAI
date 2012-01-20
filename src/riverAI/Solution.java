package riverAI;
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int numOfPpl=0;
		List<Integer> weights = new ArrayList<Integer>();
		try{
			FileInputStream fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			Scanner s = new Scanner(br);
			numOfPpl = s.nextInt();
			for(int i=0; i<numOfPpl; i++){
				weights.add(s.nextInt());
			}
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		if(numOfPpl==1){
			System.out.println("BFS "+weights.get(0)+" 0");
			System.out.println("DFS "+weights.get(0)+" 0");
			System.out.println("A*  "+weights.get(0)+" 0");
		}
		else{
			try{
				// Create file 
				FileWriter fstream = new FileWriter("output.txt");
				BufferedWriter out = new BufferedWriter(fstream);
				ArrayList<Integer> dummy = new ArrayList<Integer>();
				State init = new State(weights, dummy, true);
				State goal = new State(dummy, weights, false);
				BFS bfs = new BFS(init, goal);
				out.write(bfs.toString());
				out.write(DFS.search(init, goal));
				out.write(AStar.search(init, goal));
				
				//Close the output stream
				out.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
