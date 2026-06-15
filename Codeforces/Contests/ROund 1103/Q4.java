//To solve this problem efficiently, we sort the unique values of the array and analyze the game from right to left (largest to smallest value). Because players can only choose equal or larger elements within a distance of $k$, smaller elements are locked out permanently after any move. A player landing on a unique value can either jump to a larger value within distance $k$ or stay on the current value by consuming a duplicate. If there is a reachable larger value that forces a losing position on the opponent, the current player will jump to it and win; otherwise, they must stay, reducing the game to single-pile Nim where having an odd number of remaining copies is winning and an even number is losing.By iterating backwards, we keep track of the closest known losing entry point to the right. If this losing point is within distance $k$, the current value is marked as a winning jump state. If it is out of reach, the current value cannot jump to a win, and if its total frequency is odd, it becomes the new closest losing entry point for values to its left. Ultimately, Arseniy can win if he can pick an initial element that hands Egor a winning state—which is possible if that element either allows a winning jump or has an even total count, leaving Egor with an odd number of copies.
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            HashMap<Integer, Integer> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                mp.put(x, mp.getOrDefault(x, 0) + 1);
            }

            int m = mp.size();

            int[] v = new int[m];
            int p = 0;

            for (int x : mp.keySet()) {
                v[p++] = x;
            }

            Arrays.sort(v);

            boolean[] win = new boolean[m];
            int lose = -1;

            for (int i = m - 1; i >= 0; i--) {

                if (lose != -1 && v[lose] - v[i] <= k) {
                    win[i] = true;
                }

                if (!win[i] && (mp.get(v[i]) & 1) == 1) {
                    lose = i;
                }
            }

            boolean ok = false;

            for (int i = 0; i < m; i++) {
                int cnt = mp.get(v[i]);

                if (win[i] || (cnt & 1) == 0) {
                    ok = true;
                    break;
                }
            }

            out.println(ok ? "YES" : "NO");
        }

        out.flush();
    }
}