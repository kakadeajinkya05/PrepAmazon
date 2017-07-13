package TrieExample;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	TrieNode root ;
	class TrieNode{
		public Map<Character,TrieNode> childs;
		public boolean isLast;
	}
	
	void put(String key){
		put(root, key,0);
	}

	private void put(TrieNode root, String key, int index) {
		char c = key.charAt(index);
		if(root == null){
			root = new TrieNode();
			
		}
	}
}
