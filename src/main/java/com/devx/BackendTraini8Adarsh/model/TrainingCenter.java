package com.devx.BackendTraini8Adarsh.model;


//import javax.persistence.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CenterName is required")
    @Size(min = 3, max = 40, message = "CenterName must be less than 40 characters")
    @Column(length = 40, nullable = false)
    private String centerName;

    @Column(length = 12, nullable = false)
    @NotBlank(message = "CenterCode is required")
    @Pattern(regexp = "[a-zA-Z0-9]{12}",message = "Center code length should be exactly 12(Alphanumeric)")
    private String centerCode;

    @Embedded
    @Valid
    @NotNull(message = "Address is required")
    @Column(nullable = false)
    private Address address;

    @Column
    @Min(value = 0, message = "StudentCapacity must be a positive number")
    private int studentCapacity;

    @ElementCollection
    @CollectionTable(name = "courses_offered", joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course")
    private List<String> coursesOffered;

    @Column(nullable = false)
    private long createdOn;

    @Column(length = 100)
    @Email(message = "Invalid email format")
    private String contactEmail;

    @Column(length = 20, nullable = false)
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number. Please check it again")
    private String contactPhone;
}

