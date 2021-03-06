package riverAI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * this class does cool stuff. it is a generalized Depth first searching class that works with the node and state class defined in this package to 
 * find solutions to state space problems. to change the functionality of this only the state class and expand function need to change.
 * @author ben LEONE
 * @author Harry Moreno
 *
 */
public class DFS {

	/**
	 * searches a tree to find a solution through depth first searching
	 * @param start the starting state
	 * @param goal the goal state
	 * @return a list of all the states made to reach the solution or null in no solution was found
	 */
	static public String search(State start, State goal){
		ArrayList<State> solution = null; //will hold the states that lead to the solution later
		boolean solutionCTL=true; //used to control a loop that builds the solution list
		Stack<Node> frontier = new Stack<Node>(); // holds the frontier (nodes that have not yet been expanded
		Node tree = new Node(0, null, start,null); // the base node of the tree (i.e. the start conditions)
		boolean notSolved=true; // a variable that controls the main search loop
		frontier.push(tree); // loads the root node into the frontier, this is needed due to the way the no solution case is handled
		List<Node> expanded; // this variable with hold the nodes that are expanded from the current node before they are loaded into the frontier
		Node Active=null; //this with hold the current node being looked at by the tree. it is loaded from the frontier
		int numOfNodesExpanded=1;
		int totalCost=0;
		while(notSolved){
			if(frontier.isEmpty()){
				notSolved = false;
			}else{
				Active = frontier.pop();
				numOfNodesExpanded++;
			}
			if(Active.getState().equals(goal)){
				notSolved=true;
				break;
			}else{
				expanded = Active.expand();
				for(Node n: expanded){
					frontier.push(n);
				}
			}
		}
		solution = new ArrayList<State>();
		totalCost = Active.getCost();
		while(solutionCTL){
//			System.out.println(Active.getState().toString());
			solution.add(Active.getState());
			if(Active.getParent()==null){
				solutionCTL=false;
				break;
			}else{
				Active = Active.getParent();
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("DFS "+totalCost+" "+numOfNodesExpanded+"\n");
		for(State s : solution){
			sb.append(s.toString()+"\n");
		}
		return sb.toString();
	} 
}
