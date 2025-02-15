package lab1;

public class Employee {
	private int id;
	private String name, nokName;
	private double salary;
	
	public Employee(int id, String name, String nokName, double salary) {
		this.id = id;
		this.name = name;
		this.nokName = nokName;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNokName() {
		return nokName;
	}
	public void setNokName(String nokName) {
		this.nokName = nokName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id
				+ ", name=" + name
				+ ", nokName=" + nokName
				+ ", salary=" + salary
				+ "]";
	}
	
	
	
	
}
