# Utiliza uma imagem do ubuntu como base
FROM ubuntu:latest
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk-headless && \
    rm -rf /var/lib/apt/lists/*

# Estabelece um diretorio de trabalho em seu container
WORKDIR /app

# Copia o arquivo .jar para o container
COPY target/projeto-azure-e-container-1.0-SNAPSHOT-jar-with-dependencies.jar .

# Comando para executar o .jar
CMD ["java", "-jar", "projeto-azure-e-container-1.0-SNAPSHOT-jar-with-dependencies.jar"]