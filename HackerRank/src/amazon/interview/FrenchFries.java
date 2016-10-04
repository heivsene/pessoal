package amazon.interview;

public class FrenchFries extends DecoretedMeal {

	public FrenchFries(Meal decoretedMeal) {
		super(decoretedMeal);
	}

	@Override
	public String getMeal() {
		return super.getMeal() + " and French Fries";
	}

	@Override
	public int getPrice() {
		return super.getPrice()+2;
	}

}
