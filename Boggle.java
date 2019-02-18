import java.io.*;
import java.util.*;

// just generates all the strings & prints them as they are generated

public class Boggle
{	
    static String[][] board;

    static TreeSet<String> hits = new TreeSet<String>();
    //static HashMap<Integer, HashSet<String>> dictionary = new HashMap<Integer, HashSet<String>>();
    static HashSet<String> dictionary = new HashSet<String>();
    static HashSet<Integer> wordLengths = new HashSet<Integer>();
    static final short SMALLEST_WORD_LENGTH = 3;
    //static short longestLength = 0;

    // DEBUG:
	//static double startTime,endTime; // for timing
    //static final int MILLISEC_PER_SEC = 1000;
    //static int wordCounter = 0;

	public static void main( String args[] ) throws Exception
	{	
        //startTime= System.currentTimeMillis();
        board = loadBoard( args[1] );
        
        BufferedReader dictFile = new BufferedReader(new FileReader(args[0]));
        while (dictFile.ready()){
            String line = dictFile.readLine();
            if (line.length() >= SMALLEST_WORD_LENGTH){
                dictionary.add(line);
                wordLengths.add(line.length());
            }
        }
        dictFile.close();
        
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[row].length; col++){
                dfs(row, col, "");
            }
    // FOR EACH [R][C] THE WORD STARTS EMPTY

        for (String word : hits)
            System.out.println(word);
        
        // DEBUG:
        //System.out.println(hits.size());
        //System.out.println("TOTAL WORDS: " +wordCounter);
		//endTime =  System.currentTimeMillis(); // for timing
		//System.out.println("GENERATION COMPLETED: runtime=" + (endTime-startTime)/MILLISEC_PER_SEC );
		
	} // END MAIN ----------------------------------------------------------------------------

	static void dfs( int r, int c, String word  )
	{	
        word += board[r][c];
        if (searchDict(word))
            hits.add(word);
        //wordCounter++;
        /*
        NORTH: r-1, c
        NORTH-EAST: r-1, c+1
        EAST: r, c+1
        SOUTH EAST: r+1, c+1
        SOUTH: r+1, c
        SOUTH WEST: r+1, c-1
        WEST: r, c-1
        NORTH WEST: r-1, c-1
        */

        // N
        if (((r - 1 >= 0 && r - 1 < board.length) && (c >= 0)) && board[r - 1][c] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r - 1, c, word); // move, add String to NORTH to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // NE
        if (((r - 1 >= 0 && r - 1 < board.length) && (c + 1 >= 0 && c + 1 < board[r - 1].length)) && board[r - 1][c + 1] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r - 1, c + 1, word); // move, add String to NORTHEAST to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // E
        if (((r >= 0) && (c + 1 >= 0 && c + 1 < board[r].length)) && board[r][c + 1] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r, c + 1, word); // move, add String to EAST to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // SE
        if (((r + 1 >= 0 && r + 1 < board.length) && (c + 1 >= 0 && c + 1 < board[r].length)) && board[r + 1][c + 1] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r + 1, c + 1, word); // move, add String to SOUTHEAST to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // S
        if (((r + 1 >= 0 && r + 1 < board.length) && (c >= 0)) && board[r + 1][c] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r + 1, c, word); // move, add String to SOUTH to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // SW
        if (((r + 1 >= 0 && r + 1 < board.length) && (c - 1 >= 0 && c - 1 < board[r + 1].length)) && board[r + 1][c - 1] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r + 1, c - 1, word); // move, add String to SOUTHWEST to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // W
        if (((r >= 0) && (c - 1 >= 0 && c - 1 < board[r].length)) && board[r][c - 1] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r, c - 1, word); // move, add String to WEST to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }
        // NW
        if (((r - 1 >= 0 && r - 1 < board.length) && (c - 1 >= 0 && c - 1 < board[r - 1].length)) && board[r - 1][c - 1] != null){
            String unMarked = board[r][c]; //save to restore board after recursion
            board[r][c] = null; // mark
            dfs (r - 1, c - 1, word); // move, add String to NORTHWEST to word.
            board[r][c] = unMarked; // unmark, for next iteration.
        }                
	} // END DFS ----------------------------------------------------------------------------

	//=======================================================================================
	static String[][] loadBoard( String fileName ) throws Exception
	{	Scanner infile = new Scanner( new File(fileName) );
		int rows = infile.nextInt();
		int cols = rows;
		String[][] board = new String[rows][cols];
		for (int r=0; r<rows; r++)
			for (int c=0; c<cols; c++)
				board[r][c] = infile.next();
		infile.close();
		return board;
	} //END LOADBOARD 
    static boolean searchDict(String word){
        if (word.length() >= SMALLEST_WORD_LENGTH && wordLengths.contains(word.length()))
            if (dictionary.contains(word))
                return true;
        return false;
    }

} // END BOGGLE CLASS
