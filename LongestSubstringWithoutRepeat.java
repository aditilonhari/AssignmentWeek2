/*
Problem Statement : Given a string, find the length of the longest substring without repeating characters.
Example:
The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
For "bbbbb" the longest substring is "b", with the length of 1.
*/

public class Solution {
	public int lengthOfLongestSubstring(String a) {
	    
	    if(a == null)
	        return 0;
	        
	    HashSet<Character> uniqueElements = new HashSet<>();
	    int max_len = 0;
	    int start = 0; 
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
     
            if(!uniqueElements.contains(c)){
                uniqueElements.add(c);
     
                max_len = Math.max(max_len, i-start+1);
            }else{
                for(int j=start; j<i; j++){
                    uniqueElements.remove(a.charAt(j));
     
                    if(a.charAt(j)==c){
                        start=j+1;
                        break;    
                    }
                }        
     
                uniqueElements.add(c);
            }
        }
	        
	    return max_len;
	}
}

