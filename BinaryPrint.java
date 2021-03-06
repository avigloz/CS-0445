/*
	BinaryPrint.java
	uses >> operator to shift an int value to enable bit by bit access
*/
import java.io.*;

public class BinaryPrint
{
	public static void main( String[] args )
	{
        int number; // java's char type is just a 16 bit number
        int limit = 0xFFFF;
		int i;

		System.out.println("       B I T   P O S I T I O N");
		System.out.println("       1111100000000000");
		System.out.println("       5432109876543210");
		System.out.println("       ----------------");

		for (number=0 ; number  < limit ; ++ number)
		{
			System.out.printf("%3d == ", number);
			for (i = 15 ; i >=0  ; --i )
			{
				/* shift i'th bit to the end position then AND it with 1 */
				if ( (number >> i) % 2 == 1 ) /* true iff i'th bit is a 1 */
					System.out.print("1" );
				else
					System.out.print("0" );
			}
			System.out.println();
		}
	} // END MAIN
} // END CLASS