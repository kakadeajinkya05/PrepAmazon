package TernarySearchTrie;

public class App {
	public static void main(String[] args) {
		TSTEXam t = new TSTEXam();
		t.put("Abc", 5);
		t.put("Abd", 5);
		t.put("Abef", 5);
		t.put("Abf", 5);
		System.out.println(t.get("Abc"));
		
		System.out.println(t.getByPrefix("Ab"));
		//System.out.println(t.updatePrefix("abc", 'd'));
	}
}
