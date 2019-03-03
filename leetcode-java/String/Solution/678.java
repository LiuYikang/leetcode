/**
678. Valid Parenthesis String
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].

解法一：
使用两个stack，分别存放左括号和星号的位置，遍历字符串，当遇到星号时，压入星号栈star，当遇到左括号时，压入左括号栈left，当遇到右括号时，此时如果left和star均为空时，直接返回false；如果left不为空，则pop一个左括号来抵消当前的右括号；否则从star中取出一个星号当作左括号来抵消右括号。当循环结束后，我们希望left中没有多余的左括号，就算有，我们可以尝试着用星号来抵消，当star和left均不为空时，进行循环，如果left的栈顶左括号的位置在star的栈顶星号的右边，那么就组成了 *( 模式，直接返回false；否则就说明星号可以抵消左括号，各自pop一个元素。最终退出循环后我们看left中是否还有多余的左括号，没有就返回true，否则false。

解法二：
维护了两个变量low和high，其中low表示在有左括号的情况下，将星号当作右括号时左括号的个数(这样做的原因是尽量不多增加右括号的个数)，而high表示将星号当作左括号时左括号的个数。那么当high小于0时，说明就算把星号都当作左括号了，还是不够抵消右括号，返回false。而当low大于0时，说明左括号的个数太多了，没有足够多的右括号来抵消，返回false。那么开始遍历字符串，当遇到左括号时，low和high都自增1；当遇到右括号时，只有当low大于0时，low才自减1，保证了low不会小于0，而high直接自减1；当遇到星号时，只有当low大于0时，low才自减1，保证了low不会小于0，而high直接自增1，因为high把星号当作左括号。当此时high小于0，说明右括号太多，返回false。当循环退出后，我们看low是否为0。

解法三：
既然星号可以当左括号和右括号，那么我们就正反各遍历一次，正向遍历的时候，我们把星号都当成左括号，此时用经典的验证括号的方法，即遇左括号计数器加1，遇右括号则自减1，如果中间某个时刻计数器小于0了，直接返回false。如果最终计数器等于0了，我们直接返回true，因为此时我们把星号都当作了左括号，可以跟所有的右括号抵消。而此时就算计数器大于0了，我们暂时不能返回false，因为有可能多余的左括号是星号变的，星号也可以表示空，所以有可能不多，我们还需要反向q一下，哦不，是反向遍历一下，这是我们将所有的星号当作右括号，遇右括号计数器加1，遇左括号则自减1，如果中间某个时刻计数器小于0了，直接返回false。遍历结束后直接返回true，这是为啥呢？此时计数器有两种情况，要么为0，要么大于0。为0不用说，肯定是true，为啥大于0也是true呢？因为之前正向遍历的时候，我们的左括号多了，我们之前说过了，多余的左括号可能是星号变的，也可能是本身就多的左括号。本身就多的左括号这种情况会在反向遍历时被检测出来，如果没有检测出来，说明多余的左括号一定是星号变的。而这些星号在反向遍历时又变做了右括号，最终导致了右括号有剩余，所以当这些星号都当作空的时候，左右括号都是对应的，即是合法的。你可能会有疑问，右括号本身不会多么，其实不会的，如果多的话，会在正向遍历中被检测出来。
**/
class Solution {
    public boolean checkValidString(String s) {
        if (s == null) {
            return true;
        }

        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                if (left.isEmpty() || star.isEmpty()) {
                    return false;
                }
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    star.pop();
                }
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.peek() > star.peek()) {
                return false;
            }
            left.pop();
            star.pop();
        }

        return left.isEmpty();
    }
}
