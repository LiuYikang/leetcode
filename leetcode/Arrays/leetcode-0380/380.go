package arrays

type RandomizedSet struct {
	vals []int
	m    map[int]int
}

/** Initialize your data structure here. */
func Constructor() RandomizedSet {
	return RandomizedSet{vals: []int{}, m: make(map[int]int)}
}

/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
func (this *RandomizedSet) Insert(val int) bool {
	if _, ok := this.m[val]; ok {
		return false
	} else {
		this.m[val] = len(this.vals)
		this.vals = append(this.vals, val)
		return true
	}
}

/** Removes a value from the set. Returns true if the set contained the specified element. */
func (this *RandomizedSet) Remove(val int) bool {
	idx, ok := this.m[val]
	if !ok {
		return false
	}

	last := this.vals[len(this.vals)-1]
	if val == last {
		this.vals = this.vals[:len(this.vals)-1]
	} else {
		this.vals[idx] = last
		this.vals = this.vals[:len(this.vals)-1]
		this.m[this.vals[idx]] = idx
	}
	delete(this.m, val)
	return true
}

/** Get a random element from the set. */
func (this *RandomizedSet) GetRandom() int {
	rand.Seed(time.Now().UnixNano())
	return this.vals[rand.Intn(len(this.vals))]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
