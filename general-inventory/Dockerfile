FROM gradle:latest AS builder

WORKDIR /app

RUN apt-get update \
    && apt-get install -y git \
    && rm -rf /var/lib/apt/lists/*
RUN echo "Git installed"
VOLUME /app/inventory

COPY . /app/inventory
RUN echo "Cloning and building repository..."
RUN cd /app/inventory \
    && git pull || git clone https://github.com/LDHG-K/general-inventory.git \
    && gradle build
RUN echo "Repository cloned and built successfully :)"

FROM openjdk:11

WORKDIR /app
RUN echo "Deploying application..."
COPY --from=builder /app/inventory/build/libs/inventory-1.0.jar /app/inventory-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/inventory-1.0.jar"]
RUN echo "Application deployed successfully :)"