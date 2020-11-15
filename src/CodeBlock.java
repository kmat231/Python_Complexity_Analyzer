//name: Kevin Mathew
//id number: 112167040
//recitation: 02

/**
 * CodeBlock represents blocks of code within loops
 * @author Kevin
 *
 */
public class CodeBlock {
	public final String[] BLOCK_TYPES = {
				"def"," for "," while "," if "," else "," elif "};
	public final int DEF = 0;
	public final int FOR = 1;
	public final int WHILE = 2;
	public final int IF = 3;
	public final int ELIF = 4;
	public final int ELSE = 5;
	
	private String name;
	private Complexity blockComplexity;
	private Complexity highestSubComplexity;
	private String loopVariable; 
	
	/**
	 * no argument constructor
	 */
	public CodeBlock(){	
	}

	/**
	 * 
	 * @return
	 * return name of the Codeblock
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 * set the name of the CodeBlock
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * return the complexity of the the CodeBlock
	 */
	public Complexity getBlockComplexity() {
		return blockComplexity;
	}

	/**
	 * 
	 * @param blockComplexity
	 * set the complexity of the CodeBlock
	 */
	public void setBlockComplexity(Complexity blockComplexity) {
		this.blockComplexity = blockComplexity;
	}

	/**
	 * 
	 * @return
	 * return the highest sub complexity
	 */
	public Complexity getHighestSubComplexity() {
		return highestSubComplexity;
	}

	/**
	 * 
	 * @param highestSubComplexity
	 * set the highest sub complexity
	 */
	public void setHighestSubComplexity(Complexity highestSubComplexity) {
		this.highestSubComplexity = highestSubComplexity;
	}

	/**
	 * 
	 * @return
	 * return the while loop variable
	 */
	public String getLoopVariable() {
		return loopVariable;
	}

	/**
	 * 
	 * @param loopVariable
	 * set the loop variable for the while loop
	 */
	public void setLoopVariable(String loopVariable) {
		this.loopVariable = loopVariable;
	}
	
	/**
	 * Neatly formatted String method for the codeblock
	 */
	public String toString() {
		String block = "BLOCK " + this.getName() + ":";
		String complexity = "block complexity = " + this.getBlockComplexity().toString();
		String highComplex = "highest sub-complexity = " + this.getHighestSubComplexity().toString();
		
		return String.format("%-5s%-20s%-30s%-30s"," ",block, complexity, highComplex);
	}
	
	
	
	
	
}
