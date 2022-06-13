package com.cloud.kafka.hw3;
import com.cloud.kafka.hw3.kafka.KafkaProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw3Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Hw3Application.class, args);
	}

	String eventMessage;
	@Autowired
	private KafkaProducer kafkaProducer;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		kafkaProducer.sendMessage();	
	}

}
