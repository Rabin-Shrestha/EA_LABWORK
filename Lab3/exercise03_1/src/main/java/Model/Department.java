package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Rabin Shrestha on 7/27/2017.
 */
@Entity
public class Department {
    @Id@GeneratedValue
    int id;
    @Column
    String Name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> empList=new ArrayList<Employee>();

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
