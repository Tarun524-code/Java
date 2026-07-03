import java.util.Scanner;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
    int childCount = 0; 
}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.childCount++;
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public String getLongestCommonPrefix() {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        while (curr != null && !curr.isEndOfWord && curr.childCount == 1) {
            int nextIndex = -1;
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    nextIndex = i;
                    break;
                }
            }
            if (nextIndex == -1) break;
            
            char ch = (char) ('a' + nextIndex);
            prefix.append(ch);
            curr = curr.children[nextIndex];
        }
        return prefix.toString();
    }
}

public class Longestprefix {
    public static String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) return "";
        
        Trie trie = new Trie();
        for (String word : words) {
            if (word.isEmpty()) return ""; 
            trie.insert(word);
        }
        return trie.getLongestCommonPrefix();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        
        String[] strings = new String[n];
        System.out.println("Enter the words (lowercase only):");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        
        String result = longestCommonPrefix(strings);
        System.out.println("Longest Common Prefix: " + result);
        
        scanner.close();
    }
}
