import java.io.IOException;

public class TammysFunTimeDFATester {
	private static String myFile = "file.txt";
	private static String inputFile = "testStrings.txt";
	private String inputs[];

	/* Constructor: reads the input strings into the inputs array */
	public TammysFunTimeDFATester(String inputFile) {
		try {
			this.inputs = DFA.readFile(inputFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/* The main function creates a DFA, defined in file.txt
	 * Then tests strings against this DFA, printing if they're
	 * accepted or not.
	 */
	public static void main(String [] args)
	{
		// create a DFA
		DFA myDFA = new DFA(myFile);
		TammysFunTimeDFATester myTester = new TammysFunTimeDFATester(inputFile);

		// test every input string on the DFA
		for(int i = 0; i < myTester.inputs.length; i++){
			String input = myTester.inputs[i];
			boolean accept = myDFA.makeTransitions(input);

			myTester.printResult(input, accept);
		}


	}

	private void printResult(String input, boolean accept){
		String line = input + ": ";

		if(accept){
			line += "accepted";
		} else {
			line += "rejected";
		}

		System.out.println(line);
	}




}
