package application;

import model.dao.*;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("****TEST 1 =  FindById****");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n****TEST 2 =  FindByDepartment****");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n****TEST 3 =  FindAll****");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n****TEST 4 =  SellerInsert****");
        Seller newSeller = new Seller(null, "Victor souza", "fvamarakl.doe@example.com", new Date(), 3000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());

        System.out.println("\n****TEST 5 =  SellerUpdate****");
        seller = sellerDao.findById(1);
        seller.setName("Abish waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");


        System.out.println("\n****TEST 6 =  SellerDelete****");
        sellerDao.deleteById(14);
        System.out.println("Delete completed!");


        System.out.println("\n****TEST 7 =  DepartmentInsert****");
        Department department1 = new Department(15, "Software3");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        departmentDao.insert(department1);
        System.out.println("Update completed!");


        System.out.println("\n****TEST 7 =  DeleteById****");
        departmentDao.deleteById(14);
        System.out.println("Delete completed!");

        System.out.println("\n****TEST 8 =  FindById****");
        Department department2 = departmentDao.findById(1);
        System.out.println(department2);

        System.out.println("\n****TEST 8 =  FindById****");
        List<Department> departments = departmentDao.findALl();
        for (Department dep : departments) {
            System.out.println(dep);
        }

    }
}
