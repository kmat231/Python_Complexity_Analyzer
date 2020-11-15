//name: Kevin Mathew
//id number: 112167040
//recitation: 02

/**
 * Complexity class, aides in finding the complexity in Big O notation for each block
 * @author Kevin
 * 
 *
 */
public class Complexity {
	private int n_power; 
	private int log_power;
	
	/**
	 * No argument constructor
	 */
	public Complexity() {
	}
	/**
	 * 
	 * 2 argument constructor
	 * @param n_power
	 * represents the power of n
	 * @param log_power
	 * represents the power of log 
	 */
	public Complexity(int n_power, int log_power) {
		this.n_power = n_power;
		this.log_power = log_power;
	}
	
	/**
	 * 
	 * @return
	 * returns the power of n
	 */
	public int getN_power() {
		return n_power;
	}
	/**
	 * 
	 * @param n_power
	 * represents the power of n
	 *
	 */
	public void setN_power(int n_power) {
		this.n_power = n_power;
	}
	
	/**
	 * 
	 * @return
	 * returns the power of log
	 */
	public int getLog_power() {
		return log_power;
	}
	
	/**
	 * 
	 * @param log_power
	 * represents the power of log
	 */
	public void setLog_power(int log_power) {
		this.log_power = log_power;
	}
	
	
	/**
	 * toString function, associates the n and log powers with correct string formatting
	 */
	public String toString() {
		String complex = "";
		if(n_power == 0 && log_power == 0) {
			complex += "O(1)";
		}
		
		else if (n_power == 1 && log_power == 1) {
			complex += "O(n * log(n))";
		}
		
		else if(log_power == 1) {
			complex += "O(log(n))";
		}
		
		else if(n_power == 1) {
			complex += "O(n)";
		}
		
		else if (n_power != 0 && log_power == 0) {
			complex += "O(n^" + n_power + ")";
		}
		
		else {
			complex += "O(n^" + n_power + " * log(n)^" + log_power + ")"; 
		}
			return complex;
	}
	
	
}
