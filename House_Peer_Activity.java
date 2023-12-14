import java.util.*;
class student {
    int Rollno;
    String name;
    int age;
    int Marks;

    public student(int age, int rollno, int Marks, String name) {
        this.name = name;
        this.Rollno = rollno;
        this.Marks = Marks;
        this.age = age;
    }

    public void viewData() {
        System.out.println("Name : " + name);
        System.out.println("Rollno : " + Rollno);
        System.out.println("Mark : " + Marks);
        System.out.println("Age : " + age);
    }
}
public class House_Peer_Activity {
    public static void main(String[] args) {
        HashMap <Integer,student> database = new HashMap<>();
        try{
            while(true){

                System.out.println("""
                    Welcome to Student Database Management system ...
                    Menu : 
                    1. Add New Student Data
                    2. View Student
                    3. Search Student (Using thier Roll Number)
                    4. Calculate Average Marks
                    5. Exit
                    Please enter the one of the number in front of each action that you want to execute!!!
                    """);
                Scanner input = new Scanner(System.in);
                System.out.print("Please enter your choice of number : ");
                int choice = input.nextInt();
                input.nextLine();
                System.out.println("**************************************************");
                switch (choice) {
                    case 1:
                        System.out.print("Please enter the student's Name : ");
                        String name = input.nextLine();
                        System.out.print("Please enter the student's Roll Number :");
                        int rollno = input.nextInt();
                        input.nextLine();
                        System.out.print("Please enter the student's Age :");
                        int age = input.nextInt();
                        input.nextLine();
                        System.out.print("Please enter the student's Marks :");
                        int Mark = input.nextInt();
                        input.nextLine();
                        if(Mark<0){
                            System.out.println("Please enter the a valid Mark");
                            continue;
                        }
                        student data = new student(age,rollno,Mark,name);
                        database.put(rollno,data);
                        break;
                    case 2:
                        for(student i : database.values()){
                            i.viewData();
                        }
                        System.out.println("**************************************************");
                        break;
                    case 3:
                        System.out.print("Please enter the roll number of the student you want to view :");
                        int find = input.nextInt();
                        input.nextLine();
                        student printer = database.get(find);
                        if(printer != null){
                            System.out.println("Data of Student with the roll number :"+ find);
                            printer.viewData();
                        }else{
                            System.out.println("Data is not available with Roll Number :"+find);
                        }
                        System.out.println("**************************************************");

                        break;
                    case 4:
                        int sum = 0;
                        int count = database.size();
                        for(student i : database.values()){
                            sum += i.Marks;
                        }
                        System.out.println("The total average is : "+(sum/count));
                        System.out.println("**************************************************");
                        break;
                    case 5:
                        System.exit(0);
                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
