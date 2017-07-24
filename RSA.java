import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//The objective of this project is to 
 
// What is the point of having a private key and a public key?

//This algorithm  encrypts a message and sends it to someone
//and then have them decrypt the message. 




public class RSA {

	public static void main(String[] args) {
		/*
		 * Part 1 - prompt user for a string input of ASCII characters. Encode
		 * the string into a list of integers.
		 * 
		
		 */
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the message you would like to encode, using any ASCII characters: ");
		String input = keyboard.nextLine();
		int[] ASCIIvalues = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			ASCIIvalues[i] = input.charAt(i);
		}
		String ASCIInumbers = "";
		for (int j = 0; j < ASCIIvalues.length; j++) {
			ASCIInumbers += ASCIIvalues[j] + " ";
		}
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println("The ASCII coded sequence is:");
		System.out.println();
		System.out.println(ASCIInumbers);
		System.out.println();
		System.out.println("-----------------------------------------");

		long P = BigPrime();
		long Q = P;
		while (Q == P) {			
		Q = bigPrime();
}
	
		
		System.out.println();
		System.out.println("The two primes are P = " + P + " and Q = " + Q);
		System.out.println();
		System.out.println("The product of the two primes, P*Q, is the modulus for both the private");
		System.out.println("and public key and is thus part of the public domain: " + P * Q);
		System.out.println("Something interesting to note about how this algorithm works is that");
		System.out.println("while P*Q is public, factoring very large numbers is very difficult");
		System.out.println("computationally, so only the person with the knownledge of the");
		System.out.println("individual values P and Q, has the tools to derive the private key.");
		System.out.println();
		System.out.println("-----------------------------------------");

		/*
		 * Part 3 - Next, we calculate the public key exponent, called E. E is
		 * chosen to be an integer which is relatively prime to another integer
		 * called the totient, usually represented by phi. In this step,
		 * calculate phi, which is equal to (P-1)(Q-1). The create a public key
		 * exponent, create an integer E that is relatively prime to phi, and
		 * also less than phi.
		 * 
		 *
		 */

		long phi = (P-1)*(Q-1);
		
		////////////////////////////////////////////////		

		// next is an algorithm to find E which is relatively prime to phi here.
		// in other words find E such that gcd(phi,E)=1, and E<phi.
		//gcd( phi,n )  n==E
		int n=0;
		int c = 0;
		int E =0;
		boolean eFound = false;
		while(c < phi && !eFound){
			int gcd = 0;
			int r = 0;
			long p = phi;
			
			while(p !=0){
				r= (int) (n%p);
				n = (int) p;
				p = r;
			}
			//System.out.println("The GCD is: "+ n);
			if(n==1 && 0.25*phi < c && c <0.75*phi){
				E = c;
				eFound = true;
			}
			
			c=c+1;
			n++;
			}

			
			

		///////////////////////////////////////////////	
		
	
		
		System.out.println("The totient is phi = " + phi);
		System.out.println("and");
		System.out.println("The public key is E = " + E);
		System.out.println();
		
		System.out.println("-----------------------------------------");
	
		/*
		 * Part 4 - Find the multiplicative inverse of E mod (P-1)(Q-1). In this
		 * step, we are looking for D such that E*D = 1 mod phi. Remember, phi
		 * is called the totient and is equal to (P-1)(Q-1). To do this, we need
		 * to find what are called the Bezout coefficients of E and phi. The
		 * algorithm to get these numbers is called the '+.' 
		 * In part 4, you used the gcd function from a built-in
		 * library to make sure that the GCD of the integer you generated and
		 * phi is 1. [ie gcd(phi,E) = 1 ].There MUST exist coefficients x and y
		 * such that x*phi + y*E = 1.  The very important thing to notice about the Bezout
		 * coefficient y is that it must also be the multiplicative inverse of 
		 * 
		 * E(mod phi). Note: if x*phi + y*E = 1, then y*E = 1 - x*p56yhi, which
		 * means y*E = 1 mod phi. In this next section, is the
		 * 
		 * first part of the extended Euclidean algorithm, which will confirm
		 * that gcd(E,phi)=1, and
		 * 
		 *  
		 *  and will also generate a list of remainders and
		 * quotients which will be needed to perform the second
		 *  part of the EA
		 * 
		 * 
		 * Next, write the second part of the 
		 * extended
		 * euclidean algorithm, 
		 * which returns the bezout coefficients 
		 * to find
		 * the multiplicative inverse of E (mod phi). I will call that inverse
		 * D, and D is called the PRIVATE
		 *  KEY EXPONENT, and should only be known
		 * by the person to whom the message is being sent.
		 * 
		 * 
		 */
		
		
		long p1 = phi;
		
