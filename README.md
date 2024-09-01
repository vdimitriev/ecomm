## Ecomm application

Created with Spring Boot and GraphQL. 

It can be run using docker-compose:

> docker-compose up

then open the browser to http://localhost:8085/graphiql 

The application exposes two endpoints, /product and /image. 

/product has some implementation, one can create product and list all the products
/image is not yet implemented.


rover dev --name ecomm-products --schema ./ecomm-products/src/main/resources/graphql/schema.graphqls --url http://localhost:8081/graphql
rover dev --name ecomm-images --schema ./ecomm-images/src/main/resources/graphql/schema.graphqls --url http://localhost:8082/graphql

rover supergraph compose --config ./supergraph.yaml > supergraph.graphql

