package Trie_datastructure;
import java.util.Scanner;
class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;
    int prefixCount;
    int wordCount;
    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        prefixCount = 0;
        wordCount = 0;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            curr.prefixCount++;
        }
        curr.isEndOfWord = true;
        curr.wordCount++;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }
        return true;
    }

    public int prefixCount(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null)
                return 0;

            curr = curr.children[index];
        }
        return curr.prefixCount;
    }
    public int searchCount(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null)
                return 0;

            curr = curr.children[index];
        }
        return curr.wordCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie trie = new Trie();
        while (true) {
            System.out.println("\n===== TRIE MENU =====");
            System.out.println("1. Add String");
            System.out.println("2. Search String");
            System.out.println("3. Search Prefix");
            System.out.println("4. Count String");
            System.out.println("5. Count Prefix");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter string: ");
                    String str = sc.nextLine().toLowerCase();
                    trie.insert(str);
                    System.out.println("String added successfully.");
                    break;

                case 2:
                    System.out.print("Enter string to search: ");
                    str = sc.nextLine().toLowerCase();

                    if (trie.search(str))
                        System.out.println("String Found.");
                    else
                        System.out.println("String Not Found.");
                    break;

                case 3:
                    System.out.print("Enter prefix: ");
                    str = sc.nextLine().toLowerCase();

                    if (trie.startsWith(str))
                        System.out.println("Prefix Exists.");
                    else
                        System.out.println("Prefix Not Found.");
                    break;

                case 4:
                    System.out.print("Enter string: ");
                    str = sc.nextLine().toLowerCase();
                    System.out.println("String Count = " + trie.searchCount(str));
                    break;

                case 5:
                    System.out.print("Enter prefix: ");
                    str = sc.nextLine().toLowerCase();

                    System.out.println("Prefix Count = " + trie.prefixCount(str));
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}