package edu.icet.thogakade.model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {

    private String itemCode;
    private String description;
    private String category;
    private int qtyOnHand;
    private double unitPrice;

}
