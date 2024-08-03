package Manager;
import Handler.DataAccessObject;
import Model.Customer;
import java.util.ArrayList;
public class Manager {
    public static void main(String[] args) {
        // for retriving all data using Statement.

//        ArrayList<Customer> arrayList = new ArrayList<Customer>();
//        arrayList= DataAccessObject.getCustomersList();
//        for(Customer customer: arrayList)
//            System.out.println(customer.name.toString().trim());

        // for retriving all data using PreparedStatement.

//        ArrayList<Customer> arrayListSecond = new ArrayList<Customer>();
//        arrayList= DataAccessObject.getCustomers();
//        for(Customer customer: arrayListSecond)
//            System.out.println(customer.name.toString().trim());

        // Inserting Customer.

//        Customer customer = new Customer(29,"Aditya",21,"8591059220","Indian");
//        DataAccessObject.insertCustomer(customer);
//        ArrayList<Customer> arrayListSecond = new ArrayList<Customer>();
//        arrayListSecond= DataAccessObject.getCustomers();
//        for(Customer customerItem: arrayListSecond)
//            System.out.println(customerItem.name.toString().trim());

        // for getting 1 customer.

//        Customer customer1 = DataAccessObject.getcustomer(29);
//        System.out.println(customer1.name.toString());

        // for updating a customer.

//        Customer customer = new Customer("Aditya Kelaskar",22,"9819375722","Indian");
//        DataAccessObject.updatecustomer(customer,29);

        // for deleting a customer.
        DataAccessObject.deleteCustomer(29);

    }
}
