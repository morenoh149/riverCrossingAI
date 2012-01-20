import java.util.Collections;
import java.util.Collection;
import java.util.List;


public class State {
	private List<Integer> start;	//southbank
	private List<Integer> goal;		//northbank
	private boolean atStart;		//true if boat is on the southern bank
	
	/**
	 * makes a new state
	 * @param start a list of the meatbag weights on the start side
	 * @param goal a list of the meatbag weights of the goal side
	 * @param atStart if the boat is at the start side
	 */
	public State(List<Integer> start, List<Integer> goal, boolean atStart){
		this.start = start;
		this.goal = goal;
		this.atStart = atStart;
	}
	/**
	 * UNUSED
	 */
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
	
	/**
	 * this function will test to see if the states are equal
	 * @param state the state to compare to
	 * @return boolean of equality
	 */
	public boolean equals(State state){
		List<Integer> goal1, goal2, start1, start2;
		goal1=this.goal;
		goal2=state.goal;
		start1=this.start;
		start2=state.start;
		if(this.atStart==state.atStart){
			for(Integer i: goal1){
				goal2.remove(1);
				goal1.remove(i);
			}
			if(goal1.isEmpty()&&goal2.isEmpty()){
				for(Integer k: start1){
					start2.remove(k);
					start1.remove(k);
				}
				if(start1.isEmpty()&&start2.isEmpty()){
					return true;
				}
			}
		}
		return false;	
	}
	
	/**
	 * Updates the state by moving the indicated meatbags identified by weight
	 * @param moved an array list of the meatbag wieghts to be moved
	 * @return the update state with the meat bags and boat moved.
	 */
	public State update(List<Integer> moved){
		for(Integer i: moved){
			if(atStart){
				this.start.remove(i);
				this.goal.add(i);
			}else{
				this.goal.remove(i);
				this.start.add(i);
			}
		}
		this.atStart = !this.atStart;
		return this;
	}
	
	/**
	 * returns the atStart variable indicating where the boat is
	 * @return atStart| really, you needed to read this comment?
	 */
	public boolean getAtStart(){
		return this.atStart;
	}
}
