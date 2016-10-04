package amazon.interview;

public class SimpleMeal implements Meal {

	@Override
	public String getMeal() {
		return "Rice and Beans";
	}

	@Override
	public int getPrice() {
		return 1;
	}

}
