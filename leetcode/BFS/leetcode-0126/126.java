import java.util.Map;
import java.util.Set;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> nodeNeighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> solution = new ArrayList<>();
        
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (endWord.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (foundEnd) {
                break;
            }
        }
    }
    
    private List<String> getNeighbors(String cur, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] ch = cur.toCharArray();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < cur.length(); i++) {
                if (ch[i] == c) {
                    continue;
                }
                char oldCh = ch[i];
                ch[i] = c;
                String newStr = new String(ch);
                if (dict.contains(newStr)) {
                    res.add(newStr);
                }
                ch[i] = oldCh;
            }
        }
        return res;
    }

    private void dfs(String cur, String endWord, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (endWord.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, endWord, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}