//u2510164 AMIR PULATOV
//Public void displayEmployeeDetails(): Displays intern details including the university name.
//
//Driver Class: StudentID_Lab6
//This class contains the main() method to demonstrate the usage of inheritance and polymorphism.
//Updated by adding exceptions ,  try , catch and finally

interface Payable {
    void processPayment();
}

interface Taxable {
    double  calculateTax();
}

abstract class  Employee {
    String employeeName;
    int employeeId;
    double baseSalary;


    public abstract double calculateSalary();


    public String getEmployeeName() {
         return employeeName;
     }

     public int getEmployeeId() {
         return employeeId;
     }

     public double getBaseSalary() {
         return baseSalary;
     }



     public void setEmployeeName(String employeeName) {
         this.employeeName = employeeName;
     }

     public void setEmployeeId(int employeeId) {
         this.employeeId = employeeId;
     }

     public void setBaseSalary(double baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than zero.");
        }
         this.baseSalary = baseSalary;
     }



     //Constructor: A constructor to initialize the employeeName, employeeID, and baseSalary.
    public Employee(String employeeName, int employeeId, double baseSalary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary cannot be less than 0.");
        }
        this.baseSalary=baseSalary;


    }// constructor


     //public void displayEmployeeDetails():
     // Displays the name, ID, and salary
     // of the employee. This method should
     // be overridden by derived classes
     // to include additional information.
     public void displayEmployeeDetails() {
         System.out.println("Name of employee is: " + employeeName);
         System.out.println("ID of employee is: " + employeeId);
         System.out.println("Base salary is: " + baseSalary);

     }


     //public double calculateSalary(): A method
     // to calculate the salary of the employee. This method
     // should be overridden by derived classes.




} // class employee

 class FullTimeEmployee extends Employee implements Payable, Taxable {
    double bonus;


    @Override
    public void processPayment() {
        double total=calculateSalary();
        System.out.println("Total salary is: " + total);


    }

    @Override
    public double calculateTax(){
     return  calculateSalary() * 0.20;

    }


    public FullTimeEmployee(String employeeName, int employeeId, double baseSalary, double bonus) {
        super(employeeName, employeeId, baseSalary);
        this.bonus = bonus;
        if  (bonus < 0.0) {
            throw new IllegalArgumentException("Bonus cannot be less than 0.");
        }
        this.bonus = bonus;
    }
    //Override
     @Override
     public double  calculateSalary(){
        return baseSalary + bonus;
     }

     @Override
     public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Bonus: " + bonus);
    }
 }


  class  PartTimeEmployee extends Employee implements Payable , Taxable {
    int hoursWorked;
    double hourlyRate;

    public  PartTimeEmployee (String employeeName, int employeeId, double baseSalary, int  hoursWorked, double  hourlyRate) {
        super(employeeName, employeeId, baseSalary);
        if(hoursWorked < 0){
            throw new IllegalArgumentException("Hours worked cannot be less than 0.");
        }
        this.hoursWorked=hoursWorked;
        if(hourlyRate < 0){
            throw new IllegalArgumentException("Hourly rate cannot be less than 0.");
        }
        this.hourlyRate = hourlyRate;
    }

     @Override
      public void processPayment() {
          double total = calculateSalary();
          System.out.println("Processing payment for part-time employee: " + total);
      }

      @Override
      public double calculateTax() {
          return calculateSalary() * 0.10;  // 10% for part-time
      }

    @Override
    public double  calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hours worked: " + hoursWorked);
        System.out.println("Hourly rate is: " + hourlyRate);
    }
  }// class PartTimeEmployee



public class U2510164_lab6 {
    public static void main(String[] args) {

        try {

            FullTimeEmployee emp1 = new FullTimeEmployee("Amir", 10164, 300.0, -500.0);
            PartTimeEmployee emp2 = new PartTimeEmployee("Behzod", 10163, 0.0, 100, 200.0);


            System.out.println(" ----Full time employee details-----:     ");
            emp1.displayEmployeeDetails();
            emp1.processPayment();
            System.out.println("Tax: " + emp1.calculateTax());




            System.out.println(" ----Part time employee details-----:      ");
            emp2.displayEmployeeDetails();
            emp2.processPayment();
            System.out.println("Tax: " + emp2.calculateTax());

        } catch (IllegalArgumentException e) {
            System.out.println("Your Error: " + e.getMessage());
        } finally {
            System.out.println(" Your Employee details have been closed.     ");
        }






    }
}




