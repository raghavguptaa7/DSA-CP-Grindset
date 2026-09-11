class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) Arrays.fill(row, -1);

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') { startR = r; startC = c; }
                else if (ch == 'L') {
                    litterId[r][c] = litters.size();
                    litters.add(new int[]{r, c});
                }
            }
        }

        int numLitters = litters.size();
        if (numLitters == 0) return 0;
        int targetMask = (1 << numLitters) - 1;

        byte[][][] maxEnergy = new byte[m][n][1 << numLitters];
        for (byte[][] a : maxEnergy) for (byte[] b : a) Arrays.fill(b, (byte) -1);

        int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, 0, energy});
        maxEnergy[startR][startC][0] = (byte) energy;

        int moves = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1], mask = cur[2], e = cur[3];

                if (mask == targetMask) return moves;
                if (e == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    if (classroom[nr].charAt(nc) == 'X') continue;

                    int nextMask = mask;
                    if (classroom[nr].charAt(nc) == 'L')
                        nextMask |= (1 << litterId[nr][nc]);

                    int nextEnergy = e - 1;
                    if (classroom[nr].charAt(nc) == 'R')
                        nextEnergy = energy;

                    if (nextEnergy > maxEnergy[nr][nc][nextMask]) {
                        maxEnergy[nr][nc][nextMask] = (byte) nextEnergy;
                        q.add(new int[]{nr, nc, nextMask, nextEnergy});
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}