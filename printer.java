public class printer {
    
	linkedListManager ll = new linkedListManager();

    linkedListManager sampleStudents(){

		ll.insertAt(new student("Steve","123456","3.5"),0);          //might have been better to put this in main but its ugly
        ll.insertAt(new student("Mary","789123","2.8"),1);           //creates 11 sample students so program can be tested without manually inputting lots of students
        ll.insertAt(new student("Andrew","456789","3.3"),2);
        ll.insertAt(new student("Sam","987654","3.7"),3);
        ll.insertAt(new student("Tim","321987","2.5"),4);
        ll.insertAt(new student("Kat","654321","3.9"),5);
        ll.insertAt(new student("James","137946","3.0"),6);
        ll.insertAt(new student("Megan","467913","4.0"),7);
        ll.insertAt(new student("Stacy","654987","3.7"),8);
        ll.insertAt(new student("Paul","555777","1.8"),9);
        ll.insertAt(new student("Joe","112233","2.4"),10); 
		
        return ll;
    }

    void welcome() {
		System.out.println("Welcome To Tri-C");
		System.out.println("Option 1: Sample inputs");
		System.out.println("Option 2: Manual data entry");
	}
    
	void menu(){
		System.out.println("Select an option:");
		System.out.println("1: Insert a student at a specific index");
		System.out.println("2: Fetch a student's information");
		System.out.println("3: Delete a student's information");
		System.out.println("4: Update a student's information");
		System.out.println("5: Output all student information");
		System.out.println("6: Exit program");
    }

	
}
