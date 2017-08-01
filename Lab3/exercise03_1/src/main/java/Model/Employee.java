package Model;

import javax.persistence.*;

/**
 * Created by Rabin Shrestha on 7/27/2017.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue
    int employeeId;
    int employeenumber;
    String name;

    @ManyToOne
    @JoinColumn(name="dptid")
    private Department department;

    public int getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(int employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
