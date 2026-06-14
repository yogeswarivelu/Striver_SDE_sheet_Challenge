class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for(int row=1;row<=n;row++)
        {
        List<Integer> rows = new ArrayList<>();
        long ans=1;
        rows.add(1);

        for(int col=1;col<row;col++)
        {
            ans=ans*(row-col);
            ans/=col;
             rows.add((int) ans);
        }
        result.add(rows);
        }
        return result;

    }
}