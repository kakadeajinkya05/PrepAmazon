package TernarySearchTrie;

import java.util.ArrayList;
import java.util.List;

public class TSTEXam {

	TSTNode root;

	class TSTNode {
		char c;
		int value;
		TSTNode left, mid, right;
	}

	public void put(String key, int value) {
		root = put(root, key, value, 0);
	}

	private TSTNode put(TSTNode node, String key, int value, int index) {
		char c = key.charAt(index);
		if (node == null) {
			node = new TSTNode();
			node.c = c;
		} 
		if (node.c > c) {
			node.left = put(node.left, key, value, index);
		} else if (node.c < c) {
			node.right = put(node.right, key, value, index);
		} else if (index < key.length() - 1) {
			node.mid = put(node.mid, key, value, index + 1);
		} 
		if(index == key.length()-1){
			node.value = value;
		}
		return node;
	}
	
	public boolean contains(String query){
		boolean result = true;
		if(get(query)== -1){
			result = false;
		}
		return result;
	}
	
	public int get(String key) {
		int result = -1;
		TSTNode node = get(root, key, 0);
		if (node != null) {
			result = node.value;
		}
		return result;
	}

	private TSTNode get(TSTNode node, String key, int index) {
		if(node == null ){
			return null;
		}
		char c   =  key.charAt(index);
		if (node.c > c ){
			return get(node.left,key,index);
		}
		else if ( node.c < c){
			return get(node.right,key,index);
		}
		else if(index < key.length()-1){
			return get(node.mid, key,index +1);
		}
		else {
			return node;
		}
	}
	
	public List<String> getByPrefix(String prefix){
		List<String> result = new ArrayList<>();
		TSTNode node = get(root,prefix,0);
		if(node == null) {
			return null;
		}
		if(node.value != 0){
			result.add(prefix);
		}
		collectAll(node.mid, new StringBuilder(prefix), result);
		return result;
	}
 

	private void collectAll(TSTNode node, StringBuilder prefix, List<String> results) {
		if (node == null || prefix == null || results == null) {
		      return;
		}
		collectAll(node.left, prefix, results);
		if(node.value != 0){
			results.add(prefix.toString()+node.c);
		}
		prefix.append(node.c);
		collectAll(node.mid, prefix, results);
		prefix.deleteCharAt(prefix.length()-1);
		collectAll(node.right, prefix, results);
		
	}

}
