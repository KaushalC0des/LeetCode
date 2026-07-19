class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        
        for(int row = 1; row <= numRows; row++) {

            List<Integer> curr = new ArrayList<>();

            int ans = 1;
            curr.add(ans);

            
            for(int col = 1; col < row; col++) {

                ans = ans * (row - col);
                ans = ans / col;

                curr.add(ans);
            }

            result.add(curr);
        }

        return result;
    }
}