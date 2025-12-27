import java.lang.*;
import java.util.*;

public class StudentManagementSystem
{
    static class Student 
    {
        private int id;
        private byte age,standard;
        private String name;

        Student(int id,String name,byte age,byte standard)
        {
            this.id = id;
            this.name = name;
            this.age = age;
            this.standard = standard;
        }

        @Override
        public String toString() {
            return "\n  {\n\tStudent Id : "+ id +"\n\tName : " + name + "\n\tAge : " + age + "\n\tStandard : " + standard + "\n  }";
        }

        public int getId() {
            return id;
        }

        public byte getAge() {
            return age;
        }

        public byte getStandard() {
            return standard;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAge(byte age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStandard(byte standard) {
            this.standard = standard;
        }

    }
    
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Student> list=new ArrayList<>();

    public static void main(String[] args) {


        while(true)
        {
            System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
            System.out.print("\n1.Create Student\n2. Retrieve Student\n3. Update Student\n4. Delete Student\n5. Exit\nEnter Choice : ");
            int ch=sc.nextInt();
            if(ch==5)
                return;
            
            switch (ch) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    retrieveStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                default:
                    System.out.println("\nInvalid Choice !!\n");
                    break;
            }
        }

    }

    private static void createStudent() 
    {
        int id;
        byte age,stand;
        String name;

        System.out.print("Enter Student Data : \nId : ");
        id=sc.nextInt();
        
        sc.nextLine();                
        System.out.print("Name : ");
        name=sc.nextLine();  

        System.out.print("Age : ");
        age=sc.nextByte();

        System.out.print("Standard : ");
        stand=sc.nextByte();

        list.add(new Student(id, name, age, stand));

        System.out.println(id + " is Added !");
    }

    private static void retrieveStudent() 
    {
        if(list.isEmpty())
        {
            System.out.println("No Records Found!");
            return;
        }

        System.out.print("Students : \n[");
        for(Student s:list)
        {
            System.out.print(s);
        }
        System.out.println("\n]");
    }

    private static void updateStudent() 
    {
        System.out.print("Enter Student Data : \nId : ");
        int id=sc.nextInt();

        sc.nextLine(); 
        for(Student s:list)
        {
            if(s.getId()==id)
            {
                System.out.print("\nName : ");
                s.setName(sc.nextLine());

                System.out.print("Age : ");
                s.setAge(sc.nextByte());

                System.out.print("Standard : ");
                s.setStandard(sc.nextByte());

                System.out.println(id + " is Updated !");
                return;
            }
        }

        System.out.println("WRONG ID !!");
    }

    private static void deleteStudent() 
    {
      System.out.print("Enter Student Data : \nId : ");
        int id=sc.nextInt();

        Iterator<Student> it = list.iterator();  
        while(it.hasNext())
        {
            Student s = it.next();
            if(s.getId()==id)                     
            {
                it.remove();                      
                System.out.println(id + " is Deleted !");
                return;
            }
        }
        System.out.println("WRONG ID !!");
    }
}