# Data Generator Service

## Overview

The data generator service will generate transactions and publish them to the `transaction-events` Kafka topic to simulate purchased and returned items for stores.

### Events and Kafka Topics

#### Producer

The data generation service is producer to the following topic(s):
* `transaction-events` - TransactionEvents are published to simulate purchases and returns of items to a store

## How do I use it?

### Prerequisites

* Java 8
* Apache Maven

### Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `data-generator-service-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/data-generator-service-1.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/data-generator-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .

## Access the application

The application currently has no exposed endpoints.  All processing is completed through Kafka topic producer and consumers.

NOTE:  The current port is set to 8084 for local development
