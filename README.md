### Caracteristicas de SpringBoot
1. Crear aplicaciones Spring "stand-alone"
2. Tomcat embebido usando el artefacto [spring-boot-starter-web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web).
3. Provee dependencias configuradas por defecto para agilizar el arranque del proyecto.
4. No necesita archivos XML de configuracion.

### Capas disponibles para hacer pruebas
* Respositorios
* Servicios
* Controladores
* Web
  * Springboot nos facilita la ejecución de estas pruebas dado que con cada prueba podemos pedirle que ejecute tomcat tambien. De esta manera en lugar de probar la llamada a un metodo del controlador, probamos enviando una peticion http.

### Charla en español
* [Video entrevista](https://www.youtube.com/watch?v=ajA6F1y8iYE)

### Charla en ingles
* [Video presentacion](https://tanzu.vmware.com/content/springone-platform-2017/its-a-kind-of-magic-under-the-covers-of-spring-boot-brian-clozel-st%C3%A9phane-nicoll)
* [Video TDD](https://tanzu.vmware.com/content/springone-platform-2017/test-driven-development-with-spring-boot-sannidhi-jalukar-madhura-bhave)

### Propiedades para configurar
* [Link](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)

### Iniciar el proyecto
mvn spring-boot:run

### Referencias
* [Generador-online](https://start.spring.io/)
* [Documentacion](https://spring.io/projects/spring-boot)

