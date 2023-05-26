package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Student {

	int roll;
	String name;
	String address;
	Student(int roll,String name,String address){
		this.roll=roll;
		this.name=name;
		this.address=address;	
	}
	
	public int  getRoll(){
		
		return roll;
	}
	
	public String getName(){
		
		return name;
		
	}
	public String getAddress(){
		return address;
	}
	
	public String toString(){
		return roll+" "+name+" "+address;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		boolean loop=true;
		Scanner s=new Scanner (System.in);
		Collection<Student>c=new ArrayList<Student>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Step 1 Done");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentt","root","abc123");
System.out.println("Step 2 done");

Statement st=con.createStatement();
System.out.println("Step 3 done");
		int roll = 0;
		String name = null;
		String address = null;
		
		while(loop){
			
			System.out.println("1.Add Student :");
			System.out.println("2.Exit        :");
			System.out.println("Enter the choice");
			int choice=Integer.parseInt(s.nextLine());
			
			switch(choice){
			
			case 1:
				System.out.println("Enter the no. of Student");
			int	no=Integer.parseInt(s.nextLine());
			for(int i=0;i<no;i++){
				System.out.println(i+1+" :Enter the roll no");
             roll=Integer.parseInt(s.nextLine());
             System.out.println("Enter the name");
              name=s.nextLine();
             System.out.println("Enter the address");
             address =s.nextLine();
             c.add(new Student(roll,name,address));
             int a = st.executeUpdate("INSERT INTO stu VALUES("+roll+",'"+name+"','"+address+"')");
 			if(a>0)	{
 				
 				System.out.println("data inserted");
 				System.out.println("Step 4 done");
 				
 			}
 			else{
 				System.out.println("data not inserted");
 			}
			
			}
			
			break;
			
			
			case 2:
				System.out.println("EXIT");
				loop=false;
				break;
			
		 default :
			 
			 System.out.println("Wrong choice");
			 break;
			
			
			
			
			}
			
			
			
			
			
			
			
		}
		
		
		con.close();
		System.out.println("step 5 done");
		
		
		
	}

}
