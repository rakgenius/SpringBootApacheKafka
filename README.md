This is spring boot application to demonstrate the usage of Apache kafka
to send and receive messages.

Prerequisites to run the project

    Java, maven, kafka

Download the kafka from https://www.apache.org/dyn/closer.cgi?path=/kafka/2.2.0/kafka_2.12-2.2.0.tgz
or use any other latest version to get the packages.
Extract the tar file to any location

Follow the below steps to start the Apache Kafka server

    1. Start the zookeeper server using

        bin/zookeeper-server-start.sh config/zookeeper.properties

    2. Once zookeeper starts successfully, start the kafka server.
       Before starting the kafka server, make sure that the hostname and port
       are set properly in the file config/server.properties.

       advertised.host.name=localhost
       advertised.port=9092
       or
       port=9092

        bin/kafka-server-start.sh config/server.properties

    3. Once kafka server runs successfully, start the consumer to read the messages

        bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic user_names --from-beginning

       Here "user_names" is the topic name I am using to listen on. You can use any name you want

    4. Once the initial setup is done, clone this repository to the local folder

    5. Build the packages using the command
 
        mvn clean install

    6. If everything is successfull, start the application using

        java -jar target/kafka-demo-0.0.1-SNAPSHOT.jar

    7. As soon as the project runs, you should see messages being sent and received

    8. You can also navigate to http://localhost:9000/kafka/publish/<some message> to send
       message from the producer and you can see the same message being received by consumer


Reference materials:

https://github.com/TechPrimers/spring-boot-kafka-producer-example

https://dzone.com/articles/magic-of-kafka-with-spring-boot

https://medium.com/@contactsunny/simple-apache-kafka-producer-and-consumer-using-spring-boot-41be672f4e2b
