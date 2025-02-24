import java.util.*;

public class ratInMaze {
    
 // Initialize a string direction which represents all
    // the directions.
    static String direction = "DLRU";

    // Arrays to represent change in rows and columns
    static int[] dr = { 1, 0, 0, -1 };
    static int[] dc = { 0, -1, 1, 0 };


    // chekc next move is valid or not 
    public static boolean isValid(int row,int col,int maze[][],int N){

        return row >=0 && col >=0 && row <N && col <N && maze[row][col]==1;
    }

    public static void findpth(int row,int col,int maze[][],int N,ArrayList<String> ans,StringBuilder currentpath) {

        // base case to return ans 
        // if reached bottom row and col thenreturn ans
        if(row == N-1 && col == N-1){
            ans.add(currentpath.toString());
            return;
        }

        //mark current position in maze is blocked
        maze[row][col]=0;


        for(int i=0;i<4;i++){

            int currRow= row+dr[i];

            int currCol=col + dc[i];

            if(isValid(currRow, currCol, maze, N)){
                currentpath.append(direction.charAt(i));

                findpth(currRow, currCol, maze, N, ans, currentpath);

                //backtracking remove last char from currentpath
                currentpath.deleteCharAt(currentpath.length()-1);
            }
        }

        //again mark current position in maze is unblocked
        maze[row][col]=1;
    }

    public static void main(String args[]){

        int[][] maze = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 1, 1, 0, 0 },
                         { 0, 1, 1, 1 } };

                         int N=maze.length;

                         ArrayList<String> result=new ArrayList<>();

                         StringBuilder currentpath=new StringBuilder();

                        //  if source and destination are not blocked then check for path 
                         if(maze[0][0] != 0 && maze[N-1][N-1] != 0){

                             findpth(0, 0, maze, N, result, currentpath);
                         }
                         
        if (result.size() == 0)
        System.out.println(-1);
    else
        for (String path : result)
            System.out.print(path + " ");
    System.out.println();
    }

}
