package pres.qianmuna._kafka_

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaTemplate

/**
@author HJC
@date 2020/8/7  13:33
@description :
@version 1.0
谦谦君子 卑以自牧也
 */


/*
* 生产者 发送消息
*
* */
class Kafka1{

}

class kafkaProducer{


    private lateinit var kafkaTemplate: KafkaTemplate<String , Any>

    fun sendMessage(topic:String, content:String) = kafkaTemplate.send(topic , content)

}

class KafkaConsumenr{
    @KafkaListener( topics = ["test"] )
    fun handlerMessage(record:ConsumerRecord<String , Any>) = println(record.value())
}