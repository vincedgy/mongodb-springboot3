package com.vincedgy.mongodbserver.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Address {
    private String city;
    private String zipcode;
    private String number;
    private String street;
    private String country;
}
