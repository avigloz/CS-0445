import java.util.*;
import java.io.*;

public class Pacs
{
	public static void main( String[] args ) throws Exception
	{
		BufferedReader infile1 = new BufferedReader( new FileReader("pacs.txt") );
        BufferedReader infile2 = new BufferedReader( new FileReader("members.txt") );

        TreeMap<String, TreeSet<String>> members2pacs = new TreeMap<String, TreeSet<String>>();
        TreeMap<String, TreeSet<String>> pacs2members = new TreeMap<String, TreeSet<String>>();
            
        TreeSet<String> pacs = new TreeSet<String>();
        while (infile1.ready()){
            pacs.add(infile1.readLine());
        }
        infile1.close();

        // Read lines from Members file
        // If tokens array after tokens[0] contains PAC name, add members name to new TreeSet containing all members of that PAC
        // Put into pacs2members the pac name, and the treeset containing all names.
        while (infile2.ready()){
            String[] tokens = infile2.readLine().split(" ");
            TreeSet<String> pacNames = new TreeSet<String>();
            for (int i = 1; i < tokens.length; i++)
                pacNames.add(tokens[i]);
            members2pacs.put(tokens[0], pacNames);
        }
        infile2.close();
    
        for (String pac : pacs){
            TreeSet<String> pacNames = new TreeSet<String>();
            for (String key : members2pacs.keySet())
                if (members2pacs.get(key).contains(pac))
                    pacNames.add(key);
            pacs2members.put(pac, pacNames);
        }
        // Print out the map.
        for (String key : pacs2members.keySet()){
			System.out.print(key + " ");
			for (String name : pacs2members.get(key))
                System.out.print(name + " ");
            System.out.println();
        }   
    }
} // END CLASS
