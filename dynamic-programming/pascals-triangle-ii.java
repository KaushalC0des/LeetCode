class Solution {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<>();

        int row = rowIndex + 1;

        long ans = 1;

        result.add(1);

        for(int col = 1; col < row; col++) {

            ans = ans * (row - col);
            ans = ans / col;

            result.add((int)ans);
        }

        return result;
    }
}