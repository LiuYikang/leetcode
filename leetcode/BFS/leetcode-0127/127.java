import java.util.HashSet;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while (!q.isEmpty()) {
            String word = q.poll();
            for (int i = 0; i < word.length(); i++) {
                char[] ch = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    ch[i] = c;
                    String newWord = new String(ch);
                    if (set.contains(newWord) && newWord.equals(endWord)) {
                        return map.get(word) + 1;
                    }

                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, map.get(word) + 1);
                        q.poll(newWord);
                    }
                }
            }
        }
        return 0;
    }
}