import java.io.*;
import java.util.*;

public class Project2
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
                if (value < 1 || value > 100)
                    throw new NumberOutOfRangeException();
                else
                    break;
            }
            catch (InputMismatchException e){
                System.out.println("Input was not an integer");
            }
            // could also remove the following catch, and let it use the overriden toString method in the new exception to print e
            // like in the one after.
            catch (NumberOutOfRangeException e) {}
            catch (Exception e){
                System.out.println(e);
            }
        } while (true);
		System.out.format("Thank you. You entered %d\n", value);
	} //END main
} //END CLSS
class NumberOutOfRangeException extends Exception
{
    NumberOutOfRangeException(){
        System.out.println("Number out of range. Must be in 1..100");
        // super();
    }
    // override Throwable's toString method to print out what is desired could also work.
    // public String toString(){
    //     return "Number out of range. Must be in 1..100";
    // }
}