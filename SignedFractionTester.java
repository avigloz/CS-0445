import java.io.*;
import java.util.*;

public class SignedFractionTester
{
	public static void main( String args[] )
	{
		Random generator = new Random( 17 );
		int[] numers = { 13, -7, 26, -5,   8, -1 };
		int[] denoms = { 3,  -49, 13, 15,  -7, -1 };

		// POPULATE AN ARRAY OF FRACTIONS WITH RANDOM VALUES

		SignedFraction[] plainArr = new SignedFraction[ numers.length ];
		for ( int i = 0 ; i < numers.length ; ++i )
			plainArr[i] = new SignedFraction( numers[i], denoms[i] );

		System.out.println("\nplainArr OF SIGNED FRACTIONS");
		for ( SignedFraction f : plainArr )
			System.out.println( f );

	}// END MAIN
} // END
