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
		currentNode = new Node(0, null, initialState, null);
		frontier = new LinkedList<Node>();
		frontier.add(currentNode);
		boolean notSolved=true;
		while(notSolved){
			if(frontier.isEmpty()){
				notSolved=false;
			}
			else{
				this.currentNode = frontier.poll();
				System.out.println(currentNode.getState().toString());
			}
			if(currentNode.getState().equals(goalState)){
				notSolved=true;
				getAncestry(currentNode);
			}
			else{
				frontier.addAll(currentNode.expand());
			}
		}
		System.out.println(result);
	}
	/**
	 * saves ancestry of the given node to result string
	 * @param currentNode
	 */
	public void getAncestry(Node givenNode){
		Node iNode = givenNode;
		State index = iNode.getState();
		StringBuilder sb = new StringBuilder();
		while(iNode!=null){
			sb.insert(0,index.toString());
			iNode = iNode.getParent();
		}
		result = sb.toString();
	}
}
