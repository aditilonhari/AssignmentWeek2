/*
Problem Statement : You are given a string, S, and a list of words, L, that are all of the same length.
Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters. (order does not matter).

Example :
S: "barfoothefoobarman"    L: ["foo", "bar"]      
You should return the indices: [0,9].
*/

public class Solution {
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    
	    ArrayList<Integer> indices = new ArrayList<Integer>();
        if (b.size() == 0) 
            return indices;
        // notice: all the same length
        int total = b.size(), wordLen = b.get(0).length();
        // Store the words and frequences in a hash table for L array
        HashMap<String, Integer> words = new HashMap<String, Integer>();
        for (String s : b) {
            if(words.containsKey(s)) 
                words.put(s, words.get(s) + 1);
            else 
                words.put(s, 1);
        }
        // find the concatenations
        for (int i = 0; i <= a.length() - total * wordLen; i++) {
            // check if it is a concatenation
            HashMap<String, Integer> target = new HashMap<String, Integer>(words);
            for (int j = i; j <= a.length() - wordLen && !target.isEmpty(); j += wordLen) {
                String sub = a.substring(j, j + wordLen);
                if(!target.containsKey(sub))
                    break;
                else if (target.get(sub) > 1) {
                    // reduce the frequency
                    target.put(sub, target.get(sub) - 1);
                } else {
                    // remove the word if only one left
                    target.remove(sub);
                }
            }
            if (target.isEmpty()) {
                indices.add(i);
            }
        }
        return indices;
	}
}

