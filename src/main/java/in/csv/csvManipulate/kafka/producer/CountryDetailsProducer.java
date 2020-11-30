package in.csv.csvManipulate.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import lombok.extern.slf4j.Slf4j;

@Component("countryDetailsProducer")
@Slf4j
public class CountryDetailsProducer {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public CountryDetailsProducer() {
		log.info("-----CountryDetailsProducer Class, Constructor method-----");
	}

	public ListenableFuture<SendResult<String, Object>> produce(String topic, String msg) {
		log.info(":::::Sending file from kafka producer::::");
		ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaTemplate.send(topic, msg);
		log.info("::::Producer send the message to topic :  {}, and message {}", topic, msg);
		return listenableFuture;
	}
}
