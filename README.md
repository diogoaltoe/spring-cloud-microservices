# Microservices with Spring Cloud (Netflix)

Spring Cloud servers publishing a RESTful Web Service with OAuth2.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

- I suggest use an Java IDE. I'm using Eclipse with Spring plugin.
- PostgreSQL or other database (need edit the config).
- An client to consume and test the service. I suggest Rest Web Service Client for Chrome or RESTClient for Firefox.

### Installing

1. Download the project by clicking the "Clone or download" button.
2. Unzip the project into the directory of your choice.
3. Using Eclipse (or another IDE), open the project you saved in the directory of your choice.
4. Run the project.

## Deployment

You can use another project like Client [android-microservices](https://github.com/diogoaltoe/android-microservices) or any Web Service RESTful Client extension for browser (Chrome or Firefox).

## Testing

You can download the WAR file on [Releases Page](https://github.com/diogoaltoe/android-microservices/releases), install on your host server and test the project.

## Build and Run

1. Run as > Maven clean
2. Run as > Maven build
3. Run as > Spring Boot App

## Usage

### Checking app is deployed sucessfullly

Command:
```
curl -i http://localhost:9020/
```
Server Response:
```
{
  "_links" : {
    "user" : {
      "href" : "http://localhost:9020/user{?page,size,sort}",
      "templated" : true
    },
    "authorities" : {
      "href" : "http://localhost:9020/authorities{?page,size,sort}",
      "templated" : true
    },
    "product" : {
      "href" : "http://localhost:9020/product{?page,size,sort}",
      "templated" : true
    },
    "person" : {
      "href" : "http://localhost:9020/person{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:9020/alps"
    }
  }
}
```

### Access secure resource with token

Command:
```
curl -i http://localhost:9020/product/
```
Server Response:
```
{
	"timestamp":1444985908768,
	"status":401,
	"error":"Unauthorized",
	"message":"Access Denied",
	"path":"/product/"
}
```

### Fetching refresh_token

Command:
```
curl -vu wsapp:secret 'http://localhost:9020/oauth/token?username=admin@admin.com&password=12345678&grant_type=password'
```
Server Response:
```
{
	"access_token":"92457844-4d4f-4f5a-b053-7f5074d6y892",
	"token_type":"bearer",
	"refresh_token":"e6f8624f-213d-4343-a971-980e83f734be",
	"expires_in":1738,
	"scope":"read write"
}
```

### Fetching acess_token by submitting refresh_token

Command:
```
curl -vu wsapp:secret 'http://localhost:9020/oauth/token?grant_type=refresh_token&refresh_token=<refresh_token>'
```
Server Response:
```
{
	"access_token":"821c99d4-2c9f-4990-b68d-18eacaff54b2",
	"token_type":"bearer",
	"refresh_token":"e6f8624f-213d-4343-a971-980e83f734be",
	"expires_in":1799,
	"scope":"read write"
}
```

### Access secure resource sucessfully

Command:
```
curl -i -H "Authorization: Bearer <access_token>" http://localhost:9020/product/
```
Server Response:
```
{
  "_links" : {
    "self" : {
      "href" : "http://localhost:9020/product{?page,size,sort}",
      "templated" : true
    },
    "search" : {
      "href" : "http://localhost:9020/product/search"
    }
  },
  "_embedded" : {
    "product" : [ {
      "name" : "Bermuda",
      "description" : "Bermuda Adidas",
      "cost" : 50.5,
      "_links" : {
        "self" : {
          "href" : "http://localhost:9020/product/3"
        }
      }
    }, {
      "name" : "Meia",
      "description" : "Meia Rebook",
      "cost" : 15.7,
      "_links" : {
        "self" : {
          "href" : "http://localhost:9020/product/4"
        }
      }
    }, {
      "name" : "Camisa",
      "description" : "Camisa Nike",
      "cost" : 10.5,
      "_links" : {
        "self" : {
          "href" : "http://localhost:9020/product/6"
        }
      }
    }, {
      "name" : "Bone",
      "description" : "Do Milan",
      "cost" : 34.98,
      "_links" : {
        "self" : {
          "href" : "http://localhost:9020/product/19"
        }
      }
    }, {
      "name" : "Cueca",
      "description" : "Cueca Polo Assassin",
      "cost" : 25.9,
      "_links" : {
        "self" : {
          "href" : "http://localhost:9020/product/5"
        }
      }
    }, {
      "name" : "Tenis",
      "description" : "Tenis Nike Air",
      "cost" : 32.5,
      "_links" : {
        "self" : {
          "href" : "http://localhost:9020/product/2"
        }
      }
    } ]
  },
  "page" : {
    "size" : 20,
    "totalElements" : 6,
    "totalPages" : 1,
    "number" : 0
  }
}
```

## Servers Access Data

### Config Repository Server

- **Port:** 9000
- **User:** config
- **Password:** $2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy (123456)

### Service Discovery Server

- **Port:** 9010
- **User:** discovery
- **Password:** $2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy (123456)

### API Gateway Server

- **Port:** 9020
- **User:** gateway
- **Password:** $2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy (123456)
- **OAuth2**
	- **User:** admin
	- **Password:** $2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy (123456)
	- **client-id:** microservices
	- **client-secret:** $2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy (123456)
	- **client-id:client-secret (Base64):** bWljcm9zZXJ2aWNlczokMmEkMTAkcjBSRkRtcG5lQlZyeXguaWhISzlndTZGRkpRaTRuVHhRVXF6ZFNUdnJQcGFLWk14aWdxcHk=

### Stock Service

- **Port:** 9030

### Relationship Service

- **Port:** 9031

## Built With

- [Maven](https://gradle.org/) - Dependency Management.
- [OAuth2](https://oauth.net/2/) - Industry-standard protocol for authorization.
- [PostgreSQL](https://www.postgresql.org/) - is a powerful, open source object-relational database system.
- [Spring Boot](https://projects.spring.io/spring-boot/) - Makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) - It eases development of applications that need to access JPA data sources.
- [Spring HATEOAS ](https://projects.spring.io/spring-hateoas/) - Provides some APIs to ease creating REST representations that follow the HATEOAS principle when working with Spring and especially Spring MVC.
- [Spring Security](https://projects.spring.io/spring-security/) - Is a framework that focuses on providing both authentication and authorization to Java applications.
	
	
## References

- [Microservices with Spring Cloud - Udemy Course](https://www.udemy.com/microservices-with-spring-cloud/)
- [Arquitetura de MicroServices com Spring Cloud e Spring Boot](https://medium.com/coderef/arquitetura-de-microservices-com-spring-cloud-e-spring-boot-parte-1-b5c9288df66d)
- [Accessing a Spring Data REST API With Feign](https://dzone.com/articles/accessing-a-spring-data-rest-api-with-feign)
- [Spring Cloud – Securing Services](http://www.baeldung.com/spring-cloud-securing-services)
- [Secure a Spring Microservices Architecture with Spring Security and OAuth 2.0](https://developer.okta.com/blog/2018/02/13/secure-spring-microservices-with-oauth)
- [Spring Cloud – Bootstrapping](http://www.baeldung.com/spring-cloud-bootstrapping)
- [Spring Cloud Netflix with PATCH](https://gist.github.com/condran/36819504b5811c01f3bc2f179a85b065)

## Versioning

We use [Git](https://git-scm.com/) for versioning.

## Author

**Diogo** - *Initial work* - [diogoaltoe](https://github.com/diogoaltoe)

## License

This project is licensed under the [MIT License](LICENSE.md).
