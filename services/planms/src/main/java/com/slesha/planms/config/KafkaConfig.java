package com.slesha.planms.config;

import java.util.Map;
import java.util.HashMap;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class KafkaConfig {
   @Bean
   public ProducerFactory<String, String> producerFactory() {
      Map<String, Object> configProps = new HashMap<>();
      configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
      configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
      return new DefaultKafkaProducerFactory<>(configProps);
   }
   @Bean
   public KafkaTemplate<String, String> kafkaTemplate() {
      return new KafkaTemplate<>(producerFactory());
   }
   @Bean
   public new_kafkaprod<String, String> new_kafkaprod() {
   // Create a Kafka producer object
   Producer<String, String> producer = new KafkaProducer<>(props);

      // Create a topic with the name "user-plans"
      Properties adminProps = new Properties();
      adminProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      AdminClient adminClient = AdminClient.create(adminProps);
      NewTopic newTopic = new NewTopic("user-plans", 1, (short) 1);
      adminClient.createTopics(Collections.singleton(newTopic));

      producer.send(record);
         }
}