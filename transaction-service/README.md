# Transaction Service

## Overview

The transaction service is a mocked service that handles `transaction-events` to simulate purchased and returned items for stores.

### Events and Kafka Topics

The transaction service manages a couple events and topics.

#### Consumer

The transaction service is a consumer of the following topic(s):
* `transaction-events` - processes a TransactionEvent and creates an InventoryEvent that is published to the `inventory-events` topic


#### Producer

The transaction service is producer to the following topic(s):
* `inventory-events` - events generated to update inventory counts when items have been purchased or returned at a store

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
It produces the executable `transaction-service-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/transaction-service-1.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/transaction-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .

## Access the application

The application currently has no exposed endpoints.  All processing is completed through Kafka topic producer and consumers.

NOTE:  The current port is set to 8083 for local development
