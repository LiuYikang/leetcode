class RandomizedSet {
    
    List<Integer> vals = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, vals.size());
            vals.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int idx = map.remove(val);
            if (idx < vals.size() - 1) {
                vals.set(idx, vals.get(vals.size() - 1));
                map.put(vals.get(idx), idx);
            }
            vals.remove(vals.size() - 1);
            return true;
        }
    }
    
    Random r = new Random();
    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(r.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
