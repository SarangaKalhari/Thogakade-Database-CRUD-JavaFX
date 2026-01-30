package edu.icet.thogakade.model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String custID;

    private String custTitle;

    private String custName;

    private String dob;

    private double salary;

    private String custAddress;

    private String city;

    private String province;

    private String postalCode;
}
