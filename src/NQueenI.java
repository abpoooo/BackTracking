import java.util.ArrayList;
import java.util.List;

public class NQueenI {

    int [] cols;

    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        List<List<String>> list = new ArrayList<>();
        place(0, list);
        return list;
    }

    private void place(int row, List<List<String>> list) {
        if (row == cols.length){
            //list add showQueen(cols)
            list.add(showQueen());
            return;
        }
        for (int col = 0; col < cols.length; col++) {

            if (isValid(row, col, cols)){
                cols[row] = col;
                place(row + 1,  list);
            }
        }
    }

    private boolean isValid(int row, int col, int[] cols){
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;
            if (Math.abs(cols[i] - col) == row - i) return false;
        }
        return true;
    }

    private List<String> showQueen() {
        List<String> internal = new ArrayList<String>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder str = new StringBuilder();
            for (int col = 0; col < cols.length ; col++) {
               if (cols[row] == col) str.append('Q');
               else str.append('.');
            }
            internal.add(str.toString());
        }
        return internal;
    }
}
