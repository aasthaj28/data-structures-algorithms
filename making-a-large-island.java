class Solution {
    private static final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        List<Integer> key = new ArrayList<>();
        key.add(0);
        int id = 2;
        boolean hasZero = false;
        Map<Integer, Integer> islandSize = new HashMap<>();

        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (grid[i][j] == 1)
                {
                    int size = dfs(grid, i, j, id);
                    key.add(size);
                    islandSize.put(id, size);
                    id++;
                }
                else if (grid[i][j] == 0)
            {
                hasZero = true;
            }
            }
        }

        if (!hasZero) return n * n;

        int max = 0;

        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                if (grid[i][j] == 0)
                {
                    Set<Integer> seen = new HashSet<>();
                    int sum = 1;

                    for (int[] dir : dirs)
                    {
                        int ni = i + dir[0], nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj< n && grid[ni][nj] >= 2)
                        {
                            int islandId = grid[ni][nj];
                            if (seen.add(islandId))
                            {
                                sum += islandSize.get(islandId);
                            }
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int id)
    {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = id;
        int count = 1;

        for (int[] dir : dirs)
        {
            count += dfs(grid, i + dir[0], j + dir[1], id);
        }
        return count;
    }

    public static void main (String[] args)
    {
        Solution sol = new Solution();
        int[][] grid = {
            {1,0},
            {0,1}
        };
        System.out.println(sol.largestIsland(grid));
    }
}
