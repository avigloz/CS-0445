/*
	Exercise2.java
	- WRITE A SINGLE DO LOOP THAT DOES THE FOLLOWING UNTIL THE USER ENTERS AN INT IN 1..100 INCLUSIVE
	- 	USE TRY CATCH TO READ AN INT FROM THE KBD SUCH THAT IF USER ENTERS "FOO" IT DOES NOT CRACH
	- 	DON'T THROW AN EXCEPTIOn OR ATTEMPT TO CATCH ONE FOR THE CASE OF USER ENTERING AN VALID 
	-		INT THAT HAPPENS TO BE OUT OF RANGE.

*/
import java.io.*;
import java.util.*;

public class Exercise2
{
	public static void main( String args[] )
	{
		// MODIFY, REPLACE, ADD LOOP CODE, ADD TRY CATCH BLOCK(S) AS NEEDED BELOW
        int value = 0;
        do {
            System.out.print("Enter int in range 1..100 inclusive: ");
            try {
                Scanner numScanner = new Scanner(System.in);
                value = numScanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Input was not an integer");
                continue;
            }
            if (value < 1 || value > 100)
                System.out.println("Number out of range. Must be in 1..100");
            else
                break;
        } while (true);
		System.out.format("Thank you. You entered %d\n", value);
	} //END main
} //END CLSS