package TRIE;
class Main
{
    public static void main(String args[])
    {
        Trie trie = new Trie();
 
        String contacts [] = {"gforgeeks", "geeksquiz"};
 
        trie.insertIntoTrie(contacts);
 
        String query = "gekk";
 
        // Note that the user will enter 'g' then 'e' so
        // first display all the strings with prefix as 'g'
        // and then all the strings with prefix as 'ge'
        trie.displayContacts(query);
    }
}