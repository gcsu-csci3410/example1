import java.util.*;
import java.io.*;

/**
 * @author gita.phelps
 *
 */
enum Operator {ADD, SUBTRACT};

public class Evaluator {
	public static void main(String[] args) {
		ArrayList<Variable> list = new ArrayList<Variable>();
		String[] tokensInExpression;
		try {
			File file = new File("data.txt");
			Scanner input = new Scanner(file);
			boolean error = false;

			while (input.hasNext()) {
				String line = input.nextLine();
				//System.out.println(line);
				error = false;

				if (isVariableDeclaration(line)) {
					extractVariables(list, line);
				} 
				else if (isAssignmentStatement(line))
				{
					tokensInExpression = splitExpression(line);
					Operator currentOp = Operator.ADD;
					int exprValue = 0;
					for (String str : tokensInExpression) {
						if (isNonEmptyString(str)) {
							if (isAnOperator(str))
							{
								currentOp = setOperator(str);
							}
							else if (isANumber(str)) {
								int num = Integer.parseInt(str);
								exprValue = evaluateOperation(currentOp, exprValue, num);
							} 
							else if (isAValidVariable(list,str))
							{
								Variable var = getVariable(list, str);
								int num = var.getValue();
								exprValue = evaluateOperation(currentOp, exprValue, num);
							}
							else
							{
								error = true;
							}
						}
					}
					String leftStr = extractStorageVariable(line); 
					if (!isAValidVariable(list, leftStr))
						error =true;
					if (!error)
					{
						Variable var = getVariable(list,leftStr);
						var.setValue(exprValue);
					}
					else
						System.out.println(line +"Error in statement");
				}
				
			}
			printVariables(list);
			input.close();
		} catch (Exception e) {
			System.out.println("Error processing file");
		}
	}


	private static Variable getVariable(ArrayList<Variable> list, String str) {
		Variable var = null;
		for (Variable v: list)
			if(v.getId().equalsIgnoreCase(str))
				var = v;
		return  var;
	}

	private static int evaluateOperation(Operator op, int exprValue, int num) {
		if (op == Operator.ADD)
			exprValue = exprValue + num;
		else
			exprValue = exprValue - num;
		return exprValue;
	}

	private static boolean isAValidVariable(ArrayList<Variable> list, String str) {
		boolean found= false;
		for (Variable v: list)
		{
			if (v.getId().equalsIgnoreCase(str))
				found = true;
		}
		return found;
	}

	private static boolean isAssignmentStatement(String line) {
		int index = line.indexOf("=");
		int lastIndex = line.lastIndexOf("=");
		if (index !=-1 && index== lastIndex)
			return true;
		return false;
	}

	/** 
	 * Gets the left side of the equal sign
	 * @param assignmentStatement
	 * @return storage variable
	 */
	private static String extractStorageVariable(String assignmentStatement) {
		int index = assignmentStatement.indexOf("=");
		String storageVariable = assignmentStatement.substring(0, index).trim();
		return storageVariable;
	}

	/**
	 * @param line
	 * @param index
	 * @return
	 */
	private static String[] splitExpression(String line) {
		int index = line.indexOf("=");
		String[] tokens;
		String expression = line.substring(index + 1);
		tokens = expression.split("[ ]");
		return tokens;
	}

	/**
	 * @param statement
	 * @return
	 */
	private static boolean isVariableDeclaration(String statement) {
		statement = statement.trim();
		return  statement.startsWith("var ") && !statement.contains("=");
	}

	/**
	 * @param str
	 * @return
	 */
	private static boolean isNonEmptyString(String str) {
		return str.length() > 0;
	}

	/**
	 * @param s
	 * @return
	 */
	private static Operator setOperator(String s) {
		Operator op = Operator.ADD;
		if (s.equals("+"))
			op = Operator.ADD;
		else if (s.equals("-"))
			op = Operator.SUBTRACT;
		return op;
	}

	/**
	 * @param s
	 * @return
	 */
	private static boolean isAnOperator(String s) {
		return s.equals("+") || s.equals("-");
	}

	private static boolean isANumber(String s) {
		try
		{
			int num = Integer.parseInt(s);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}



	/**
	 * @param list
	 * @param line
	 */
	private static void extractVariables(ArrayList<Variable> list, String line) {
		String[] tokens;
		tokens = line.split("[ ,]");
		if (tokens[0].equalsIgnoreCase("var")) {
			for (int i = 1; i < tokens.length; i++) {
				if (tokens[i].length() > 0) {
					Variable temp = new Variable();
					temp.setId(tokens[i]);
					list.add(temp);
				}
			}
		}
	}

	/**
	 * @param list
	 */
	private static void printVariables(ArrayList<Variable> list) {
		for (Variable v : list)
			System.out.println(v);
	}

	/**
	 * @param list
	 * @param name
	 * @return
	 */
	public static int search(ArrayList<Variable> list, String name) {
		int loc = -1;
		for (Variable v : list) {
			loc++;
			if (v.getId().equalsIgnoreCase(name))
				return loc;
		}
		return -1;
	}

}