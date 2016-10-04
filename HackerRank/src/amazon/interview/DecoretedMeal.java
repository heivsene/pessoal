package amazon.interview;

public abstract class DecoretedMeal implements Meal {

	private Meal decoretedMeal;
	
	public DecoretedMeal(Meal decoretedMeal) {
		this.decoretedMeal = decoretedMeal;
	}
	
	@Override
	public String getMeal() {
		return decoretedMeal.getMeal();
	}

	@Override
	public int getPrice() {
		return decoretedMeal.getPrice();
	}

}
