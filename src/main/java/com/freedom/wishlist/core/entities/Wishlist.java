package com.freedom.wishlist.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String userId;

    private List<String> products;

}
