# Training Center Management System

This project implements a Training Center Management System using Spring Boot and JPA.

## Overview

The Training Center Management System allows users to create and manage training centers. Each training center can have various details such as center name, center code, address, student capacity, courses offered, contact email, and contact phone number. The system ensures that mandatory fields are filled, and it performs validations for email format, phone number format, and field sizes.

## Features

- Create a new training center with the following fields:
  - CenterName (less than 40 characters)
  - CenterCode (exactly 12 character alphanumeric)
  - Address (detailed address, city, state, pincode)
  - Student Capacity
  - Courses Offered
  - CreatedOn (generated by the system)
  - ContactEmail (optional, validated for email format)
  - ContactPhone (validated for phone number format)
- Validate mandatory fields and perform email, phone, and size validations.
- Populate CreatedOn field with the server timestamp.
- Exception handling for validation failures
- RESTful API endpoints to interact with the system.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL Database
- Maven for Project Build

## Getting Started

1. Clone the repository:
git clone <repository_url>

2. Navigate to the project directory:
cd training-center-management-system

3. Build the project:
mvn clean install

4. Run the application:
mvn spring-boot:run

5. Access the application at http://localhost:8888

## API Endpoints

- POST /api/training-centers: Create a new training center
  - Request Body: JSON object with training center details
  - Response: Newly created training center details in JSON format
 
- GET /api/training-centers: Get list of all stored training centers information
  - Response: List of training center details in JSON format. If no training centers exist, an empty list is returned.
 
## JASON Code for API Testing

  "centerName": "Traini8 Training Centera",
  "centerCode": "ABC123456789",
  "address": {
    "detailedAddress": "123 Traini8 Street",
    "city": "Exampleville",
    "state": "Examplestate",
    "pincode": "123456"
  },
  "studentCapacity": 3,
  "coursesOffered": ["Course1", "Course2", "Course3"],
  "createdOn": 1649438705000,
  "contactEmail": "traini8@gmail.in",
  "contactPhone": "1234567896"
}



