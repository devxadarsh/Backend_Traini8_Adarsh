package com.devx.BackendTraini8Adarsh.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
        @NotBlank
        @Column(nullable = false)
        private String detailedAddress;

        @NotBlank(message = "City is required")
        @Column(nullable = false)
        @Size(min = 3, max = 25, message = "City should at least 3 words and less than 25 words")
        private String city;

        @NotBlank(message = "State is required")
        @Column(nullable = false)
        @Size(min = 3, max = 25, message = "State should at least 3 words and less than 25 words")
        private String state;

        @Column(length = 6, nullable = false)
        @NotBlank(message = "Pin Code is required")
        @Pattern(regexp = "[0-9]{6}", message = "Pin Code length should be 6(Numbers Only)")
        private String pincode;
}
