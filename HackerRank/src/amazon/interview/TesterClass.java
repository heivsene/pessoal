package amazon.interview;

public class TesterClass {
	
	public static void main(String[] args){
		Meal meal = new SimpleMeal();
		System.out.println("Meal - "+meal.getMeal());
		System.out.println("Price US$ "+meal.getPrice());
		
		meal = new Juice(new SimpleMeal());
		System.out.println("Meal - "+meal.getMeal());
		System.out.println("Price US$ "+meal.getPrice());
		
		meal = new FrenchFries(new Juice(new SimpleMeal()));
		System.out.println("Meal - "+meal.getMeal());
		System.out.println("Price US$ "+meal.getPrice());
	}

}
