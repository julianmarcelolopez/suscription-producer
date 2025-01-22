# Usa una imagen base de Maven para compilar el proyecto
FROM maven:3.9.2-eclipse-temurin-17 AS builder

# Establece el directorio de trabajo en el contenedor
WORKDIR /build

# Copia el contenido del proyecto al contenedor
COPY . .

# Ejecuta Maven para compilar el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Usa una imagen base ligera de Java para ejecutar el JAR
FROM eclipse-temurin:17-jdk-alpine

# Establece el directorio de trabajo para el JAR
WORKDIR /app

# Copia el JAR generado desde la etapa de construcción
COPY --from=builder /build/target/suscription-producer-0.0.1-SNAPSHOT.jar /app/suscription-producer.jar

# Expone el puerto en el que correrá el servicio
EXPOSE 8080

# Comando para ejecutar el servicio
ENTRYPOINT ["java", "-jar", "/app/suscription-producer.jar"]
