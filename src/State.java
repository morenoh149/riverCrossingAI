import java.util.Collections;
import java.util.Collection;
import java.util.List;


public class State {
	private List<Integer> start;	//southbank
	private List<Integer> goal;		//northbank
	private boolean atStart;		//true if boat is on the southern bank
	
	public State(List<Integer> start, List<Integer> goal, boolean atStart){
		this.start = start;
		this.goal = goal;
		this.atStart = atStart;
	}
	public int hashCode(){
		Integer hash = 0;
		int goalSum = 0;
		int goalCount =0;
		int startSum = 0;
		int startCount = 0;
		int boat = 0;
		for(Integer Is: start){
			startCount++;
			startSum = Is + startSum;
		}
		for(Integer Ig: goal){
			goalCount++;
			goalSum = Ig + goalSum;
		}
		if(atStart){
			boat = 1;
		}
		String prehash = Integer.toString(1).concat(Integer.toString(goalCount)).concat(Integer.toString(goalSum)).concat(Integer.toString(1)).concat(Integer.toString(startCount)).concat(Integer.toString(startSum)).concat(Integer.toString(1)).concat(Integer.toString(boat));
		hash = Integer.parseInt(prehash);
		return hash;
	}
	public boolean equals(State state){
		Collections.
		return equals;	
	}
}
