package edu.icet.thogakade.model.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private String OrderID;
    private String  OrderDate;
    private String CustID;

}
