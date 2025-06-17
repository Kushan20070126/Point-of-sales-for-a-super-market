class EmployeeDetails{
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("H.M.Kushan Randika Herath","E00123",10000.00,4000);

        System.out.println("FullTime Employee name : " + fullTimeEmployee.getName());
        System.out.println("FullTime Employee ID : " + fullTimeEmployee.getEmployeeId());
        System.out.println("FullTime Employee  Base Salary : " + fullTimeEmployee.getBaseSalary());
        System.out.println("FullTime Employee Monthly Salary : " + fullTimeEmployee.calculateMonthlySalary());
        System.out.println("FullTime Employee Monthly Salary bonus: " + fullTimeEmployee.calSalary());

    }
}
