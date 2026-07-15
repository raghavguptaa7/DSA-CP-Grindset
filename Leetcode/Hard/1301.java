class Solution {
    static final int MOD = 1000000007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], -1);
        }

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X' || (i == n - 1 && j == n - 1))
                    continue;

                int best = -1;
                int cnt = 0;

            
                if (i + 1 < n && score[i + 1][j] != -1) {
                    if (score[i + 1][j] > best) {
                        best = score[i + 1][j];
                        cnt = ways[i + 1][j];
                    } else if (score[i + 1][j] == best) {
                        cnt = (cnt + ways[i + 1][j]) % MOD;
                    }
                }

                
                if (j + 1 < n && score[i][j + 1] != -1) {
                    if (score[i][j + 1] > best) {
                        best = score[i][j + 1];
                        cnt = ways[i][j + 1];
                    } else if (score[i][j + 1] == best) {
                        cnt = (cnt + ways[i][j + 1]) % MOD;
                    }
                }

                
                if (i + 1 < n && j + 1 < n && score[i + 1][j + 1] != -1) {
                    if (score[i + 1][j + 1] > best) {
                        best = score[i + 1][j + 1];
                        cnt = ways[i + 1][j + 1];
                    } else if (score[i + 1][j + 1] == best) {
                        cnt = (cnt + ways[i + 1][j + 1]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                score[i][j] = best;

                if (ch >= '1' && ch <= '9')
                    score[i][j] += ch - '0';

                ways[i][j] = cnt;
            }
        }

        if (ways[0][0] == 0)
            return new int[]{0, 0};

        return new int[]{score[0][0], ways[0][0]};
    }
}