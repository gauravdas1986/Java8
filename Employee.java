package com.example.test.java8;

import java.util.Objects;

public class Employee {

	private String name;
	private int id;
	private int salary;
		public Employee(int i, String name, int salary) {
		this.id = i;
		this.name = name;
		this.salary=salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;
		Employee employee = (Employee) o;
		return getId() == employee.getId() && getName().equals(employee.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getId());
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", id=" + id +
				", salary=" + salary +
				'}';
	}
}
