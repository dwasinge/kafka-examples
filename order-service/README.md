# Order Service

## Overview

The order service is a mocked service that handles several events and produces `inventory-events` to restock items for stores.

### Events and Kafka Topics

The order service manages several events and topics.

#### Consumer

The order service is a consumer of the following topics:
* `low-inventory-events` - processes InventoryEvent and produces a OrderCreatedAndShippedEvent and places it on the `order-shipped-events` kafka topic to be processed
* `order-shipped-events` - mocks a shipment notification.  The en route process simulates an order being shipped to a store
* `order-received-events` - simulates a store receiving a shipment and creates new InventoryEvents to update the inventory service

#### Producer

The order service is producer to the following topics:
* `order-shipped-events` - used to simulate an order being shipped to the store
* `order-received-events` - used to simulate an order being received at a store
* `inventory-events` - events generated to update inventory counts when an order had been received at a store

## How do I use it?

### Prerequisites

* Java 8
* Apache Maven
* Docker (if using for Mongo)
* A running Mongo instance

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

### Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `order-service-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/order-service-1.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/order-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .

## Access the application

The application currently has no exposed endpoints.  All processing is completed through Kafka topic producer and consumers.

NOTE:  The current port is set to 8085 for local development
