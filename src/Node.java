import java.util.*;

/**
 * Our tree is a collection of Nodes. The search strategy loosely keeps track of it's own location
 * in the tree by traversing node by node.
 * @author harry moreno
 * @author ben leone
 */
public class Node {
	private int cost;					//the heaviest person that is in the boat
	private State state;
	private Node parent;
	private List<Node> children;

	Node(int cost, Node parent, State state){
		this.parent = parent;
		this.cost = cost;
		this.children = new ArrayList<Node>();
		this.state = state;
		
	}
	public void addChild(Node child){
		children.add(child);
	}
	/**
	 * returns null if no child with the given cost exists
	 * @param cost
	 * @return
	 */
	public Node getChild(int cost){
		Node result=null;
		for(Node n: children){
			if(n.cost==cost){
				result=n;
			}
		}
		return result;
	}
	public Node getParent(){
		return parent;
	}
	public int hashCode(Node node){
		return node.state.hashCode();
	}
}