		long h =0;
		ArrayList rem = new ArrayList();
		ArrayList quo = new ArrayList();
	
		n = 0;
		
		c = 0;
		int gcd = 0;
		int r1 = 0;
		long p = phi;
		
		quo.add(phi/E);
		rem.add(phi%E);
		int i=0;
		quo.add(E/(long) rem.get(0));
		rem.add(E % (long) rem.get(0));
		while((long)rem.get(i+1)!=1){
		
		quo.add((long)rem.get(i)/(long) rem.get(i+1));
		rem.add((long)rem.get(i)%(long) rem.get(i+1));
		System.out.print(rem);
		i++;
		}
	
			
		
		   
	 for (int l = 0; l < rem.size(); l++) {
    long value = (long) rem.get(l);
        }
     for (int j = 0; j < quo.size(); j++) {
       long value1 = (long) quo.get(j);
            
     }
     	ArrayList x = new ArrayList();
		ArrayList y = new ArrayList();
		
		x.add((long) 1);
		y.add(0, -1 * (long) quo.get(i + 1));
		int k=1;
		i++;
		while(k<=i){
			x.add(k,y.get(k-1));
			y.add(k,(long)x.get(k-1)-((long)quo.get(i-k)*(long)y.get(k-1)));
			k++;
		}
	
		long D = 0;
		if((long)y.get(y.size() - 1)<0){
			D = (long)y.get(y.size() - 1)+(long)phi;
		} else {
			D = (long) y.get(y.size() - 1);
		}
		
		
		
//		

		//////////////////////////////////////////////
    
		//Next, IS the second part of the euclidean algorithm, where I substitute
		//the way back up the algorithm to find the multiplicative inverse of E.

		////////////////////////////////////////////////

		//Display results
		

		System.out.println("The Bezout Equation for E and phi is given by:");
		System.out.println(D + "*" + E + "+" + x.get(x.size()-1) + "*" + phi + " = " + (D * E + (long) x.get(x.size()-1) * phi));

		//depending on whether you take an odd or even number of steps, D may end up
		//as a negative. I must make sure D is positive so that I may use it as an exponent.. 

		//Display results for of extended Euclidean Algorithm
		

		System.out.println("Which means the private key is D = " + D);
		System.out.println("D*E mod phi = " + (D * E) % phi);
		System.out.println("So the above equation is written as");
		System.out.println(D + " * " + E + " mod " + phi + " = " + (D * E) % phi);
		System.out.println();
		System.out.println("-----------------------------------------");

		/*
		 * Part 5 - Encrypt the ASCII-coded message using the public key. This
		 * is accomplished by taking the ASCII-coded list and raising each
		 * component to power of the public key exponent, and dividing modulus
		 * PQ. One hint to note: taking the ASCII code and raising to the power
		 * E leads to a HUGE number, which will cause an overflow. 
		 * instead make use of the fact thatI  can divide modulo n after each
		 * \multiplication. 
//Here I perform the calculation to encrypt ASCIIstringEncoded here.


		i=0;
		int div = P*Q;
	    int[] stringEncrypted = new int[input.length()];
		 
		while(i< ASCIIvalues.length)
			{
			long mod = ASCIIvalues[i];
			n = 1;
		while(n<E){
			mod = mod*ASCIIvalues[i]%div;
			n++;
		}
		
		stringEncrypted[i]=(int) (mod);
		System.out.print(mod + " ");

			i++;
			}
	
	
		System.out.println();
		System.out.println("The ASCII sequence after encrypting with the public key is:");
		System.out.println();
		System.out.println(Arrays.toString(stringEncrypted));
		System.out.println();
		System.out.println("-----------------------------------------");

		/*
		 * Part 6 - To decrypt the encrypted code, one raises each of the
		 * elements in the encrypted string to the private key exponent, and
		 * dividing modulus PQ.
		 * 
		 *
		 */

