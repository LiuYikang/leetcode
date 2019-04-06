## 49. Group Anagrams

Given an array of strings, group anagrams together.

Example:
```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```
Note:
* All inputs will be in lowercase.
* The order of your output does not matter.

#### solution
对字符串进行排序，排序后的新字符串作为hashtable的key