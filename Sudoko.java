//Backtracking Concept and we use a function to check whether the number is safe at that 
//position or not by checking in its col,row and in its 3X3 grid 
class Sudoko {
   public boolean isSafe(char[][] board, int row, int col, int number) {
       //column
       for(int i=0; i<board.length; i++) {
           if(board[i][col] == (char)(number+'0')) {
               return false;
           }
       }
      
       //row
       for(int j=0; j<board.length; j++) {
           if(board[row][j] == (char)(number+'0')) {
               return false;
           }
       }
      
       //grid
       int sr = 3 * (row/3);
       int sc = 3 * (col/3);
      
       for(int i=sr; i<sr+3; i++) {
           for(int j=sc; j<sc+3; j++) {
               if(board[i][j] == (char)(number+'0')) {
                   return false;
               }
           }
       }
      
       return true;
   }
  
   public boolean helper(char[][] board, int row, int col) {
       if(row == board.length) {
           return true;
       }
      
       int nrow = 0;
       int ncol = 0;
      
       if(col != board.length-1) {
           nrow = row;
           ncol = col+1;
       } else {
           nrow = row+1;
           ncol = 0;
       }
      
       if(board[row][col] != '.') {
           if(helper(board, nrow, ncol)) {
               return true;
           }
       } else {
          
           //fill the place
           for(int i=1; i<=9; i++) {
               if(isSafe(board, row, col, i)) {
                   board[row][col] = (char)(i+'0');
                   if(helper(board, nrow, ncol))
                       return true;
                   else
                        board[row][col] = '.';
               }
           }
       }
                     
       return false;
   }
  
   public void solveSudoku(char[][] board) {
       helper(board, 0, 0);
   }
   public static void main(String[] args) {
       Sudoko s = new Sudoko();

    // Example Sudoku board (empty cells are represented by '.')
       char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

    // Call the solveSudoku method to solve the board
        s.solveSudoku(board);

    // Print the solved board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}

