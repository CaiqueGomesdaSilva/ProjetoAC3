# Utiliza uma imagem do Java como base
FROM openjdk:17-jdk-alpine
RUN apt-get update && apt-get install -y bash
RUN which bash
# Copia o arquivo .jar para o container
COPY target/projeto-azure-e-container-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/app/

# Estabelece um diretorio de trabalho em seu container
WORKDIR /usr/app/

# Comando para executar o .jar
CMD ["/bin/bash"]