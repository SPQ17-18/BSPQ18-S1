# BSPQ18-S1
Repository for Team BSPQ18-S1




#  🎬 ### ![logo150.png](https://s26.postimg.cc/eiqjhu0pl/logo150.png) ### 🎬
       
## 🔰 MIEMBROS DEL GRUPO:
       
       Javier Fernández, Mikel Fernández, Aritz Rasines, Xabi Sarrionandia.
       
## 🔰 DESCRIPCIÓN:
       
       CinePlus es el nombre de nuestro proyecto de la asignatura de Software Process and Quality. 
       Se trata de un pequeño videoclub online desarrollado en java utilizando la herramienta Maven que puede 
       ser portado y utilizado en cualquier ordenador que ejecute java. 
       
       Para ello, utilizaremos un modelo de desarrollo agil. 
       
       CinePlus se basa en el modelo de negocio que tienen grandes compañias como Netflix o Amazon Prime Video.
       Cualquier coincidencia con estas será mera casualidad.
       
## 🔰 INSTRUCCIONES:

       Orden de los comandos para ejecutar las aplicaciones:
       
       1) Abrir la base de datos : mysqld --console
       2) Crear la base de datos con el documento create-pcineplusdb.sql
       3) Compilar la aplicación desde la carpeta donde se encuentre el POM : mvn clean compile
       4) Ejecutar el servidor: mvn exec:java -Pserver
       5) Ejecutar el cliente: mvn exec:java -Pclient
       6) Para ejecutar los test: mvn test (Genera el informe Contiperf)
       7) Para generar el informe de cobertura: mvn cobertura:cobertura
       8) Para generar la documentación Doxygen: mvn doxygen:report validate
       
## 🔰 SPRINTS:

###### ✅ [SPRINT 1:](https://github.com/SPQ17-18/BSPQ18-S1/releases/tag/FinSprint1)
                      
       - Tareas a realizar:
              ⭕ Sistema de registro de usuario.
              ⭕ Sistema de login.
              ⭕ Ventana de perfil personal.
              ⭕ Resource Bundle.
              ⭕ Documentación Sprint1.
        
###### ✅ [SPRINT 2:](https://github.com/SPQ17-18/BSPQ18-S1/releases/tag/FinSprint2)
       
        - Tareas a realizar:
              ⭕ Sistema Buscar películas.
              ⭕ Sistema de añadir saldo.
              ⭕ Loggers.
              ⭕ JUnit.
              ⭕ Cobertura.
              ⭕ VisualVM.
              ⭕ Documentación Sprint2.
       
###### ✅ [SPRINT 3:](https://github.com/SPQ17-18/BSPQ18-S1/releases/tag/FinSprint3)

       - Tareas a realizar:
              ⭕ Corrección de bugs.
              ⭕ Gestión de errores.
              ⭕ Sistema de alquiler de películas.
              ⭕ Sistema de perfil de películas de usuario.
              ⭕ Doxygen.
              ⭕ Jenkins.
              ⭕ Documentación Sprint3.
              
## 🔰 [DOCUMENTACIÓN:](https://spq17-18.github.io/BSPQ18-S1/)

             https://spq17-18.github.io/BSPQ18-S1/
              
