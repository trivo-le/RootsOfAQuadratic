import java.util.Scanner;

public class RootsOfAQuadratic {
	/* Tri Vo-Le
	 * February, 2021
	 * Given the user's inputted values, display the corresponding standard form quadratic equation as 
	 * well as finding the zeros through the use of factoring or the quadratic formula, and if possible, 
	 * display the factored form equivalent equation.
	 */

	
	static int aValue, bValue, cValue, rValue, sValue;
	static int stop = 0; 
	
	public static void main(String[] args) {
	 	
	// Welcome user
	System.out.println("Hello!");
	System.out.println("Where a=1, I can transform a quadratic equation ax^2+bx+c=0 to its factor form!");
	
	// Get input and display the standard form equation
	getInput();
	standard(bValue,cValue);
		
		
	// Solve the equation
		
	//If cValue is POSITIVE
	if (cValue>0) {
		factorPositiveC(bValue,cValue);
	}//if
		
	//If c-value is negative
	else if (cValue<0) {
		factorNegativeC(bValue,cValue);
	}//else if
	
	// If a solution is found, then print the solutions
	if (stop == 1) {
		printZeroes(rValue, sValue);
	}//if
	
	//If the equation is prime, use the quadratic formula instead
	if (stop == 0) {
		System.out.println(solveQuadForm(aValue, bValue, cValue));
	}//if
	
	}//main
	

	public static void getInput() {
	/* Get user's input on aValue, bValue, and cValue */
	
	Scanner input = new Scanner(System.in);
		
	System.out.println("Please input the a-value of the equation.");
	aValue = input.nextInt();
	
	while (aValue!=1) {
		System.out.println("Invalid a-value. Please make sure a=1.");
		aValue = input.nextInt();
	}//while
	
	System.out.println("Please input the b-value of the equation.");
	bValue = input.nextInt();
	System.out.println("Please input the c-value of the equation.");
	cValue = input.nextInt();
		
	input.close();
	}//getInput
	


	public static void standard(int b, int c) {
	/* Display the standard form quadratic equation based on the integers b and c that are in the parameters. */

	System.out.printf("The standard form equation is x^2%+dx%+d = 0", b, c);
	System.out.println();
	}//standard
	


	public static void factorPositiveC(int sum, int product) {
	/* Factor the standard form equation where the factor pair adds to the integer sum 
	 * while the int product (both passed to the parameter) is positive. */
		
	for (int counter = 1; counter < product; counter++) {
		
		//Find factor pairs
		if (product%counter==0) {
			
			int possibleF1 = counter;
			int possibleF2 = product/counter;
			
			// Check if factor factor pair adds to sum
			checkSum(possibleF1, possibleF2, sum);
		}//if
		

		// If the factor pair passes the check, break to remove duplicate solutions
		if (stop==1) {
			break;
		}//if
		
	}//for
	
	}//factorPositive



	public static void factorNegativeC(int sum, int product) {
	/* Factor the standard form equation in the case where int product (passed to the parameter) is negative. */
		
	//Counter decreases starting at -1 
	for (int counter=-1; counter>product; counter--) {
		
		//Find factor pairs
		if (product%counter==0) {
			
			int possibleF1 = counter;
			int possibleF2 = product/counter;
			
			// Find valid factor pair (will add to sum)
			checkSum(possibleF1, possibleF2, sum);
		
		}//if
		
		// If a solution is found, break to remove duplicate solutions
		if (stop==1) {
			break;
		}//if
		
	}//for
		
	}//factor Negative
	


	public static int checkSum(int factor1, int factor2, int sum) {
	/* Return stop whether or not the factor pair consisting of integers factor1 and factor2 (in the parameters) add to equal the integer b (in the parameters). */
		
	// If the factor pair adds to sum, then the factor pair is valid.
	if (factor1 + factor2 == sum) {
		
		rValue = factor1;
		sValue = factor2;
		stop++;
	}//if
	
	// If the factor pair adds to sum, which is negative. They are valid.
	else if (((factor1+factor2)*-1)==sum) {
		
		rValue = factor1*-1;
		sValue = factor2*-1;
		stop++;
	}//else if

	return stop;
	}//checkSum
	
	public static String solveQuadForm(int a, int b, int c) {
	/* Return a string that displays the solution of the standard form quadratic equation consisting of 
	 * integers a, b and c (all passed to the parameter list) using the quadratic formula.
	 */
		
	if ((Math.pow(b, 2)-(4*a*c))<=0)	 {
		return "The equation has no real roots";
		}
		
	System.out.println("\nThe equation is not factorable");
	double rootOne = (-b + (Math.sqrt((Math.pow(b,2))-4*a*c)))/(2*a);
	double rootTwo = (-b - (Math.sqrt((Math.pow(b,2))-4*a*c)))/(2*a);
	
	return "The roots of the equation are " +rootOne+ " and " +rootTwo+ ".";
	}//solveQuadForm
	
	public static void printZeroes(int r, int s) {
	/* Display the factored form equation and the solutions using the integers r and s that are 
	 * passed to the parameters
	 */
		
	System.out.println("\nThe factored form equation is (x-r)(x-s), where r and s are zeroes.");
	System.out.printf("\nThe factored form equivalent equation is (x%+d)(x%+d) = 0",r,s);
	System.out.println("\nThe solutions are x="+r*-1+" and x="+s*-1);
	}//displayZeroes

}//SolvingFactoringStandardForm
