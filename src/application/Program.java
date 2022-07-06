package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		List<Seller> list = new ArrayList<>();
		List<Department> listDepartment = new ArrayList<>();
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findById ===");
		Department dep = new Department(2, null);
		list = sellerDao.findDepartment(dep);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		/*System.out.println("\n=== TEST 4: seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id =" + newSeller.getId()); */
		
		System.out.println("\n=== TEST 4: seller update ===");
		seller = sellerDao.findById(1);
		seller.setBaseSalary(3000.0);
		sellerDao.update(seller);
		System.out.println("Update Completed!");
		
		/* System.out.println("\n=== TEST 5: seller delete ===");
		seller = sellerDao.findById(11);
		sellerDao.deleteById(seller.getId());
		System.out.println("Delete Completed!"); */
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST DEPARTMENT ===");
		System.out.println("=== TEST 1: department findById ===");
		Department department = departmentDao.findById(2);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findById ===");
		listDepartment = departmentDao.findAll();
		for(Department obj : listDepartment) {
			System.out.println(obj);
		}
		
	/*	System.out.println("\n=== TEST 3: department insert ===");
		departmentDao.insert(new Department(null, "Games"));
		System.out.println("Department Inserted With Success!"); */
		
		System.out.println("\n=== TEST 4: department update ===");
		department = departmentDao.findById(7);
		department.setName("Cellphones");
		departmentDao.update(department);
		System.out.println("Update complete!");
		
		System.out.println("\n=== TEST 5: department delete ===");
		department = departmentDao.findById(6);
		departmentDao.deleteById(department.getId());
		System.out.println("Delete complete!");
	}

}
