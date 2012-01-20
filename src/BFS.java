import java.util.*;

/**
 * searches the tree using Breadth first search
 * @author harry
 *
 */
public class BFS {
	private Node currentNode;
	private Queue frontier;
	BFS(State initialState, State goalState){
		currentNode = new Node(0, null, initialState, null);
		frontier = new LinkedList<Node>();
	}
}
