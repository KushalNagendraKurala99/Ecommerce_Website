# Ecommerce

A full-stack e-commerce web application with a **Spring Boot REST API backend** and an **Angular frontend**. It supports customer registration/login, product catalog management, delivery date-slot assignment, and order placement/cancellation.

## Tech Stack

**Backend** (`e-commerce_website/`)
- Java 17
- Spring Boot 2.7.10 (Spring Web, Spring Data JPA)
- MySQL (via `mysql-connector-j`)
- Lombok
- Maven (with Maven Wrapper)

**Frontend** (`Ecommerce__Website/`)
- Angular (TypeScript)

## Project Structure

```
Ecommerce-main/
├── e-commerce_website/          # Spring Boot backend
│   ├── src/main/java/com/shopping/
│   │   ├── Entities/            # JPA entities: Customer, Product, OrderDetails, DateSlot, ...
│   │   ├── controller/          # REST controllers
│   │   ├── service/             # Service interfaces
│   │   ├── serviceimpl/         # Service implementations
│   │   ├── repositories/        # Spring Data JPA repositories
│   │   └── exception/           # Global exception handling
│   ├── src/main/resources/application.properties
│   └── pom.xml
└── Ecommerce__Website/           # Angular frontend
    └── src/app/
        ├── create-customer/, update-customer/, customer-list/
        ├── create-product/, update-product/, product-list/, search-product/
        ├── create-dateslot/, product-date-assignment/, product-dateslot-relation/
        ├── orders-customer/, orders-list/, order-details/, cancel-order/
        └── *.service.ts          # HTTP services for each domain (customer, product, date-slot, order)
```

## Data Model

- **Customer** — name, age, gender, email, phone, password, address; linked to orders
- **Product** — name, price, category, brand, available quantity; linked to a `DateSlot`
- **DateSlot** — order date / delivery date, with a list of assigned products
- **OrderDetails** — order id (custom generator), number of products, total price, booking/delivery dates, seller, delivery status; linked to a `Customer` and `Product`

## Prerequisites

- JDK 17
- MySQL Server (running locally, or update the connection settings)
- Node.js and npm
- Angular CLI (`npm install -g @angular/cli`)

## Backend Setup

1. Create a MySQL database named `ECommerce` (the app will auto-create/update tables via `spring.jpa.hibernate.ddl-auto=update`).
2. Update the datasource credentials in `e-commerce_website/src/main/resources/application.properties` to match your MySQL setup:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ECommerce
   spring.datasource.username=root
   spring.datasource.password=<your-password>
   ```
3. From `e-commerce_website/`, run:
   ```bash
   ./mvnw spring-boot:run
   ```
   (or `mvnw.cmd spring-boot:run` on Windows)

The API server starts on **`http://localhost:8082`**.

> **Note:** `application.properties` in this repo contains a hardcoded local password — replace it with your own credentials (and avoid committing real secrets) before deploying.

## Frontend Setup

> The `Ecommerce__Website/` folder in this archive contains only the `src/` sources — it's missing the Angular project scaffolding (`package.json`, `angular.json`, etc.). To run it, generate a new Angular workspace and drop this `src/` folder in, or restore the original scaffolding files, then:

```bash
cd Ecommerce__Website
npm install
ng serve
```

The frontend expects to run on **`http://localhost:4200`** — the backend's `@CrossOrigin` annotations are explicitly configured to allow requests from that origin.

## API Overview

All endpoints are served from `http://localhost:8082`.

### Customers (`/api`)
| Method | Endpoint | Description |
|---|---|---|
| POST | `/createCustomer` | Register a new customer |
| PUT | `/updateCustomer/{id}` | Update a customer |
| DELETE | `/deletecustomer/{id}` | Delete a customer |
| GET | `/getCustomerById/{id}` | Get customer by ID |
| GET | `/getAllCustomer` | List all customers |
| GET | `/getCustomerByName/{name}` | Find customers by name |
| GET | `/getCustomerByEmail/{email}` | Find customer by email |
| GET | `/getCustomer/{pname}/{email}` | Find by name and email |
| GET | `/getCustomerlogin/{email}/{pwd}` | Login (email + password) |

### Products (`/api`)
| Method | Endpoint | Description |
|---|---|---|
| POST | `/createProduct` | Add a new product |
| PUT | `/updateProduct/{id}` | Update a product |
| DELETE | `/deleteProduct/{id}` | Delete a product |
| GET | `/getProductById/{id}` | Get product by ID |
| GET | `/getAllProduct` | List all products |
| GET | `/getProduct/{id}/{brand}/{productName}` | Find by ID, brand, and name |
| GET | `/searchProduct/{category}` | Search products by category |
| GET | `/searchProductByName/{productName}` | Search products by name |
| POST | `/assignProductToDateslot/{productNo}/{dateslotId}` | Assign a product to a delivery date slot |

### Date Slots
| Method | Endpoint | Description |
|---|---|---|
| POST | `/createDateSlot` | Create a new order/delivery date slot |

### Orders
| Method | Endpoint | Description |
|---|---|---|
| POST | `/orderProduct/{productNo}/{customerId}` | Place an order for a product |
| DELETE | `/cancelOrder/{orderId}` | Cancel an order |
| GET | `/getOrdersByCustomerId/{customerId}` | List orders for a customer |
| GET | `/getAllOrders` | List all orders |

## Running Tests

```bash
cd e-commerce_website
./mvnw test
```

## Known Notes / Limitations

- CORS is hardcoded to `http://localhost:4200`; update the `@CrossOrigin` origins if the frontend is deployed elsewhere.
- Database credentials in `application.properties` are checked into the repo as plaintext — move these to environment variables or a secrets manager for anything beyond local development.
- The Angular workspace configuration files (`package.json`, `angular.json`, `tsconfig.json`) are not present in this archive and will need to be added/regenerated to build and run the frontend.
