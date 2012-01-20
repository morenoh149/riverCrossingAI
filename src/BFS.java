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
		search(frontier);
	}
	
	/**
	 * searches the frontier in FIFO order
	 * @param frontier
	 */
	public void search(Queue<Node> frontier){
		this.currentNode = frontier.poll();
		if(currentNode.getState().equals(goalState)){
			getAncestry(currentNode);
		}
		else{
			frontier.addAll(currentNode.expand());
			search(frontier);
		}
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
