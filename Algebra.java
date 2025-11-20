// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int n = x1;
		if(x2 >= 0){
			for(int i = 0 ; i < x2 ; i++) {
				n++;
			}
		} else {
			for(int i = 0 ; i < (-1 * x2) ; i++){
				n--;
			}
		}
		return n;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		int n = x1;
		if(x2 < 0){
			for(int i = 0 ; i < (-1 * x2) ; i++) {
				n++;
			}
		} else {
			for(int i = 0 ; i < x2 ; i++){
				n--;
			}
		}
		return n;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int n = x1;
		int time = x2;
		boolean neg = false;
		if(x1 < 0) neg = !neg;
		if(x2 < 0) neg = !neg;
		if(x1 == 0 || x2 == 0) return 0;
		if(x1 < 0) n = minus(0, x1);
		if(x2 < 0) time = minus(0, x2);
		int n2 = n;
		for(int i = 1 ; i < time ; i++){
			n = plus(n, n2);
		}
		if(neg) n = minus(0, n);
		return n;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int n1 = x;
		int n2 = x;
		int calc = n;
		if(n == 0) return 1;

		for(int i = 1 ; i < calc ; i++){
			n1 = times(n1, n2);
		}
		return n1;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int n1 = x1;
		int n2 = x2;
		int calc = 0;
		boolean neg = false;
		if(x1 == x2) return 1;
		if(x2 == 1) return x1;
		if(x1 < 0){
			neg = !neg;
			n1 = minus(0, n1);
		}
		if(x2 < 0){
			neg = !neg;
			n2 = minus(0, n2);
		}
		while(n1 > 0){
			n1 = minus(n1, n2);
			calc ++;
		}
		if(n1 < 0){
			calc--;
		}
		if(neg) calc = minus(0, calc);
		return calc;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int n1 = x1;
		int n2 = x2;
		while(n1 >= n2){
			n1 = minus(n1, n2);
		}
		return n1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// Replace the following statement with your code
		int n1 = 2;
		int toRoot = x;
		int res = 0;
		if(toRoot == 0 || toRoot < 0){
			return 0;
		} 
		while(res < toRoot){
			res = pow(n1, 2);
			n1++;
		}
		n1--;
		if (res > toRoot) {
			n1--;
		}
		return n1;
	}	  	  
}