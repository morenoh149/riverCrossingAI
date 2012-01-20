package riverAI;
import java.util.*;

/**
 * searches the tree using Breadth first search
 * @author harry
 *
 */
public class BFS {
	private Node currentNode;
	private Queue<Node> frontier;
	private State goalState;
	private String result;

	/**
	 * initializes the BFS algorithm
	 * @param initialState
	 * @param goalState
	 */
	BFS(State initialState, State goalState){
		this.goalState = goalState;
		Node tree = new Node(0, null, initialState, null);
		frontier = new LinkedList<Node>();
		frontier.add(tree);
		boolean notSolved=true;
		boolean solutionCTL = true;
		StringBuilder sb = new StringBuilder();
		int i=0;
		while(notSolved && i<20){
			if(frontier.isEmpty()){
				notSolved=false;
			}
			else{
				this.currentNode = frontier.poll();
//				System.out.println(currentNode.getState().toString());
			}
			if(currentNode.getState().equals(goalState)){
				notSolved=true;
				break;
			}
			else{
				frontier.addAll(currentNode.expand());
			}
			i++;
		}
		while(solutionCTL){
			sb.insert(0,currentNode.toString()+"\n hi");
			if(currentNode.getParent()==null){
				solutionCTL=false;
				break;
			}
			else{
				currentNode = currentNode.getParent();
			}
		}
		result = sb.toString();
		System.out.println(result);
	}
}
