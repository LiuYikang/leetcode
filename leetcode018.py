# class Solution:
#     # @param {integer[]} nums
#     # @param {integer} target
#     # @return {integer[][]}
#     def fourSum(self, nums, target):
#     	nums.sort()
#     	ans = []
#     	for i in range(len(nums)):
#     		for j in range(i + 1, len(nums)):
#     			twoPairs = self.TwoNUms(nums[j + 1:], target - nums[i] - nums[j])
#     			for pair in twoPairs:
#     				tmp = [nums[i], nums[j]] + pair
#     				if tmp not in ans:
#     					ans.append(tmp)
#     	return ans
    
#     def TwoNUms(self, nums, target):
#     	ret, pair = [], {}
#     	for item in nums:
#     		if item in pair.keys():
#     			ret.append([target - item, item])
#     		else:
#     			pair[target - item] = True
#     	return ret


class Solution:
    # @param {integer[]} nums
    # @param {integer} target
    # @return {integer[][]}
    def fourSum(self, nums, target):
	    nums.sort()
	    ans = set()
	    ln = len(nums)
	    for i in range(ln - 3):
	    	for j in range(i + 3, ln):
	    		m, n, TwoSum = i + 1, j - 1, nums[i] + nums[j]
	    		while(m < n):
	    			FourSum = nums[m] + nums[n] + TwoSum
	    			if FourSum == target:
	    				ans.add((nums[i], nums[m], nums[n], nums[j]))
	    				m += 1
	    				n -= 1
	    			elif FourSum < target:
	    				m += 1
	    			else:
	    				n -= 1
	    return list(set(ans))


class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        num.sort()
        result = []
        for i in xrange(len(num)-3):
            if num[i] > target/4.0:
                break
            if i > 0 and num[i] == num[i-1]:
                continue
            target2 = target - num[i]
            for j in xrange(i+1, len(num)-2):
                if num[j] > target2/3.0:
                    break
                if j > i+1 and num[j] == num[j-1]:
                    continue
                k = j + 1
                l = len(num) - 1
                target3 = target2 - num[j]
                # we should use continue not break
                # because target3 changes as j changes
                if num[k] > target3/2.0:
                    continue
                if num[l] < target3/2.0:
                    continue
                while k < l:
                    sum_value = num[k] + num[l]
                    if sum_value == target3:
                        result.append([num[i], num[j], num[k], num[l]])
                        kk = num[k]
                        k += 1
                        while k<l and num[k] == kk:
                            k += 1

                        ll = num[l]
                        l -= 1
                        while k<l and num[l] == ll:
                            l -= 1
                    elif sum_value < target3:
                        k += 1
                    else:
                        l -= 1
        return result