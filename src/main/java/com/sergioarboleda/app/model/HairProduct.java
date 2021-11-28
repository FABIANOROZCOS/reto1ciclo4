package com.sergioarboleda.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;

/**
 * @author FABIAN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hairproducts")
public class HairProduct {
    
    @Id
    private Integer reference;
    private String brand;
    private String category;
    private String name;
    private String description;
    private Boolean availability = true;
    private Double price;
    private Integer quantity;
    private String photography;

}
