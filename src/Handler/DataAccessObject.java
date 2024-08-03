package Handler;
import Keys.Keys;
import Model.Customer;
import com.mysql.cj.log.Log;
import java.security.Key;
import java.sql.*;
import java.util.ArrayList;
public class DataAccessObject {
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ArrayList<Customer> getCustomersList(){
        ArrayList<Customer> arrayList = new ArrayList<Customer>();
        try{
            Class.forName(Keys.DRIVER);
            connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
            statement = connection.createStatement();
            ResultSet set = statement.executeQuery(Keys.SELECT_ALL_QUERY);
            set.next();
            do{
                Customer customer = new Customer();
                customer.setId(set.getInt(1));
                customer.setName(set.getString(2));
                customer.setAge(set.getInt(3));
                customer.setContact(set.getString(4));
                customer.setNationality(set.getString(5));
                arrayList.add(customer);
            }
            while (set.next());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{

                statement.close();
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return arrayList;
    }
    public static ArrayList<Customer> getCustomers(){
        ArrayList<Customer> arrayList = new ArrayList<Customer>();
        try{
            Class.forName(Keys.DRIVER);
            connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
           preparedStatement=connection.prepareStatement(Keys.SELECT_ALL_QUERY);
            ResultSet set = preparedStatement.executeQuery();
            set.next();
            do{
                Customer customer = new Customer();
                customer.setId(set.getInt(1));
                customer.setName(set.getString(2));
                customer.setAge(set.getInt(3));
                customer.setContact(set.getString(4));
                customer.setNationality(set.getString(5));
                arrayList.add(customer);
            }
            while (set.next());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{

                preparedStatement.close();
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return arrayList;
    }
    public static void insertCustomer(Customer customer){
        try{
            Class.forName(Keys.DRIVER);
            connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
            preparedStatement=connection.prepareStatement(Keys.INSERT_QUERY);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setInt(3,customer.getAge());
            preparedStatement.setString(4,customer.getContact());
            preparedStatement.setString(5,customer.getNationality());
            preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{

                preparedStatement.close();
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static Customer getcustomer(int id){
        Customer customer = new Customer();
        try{
            Class.forName(Keys.DRIVER);
            connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
            preparedStatement=connection.prepareStatement(Keys.SELECT_CUSTOMER_QUERY);
            preparedStatement.setInt(1,id);
            ResultSet resultSet =  preparedStatement.executeQuery();
            resultSet.next();
            customer.setName(resultSet.getString(2));
            customer.setAge(resultSet.getInt(3));
            customer.setContact(resultSet.getString(4));
            customer.setNationality(resultSet.getString(5));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try{

                preparedStatement.close();
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return customer;
    }
    public static void updatecustomer(Customer customer,int id){
        try{
            Class.forName(Keys.DRIVER);
            connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
            preparedStatement = connection.prepareStatement(Keys.UPDATE_QUERY);
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setInt(2,customer.getAge());
            preparedStatement.setString(3,customer.getContact());
            preparedStatement.setString(4,customer.getNationality());
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                preparedStatement.close();
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void deleteCustomer(int id){
        try{
            Class.forName(Keys.DRIVER);
            connection = DriverManager.getConnection(Keys.URL,Keys.USERNAME,Keys.PASSWORD);
            preparedStatement = connection.prepareStatement(Keys.DELETE_QUERY);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                preparedStatement.close();
                connection.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
