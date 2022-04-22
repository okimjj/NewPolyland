
public class Discount {

	void discount (int dcCondition, OrderVariables orderVariable) {
		if (dcCondition == 1) {
			orderVariable.price = orderVariable.price - (int)(orderVariable.price * StaticValues.DC_DIS_NAT_PREG);
			orderVariable.discountType = StaticValues.DC_TYPE_DISABLED;
		} else if (dcCondition == 2) {
			orderVariable.price = orderVariable.price - (int)(orderVariable.price * StaticValues.DC_DIS_NAT_PREG);
			orderVariable.discountType = StaticValues.DC_TYPE_MERIT;
		} else if (dcCondition == 3) {
			orderVariable.price = orderVariable.price - (int)(orderVariable.price * StaticValues.DC_DIS_NAT_PREG);
			orderVariable.discountType = StaticValues.DC_TYPE_PREGNANT;
		} else if (orderVariable.discountCondition == 4) {
			orderVariable.price = orderVariable.price - (int)(orderVariable.price * StaticValues.DC_SOLDIER);
			orderVariable.discountType = StaticValues.DC_TYPE_SOLDIER;
		} else if (orderVariable.discountCondition == 5) {
			orderVariable.price = orderVariable.price - (int)(orderVariable.price * StaticValues.DC_MULTIKID);
			orderVariable.discountType = StaticValues.DC_TYPE_MULTILKID;
		}else {
			orderVariable.discountType = StaticValues.DC_TYPE_NONE;
		}
	}
}
