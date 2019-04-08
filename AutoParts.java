import java.util.*;
import java.io.*;
/*

NOTE: 
THIS CODE IS ADAPTED FROM A FALL 2018 401 ASSIGNMENT.
ORIGINALLY, THE OUTPUT WAS SORTED. 

I CHANGED TREEMAPS to HASHMAPS FOR THIS VERSION.
PRINTLNs WERE ALSO ADAPTED.

*/
public class AutoParts
{
	public static void main( String[] args ) throws Exception
	{
		BufferedReader num2quantFile = new BufferedReader( new FileReader( "num2quant.txt" ) );
		BufferedReader num2nameFile = new BufferedReader( new FileReader( "num2name.txt" ) );

		System.out.println("PART NUMBER TO PART NAME\n");

		//TreeMap<Integer, String> num2name = new TreeMap<Integer, String>();
		HashMap<Integer, String> num2name = new HashMap<Integer, String>();
		while (num2nameFile.ready()){
			String[] tokens = num2nameFile.readLine().split("\t");
			num2name.put(Integer.parseInt(tokens[0]), tokens[1]);
		}
		for (int i : num2name.keySet())
			System.out.println(i + "\t" + num2name.get(i));

		System.out.println("\nJOIN OF PART NUMBER TO NAME TO QUANTITY\n");

		//TreeMap<Integer, Integer> num2quant = new TreeMap<Integer, Integer>();
		HashMap<Integer, Integer> num2quant = new HashMap<Integer, Integer>();
		while (num2quantFile.ready()){
			String[] tokens = num2quantFile.readLine().split("\t");
			num2quant.put(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		for (int i : num2name.keySet())
			System.out.println(i + "\t" + num2name.get(i) + "\t" + num2quant.get(i));

		num2quantFile.close();
		num2nameFile.close();
	} // END MAIN

} // END CLASS
