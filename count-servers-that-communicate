class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] rc = new int[r];
        int[] cc = new int[c];
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                if (grid[i][j] == 1)
                {
                    rc[i]++;
                    cc[j]++;
                }
            }
        }
        int ans = 0;
        for (int i=0; i<r; i++)
        {
            for (int j=0; j<c; j++)
            {
                if (grid[i][j] == 1 && (rc[i] > 1 || cc[j] > 1))
                {
                    ans++;
                }
            }
        }
        return ans;
    }
}
