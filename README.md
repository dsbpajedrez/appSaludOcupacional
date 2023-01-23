# App Salud Ocupacional

Proyecto App Salud Ocupacional usando DDD

## Contenido del proyecto

### Domain

#### Clase Accidente
Representa el agregado root con las siguientes entidades:
   * Registro
   * Tipo

Objetos de valor:
 * Clasificación
 * Lugar
 * Fecha
 * Severidad


#### Clase Ausencia
Representa el agregado root con las siguientes entidades:
* Registro
* Clasificación

Objetos de valor:
* Duración
* Lugar
* Fecha
* Descripción
* Tipo
* Temporal

#### Clase Trabajador
Representa el agregado root con las siguientes entidades:
* Departamento
* Cargo

Objetos de valor:
* Datos personales
* Nombre departamento
* Nombre cargo

### Negocio

### Casos de uso
Se crean casos de uso para la aplicación, para agregar
y actualizar accidente, para agregar y crear ausencia,
agregar y actualizar trabajador y para sus respectivas entidades.


## Pruebas Unitarias ⚙️

Se realizan pruebas unitarias para agregar y actualizar accidente, 
para agregar y crear ausencia,
agregar y actualizar trabajador y para sus respectivas entidades.

Las pruebas unitarias se realizan con 

* [JUnit5](https://junit.org/junit5/) - Biblioteca usada para realizar test
* [Mockito](https://site.mockito.org/) - Framework usado para la prueba de código


## Construido con 🛠️

* [SpringBoot](https://start.spring.io/) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias


## Autores ✒️

* [David Santiago Benjumea Pérez](https://github.com/dsbpajedrez) **- *Codificación-Pruebas y Documentación de código*  
* [Valentina Santa Muñoz](https://github.com/Valen2605) **- *Codificación-Pruebas y Documentación de código*

