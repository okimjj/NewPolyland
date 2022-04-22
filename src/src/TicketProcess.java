import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TicketProcess {
	OrderVariables variables;//입력 데이터 클래스
	ArrayList <OrderVariables> orderList = new ArrayList <OrderVariables>(); //구매 목록 ArrayList 
	OrderStage ordStage = new OrderStage(); //주문 정보 입력 클래스
	AgeCalculator ageCal = new AgeCalculator(); //나이 계산 클래스
	TicketChoice tickChoice = new TicketChoice(); //권종 선택에 따른 가격 계산 클래스
	Discount dc = new Discount(); //할인 조건에 따른 가격 계산 클래스
	RepeatCheck rpCheck = new RepeatCheck(); // 반복 여부 확인 클래스
	EndPrint end = new EndPrint(); //최종 구매 결과 출력 클래스
	
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
			
			try {
				BufferedWriter dataPrint;
				dataPrint = new BufferedWriter(new FileWriter("C:\\Users\\jj\\Desktop\\NewPolylandUp\\SellData.csv", true));
				dataPrint.write(orderList.get(orderList.size() - 1).ticketTypeName + ",");
				dataPrint.write(orderList.get(orderList.size() - 1).ageGroup + ",");
				dataPrint.write(orderList.get(orderList.size() - 1).age + " 세 ,");
				dataPrint.write(orderList.get(orderList.size() - 1).price + ",");
				dataPrint.write(orderList.get(orderList.size() - 1).numberOfTicket + ",");
				dataPrint.write(orderList.get(orderList.size() - 1).discountType + "\n");
				
				dataPrint.flush();
				dataPrint.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} while (variables.repeat == 1);
		
		
		end.ending();
		
		for (OrderVariables items : orderList) { //구매 최종 결과 출력
			
			System.out.printf("%5s\t", items.ticketTypeName); //고객이 선택한 권종
			System.out.printf("%3s\t", items.ageGroup); //고객의 연령대
			System.out.printf("%d장\t", items.numberOfTicket); //주문한 티켓 수량
			System.out.printf("%7d원\t", items.price); //가격
			System.out.printf("%s\n", items.discountType); //적용 받은 할인의 종류
		}
		
		System.out.printf("==================================\n");
		System.out.printf("총 결제액은 %d원입니다. 감사합니다.", variables.priceFinal); //최종 총액 출력 
	}
}
