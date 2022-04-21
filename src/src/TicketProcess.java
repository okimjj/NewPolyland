import java.util.ArrayList;

public class TicketProcess {
	OrderVariables variables;
	ArrayList <OrderVariables> orderList = new ArrayList <OrderVariables>(); 
	OrderStage ordStage = new OrderStage();
	AgeCalculator ageCal = new AgeCalculator();
	TicketChoice tickChoice = new TicketChoice();
	Discount dc = new Discount();
	RepeatCheck rpCheck = new RepeatCheck();
	EndPrint end = new EndPrint();
	
	void run() {
		
		do {
			variables = ordStage.order(variables);
			
			ageCal.ageCal(variables);
			
			tickChoice.ticketChoice(variables.dayOrNight, variables);
			
			dc.discount(variables.discountCondition, variables);
			
			for (int index = 0; index < orderList.size(); index++) {
				variables.priceFinal = variables.priceFinal + orderList.get(index).price;
			}
			
			variables.priceFinal = variables.priceFinal + variables.price;
			
			rpCheck.check(variables);
			
			orderList.add(variables);
			
		} while (variables.repeat == 1);
		
		
		end.ending();
		
		for (OrderVariables items : orderList) {
			
			System.out.printf("%5s\t", items.ticketTypeName);
			System.out.printf("%3s\t", items.ageGroup);
			System.out.printf("%d장\t", items.numberOfTicket);
			System.out.printf("%7d원\t", items.price);
			System.out.printf("%s\n", items.discountType);
		}
		
		System.out.printf("==================================\n");
		System.out.printf("총 결제액은 %d원입니다. 감사합니다.", variables.priceFinal);
	}
}
