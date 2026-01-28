package edu.icet.thogakade.model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
    private String custId;

    private String title;

    private String name;

    private String dob;

    private double salary;

    private String address;

    private String city;

    private String province;

    private String postalCode;
}
