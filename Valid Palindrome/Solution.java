// https://leetcode.com/problems/valid-palindrome
// 
// 
// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
// 
// 
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
// 
// 
// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.
// 
// For the purpose of this problem, we define empty string as valid palindrome.
// 
public class Solution {
    
    private static boolean isValid(char i) {
        if (i >= 'A' && i <= 'Z' || i >= 'a' && i <= 'z' || i >= '0' && i <= '9') {
            return true;
        }
        return false;
    }

    private static boolean compare(char a, char b) {
        if (a >= '0' && a <= '9') {
            return a == b;
        }
        if (a >= 'A' && a <= 'Z') {
            if (b >= 'A' && b <= 'Z') {
                return a == b;
            }
            if (b >= 'a' && b <= 'z') {
                return a == b - 32;
            }
        } else {
            if (b >= 'A' && b <= 'Z') {
                return a - 32 == b;
            }
            if (b >= 'a' && b <= 'z') {
                return a == b;
            }
        }
        return false;
    }
    
    public boolean isPalindrome(String s) {
        char c[] = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (left < right) {
            if (isValid(c[left])) {
                if (isValid(c[right])) {
                    if (!compare(c[left], c[right])) {
                        return false;
                    } else {
                        left++;
                        right--;
                    }
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return true;
    }
}
