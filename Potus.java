import java.util.*;
import java.io.*;

/*

NOTE: 
THIS CODE IS *EXACTLY* THE SAME AS I PREVIOUSLY SUBMITTED IN FALL 2018 401.

*/

public class Potus
{
	public static void main( String[] args )  throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader("state2presidents.txt") );
		BufferedReader infile2 = new BufferedReader( new FileReader("allPresidents.txt") );
		BufferedReader infile3 = new BufferedReader( new FileReader("allStates.txt") );

		TreeMap<String, TreeSet<String>> state2Presidents = new TreeMap<String, TreeSet<String>>();
		TreeMap<String, String> president2States = new TreeMap<String, String>();
		TreeSet<String> allPresidents = new TreeSet<String>();
		TreeSet<String> allStates = new TreeSet<String>();

		while (infile1.ready()){
			String[] tokens = infile1.readLine().split(" ");
			TreeSet<String> presidents = new TreeSet<String>();
			for (int i = 1; i < tokens.length; i++){
				presidents.add(tokens[i]);
				state2Presidents.put(tokens[0], presidents);
			}
		}
		infile1.close();

		for (String state : state2Presidents.keySet()){
			System.out.print(state + " ");
			for (String president : state2Presidents.get(state)){
				System.out.print(president + " ");
				president2States.put(president, state);
			}
			System.out.println();
		}
		System.out.println();

		for (String president : president2States.keySet())
			System.out.println(president + " " + president2States.get(president));

		System.out.println();

		while (infile2.ready())
			allPresidents.add(infile2.readLine());
		infile2.close();

		for (String presidentWithoutState : allPresidents)
			if (!president2States.keySet().contains(presidentWithoutState))
					System.out.println(presidentWithoutState);

		System.out.println();

		while (infile3.ready())
			allStates.add(infile3.readLine());
		infile3.close();

		for (String state : allStates)
			if (!state2Presidents.keySet().contains(state))
				System.out.println(state);


	} // END MAIN

	//              - - - - - - - - - - -  H E L P E R    M E T H O D S     D O W N    H E R E  - - - - - - - - - -

}	// END POTUS CLASS
