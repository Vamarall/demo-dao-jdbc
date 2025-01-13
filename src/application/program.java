package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.SellerDaoJDBC;
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

        System.out.println("\n****TEST 4 =  SellerInsert****");
        Seller newSeller = new Seller(null, "John Doe", "john.doe@example.com", new Date(), 3000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());

        System.out.println("\n****TEST 5 =  SellerUpdate****");
        seller = sellerDao.findById(1);
        seller.setName("Abish waine");
        sellerDao.update(seller);
        System.out.println("Update completed!");


        System.out.println("\n****TEST 6 =  SellerDelete****");
        sellerDao.deleteById(8);

        System.out.println("Delete completed!");


    }
}
