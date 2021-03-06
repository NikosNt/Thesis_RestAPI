package com.master.products_services.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;

@Entity
@Table(	name = "products_photos_path")
public class Product_Photos {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    private Long productId;

    private Long businessId;
    @Lob
    private byte[] data;

    public Product_Photos() {
    }

    public Product_Photos(String name, String type, Long productId, Long businessId, byte[] data) {
        this.name = name;
        this.type = type;
        this.productId = productId;
        this.businessId = businessId;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

}
