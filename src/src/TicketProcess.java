import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TicketProcess {
	OrderVariables variables;//�Է� ������ Ŭ����
	ArrayList <OrderVariables> orderList = new ArrayList <OrderVariables>(); //���� ��� ArrayList 
	OrderStage ordStage = new OrderStage(); //�ֹ� ���� �Է� Ŭ����
	AgeCalculator ageCal = new AgeCalculator(); //���� ��� Ŭ����
	TicketChoice tickChoice = new TicketChoice(); //���� ���ÿ� ���� ���� ��� Ŭ����
	Discount dc = new Discount(); //���� ���ǿ� ���� ���� ��� Ŭ����
	RepeatCheck rpCheck = new RepeatCheck(); // �ݺ� ���� Ȯ�� Ŭ����
	EndPrint end = new EndPrint(); //���� ���� ��� ��� Ŭ����
	
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
				dataPrint.write(orderList.get(orderList.size() - 1).age + " �� ,");
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
		
		for (OrderVariables items : orderList) { //���� ���� ��� ���
			
			System.out.printf("%5s\t", items.ticketTypeName); //���� ������ ����
			System.out.printf("%3s\t", items.ageGroup); //���� ���ɴ�
			System.out.printf("%d��\t", items.numberOfTicket); //�ֹ��� Ƽ�� ����
			System.out.printf("%7d��\t", items.price); //����
			System.out.printf("%s\n", items.discountType); //���� ���� ������ ����
		}
		
		System.out.printf("==================================\n");
		System.out.printf("�� �������� %d���Դϴ�. �����մϴ�.", variables.priceFinal); //���� �Ѿ� ��� 
	}
}
