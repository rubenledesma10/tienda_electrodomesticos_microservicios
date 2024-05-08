👨🏾‍💻 Tienda de Electrodomésticos

✅ Tienda de electrodomésticos online, que contiene 3 microservicios (en cada uno de los servicios se puede llevar a cabo los CRUD correspondiente de cada uno) que se encargaran de diferentes aspectos del sistema, comunicandose entre ellos para brindar una experiencia de compra fluida a cada uno de los usuarios

✅ Servicios desarrollados:

🧉 Microservicio Productos: Se encarga de gestionar la información de los electrodomésticos disponibles en la plataforma. Es capaz de listar los mismos y proporcionar detalles como código, nombre, marca y precio individual

🧉 Microservicio Carrito de Compras: Mediante este servicio, se podrá agregar y quitar productos de la lista de electrodomésticos de su carrito de compras. Cada carrito tendra su número de identificación (id) y un campo para almacenar el precio total de la sumatoria de todos los productos que se encuentren en el carrito

🧉 Microservicio de Ventas: Se encarga de registrar cada venta mediante un número de identificación y una fecha. Cada venta está asociada a un carrito de compras, por lo que al guardar una nueva venta se debe asignar, un carrito. A través de esta asociación, la venta puede conocer el monto total de la misma (consultando al carrito de compras) y la lista de productos (consultando al servicio de carrito de compras que a su vez consume el servicio de productos)


✅ Utilizando distintos patrones de diseño, como por ejemplo:

🧉 Eureka

🧉 Spring Cloud Load Balancer

🧉 Circuit Breaker mediante Resilience4J (utilizando también la annotation @Retry)

🧉 API Gateway

🧉 Config server

🧉 Utilizo Docker para deployar la aplicación

✅ Tecnologías: Spring Boot, Java, Spring Cloud, Docker, APIs Rest, Hibernate, Postman, MySQL.
