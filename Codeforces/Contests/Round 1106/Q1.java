import java.io.*;
import java.util.*;

public class Q1 {
    static void solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        int sol = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                sol = (int) 1e9;
                break;
            } else {
                sol += a[i] - b[i];
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int s2 = c;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                s2 = (int) 1e9;
                break;
            } else {
                s2 += a[i] - b[i];
            }
        }

        sol = Math.min(sol, s2);

        if (sol > 5e8)
            System.out.println(-1);
        else
            System.out.println(sol);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            solve(br);
        }
    }
}