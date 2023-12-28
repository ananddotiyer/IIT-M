class GA6_Employee {
	private String name;
	private double salary;

	public GA6_Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}
}

class GA6_Developer extends GA6_Employee {
	public GA6_Developer(String name, double salary) {
		super(name, salary);
	}
	// implementation with some new instance variable and methods
}

class GA6_Manager extends GA6_Employee {
	public GA6_Manager(String name, double salary) {
		super(name, salary);
	}
}

class SalaryStat<T extends GA6_Employee> {
	private T[] eps;

	public SalaryStat(T[] eps) {
		this.eps = eps;
	}

	private double getTotalSalary() {
		double total = 0;
		for (int i = 0; i < eps.length; i++)
			total += eps[i].getSalary();
		return total;
	}

	// public boolean greaterSalary(SalaryStat< ?> d) { //works
	public boolean greaterSalary(SalaryStat<? extends GA6_Employee> d) { // also works
		if (this.getTotalSalary() > d.getTotalSalary())
			return true;
		return false;
	}
}

public class GA6 {
	public static void main(String[] args) {
		GA6_Developer[] dA = { new GA6_Developer("A", 50000.0), new GA6_Developer("B", 40000.0),
				new GA6_Developer("C", 45000.0) };
		GA6_Manager[] mA = { new GA6_Manager("X", 65000.0), new GA6_Manager("Y", 51000.0) };
		SalaryStat<GA6_Developer> dO = new SalaryStat<GA6_Developer>(dA);
		SalaryStat<GA6_Manager> mO = new SalaryStat<GA6_Manager>(mA);
		if (mO.greaterSalary(dO))
			System.out.println("managers have higher salary expenditure");
		else
			System.out.println("developers have higher salary expenditure");
	}
}