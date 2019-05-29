class RandomizedCollection {

    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        if (!contains) {
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !contains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        LinkedHashSet<Integer> valSet = map.get(val);
        int idx = valSet.iterator().next();

        int last = nums.get(nums.size() - 1);
        LinkedHashSet<Integer> replace = map.get(last);

        nums.set(idx, last);
        valSet.remove(idx);
        if (idx != nums.size() - 1) {
            replace.remove(nums.size() - 1);
            replace.add(idx);
        }
        nums.remove(nums.size() - 1);

        if (valSet.isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */