package edu.icet.thogakade.controller.Customer;

public interface CustomerService {
    void addCustomer(String id, String title, String name, String date, double salary, String address, String city, String province, String postalCode);

    void deleteCustomer(String id);

    void updateCustomerDetails(String custId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);
}
