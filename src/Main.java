import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer.createCustomerTable();
        Cars.createCarsTable();
        Rentals.createRentalsTable();

        CustomerRepository.createCustomer("boda", "teste1234@gmail.com");
       // CustomerRepository.updateCustomer(1, "teste", "null");
        CustomerRepository.getCustomer(1);


    }
}
