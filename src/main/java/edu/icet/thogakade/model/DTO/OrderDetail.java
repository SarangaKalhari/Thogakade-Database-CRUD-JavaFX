package edu.icet.thogakade.model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetail {

    private String orderID;
    private String itemCode;
    private int orderQTY;
    private double discount;

}
