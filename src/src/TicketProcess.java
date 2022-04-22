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
	CsvWrite csv = new CsvWrite();
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
