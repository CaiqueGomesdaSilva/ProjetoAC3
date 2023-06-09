# Utiliza uma imagem do Java como base
FROM openjdk:17-jdk-alpine

# Copia o arquivo .jar para o container
COPY target/projeto-azure-e-container-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/

# Estabelece um diretorio de trabalho em seu container
WORKDIR /usr/app/

# Comando para executar o .jar
CMD ["java","-jar","projeto-azure-e-container-1.0-SNAPSHOT-jar-with-dependencies.jar"]