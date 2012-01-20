package riverAI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class AStar {
	static public String search(State start, State goal){
		ArrayList<State> solution = null; //will hold the states that lead to the solution later
		boolean solutionCTL=true; //used to control a loop that builds the solution list
		Comparator<Node> comp = new Node();
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(1, comp); // holds the frontier (nodes that have not yet been expanded
		Node tree = new Node(0, null, start,null); // the base node of the tree (i.e. the start conditions)
		boolean notSolved=true; // a variable that controls the main search loop
		frontier.add(tree); // loads the root node into the frontier, this is needed due to the way the no solution case is handled
		List<Node> expanded; // this variable with hold the nodes that are expanded from the current node before they are loaded into the frontier
		Node Active=null; //this with hold the current node being looked at by the tree. it is loaded from the frontier
		int numOfNodesExpanded=1;
		int totalCost=0;
		while(notSolved){
			if(frontier.isEmpty()){
				notSolved = false;
			}else{
				Active = frontier.poll();
				numOfNodesExpanded++;
			}
			if(Active.getState().equals(goal)){
				notSolved=true;
				break;
			}else{
				expanded = Active.expand();
				for(Node n: expanded){
					frontier.add(n);
				}
			}
		}
		solution = new ArrayList<State>();
		totalCost = Active.getCost();
		while(solutionCTL){
			solution.add(Active.getState());
			if(Active.getParent()==null){
				solutionCTL=false;
				break;
			}else{
				Active = Active.getParent();
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("A* "+totalCost+" "+numOfNodesExpanded+"\n");
		for(State s : solution){
			sb.append(s.toString()+"\n");
		}
		return sb.toString();
	}

}
