"# Digirest" 

## Running Digirest locally
```
	git clone https://github.com/sraghu-rs/Digirest.git
	cd Digirest
	mvn clean package    
```


You can then access Digirest here: [http://localhost:8080/digirest/index.html](http://localhost:8080/)


## Database configuration

In its default configuration, Digirest needs to be configured against 
the Database used by Digital Bank Application.

The Database configurations needs to be updated in src/resources/hibernate.cfg.xml file.

