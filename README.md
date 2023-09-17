# Hotel Alura

<p align="center" >
     <img width="300" heigth="300" src="https://user-images.githubusercontent.com/91544872/189419040-c093db78-c970-4960-8aca-ffcc11f7ffaf.png">
</p>

---
## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder </br>
- Maven
- Spring Security

---

## 💻 Versiones y actualizaciones

- v1.0
     - Se modificó la forma de acceso a la base de datos, anteriormente se hacía mediante el uso de un archivo **application.properties** ahora se realiza mediante el uso de un archivo **.env** y de la librería <a href="https://github.com/cdimascio/dotenv-java" title="Dotenv">dotenv-java</a>.
     Se requiere de un archivo .env (dotenv) dentro del cual se declararan la URL de la base de datos, y el usuario y contraseña para el acceso a la misma; debe tener el siguiente formato:
          <p align="center">db.url=jdbc:mysql://localhost/nombre_base_de_datos</p>
          <p align="center">db.user=user</p>
          <p align="center">db.password=password</p>

---

## 🗒️ Descripción:

Alura Hotel es una aplicación de escritorio que busca facilitar tareas básicas del 🏨 **Hotel Alura**. Entre las tareas que se pueden realizar en esta app se encuentran:
- Registro de reservas.
- Registro de huespedes.
- Buscar reservas por numero de id y por fechas de check-in y check-out.
- Buscar huespedes por numero de id y por apellido.
- Editar la fecha de salida y forma de pago de una reserva.
- Editar la nacionalidad y el telefono de contacto de un huesped.
- Eliminación de reservas y huespedes.

---

## 📊 Pruebas y ejemplos

La aplicación comienza con la pantalla inicial y la opción de Login.

<p align="center">
     <img width="" height="350" src="./Imagenes GitHub/Main.png">
</p>

En la pantalla de Login podemos ver dos campos para ingresar el usuario y contraseña, respectivamente y el botón de inicio de sesión (entrar). En dado caso de que los datos ingresados no coincidan con los datos guardados dentro de la base de datos (esto se verifica con la ayuda de spring security) aparecera un mensaje de error.

<p align="center">
     <img height="240" src="./Imagenes GitHub/Login.png">
     <img height="240" src="./Imagenes GitHub/BadLogin.png">
</p>

En la siguiente pantalla nos encontramos con el menú de usuario desde el cual podremos acceder a los menús de registro de reservas y de huéspedes, y a los menús de búsqueda, edición y eliminación. También se nos mostrará la fecha actual y un mensaje de bienvenida en donde se explican las funciones de la aplicación.

<p align="center">
     <img height="350" src="./Imagenes GitHub/UserMenu.png">
</p>

Si accedemos a la opción de **Registro de reservas** se nos mostrará el menú de registro de reservas en donde podremos elegir una fecha de Check-in, una fecha de Check-out, nos mostrará el valor calculado de la reserva, a partir de la cantidad de días entre Check-in y Check-out y multiplicado por $100 (MXN); una lista de **Forma de pago** y el botón siguiente.

Si el **Check-in** es menor que la fecha actual, el sistema muestra un mensaje de error. Si el **Check-out** es menor que el **Check-in**, se mostrará un mensaje de error diferente. Y si ambas fechas son las mismas, también se mostrará un mensaje de error.

<p align="center">
     <img height="230" src="./Imagenes GitHub/Reservation.png">
     <img height="230" src="./Imagenes GitHub/DifferentPaymentMethods.png">
     <img height="230" src="./Imagenes GitHub/WrongCheck-in.png">
     <img height="230" src="./Imagenes GitHub/WrongCheck-out.png">
     <img height="250" src="./Imagenes GitHub/WrongCheck-inAndCheck-out.png">
</p>

En la siguiente pantalla podremos realizar el **Registro de huespedes** donde tendremos campos para introducir el nombre, el apellido, la fecha de nacimiento, la nacionalidad y el telefono de contacto de nuestro huesped. Tendremos un campo con la referencia al número de reserva del huesped, y por último el boton guardar.

Si el huésped no es mayor a 18 años, o todos los campos no están llenos, no se podrá realizar la reserva, se mostrará un mensaje de error, se regresará a la pantalla de **Registro de reservas** y se eliminará la reserva ya guardada de la base de datos.

En caso contrario, se mostrará una pequeña ventana con un mensaje de éxito.

<p align="center">
     <img height="230" src="./Imagenes GitHub/GuestRegistration.png">
     <img height="230" src="./Imagenes GitHub/WrongAge.png">
     <img height="150" src="./Imagenes GitHub/Success.png">
</p>

Si decidimos elegir la opción de búsqueda nos dirigirá al **Sistema de búsqueda** en donde se nos mostrarán dos tablas con los datos de las reservas guardadas y los huespedes guardados.

<p align="center">
     <img height="230" src="./Imagenes GitHub/SearchingSystem.png">
     <img height="230" src="./Imagenes GitHub/SearchingSystem(0).png">
</p>

Si nos posicionamos en el campo de búsqueda podremos realizar una búsqueda por Id de reserva o de huesped, una búsqueda por apellido de huesped o una búsqueda por fecha de check-in o check-out de reserva.

<p align="center">
     <img height="240" src="./Imagenes GitHub/DateSearch.png">
     <img height="240" src="./Imagenes GitHub/IdSearch.png">
     <img height="250" src="./Imagenes GitHub/LastNameSearch.png">
</p>

Si seleccionamos alguna de las filas de la tabla y, en el caso de reservas, seleccionamos alguna de las columnas de **Fecha de salida** o de **Forma de pago** podremos editar dichos valores; en el caso de huespedes podemos editar las columnas de **Teléfono** y **Nacionalidad**. una vez modificado el valor, damos click en el botón **EDITAR**.

Si alguno de los dos valores se encuentra en blanco se mostrará un mensaje de error. Si la fecha es menor que la fecha actual se mostrará un mensaje de error.

<p align="center">
     <img height="240" src="./Imagenes GitHub/WrongFormat.png">
     <img height="240" src="./Imagenes GitHub/EditedTelephone.png">
</p>

Y una vez seleccionada la fila que deseamos elegir, podemos eliminarla al dar click en el botón **ELIMINAR** y se nos mostrará un mensaje de éxito.

<p align="center">
     <img height="350" src="./Imagenes GitHub/SelecedRowDeleted.png">
</p>

---
## 🪪 Créditos

El diseño de la aplicación fue creado por los maestros del programa **ONE** de  **Alura** y **Oracle**, y proporcionado a nosotros los estudiantes para poder realizar la lógica de la aplicación así como su conexón con la base de datos.
Esta aplicación fue realizado por mi, **Gerardo Gabriel Santana Amezcua**, con apoyo de los conocimientos adquiridos a lo largo del programa anteriormente citado y los conocimientos adquiridos en la carrera **Ingeniería en Computación** en la **Facultad de Ingeniería** de la **UNAM**.