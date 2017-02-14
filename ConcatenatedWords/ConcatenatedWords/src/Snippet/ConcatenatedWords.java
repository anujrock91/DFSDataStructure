package Snippet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class ConcatenatedWords {
	
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		if(words.length == 0 || words.length==1){ return new ArrayList<>(); }
        ArrayList<String> result = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        for(String word: words){
        	set.add(word);
        	maxLen = Math.max(maxLen, word.length());
        }
        getList(words, "", set, maxLen, 0,result);
        return result;
    }
	
	public void getList(String[] words, String pString, HashSet<String> set, int maxLength, int level, ArrayList<String> result){
		for(int i=0;i<words.length;i++){
			String derived = pString+words[i];
			//if(words[i] == ""){ continue; }
			if(derived.length() > maxLength || level > maxLength){ continue; }// if the concatenation has resulted in a word whose length > max
			if(level!=0 && set.contains(derived)){
				result.add(derived);
			}
			getList(words, derived, set, maxLength, level+1, result);
		}
	}
	
	
	public static void main(String args[]){
		System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(
				new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}
				));
	}
	
}
