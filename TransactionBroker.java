public class TransactionBroker{
	
	public static void main(String[] args){
		double amount = 500.0;
		double negativeCounter = 0.0;
		for(int counter=0; counter < args.length; counter++){
				String BOLD = "\u001b[1m";
				double addition = 0.0;
				if(isValidOperator (args[counter])){
					System.out.println("The " + args[counter] + " operator must be preceded by, and followed by, numeric operands");
					return; //end program
				}else if(isValidDouble(args[counter])){

					if(counter+1 < args.length){
						if(isValidDouble(args[counter + 1])){
							addition = Double.parseDouble(args[counter]);

						}else if(isValidOperator(args[counter + 1])){
							if(counter+2 < args.length){
								if(isValidDouble(args[counter + 2])){
									addition = operation(Double.parseDouble (args[counter]), Double.parseDouble (args[counter+2]), (args[counter+1]));
									counter+=2;

								}else if(((counter + 2) < args.length) && isValidOperator(args[counter + 2])){
									System.out.println("The " + args[counter+1] + " operator must be preceded by, and followed by, numeric operands");
									return;
								
								}else{
									System.out.println("\"" + args[counter+1] + "\" is not a valid operator. Transactions can’t be processed.");
									return;
								}
							}else{
								System.out.println("The " + args[counter+1] + " operator must be preceded by, and followed by, numeric operands");
								return;
							}
						}else{
							System.out.println("\"" + args[counter+1] + "\" is not a valid operator. Transactions can’t be processed.");
							return;
						}
					}else{
						addition = Double.parseDouble(args[counter]);
					}


				}else{
					System.out.println("\"" + args[counter] + "\" is not a valid operator. Transactions can’t be processed.");
					return; //end program
				}

			if(amount>=500 && amount + addition < 500){
				amount=amount+addition;
				if(amount>=0){
					System.out.println("Your balance: $" + amount);
					System.out.println("Your last transaction lowered your balance to $" + amount);
					amount = amount - 20;
					System.out.println("You have been charged a low-balance penalty of $20.0");
					System.out.println("Your balance: $" + amount);
					negativeCounter += 20.0;
				}else{
					System.out.println("Your balance: -$" + (Math.abs(amount)));
					System.out.println("Your last transaction lowered your balance to -$" + (Math.abs(amount)));
					amount = amount - 20;
					System.out.println("You have been charged a low-balance penalty of $20.0");
					System.out.println("Your balance: -$" + (Math.abs(amount)));
					negativeCounter += 20.0;
				}
			}else{
				amount=amount+addition;
				if(amount>=0){
					System.out.println("Your balance: $" + amount);
				}else{
					System.out.println("Your balance: -$" + (Math.abs(amount)));
				}

			}
		}
		if(amount>=0){	
			System.out.println("********************");
			System.out.println("Your final balance: $" + amount);
			System.out.println("The total you were charged in penalties: $" + negativeCounter);
		}else{
			System.out.println("********************");
			System.out.println("Your final balance: -$" + (Math.abs(amount)));
			System.out.println("The total you were charged in penalties: $" + negativeCounter);
		}
	}



public static boolean isValidDouble(String str){
		try{
			Double.parseDouble(str);
			return true;
		}catch (NumberFormatException e){
			return false;
		}
}

public static boolean isValidOperator(String operator){
	switch (operator){
		case "sub":
			return true;

		case "mul":
			return true;

		case "div":
			return true;

		case "mod":
			return true;

		case "add":
			return true;

		case "pow":
			return true;
	}
		return false;

}							


public static double operation(double op1, double op2, String operator){	
		
				switch (operator){
					case "sub":
						return op1 - op2;

					case "mul":
						return op1 * op2;

					case "div":
						return op1 / op2;

					case "mod":
						return op1 % op2;

					case "add":
						return op1 + op2;

					case "pow":
						return exponentiate(op1, op2);

					default:
						return -1;
				}

}


public static double exponentiate(double base, double exponent){
	return (Math.pow(base, exponent));
}
}
