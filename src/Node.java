import java.util.*;

/**
 * Our tree is a collection of Nodes. The search strategy loosely keeps track of it's own location
 * in the tree by traversing node by node.
 * @author harry moreno
 * @author ben leone
 */
public class Node {
	private int cost;					//the heaviest person that is in the boat
	private Node parent;
	private List<Node> children;
	private List<Integer> northBank;	
	private List<Integer> southBank;

	Node(int cost, Node parent){
		this.parent = parent;
		this.cost = cost;
		this.children = new ArrayList<Node>();
		this.northBank = new ArrayList<Integer>();
		this.southBank = new ArrayList<Integer>();
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
}
