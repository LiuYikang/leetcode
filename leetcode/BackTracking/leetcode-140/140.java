class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return helper(s, wordDict, map);
    }

    private List<String> helper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict.toArray(new String[wordDict.size()])) {
            if (word.length() > s.length()) {
                continue;
            }
            if (s.substring(0, word.length()).compareTo(word) != 0) {
                continue;
            }
            List<String> rem = helper(s.substring(word.length()), wordDict, map);
            for (String str : rem.toArray(new String[rem.size()])) {
                String tmp = word + ((str.length() == 0) ? "" : " ") + str;
                res.add(tmp);
            }
        }
        map.put(s, res);
        return map.get(s);
    }
}