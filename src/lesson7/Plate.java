package lesson7;

public class Plate {
    protected int food;
    public void info(){
        System.out.println("Осталось еды "+food);
    }

    public int getFood() {
        return food;
    }

    public boolean decrise(int decFood){
        if (food>=decFood){
            food-=decFood;
            return true;
        }
        else{
            return false;
        }

    }


    public void increase(int incFood){
        food+=incFood;
    }

}
