//name: Kevin Mathew
//id number: 112167040
//recitation: 02

import java.util.Scanner; 
import java.io.File;
import java.io.FileNotFoundException; 

/**
 * 
 * @author Kevin
 * Scans through Python file and examines complexities of the codeblocks
 */
public class PythonTracer {
	public static final int SPACE_COUNT = 4;
	
	public static void main(String args[]) throws Exception {
		Scanner stdin = new Scanner(System.in);
		boolean running = true; 
		while(running) {
			try {
				System.out.println("Please enter a file name (or 'quit' to quit): ");
				String fileName = stdin.nextLine(); 
				
				if (fileName.equals("quit")) {
					System.out.println("Program terminating successfully...");
					running = false; 
				}
				
				else {
					Complexity overall = traceFile(fileName);
					fileName = fileName.substring(0, fileName.length() - 3);
					System.out.println("Overall complexity of " + fileName + ": " + overall.toString() + "\n");
					//System.out.print("here"); 
				}
			}
			
			catch (FileNotFoundException error) {
				System.out.print(error.getMessage() + "\n"); 
			}
			
			catch(Exception error) {
				System.out.print(error.getMessage() + "\n");
			}
		}
			stdin.close();
	}
	
	/**
	 * 
	 * @param fileName
	 * Python file name to be traced
	 * @return
	 * return total Complexity of the file
	 * @throws Exception
	 * throws exception for when the filename is null 
	 */
	public static Complexity traceFile(String fileName) throws Exception {
		if(fileName == null) {
			throw new Exception("Filename is null");
		}
		File file = new File(fileName); 
		Scanner scan = new Scanner(file);
		BlockStack stack = new BlockStack();
		CodeBlock oldTop = new CodeBlock();
		CodeBlock newBlock = new CodeBlock();
		Complexity oldTopComplexity = new Complexity(0,0);
		Complexity oldSubTopComplexity = new Complexity(0,0);
		String keyword = "";
		String data = "";
	
		while(scan.hasNextLine()){
			
			int indents = 0;
			int spaces = 0; 	
			boolean keyExists = false;
			data = scan.nextLine();
			//System.out.println(data);
			
			if((!data.isEmpty()) && (!data.contains("#"))){
 					for(int i = 0; i < data.length(); i++){
 						if (data.charAt(i) == ' ')
 							spaces++;
 						else 
 							break;
 					}			
 					indents = spaces / SPACE_COUNT;
 					//System.out.println(indents);
 					while (indents < stack.size()){	
 							if(indents == 0) {
 								scan.close();
 								System.out.println("Leaving Block 1");
 								return stack.peek().getBlockComplexity(); 
 							}
 							else {
 								oldTop = stack.pop();
 								oldTopComplexity = oldTop.getBlockComplexity();
 								oldSubTopComplexity = oldTop.getHighestSubComplexity();
 								String updating = "";
 								String leaving = "Leaving block " + oldTop.getName();
 									if(oldTopComplexity.getN_power() + oldTopComplexity.getLog_power() + oldSubTopComplexity.getLog_power() + oldSubTopComplexity.getN_power() > stack.peek().getHighestSubComplexity().getN_power() + stack.peek().getHighestSubComplexity().getN_power())
 								{		
 										Complexity finalComplex = new Complexity(); 
 										finalComplex.setN_power(oldTopComplexity.getN_power() + oldSubTopComplexity.getN_power());
 										finalComplex.setLog_power(oldTopComplexity.getLog_power() + oldSubTopComplexity.getLog_power());
 										stack.peek().setHighestSubComplexity(finalComplex);
 										updating = "updating block " + stack.peek().getName();
 								}
 									else {
 										updating = "nothing to update";
 									}
 									
 								System.out.println(leaving + ", " + updating);
 								System.out.println(stack.peek().toString()+ "\n");
 							}
 						}
 					
 					for (int i = 0; i < newBlock.BLOCK_TYPES.length; i++) {
 							if(data.contains(newBlock.BLOCK_TYPES[i])) {
 								keyword = newBlock.BLOCK_TYPES[i];
 								keyExists = true; 
 							}
 					}
 					if (keyExists) {
 						if(keyword.equals("def")){
 							CodeBlock defBlock = new CodeBlock();
 							Complexity defComplex = new Complexity(0,0);
 							Complexity subDefComplex = new Complexity(0,0);
 							defBlock.setName("1");
 							defBlock.setBlockComplexity(defComplex);
 							defBlock.setHighestSubComplexity(subDefComplex);
 							stack.push(defBlock);
 							System.out.println("\n" +"Entering block " + defBlock.getName() + " 'def' : ");
 							System.out.print(defBlock.toString() + "\n");
 							System.out.println();
 						}
 						
 						else if (keyword.equals(" for ")){
 							Complexity forComplex = new Complexity();
 							Complexity oldComplexity = stack.peek().getHighestSubComplexity();
 							if (data.contains("N:")) {
 								forComplex.setN_power(1);
 								forComplex.setLog_power(0);
 							}
 							if (data.contains("log_N:")) {
 								forComplex.setN_power(0);
 								forComplex.setLog_power(1);
 							}
 							CodeBlock forBlock = new CodeBlock();
 							forBlock.setBlockComplexity(forComplex);
 							forBlock.setHighestSubComplexity(oldComplexity);
 							String forName = stack.peek().getName();
 							forName += ".1";
 							forBlock.setName(forName);
 							stack.push(forBlock);
 							System.out.println("Entering block " + forBlock.getName() + " 'for' : ");
 							System.out.println(forBlock.toString() + "\n");
 							
 						}
 						
 						else if (keyword.equals(" while ")){
 							Complexity whileComplex = new Complexity(0,0);
 							CodeBlock whileBlock = new CodeBlock(); 
 							whileBlock.setBlockComplexity(whileComplex);
 							whileBlock.setHighestSubComplexity(whileComplex);
 							String loopVariable = Character.toString(data.trim().charAt(6));
 							whileBlock.setLoopVariable(loopVariable);
 							whileBlock.setName("1.2");
 							stack.push(whileBlock);
 							System.out.println("Entering block " + whileBlock.getName() + " 'while' : ");
 							System.out.println(whileBlock.toString() + "\n");
 							
 							
 							
 							
 						}
 					}	
 					else if(stack.peek().getName().contains("2") && data.contains(stack.peek().getLoopVariable())){
 						//update block
 						Complexity updateComplex = new Complexity(0,0); 
 						if(data.contains(" -= ")){
 							updateComplex.setN_power(1);
 						}
 						else if (data.contains(" /= ")) {
 							updateComplex.setLog_power(1);
 						}
 						stack.peek().setBlockComplexity(updateComplex);
 						System.out.println("Found update statement, updating block " + stack.peek().getName());
 						System.out.println(stack.peek().toString()+ "\n");
 					}
 
			}
	
			else {
				continue;
			}
		}
		while(stack.size() > 1) {
			oldTop = stack.pop(); 
			oldTopComplexity = oldTop.getBlockComplexity();
			if(oldTopComplexity.getN_power() > stack.peek().getHighestSubComplexity().getN_power()) {
				stack.peek().setHighestSubComplexity(oldTopComplexity);
			}
		}
		scan.close();
		
		System.out.println("Leaving block 1." + "\n");
		return stack.pop().getHighestSubComplexity();

	}
}
