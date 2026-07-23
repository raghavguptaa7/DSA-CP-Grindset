import java.util.regex.*;
import java.util.*;
import java.util.stream.IntStream;

class Solution {
    private int[] zs, ze, V;
    private int nblocks;
    private List<int[]> sparse;

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int ones = (int) s.chars().filter(c -> c == '1').count();

        List<Integer> zsL = new ArrayList<>(), zeL = new ArrayList<>();
        Matcher mo = Pattern.compile("0+").matcher(s);
        while (mo.find()) {
            zsL.add(mo.start());
            zeL.add(mo.end() - 1);
        }

        zs = zsL.stream().mapToInt(Integer::intValue).toArray();
        ze = zeL.stream().mapToInt(Integer::intValue).toArray();
        nblocks = zs.length;

        V = IntStream.range(0, nblocks - 1)
                .map(j -> (ze[j] - zs[j] + 1) + (ze[j + 1] - zs[j + 1] + 1))
                .toArray();

        int nv = V.length;
        sparse = new ArrayList<>();
        sparse.add(V);

        for (int half = 1; half * 2 <= nv; half *= 2) {
            int[] prev = sparse.get(sparse.size() - 1);
            int[] next = new int[prev.length - half];
            for (int i = 0; i < next.length; i++) {
                next[i] = Math.max(prev[i], prev[i + half]);
            }
            sparse.add(next);
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            ans.add(ones + gain(q[0], q[1]));
        }
        return ans;
    }

    private int rmq(int lo, int hi) {
        int t = 31 - Integer.numberOfLeadingZeros(hi - lo + 1);
        return Math.max(sparse.get(t)[lo], sparse.get(t)[hi - (1 << t) + 1]);
    }

    private int clip(int j, int l, int r) {
        return V[j] - Math.max(0, l - zs[j]) - Math.max(0, ze[j + 1] - r);
    }

    private int gain(int l, int r) {
        if (nblocks < 2) {
            return 0;
        }

        int ja = lowerBound(ze, l);
        int jb = upperBound(zs, r) - 2;

        if (ja > jb) {
            return 0;
        }

        return Math.max(
                Math.max(clip(ja, l, r), clip(jb, l, r)),
                jb - ja >= 2 ? rmq(ja + 1, jb - 1) : 0
        );
    }

    private static int lowerBound(int[] a, int x) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int upperBound(int[] a, int x) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}