//U2510164 Amir Pulatov
//LABORATORY 07: SINGLETON DESIGN PATTERN
//Topics Covered:
//Singleton Design Pattern
//Private Constructor
//Static Variables and Static Methods
//Object References



class PrintManager  {

private  static PrintManager instance ;
private PrintManager(){

}


public static PrintManager getInstance(){
    if(instance==null){
        instance = new PrintManager();
    }
    return instance;
}
 public  void printDocument(String documentName){
     System.out.println("Printing document "+documentName);
 }

}

class U2510164_lab7 {
    public static void main(String[] args) {

        PrintManager printer1=PrintManager.getInstance();
        printer1.printDocument("LabReport.pdf");
        PrintManager printer2=PrintManager.getInstance();
        printer2.printDocument("Assigment07.pdf");
        System.out.println("Compare printer 1 and printer 2: "+ ( printer1.equals(printer2)) );


    }


}