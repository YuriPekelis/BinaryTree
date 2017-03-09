package BinaryTree;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
	Scanner inputData = new Scanner (System.in);
	System.out.println("Input number of elements:");
	int numberElements;
	if (inputData.hasNextInt()){
		numberElements = inputData.nextInt();
		if (numberElements <= 0) {
			System.out.println("Wrong number of elements!");
			inputData.close();
			return;		
		}
	}
	else {
		System.out.println("It`s not 'int' number!");
		inputData.close();
		return;		
	}
	System.out.println ("Please enter element #1:");
	if (!inputData.hasNextDouble()) {
		inputData.close();
		System.out.println ("Element #1 isn`t double");
		return;
	}
	Element first = new Element (inputData.nextDouble());
	for (int i = 1; i < numberElements; i++) {
		System.out.println("Please enter element #" + (i+1) + ":");		
		if (!inputData.hasNextDouble()) {
			inputData.close();
			System.out.println("Element #" + (i+1) + " isn`t double");
			return;
		}
		first.addOneMore(inputData.nextDouble());
	}
	int choose = 0;
	while (choose != 3){
		System.out.println("Please choose operation: 1 - Add one more; 2- Search; 3 - Exit");
		choose = 0;
		if (inputData.hasNextInt()) {
			choose = inputData.nextInt();
			switch (choose) {
			case 1: {
				System.out.println("Enter new element:");
				if (inputData.hasNextDouble())
					first.addOneMore(inputData.nextDouble());
				else
					System.out.println("Incorrect element. Must be 'double' type!");
				break;
			}
			case 2: {
				System.out.println("Enter element to find:");
				if (inputData.hasNextDouble())
					if (first.findElement(inputData.nextDouble()))
						System.out.println("This element is present");
					else
						System.out.println("This element is absent");
				else
					System.out.println("Incorrect element. Must be 'double' type!");
				break;
			}
			default:
				choose = 0;
			}
		}
			
	}
	System.out.println("Bye!");
	inputData.close();
	}

}
