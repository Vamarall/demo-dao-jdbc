package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

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


    }
}
