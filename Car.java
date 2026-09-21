//U2510164
//Amir Pulatov
// task:Car system



public class Car {//by default they are all private
    String carModel;
    String carNumber;
    boolean isRented;
    double rentPricePerDay;
    static int totalCars = 0;

    public Car(String carModel, String carNumber, double rentPricePerDay) {
        this.carModel = carModel;
        this.carNumber = carNumber;
        this.isRented = false;
        this.rentPricePerDay = rentPricePerDay;
        totalCars++;
    }

    //getters
    public String getCarModel() {
        return carModel;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public boolean isRented() {
        return isRented;
    }

    public double getRentPricePerDay() {
        return rentPricePerDay;
    }

    //setters

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public void setRentPricePerDay(double rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public void rentCar() {
        this.isRented = true;
        System.out.println(carModel + "Has been  rented!");
    }

    public void returnCar() {
        this.isRented = false;
        System.out.println(carModel + "Has been  returned!");
    }

    // CAR DETAILS

    public void displayCarDetails() {
        System.out.println("Car Model :" + carModel);
        System.out.println("Car Number: " + carNumber);
        System.out.println(" Car status: " + isRented);
        System.out.println(" Renting price per day: " + rentPricePerDay);
    }

    public static int getTotalCars() {
        return totalCars;
    }

    public Car compareRentPrice(Car anotherCar) {
        if (this.rentPricePerDay >= anotherCar.rentPricePerDay) {
            return this;
        } else {
            return anotherCar;
        }

    }//compare

}

    class U2510164_lab3 {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", "777UZB", 25.00);
        Car car2 = new Car("Matiz ", "888UZB", 20.00);
        Car car3 = new Car("Damas", "999UZB", 10.00);


        car2.setRentPricePerDay(35.00);

        //calling display function

        car1.displayCarDetails();
        car2.displayCarDetails();
        car3.displayCarDetails();

       //rent and return
        car1.rentCar();
        car1.returnCar();
        //comparison
        Car expensive=car1.compareRentPrice(car2);
        System.out.println("More expensive car" + expensive.getCarModel());

        System.out.println("Total cars in fleet" + Car.getTotalCars());


    }// public static




}// class U2510164


