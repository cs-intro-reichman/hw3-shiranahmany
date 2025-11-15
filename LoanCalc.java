// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		//System.out.println((int)endBalance(loan, rate, n,  10000));
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int)bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		//double endPay = loan * (1+ (rate / 100));
		double calcLoan = loan;
		for(int i = 0; i < n; i++){
			calcLoan = calcLoan - payment;
			calcLoan = calcLoan * (1 + (rate / 100));
			//System.out.println(calcLoan);
		}

		return calcLoan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// Replace the following statement with your code
		double g = (loan / (double)(n));
		double checkPayment = endBalance(loan, rate, n, g);
		iterationCounter = 0;
		while(checkPayment > 0){
			g = g + epsilon;
			checkPayment = endBalance(loan, rate, n, g);
			iterationCounter++;
		}
		
		return g;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
        double h = loan/2.0;
		double lo = loan/(double)(n*2);
		double mid = (h + lo)/2.0;
		double check = endBalance(loan, rate, n, mid);
		double checkL = endBalance(loan, rate, n, lo);
		iterationCounter = 1;
		while((h - lo) > epsilon){
			check = endBalance(loan, rate, n, mid);
			checkL = endBalance(loan, rate, n, lo);
			if ((check * checkL) > 0) {
				lo = mid;
			} else {
				h = mid;
			}
			mid = (h + lo)/2.0;
			iterationCounter++;
		}
		return mid;
    }
}