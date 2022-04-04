package dp;

// flyweight

import java.util.HashMap;
import java.util.Map;

class Sentence
{

    private String[] words;
    private Map<Integer, WordToken> tokenMap = new HashMap<>();

    public Sentence(String plainText)
    {
        words = plainText.split(" ");
    }

    public WordToken getWord(int index)
    {
        tokenMap.put(index, new WordToken());
        return tokenMap.get(index);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for( int i = 0 ;i < words.length ; i++) {
            sb.append(tokenMap.containsKey(i) && tokenMap.get(i).capitalize ? words[i].toUpperCase() : words[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }

    class WordToken
    {
        public boolean capitalize;
    }
}
