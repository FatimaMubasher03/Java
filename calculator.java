import java.util.Scanner;

class calculator{
	public static void main(String args[])
	{
		System.out.println("Calculator");
		Scanner in = new Scanner(System.in);
		//int a,b;
		//String operator;

		System.out.println("Value 1: ");
		int a= in.nextInt();
		
		System.out.println("Value 2: ");
		int b= in.nextInt();
		
		System.out.println("Operator: ");
		String operator= in.next().trim();

		int result=0;
		//boolean ans =true;
		
		if (operator.equals("+")){
			result=a+b;
		}

		else if (operator.equals("-")){
			result=a-b;
		}

		else if (operator.equals("*")){
			result=a*b;
		}
	
		else if (operator.equals("/")){
			if (b!=0){
				result=a/b;
			}
			else{
				System.out.println("Error: Division by zero!");
				in.close();
				return;
				//ans=false;
			}
		}	
		else{
            System.out.println("Invalid operator!");
            in.close();
            return; 
        }
		System.out.println("Result: " + result);
		in.close();
		
	}
}