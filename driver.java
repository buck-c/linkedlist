import java.util.Scanner;

public class driver {
    public static void main(String[] args) {

        printer printer = new printer();
        student student = new student();
        linkedListManager ll = new linkedListManager();
        Scanner input=new Scanner(System.in);
        String quit="quit";

        while(true){
            printer.welcome(); // prompts for manual entry vs sample entry
            int inputOption=input.nextInt();  

            if(inputOption==1){  // if user selects option 1, automatically creates a linked list with 11 sample students from the printer class
                ll=printer.sampleStudents();
                System.out.println("All entries:");
                ll.showAll(); // displays all students initially put in list
                break;
            }

            else if(inputOption==2){ // if user selects option 2, creates linked list according to user input
                int count=0;
                System.out.println("enter student name 'quit' to exit");
                while(true){    
                    student.input(input);
                    if (quit.equalsIgnoreCase(student.getName())) // loops forever until user types "quit"
                        break;
                    ll.insertAt(student,count); 
                    count++;
                }
                System.out.println("All entries:");
                ll.showAll();
                break;
            }
            else{
                System.out.println("Invalid selection"); 
                input.next();  
                }
        }

        while(true){ //after data has been submitted, prompts user for a new menu with options on what to do with the data

            printer.menu(); //lists selection to edit entries

	        int sel=input.nextInt();
        
            if(sel==1){ // inputs a student at desired index
                student.input(input);
                System.out.println("index?");
                int index=input.nextInt();
                if(ll.insertAt(student,index))
                    System.out.println("Operation complete.");
            }
            else if(sel==2){  //pulls a student's information based on a name search
                System.out.println("Student name?");
                String name = input.next();
                student=ll.fetch(name); 
                if(student==null)
                    System.out.println("Student not found.");
                else
                    System.out.println(student.toString());
            }
            else if(sel==3){ //deletes a student based on name search
                System.out.println("Student name?");
                String name = input.next();
                if(ll.delete(name))
                    System.out.println("Operation complete.");
                else
                    System.out.println("Student not found.");
            }
            else if(sel==4){ //updates a student's information based on name search
                student.input(input);
                if(ll.update(student.getName(),student))
                    System.out.println("Operation complete.");
                else
                    System.out.println("Student not found."); 
            }
            else if(sel==5){
                ll.showAll(); //prints all students in list
            }
            else if(sel==6){
                System.exit(0); //ends program
            }
            else{
                System.out.println("invalid selection"); 
            }
        } 
    }
}