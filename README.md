# Point-of-sales-for-a-super-market
# Simple Supermarket Point-Of-Sale (POS) System

A simple and efficient Java-based Point-Of-Sale system designed for managing supermarket inventory, customer carts, and checkout operations. This project demonstrates core Object-Oriented Programming concepts while streamlining supermarket sales processes.

---

## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [OOP Concepts](#oop-concepts)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [License](#license)

---

## Project Overview

This POS system allows supermarket staff to:

- Manage product inventory (add, search, update stock)
- Handle customer carts (add/remove products, view cart contents)
- Process checkout with payment handling and receipt generation
- Automatically update inventory after sales

---

## Features

- Easy-to-use console menu interface
- Real-time inventory updates
- Error handling for invalid product IDs and insufficient stock
- Simple receipt printing with cashier and timestamp details
- Supports multiple products and quantities per cart

---

## Technologies Used

- Java (JDK 8+)
- Object-Oriented Programming (OOP) principles

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- Java IDE or command line setup

### Installation

1. Clone the repository: https://github.com/Kushan20070126/Point-of-sales-for-a-super-market.git
   
2. Open the project in your preferred Java IDE or compile via command line.

3. Run the main class `SupermarketDriver` to start the application.

---

## Usage

- Follow the on-screen menu to add/remove products from the cart.
- View cart contents and total price anytime.
- Proceed to checkout by entering payment amount.
- Exit the application from the menu.

---

## Code Structure

- `AccSall` interface — Defines product-related methods.
- `Product` class — Represents products in inventory.
- `CartItem` class — Represents individual items in the cart.
- `Cart` class — Manages cart operations.
- `SupermarketDriver` class — Main driver class handling program flow and user interaction.

---

## OOP Concepts Used

- **Encapsulation:** Private fields with public getters/setters.
- **Abstraction:** Interface `AccSall` abstracts product details.
- **Polymorphism:** Interface implementation allows flexible product handling.
- **Classes and Objects:** Clear modular design with dedicated classes for each entity.

---

## Future Enhancements

- Integrate database support for persistent inventory and sales records.
- Add GUI for improved user experience.
- Implement barcode scanning for faster product entry.
- Support discounts, promotions, and tax calculations.
- Add user authentication and role-based access.

---

## Contributing

Contributions are welcome! Please fork the repository and submit pull requests for improvements or bug fixes.

---

## License

This project is licensed under the MIT License. See the [MIT](LICENSE) file for details.

---

## Contact

For questions or suggestions, please contact [kushanrandikaherath@outlook.com].

---

*Thank you for using the Simple Supermarket POS System!*