		//use the variable name stringDecrypted for the list of decrypted integers.
//Perform the calculation to decrypt the list stringEncrypted into the list
//stringDecrypted here.
	n=0;
	i=0;
	div = P*Q;
	int[] stringDecrypted = new int[input.length()];
	 
	while(i< ASCIIvalues.length)
	{
	long mod = stringEncrypted[i];
	n = 1;
while(n<D){
	mod = (mod*stringEncrypted[i])%div;
	
	
	n++;
}

stringDecrypted[i]=(int) (mod);
System.out.print(mod + " ");

	i++;
	}

		/////////////////////////////////////////////////////
		System.out.println();
		System.out.println("The ASCII sequence after decrypting with the private key is:");
		System.out.println();
		System.out.println(Arrays.toString(stringDecrypted));
		System.out.println();
		System.out.println("-----------------------------------------");

		/*
		 * Part 7 - The decrypted message should now be a list of integers which
		 * are the ASCII code of the of the original message. 
		 * 
		 * 
		 */

		String message = "";
		for (int n1 = 0; n1 < stringDecrypted.length; n1++) {
			message = message + (char) stringDecrypted[n1];
		}

		System.out.println();
		System.out.println("The decrypted message is:");
		System.out.println();
		System.out.println(message);
		System.out.println();
		System.out.println("-----------------------------------------");
	
		/*Part 8 - 
		//To digitally sign the message, input a 4 digit PIN...

		System.out.println("Enter a 4 digit integer 'PIN' : ");
		int pin = keyboard.nextInt();
		String pas = String.valueOf(pin);
		System.out.println();
		
		//Now, to verify  the sender, the program will encrypt the pin with the private
//key (D, which no one else knows)...

// code which encrypts the pin number with the private key

		n=0;
		i=0;
		div = P*Q;
		
		
		
		long mod = 1;
		
	while(n<E){
		
		mod = (mod*pin)%div;
		
		
		n++;
	}

	int pinEncrypted=(int) (mod);
	System.out.print(mod + " ");


		
/////////////////////////////////////////////////////////

		System.out.println();
		System.out.println("The encrypted PIN is: " + pinEncrypted);
		System.out.println();
		

		

//Here you should write your code for decrypting the int PINencrypted. Use the
//variable PINdecrypted 

/////////////////////////////////////////////////////
		n=0;
		i=0;
		div = P*Q;
		
		
		
		 mod = 1;
		
	while(n<D){
		
		mod = (mod*pinEncrypted)%div;
		
		
		n++;
	}

	int pinDecrypted=(int) (mod);
	System.out.print(mod + " ");

		
/////////////////////////////////////////////////////////

		System.out.println();
		System.out.println("The encrypted PIN is: " + pinDecrypted);
		System.out.println();
	/*
	 * Part 2 - Define two very large, random, primes. Do not allow the primes
	 * to be larger than 2*10^3 or so, as larger numbers may cause an overflow
	 * On the other hand, be sure that the primes are at least as
	 * large as 5*10^2.
	 * 
	 * 
	 */
	}
	public static int bigPrime() {
		boolean prime = false;
		int n = 0;
		while (!prime) {
			Random rand = new Random();
			n = rand.nextInt(500);
			n = 2 * (n + 500) + 1;
			int sqrtn = (int) Math.pow(n, 0.5) + 1;
			for (int i = 3; i < sqrtn; i += 2) {
				if (n % i == 0) {
					prime = false;
					break;
				} else {
					prime = true;
				}
			}
		}
		return n;
	}

	//Method to compute the GCD of two positive integers.
	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}
