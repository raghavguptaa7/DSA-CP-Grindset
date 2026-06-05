//This problem asks if a string can be completely cleared by repeatedly replacing adjacent, identical characters with asterisks (*), which can then be skipped over to make distant characters adjacent. While checking only for initial consecutive pairs tells us if a single move is possible, it fails if remaining characters become permanently isolated. To correctly solve this, we can process the string from left to right using a stack to simulate the clearance in $O(N)$ time. If the current character matches the top of the stack, it means all characters between them have already been cleared; we then pop the matching character to eliminate the pair. Otherwise, we push the character onto the stack. If the stack is completely empty at the end, all characters were successfully cleared (YES); if any characters remain, the game is deadlocked (NO).

import java.util.*;
public class Q3 {
    static void solve(Scanner sc) {
        int n = sc.nextInt();
        String s = sc.next();

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == ch) st.pop();
            else st.push(ch);
        }

        System.out.println(st.isEmpty() ? "YES" : "NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) solve(sc);
    }
}