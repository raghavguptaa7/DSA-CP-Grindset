class Solution {
    public int[] groupStrings(String[] words) {
        Map<Integer, Integer> maskCount = new HashMap<>();
        for (String w : words) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            maskCount.put(mask, maskCount.getOrDefault(mask, 0) + 1);
        }

        Set<Integer> visited = new HashSet<>();
        int groups = 0;
        int maxGroup = 0;

        for (int m : maskCount.keySet()) {
            if (!visited.contains(m)) {
                groups++;
                maxGroup = Math.max(maxGroup, dfs(m, maskCount, visited));
            }
        }
        return new int[] { groups, maxGroup };
    }

    private int dfs(int start, Map<Integer, Integer> maskCount, Set<Integer> visited) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        int size = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (visited.contains(node))
                continue;
            visited.add(node);
            size += maskCount.get(node);

            for (int i = 0; i < 26; i++) {
                if ((node & (1 << i)) != 0) {
                    int neighbor = node ^ (1 << i);
                    if (maskCount.containsKey(neighbor) && !visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if ((node & (1 << i)) == 0) {
                    int neighbor = node | (1 << i);
                    if (maskCount.containsKey(neighbor) && !visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if ((node & (1 << i)) != 0) {
                    for (int j = 0; j < 26; j++) {
                        if ((node & (1 << j)) == 0) {
                            int neighbor = (node ^ (1 << i)) | (1 << j);
                            if (maskCount.containsKey(neighbor) && !visited.contains(neighbor)) {
                                stack.push(neighbor);
                            }
                        }
                    }
                }
            }
        }
        return size;
    }
}