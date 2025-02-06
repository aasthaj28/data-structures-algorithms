class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> countOfProduct = new HashMap<>();
        int n = nums.length;
        int count=0;
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int product = nums[i]*nums[j];
                count =count + countOfProduct.getOrDefault(product,0);
                countOfProduct.put(product, countOfProduct.getOrDefault(product,0)+ 1);
            }
        }
        return count * 8;
    }
}
