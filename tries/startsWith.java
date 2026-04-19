import java.util.*;
public class basic{
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;
    
        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }
    public static Node root = new Node();
    
    public static void insert(String word){
        Node curr = root;
        for(int level = 0; level<word.length(); level++){
            int idx  = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

     public static boolean search(String key){
        Node curr = root;
        for(int level = 0; level<key.length(); level++){
            int idx  = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
  
    public static boolean startWith(String prefix){//t.c -> O(l)
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    
   
    public static void main(String args[]){
        String word[] = {"apple","app","woman","man","mango"};
        String prefix1 = "app";
        String prefix2 = "moon";

        for(int i=0; i<word.length; i++){
            insert(word[i]);
        }
        System.out.println(startWith(prefix1));
        System.out.println(startWith(prefix2));

    }
}
