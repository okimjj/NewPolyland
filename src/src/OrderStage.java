import java.util.Scanner;

public class OrderStage {
//	OrderVariables variables = new OrderVariables();
	Scanner scanner = new Scanner(System.in);
//	OrderVariables variables;
	
	public OrderVariables order(OrderVariables variables) {
		variables = new OrderVariables();

		System.out.printf("권종을 선택하세요.\n1. 종일권\n2. 야간권\n");
		System.out.printf("선택: ");
		variables.dayOrNight = scanner.nextInt();
		
		
		System.out.printf("****************************************\n");
		System.out.printf("주민등록번호 7번째 자리까지 입력하세요\n");
		System.out.printf("주민번호: ");
		variables.juminString = scanner.next();
		
	for (int index = 0; index < variables.juminString.length(); index++) {
		variables.jumin[index] = variables.juminString.charAt(index);
	}
	
	do {
		System.out.printf("****************************************\n");
		System.out.printf("몇 장을 주문하시나요? (10장 초과 시 무효)\n"); 
		System.out.printf("수량: ");
		variables.numberOfTicket = scanner.nextInt();
	} while (variables.numberOfTicket > 10);
	
	System.out.printf("****************************************\n");
	System.out.printf("우대사항을 선택하세요.\n");
	System.out.printf("1. 장애인\n2. 국가유공자\n3. 임산부\n4. 휴가장병\n5. 다둥이\n6. 없음\n");
	System.out.printf("선택: ");
	variables.discountCondition = scanner.nextInt();
	
//	System.out.println("*****************"+variables.dayOrNight);
//	System.out.println("*****************"+variables.juminString);
//	System.out.println("*****************"+variables.numberOfTicket);
//	System.out.println("*****************"+variables.discountCondition);
	return variables;
	}
}
