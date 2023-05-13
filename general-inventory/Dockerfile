FROM gradle:latest AS builder

WORKDIR /app

RUN apt-get update \
    && apt-get install -y git \
    && rm -rf /var/lib/apt/lists/*

VOLUME /app/inventory

COPY . /app/inventory

RUN cd /app/inventory \
    && git pull || git clone https://github.com/LDHG-K/general-inventory.git \
    && gradle build


FROM openjdk:11

WORKDIR /app

COPY --from=builder /app/inventory/build/libs/inventory-1.0.jar /app/inventory-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/inventory-1.0.jar"]

COPY --from=builder /app/inventory/build/libs/inventory-1.0.jar /app/inventory-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/inventory-1.0.jar"]
