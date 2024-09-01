## Ecomm web application

The application have been build as multimodule spring boot application, of which there are two web modules, 
ecomm-products and ecomm-images, as part of federation managed by apollo. 

ecomm-products acts as a main module as it contains flyway scripts for creating the database.
Both modules use the ecomm-core, which contains all the entities, dtos, repositories and services.
ecomm-products and ecomm-images only have controllers. 




### The application can be run using docker-compose.

> docker-compose up

then open the browser to http://localhost:4000, and write some queries. There are sample queries in sample.graphql.


### Further improvements

- Unit tests
- Integration tests
- Functional tests
- Authentication & Authorization
- Move the project to gitlab (as I am more familier with gitlab-ci then github actions)
- Create CI/CD pipeline, which will build the project, create docker images and add the images to docker registry.
- Use the docker registry from gitlab in docker-compose
- Create kubernetes cluster in AWS on GCP or some other cloud provider
- Create helm charts
- Deploy the charts to kubernetes cluster ideally using terraform


