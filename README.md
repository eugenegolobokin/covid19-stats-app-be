# COVID-19 Statistics App 
*COVID-19 Statistics App* is a web based application that shows a graph of Covid-19 weekly cases and deaths in a selected country. App uses statistics data from [this source](https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/).

## Table of contents
* [Setup](#setup)
* [Features](#features)
* [Technologies](#technologies)


## Setup
#### 1. Necessary resources
1. JDK version 11.
2. Front end from [this repository](https://github.com/eugenegolobokin/covid19-stats-app-fe).

#### 2. Starting application
```
# Clone this repository
$ git clone https://github.com/eugenegolobokin/covid19-stats-app-be.git

# Go into the repository folder
$ cd covid19-stats-app-be

# Run the app
$ ./gradlew bootRun
```

* As alternative - open project in your IDE and run main method from Covid19StatsAppApplication.java
* Project uses in-memory H2 database - data from external source will be downloaded and saved into database on app loading. 
* Open [http://localhost:8080](http://localhost:8080) in your browser - welcome message should indicate your backend is up and running.
* Clone [this frontend repository](https://github.com/eugenegolobokin/covid19-stats-app-fe) and setup according to instructions for full experience.


## Features 
* The application backend reads data from [this endpoint](https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/). 
* Data is read from external source only once when application is starting. 
* The  COVID-19 data should is kept in memory (H2 in-memory DB is used). 
* BE provides rest api endpoint which provides covid-19 case and death data by country.
* The country should be passed as a parameter to the rest api. 
* The web application displays the chart with two lines (cases and deaths) by week. 
* In web application it is possible to select the country from the dropdown list. 
* After the country is selected the data in the chart is refreshed.


## Technologies
* Java 11
* Spring Boot
* Gradle
* H2 db
