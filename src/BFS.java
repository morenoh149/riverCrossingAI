import java.util.*;

/**
 * searches the tree using Breadth first search
 * @author harry
 *
 */
public class BFS {
	BFS(Node root, List<Integer> ppl){
		Queue<int[]> pairs = new LinkedList<int[]>();
		List<Integer> copy = new ArrayList<Integer>(ppl);
		for(Integer i : ppl){
			copy.remove(i);
			for(Integer j: copy){
				int[] tuple = new int[]{i,j};
				pairs.add(tuple);
			}
		}
		
	}
}
