package _07_AbstractClass_and_Interface.Practice.Animal_Edible;

public class Chicken extends Animal implements IEdible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howtoEat() {
        return "could be fried";
    }
}
