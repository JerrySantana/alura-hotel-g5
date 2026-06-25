# Hotel Alura

<p align="center" >
     <img width="300" height="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---
## 🖥️ Tech Stack:

### Core & Backend:
- Java (Java 21)
- Maven (Dependency management and build tool)
- Spring Security (For validation and access control)

### Database & Configuration:
- MySQL (Relational data persistence)
- Dotenv-java (Secure management of environment variables and credentials)

### Frontend / UI:
- Java Swing / WindowBuilder / JCalendar

---

## 💻 Versions and Updates

- v1.0
     - The database access method was modified. Previously, an **application.properties** file was used, but it is now handled using a **.env** file and the <a href="https://github.com/cdimascio/dotenv-java" title="Dotenv">dotenv-java</a> library.
     A .env (dotenv) file is required, in which the database URL, username, and password must be declared for access. It must have the following format:
          <p align="center">db.url=jdbc:mysql://localhost/database_name</p>
          <p align="center">db.user=user</p>
          <p align="center">db.password=password</p>

---

## 🗒️ Description:

Alura Hotel is a reservation and guest management system (full CRUD) that simulates the business logic of a hotel environment. The project focuses on relational data persistence, backend business rule validation, and basic authentication.

---

## 📊 Tests and Examples

The application starts with the home screen and the Login option.

<p align="center">
     <img width="" height="350" src="./Imagenes GitHub/Main.png">
</p>

On the Login screen, we can see two fields to enter the username and password, respectively, and the login button. If the validation of encrypted credentials against the database using Spring Security fails, an error message will appear.

<p align="center">
     <img height="240" src="./Imagenes GitHub/Login.png">
     <img height="240" src="./Imagenes GitHub/BadLogin.png">
</p>

On the next screen, we find the user menu from which we can access the reservation and guest registration menus, as well as the search, edit, and delete menus. It also displays the current date and a welcome message explaining the application's core functions.

<p align="center">
     <img height="350" src="./Imagenes GitHub/UserMenu.png">
</p>

If we access the **Reservation Registration** (Registro de reservas) option, the reservation menu will be displayed. Here we can choose a Check-in date and a Check-out date. It will automatically show the calculated value of the reservation based on the number of days between Check-in and Check-out multiplied by $100 (MXN), a list of **Payment Methods** (Forma de pago), and the next button.

Implementation of validation logic and exception handling to prevent inconsistent records in the database: If the **Check-in** date is earlier than the current date, the system displays an error message. If the **Check-out** date is earlier than the **Check-in** date, a different error message will be shown. If both dates are the same, an error message will also be displayed.

<p align="center">
     <img height="230" src="./Imagenes GitHub/Reservation.png">
     <img height="230" src="./Imagenes GitHub/DifferentPaymentMethods.png">
     <img height="230" src="./Imagenes GitHub/WrongCheck-in.png">
     <img height="230" src="./Imagenes GitHub/WrongCheck-out.png">
     <img height="250" src="./Imagenes GitHub/WrongCheck-inAndCheck-out.png">
</p>

On the following screen, we can perform the **Guest Registration** (Registro de huéspedes), which includes fields to input the guest's name, last name, date of birth, nationality, and contact phone number. There is an uneditable field referencing the guest's reservation number, and finally the save button.

If the guest is not over 18 years old, or if any fields are left blank, the transaction is interrupted. An error message is displayed, the UI returns to the **Reservation Registration** screen, and the preliminary reservation saved in the database is rolled back/deleted to maintain referential integrity.

Otherwise, a small window with a success message will be displayed.

<p align="center">
     <img height="230" src="./Imagenes GitHub/GuestRegistration.png">
     <img height="230" src="./Imagenes GitHub/WrongAge.png">
     <img height="150" src="./Imagenes GitHub/Success.png">
</p>

If we choose the search option, it will direct us to the **Searching System** (Sistema de búsqueda) where two tables will be displayed showing the data of the reservations and guests extracted directly from the database.

<p align="center">
     <img height="230" src="./Imagenes GitHub/SearchingSystem.png">
     <img height="230" src="./Imagenes GitHub/SearchingSystem(0).png">
</p>

If we click on the search bar, we can perform a filtered search by reservation or guest ID, by guest last name, or by reservation check-in / check-out dates.

<p align="center">
     <img height="240" src="./Imagenes GitHub/DateSearch.png">
     <img height="240" src="./Imagenes GitHub/IdSearch.png">
     <img height="250" src="./Imagenes GitHub/LastNameSearch.png">
</p>

If we select a table row and, in the case of reservations, select the **Check-out Date** (Fecha de salida) or **Payment Method** (Forma de pago) columns, we can update those values. In the case of guests, we can edit the **Phone** (Teléfono) and **Nationality** (Nacionalidad) columns. Once the value is modified, we click the **EDIT** (EDITAR) button and the changes are persisted to the database.

If either value is left blank, an error message will be displayed. If the edited date is earlier than the current date, an error message will also be displayed.

<p align="center">
     <img height="240" src="./Imagenes GitHub/WrongFormat.png">
     <img height="240" src="./Imagenes GitHub/EditedTelephone.png">
</p>

Once the desired row is selected, we can delete it by clicking the **DELETE** (ELIMINAR) button. This executes the deletion query directly in the database and shows a success message.

<p align="center">
     <img height="350" src="./Imagenes GitHub/SelecedRowDeleted.png">
</p>

---
## 🪪 About the Project

The business logic, persistence architecture, and database connection were fully developed by **Gerardo Santana**. 

This project is part of the practical portfolio built during the Backend Developer specialization in the **Oracle Next Education (ONE)** program, complementing the algorithmic foundations acquired in the **Computer Engineering** major at **UNAM**. The base graphical user interface (UI) was provided by the Alura team to focus the development entirely on backend operations.
