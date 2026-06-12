//The Approach (For Future Revision)To solve this problem efficiently, we use dynamic programming combined with a frequency tracker to process the array in a single pass. We define our main DP state such that it stores the maximum length of a neat subsequence where the final block ends exactly at the current index. To form a valid block for a given number, say $x$, we need to gather exactly $x$ copies of it. By maintaining a list of indices where each number appears, we can instantly check if we have enough copies to form a block whenever we encounter a new element. If we do have enough copies, we look back to find the starting index of this newly formed block. The optimal answer at our current index then becomes the size of this block ($x$) plus the longest neat subsequence we could possibly build entirely before this block started. To avoid searching backwards and wasting time, we maintain a secondary running-maximum array that constantly tracks the best possible sequence length found up to any given prefix of the array
import java.io.*;
import java.util.*;

public class Q3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayList<Integer>[] pos = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                pos[i] = new ArrayList<>();
            }

            int[] dp = new int[n + 1];
            int[] pref = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = Integer.parseInt(st.nextToken());

                if (a[i] <= n) {
                    pos[a[i]].add(i);

                    if (pos[a[i]].size() >= a[i]) {
                        int start = pos[a[i]].get(pos[a[i]].size() - a[i]);
                        dp[i] = a[i] + pref[start - 1];
                    }
                }

                pref[i] = Math.max(pref[i - 1], dp[i]);
            }

            ans.append(pref[n]).append('\n');
        }

        System.out.print(ans);
    }
}