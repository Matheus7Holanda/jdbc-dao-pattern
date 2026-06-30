package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> departments;


        System.out.println("===TEST 1: Department Insert ===");
        Department department = new Department(null, "Cellphones");
        departmentDao.insert(department);
        System.out.println("Inserted! New id: " + department.getId());

        System.out.println("===TEST 2: Department Delete ===");
        System.out.println("Entre com o id que deseja deletar: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        System.out.println("===TEST 3: Department Update ===");
        System.out.println("Entre com o id que deseja modificar: ");
        department = departmentDao.findbyId(2);
        department.setName("Gadgets");
        departmentDao.update(department);
        System.out.println("Updated Completed!");

        System.out.println("===TEST 4: Department findById ===");
        department = departmentDao.findbyId(3);
        System.out.println(department);

        System.out.println("===TEST 5: Department findAll ===");
        departments = departmentDao.findAll();
        for (Department d : departments) {
            System.out.println(d.getName());
        }

    }
}
