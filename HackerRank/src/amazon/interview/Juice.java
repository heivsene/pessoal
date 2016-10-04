package amazon.interview;

public class Juice extends DecoretedMeal {

	public Juice(Meal decoretedMeal) {
		super(decoretedMeal);
	}

	@Override
	public String getMeal() {
		return super.getMeal() + " and Juice";
	}

	@Override
	public int getPrice() {
		return super.getPrice()+1;
	}

}
