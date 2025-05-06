import java.util.*;
public class employemngt{
    public static void addemp(Scanner sc ,ArrayList<Employee> alllist){
            System.out.print("Enter Employee ID = ");
            int id = sc.nextInt();
            sc.nextLine();
            System.err.print("Enter Employee Name = ");
            String name = sc.nextLine();
            System.out.print("Enter Employee Salary = ");
            double salary = sc.nextInt();
            sc.nextLine();
            System.err.print("Enter Employee Department = ");
            String dept = sc.nextLine();
            alllist.add(new Employee(String.valueOf(id),name,salary,dept));
            System.err.println("");
            System.err.println("");
            System.out.println(" Employee Succesfully Added ");
            System.err.println("");
            System.err.println("");
    }
    public static void menu(){
            System.out.println("1. Add Employee");
            
            System.out.println("2. View Employees");
            
            System.out.println("3. Update Employee");
            
            System.out.println("4. Delete Employee");
            
            System.out.println("5. Exit");
    }
    public static void view_details(ArrayList<Employee> alllist){
        if(alllist.isEmpty()){
            System.out.println("NO Employee Record Found !");
        }else{
            for(Employee e : alllist){
                e.get();
            }
        }
    }
    public static void Update_details(Scanner sc , ArrayList<Employee> alllist){
            System.out.print("Enter Employee ID =");
            String newid = sc.nextLine();
            boolean f = false;
            for(Employee emp : alllist){
                if(emp.emp_Id.equals(newid)){
                    System.err.print("Enter new salary = ");
                    double newsalary = sc.nextDouble();
                    sc.nextLine();
                    emp.emp_salary = newsalary;
                    System.err.print("Enter new Department = ");
                    String newdept = sc.nextLine();
                    emp.emp_Dept = newdept;
                    System.err.println("");
                    System.err.println("");
                    System.err.println(" Employee Details Succesfully change ");
                    System.err.println("");
                    System.err.println("");
                    f = true;
                }
            }
            if(!f){
                System.err.println("? Please Enter Valid Employee ID !");
            }
    }
    public static void delete_employee(Scanner sc,ArrayList<Employee> alllist){
            System.err.print("Enter Employee ID = ");
            int nid = sc.nextInt();
            sc.nextLine(); // buffer clear
            boolean removed = false;
                    
            for (int i = 0; i < alllist.size(); i++) {
                if (alllist.get(i).emp_Id.equals(nid + "")) { // emp_Id is String
                    alllist.remove(i);
                    System.out.println();
                    System.out.println();
                    System.out.println(" Employee deleted successfully ");
                    System.out.println();
                    System.out.println();
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                System.err.println("? Please Enter Valid Employee ID !");
            }
    }
    public static void header(){
        System.err.println("");
        System.err.println("========== Welcome To Employee Management System ==========");
        System.err.println("");
        System.err.println("");
    }
    public static void main(String[] args) {
        ArrayList<Employee> alllist = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        header();
        
        while(true){
            menu();
            System.err.println("");
            System.err.println("");
            System.out.print("Enter Your Choice = ");
            int choice;
            
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a number !");
                continue;
            }
            switch(choice){
                case 1: // for add empolyee
                    addemp(sc,alllist);
                    break;
                case 2: //view Employee 
                    System.out.println();
                    view_details(alllist);
                    break;
                case 3: // Update Employee details
                    Update_details(sc, alllist);
                    break;
                
                case 4: // Delete Employee 
                    delete_employee(sc, alllist);
                    break;
                case 5://Exit
                    System.out.println(" Exiting... Thank you for using the system!");
                    return;
                default:
                    System.out.println(" Invalid choice. Try again ");
                    break;
            
            }
            
            System.out.print("Do you want to continue? (y/n) :  ");
            String ask_for_exit = sc.nextLine();
            if(ask_for_exit.equalsIgnoreCase("n")){
                return;
            }
            System.out.println("");
            System.out.println("");
        }
    }
}
class Employee{
    String emp_Id;
    String emp_name;
    Double emp_salary;
    String emp_Dept;

    Employee(String emp_Id , String emp_name , Double emp_salary , String emp_Dept){
        this.emp_Id = emp_Id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
        this.emp_Dept = emp_Dept;
    }
    void get(){
        System.err.println("Employee Details ");
        System.out.println("Employe Id = "+emp_Id);
        System.out.println("Employe name = "+emp_name);
        System.out.println("Employe Salary = "+calculatesalary(emp_salary));
        System.out.println("Employe Department = "+emp_Dept);
        System.err.println("");
        System.err.println("");
    }
    double calculatesalary(double emp_salary){
        return (emp_salary*0.90);
    }
}