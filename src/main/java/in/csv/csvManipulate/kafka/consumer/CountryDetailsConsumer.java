package in.csv.csvManipulate.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("countryDetailsConsumer")
@Slf4j
public class CountryDetailsConsumer {

	public CountryDetailsConsumer() {
		log.info("-----CountryDetailsConsumer Class, CountryDetailsConsumer method-----");
	}

	@KafkaListener(topics = "", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consumes(ConsumerRecord<String, String> msg) {

	}

}
