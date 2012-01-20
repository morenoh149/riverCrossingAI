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
		int numOfNodesExpanded=1;
		int totalCost=0;
		while(notSolved){
			if(frontier.isEmpty()){
				notSolved=false;
			}
			else{
				this.currentNode = frontier.poll();
				numOfNodesExpanded++;
//				System.out.println(currentNode.getState().toString());
			}
			if(currentNode.getState().equals(goalState)){
				notSolved=true;
				break;
			}
			else{
				frontier.addAll(currentNode.expand());
			}
		}
		totalCost = currentNode.getCost();
		while(solutionCTL){
			sb.append(currentNode.toString()+"\n");
//			System.out.println("instance cost:"+currentNode.getCost());
			if(currentNode.getParent()==null){
				solutionCTL=false;
				break;
			}
			else{
				currentNode = currentNode.getParent();
			}
		}
		sb.insert(0, numOfNodesExpanded+" \n");
		sb.insert(0, "BFS "+totalCost+" ");
		result = sb.toString();
		System.out.println(result);
	}
}
