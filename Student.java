import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
	
	private Integer ID;
	
	private String Name;
	
	private Integer Marks;
	
	private static List<Student> list = new ArrayList<>();
	
	public Student(Integer id, String name, Integer marks) {
		
		ID = id;
		Name = name;
		Marks = marks;
		
	}
	
	
	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public Integer getMarks() {
		return Marks;
	}


	public void setMarks(Integer marks) {
		Marks = marks;
	}


	public static List<Student> getList() {
		return list;
	}


	public static void setList(List<Student> list) {
		Student.list = list;
	}


	private static Student getByStudentId(Integer id) {
		for(Student stu : list) {
			if(stu.ID == id) {
				return stu;
			}
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		int choice = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("1. Add student");
			System.out.println("2. Update student");
			System.out.println("3. Delete student");
			System.out.println("4. View student");
			System.out.println("5. get all students");
			System.out.println("6. Exit");
			
			System.out.println("Enter choice");
			choice = sc.nextInt();
			
			Integer id; String name; Integer marks; Student student;
			
			switch(choice) {
			
				case 1: System.out.println("Enter ID of student");
							 id = sc.nextInt();
						System.out.println("Enter name of student");
							 name  = sc.next();
						System.out.println("Enter total marks of student");
							 marks = sc.nextInt();
						
						Student s = new Student(id, name, marks);
						
						list.add(s);
						System.out.println("created successfully");
						System.out.println("------------");
						break;
				case 2: System.out.println("Enter ID of student");
							 id = sc.nextInt();
							 
							 student = getByStudentId(id);
							 
							 if(student!=null) {
								 System.out.println("Enter the new name");
								 name = sc.next();
								 student.setName(name);
								 System.out.println("Enter the new marks");
								 marks = sc.nextInt();
								 student.setMarks(marks);
								 
								 System.out.println("Student updated sucessfully");
							 }
							 else {
								 System.out.println("Student not found");
							 }
							 System.out.println("------------");
						break;
				case 3: System.out.println("Enter ID of student"); 
							id = sc.nextInt();
							
							 student = getByStudentId(id);
							
							if(student!=null) {
								list.remove(student);
								System.out.println("Student deleted");
							}
						System.out.println("Student not found");
						System.out.println("------------");
						break;	
				case 4: System.out.println("Enter ID of student"); 
							id = sc.nextInt();
				
							 student = getByStudentId(id);
				
							if(student!=null) {
								System.out.print(student.getName()+ " ");
								System.out.println(student.getMarks());
							}
							System.out.println("------------");
						break;
				case 5: System.out.println("Getting all students");
						
						for(Student stu : list) {
							
							System.out.print(stu.getID() + " ");
							System.out.print(stu.getName() + " ");
							System.out.println(stu.getMarks());
							
						}
						System.out.println("------------");
						break;
				case 6: System.out.println("exited"); 
						break;
				}
			
				}while(choice!=6);
		
			sc.close();	
	}


}

