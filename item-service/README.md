# Item Service

## Overview

The item service uses [Quarkus](https://quarkus.io) and is used to manage item resources.  These would be items a store sells and need to be in the inventory. It exposes a REST API that exposes the standard CRUD operations for item resources.

### Data Store

The service is configured to use [PostgreSQL](https://www.postgresql.org/) as its data store.

### Kafka Topic

When an item resource has been created or modified, an ItemEvent will be created and published to the `item-events` topic in the Kafka instance or cluster.  The inventory service is the consumer of this topic.

## How do I use it?

### Prerequisites

* Java 8
* Apache Maven
* Docker (if using for Mongo)
* A running PostgreSQL instance

#### Starting PostgreSQL using Docker

Assuming docker is installed, run the following command:
```
docker run --name items-postgres -e POSTGRES_USER=pguser -e POSTGRES_PASSWORD=pgpass -e POSTGRES_DB=itemsdb -p 5432:5432 -d postgres
```

### Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

### Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `item-service-1.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/item-service-1.0-SNAPSHOT-runner.jar`.

### Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/item-service-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .

## Access the application

To access the application, open the following link in your browser:

`http://localhost:8081`

Swagger UI can be accessed with the following link:

`http://localhost:8081/swagger-ui/`

### Exposed Endpoints

All exposed endpoints and Models can be found using the [swagger api documentation](http://localhost:8081/openapi) or the [swagger-ui page](http://localhost:8081/swagger-ui/).

The current endpoints are as follows:
```
# retrieve all item resources
GET    /items

# create new item resource
POST   /items

# create multiple new item resources
POST   /items/list

# retrieve item resource by item ID
GET    /items/{itemId}

# update item resource by item ID
PUT    /stores/{itemId}

# delete item resource by item ID
DELETE /items/{itemId}

```

### Item Resource Model
```
Item:
{
id	        integer($int64)
brandName   string
color       string
description string
gender      string
size        string
type        string
}
```

NOTE: id is generated upon creation
