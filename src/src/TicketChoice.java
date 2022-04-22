
public class TicketChoice {

	
	void ticketChoice (int choice, OrderVariables variables) {
		if (choice == 1) {
		if (variables.age >= 0 && variables.age < 3 || (variables.age > 64)) {
			variables.price = StaticValues.BABY * variables.numberOfTicket;
		} else if (variables.age >= 3 && variables.age < 13) {
			variables.price = StaticValues.KID_DAY *variables.numberOfTicket;
		} else if (variables.age >= 13 && variables.age < 19) {
			variables.price = StaticValues.YOUNG_DAY *variables.numberOfTicket;
		} else if (variables.age >= 19 && variables.age < 65) {
			variables.price = StaticValues.ADULT_DAY * variables.numberOfTicket;
		}
		variables.ticketTypeName = StaticValues.TICKET_TYPE_DAY;
	}
	
	if (choice == 2) {
		if (variables.age >= 0 && variables.age <= 3 || variables.age >= 65) {
			variables.price = StaticValues.BABY * variables.numberOfTicket;
		} else if (variables.age >= 13 && variables.age < 19) {
			variables.price = StaticValues.YOUNG_NIGHT * variables.numberOfTicket;
		} else if (variables.age >= 19 && variables.age < 65) {
			variables.price = StaticValues.ADULT_NIGHT * variables.numberOfTicket;
		}
		variables.ticketTypeName = StaticValues.TICKET_TYPE_NIGHT;
	}
  }
}
