import java.util.Scanner;

public class RepeatCheck {
	Scanner scanner = new Scanner(System.in);
	
	void check (OrderVariables variables){
		System.out.printf("****************************************\n");
		System.out.printf("가격은 %d원입니다. 감사합니다.\n", variables.price);
		System.out.printf("계속 발권하시겠습니까?[1. 예 / 2. 아니오]\n");
		System.out.printf("선택: ");
		variables.repeat = scanner.nextInt();
		System.out.printf("\n**************************************\n");
		
		
	}
}
