ShowSpot 🎬

ShowSpot is a Spring Boot backend application inspired by a
BookMyShow-style movie ticket booking system.

The application models the core booking flow: users select a movie/show,
choose seats, create a booking, calculate the price, and persist the
booking-related information.

Tech Stack: Java, Spring Boot, Spring Data JPA, REST APIs,
relational database

📌 Project Overview

ShowSpot is designed as a backend for an online movie-ticket booking
platform.

  The main responsibilities are:
      
      Managing users
      
      Managing movies, cities, theaters and screens
      
      Managing shows and show-seat availability
      
      Creating movie-ticket bookings
      
      Calculating booking prices
      
      Managing payments
      
      Validating requests and business rules
      
      Persisting data through Spring Data JPA repositories
      
      Returning clean DTO-based API responses

The project follows a layered architecture so that controllers, business
logic and database access remain separated.

🏗️ Architecture

The application follows a Layered Architecture:

                    Client / Postman / Frontend
                              |
                              v
                    +--------------------+
                    |   BookingController|
                    +--------------------+
                              |
                              v
                    +--------------------+
                    |    BookingService  |
                    +--------------------+
                       |             |
                       v             v
             +----------------+   +---------------------+
             | PriceCalculator|   | Domain Models / JPA |
             |    Service     |   |      Entities       |
             +----------------+   +---------------------+
                       |                    |
                       +---------+----------+
                                 |
                                 v
                    +------------------------+
                    | Spring Data Repositories|
                    +------------------------+
                                 |
                                 v
                         Relational Database
