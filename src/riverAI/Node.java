package riverAI;
import java.util.*;

/**
 * Our tree is a collection of Nodes. The search strategy loosely keeps track of it's own location
 * in the tree by traversing node by node.
 * @author harry moreno
 * @author ben leone
 */
public class Node implements Comparator<Node>{
	private int cost;					//the heaviest person that is in the boat
	private int time;
	private State state;
	private Node parent;
	private int estimate;              //this servers as F(state) for the A* search
	private List<Node> children;
	private List<Integer> moved;

	Node(){
		this.state = null;
	}
	Node(int cost, Node parent, State state, List<Integer> moved){
		this.parent = parent;
		this.cost = cost;
		this.children = new ArrayList<Node>();
		this.state = state;
		this.moved = moved;
		if(moved!=null){
			this.state = this.state.update(moved);
			int max = 0;
			for(Integer i: moved){
				if(i>max){
					max = i;
				}
			}
			this.cost = cost + max;
		}
		int max = 0;
		for(int i: this.state.getSouthBank()){
			if(i> max){
				max=i;
			}
		}
		//A* notes
		estimate = max + cost; //max is our h(n) cost is the g(n) and estimate is our f(n)
	}
	public int getCost(){
		return cost;
	}
	public void addChild(Node child){
		children.add(child);
	}
	/**
	 * expands the current node, for the southbank, create all combinations of ppl and
	 * branch, for northbank branch on each person
	 */
	public List<Node> expand(){
		if(state.getAtStart()){
			List<List<Integer>> pairs =  new ArrayList<List<Integer>>();
			List<Integer> copy = new ArrayList<Integer>(state.getSouthBank());
			if(state.getSouthBank().size()==1){									//if one person on south side
				for(Integer i: state.getSouthBank()){
					List<Integer> tuple = new ArrayList<Integer>();
					tuple.add(i);
					Boolean t = state.getAtStart();
					State copyState = new State(new ArrayList<Integer>(state.getSouthBank()),
							new ArrayList<Integer>(state.getNorthBank()),
							t);
					Node child = new Node(this.getCost(), this, copyState, tuple);
					children.add(child);
				}
			}
			else{																//if >1 person on south side
				for(Integer i: state.getSouthBank()){
					copy.remove(i);
					for(Integer j: copy){
						List<Integer> tuple = new ArrayList<Integer>();
						tuple.add(i);
						tuple.add(j);
						pairs.add(tuple);
					}
				}
				for(List<Integer> p: pairs){
					//System.out.println(p.toString());
					Boolean t = state.getAtStart();
					State copyState = new State(new ArrayList<Integer>(state.getSouthBank()),
							new ArrayList<Integer>(state.getNorthBank()),
							t);
					Node child = new Node(this.getCost(), this, copyState, p);
					children.add(child);
				}
			}
		}
		else{																	//if on north side
			ArrayList<Integer> copy = new ArrayList<Integer>(state.getNorthBank());
			for(Integer i: copy){
				List<Integer> tuple = new ArrayList<Integer>();
				tuple.add(i);
				Boolean t = state.getAtStart();
				State copyState = new State(new ArrayList<Integer>(state.getSouthBank()),
						new ArrayList<Integer>(state.getNorthBank()),
						t);
				Node child = new Node(this.getCost(), this, copyState, tuple);
				children.add(child);
			}
		}
		return children;
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
	public State getState(){
		return this.state;
	}
	public List<Integer> getMoved(){
		return this.moved;
	}
	public String toString(){
		return this.state.toString();
	}
	public int getEstimate(){
		return this.estimate;
	}
	@Override
	public int compare(Node n1, Node n2) {
		int result = 0;
		if(n1.getEstimate() <= n2.getEstimate()){
			result = -1;
		}
		else{
			result = 1;
		}
		return result;
	}
}
