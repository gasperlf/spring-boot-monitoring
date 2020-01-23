[![Twitter](https://img.shields.io/github/followers/gasperlf.svg?label=Follow%20Me&logo=twitter&style=social)](https://twitter.com/gasper_lf)

# spring-boot-monitoring
Example how to monitoring microservices with spring boot, Spring Actuator, Prometheus and Grafana.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

      git clone https://github.com/gasperlf/spring-boot-monitoring.git

## Prerequisites

- Java 11
- Spring boot 2.2.4
- Docker
- Docker compose
- Prometheus
- Grafana
- YahooFinanceAPI Library (https://financequotes-api.com/)
- Postman

## Model
<img src="https://i.ibb.co/khpQz25/monitoring-services.png" alt="ms-model-1" border="0">

## IDE's

1. Eclipse
2. Intellij IDEA

##Running
### Components

1. api-finance-service
2. api-finance-service-reactive
3. prometheus
4. Grafana

### Command

1. `mvn clean package` compile and create artifacts.

2. ` docker-compose up -d` create docker image and run in a container.

Also you can use bash script `start.sh` that contains both commands.


### See monitoring in grafana

First in your browser `http://localhost:3000` 

next Log in with user and password admin/admin
then create a datasource, select prometheus.
in this step you need to set URL from prometheus service, in this case `http://[docker-container]:9090` (check docker compose name)
after that you can import a dashboard that I have included in Grafana folder, I prefer to use `jvm-micrometer_rev9.json`
check when you imported the dashboard choose the datasource created before.
and that is all.

<img src="https://i.ibb.co/wKXGQbW/grafana-dashboard.jpg" alt="ms-grafana-1" border="0">

## Postman

#### Api-finance-service
<img src="https://i.ibb.co/5rQ31QW/api-finance-service.png" alt="ms-api-finance-service-1" border="0"> 

#### Api-finance-service-reactive
<img src="https://i.ibb.co/JdPkj2F/api-finance-service-reactive.png" alt="ms-api-finance-service-reactibe-1" border="0">

## Contributing

## Versioning

0.0.1-snapshot

## Authors

    - Lewis Florez Renza

## License

## Acknowledgments


