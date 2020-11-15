//name: Kevin Mathew
//id number: 112167040
//recitation: 02

import java.util.Stack;

/**
 * This class allows use to implement the stack operations for storing codeBlocks
 * 
 * @author Kevin
 *
 */
public class BlockStack {
	Stack <CodeBlock> stack = new Stack<CodeBlock>();
	
	/**
	 * 
	 * @param block 
	 * Codeblock object to be pushed to stack
	 * 
	 */
	public void push(CodeBlock block) {
		stack.push(block);
	}
	
	/**
	 * 
	 * @return
	 * returns the Codeblock object at the top of the stack
	 */
	public CodeBlock pop() {
		return stack.pop();
	}
	
	/**
	 * 
	 * @return
	 * returns the Codeblock object information without popping it from the stack
	 */
	public CodeBlock peek() {
		return stack.peek();
	}
	
	/**
	 * 
	 * @return
	 * returns the size of the stack
	 */
	public int size() {
		return stack.size(); 
	}
	
	/**
	 * 
	 * @return
	 * returns if the stack is empty
	 */
	public boolean isEmpty() {
		return stack.empty();
	}
	
	
}
