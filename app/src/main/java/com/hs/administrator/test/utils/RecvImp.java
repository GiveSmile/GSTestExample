package com.hs.administrator.test.utils;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @auther : yanbin
 * @time : 2018/8/16 0016 17:30
 * @describe :
 */

public class RecvImp extends Thread {
    ConnectionFactory factory;
    Connection connection = null;
    Channel channel;
    Handler handler;
    private final static String QUEUE_NAME = "yanbin";

    public RecvImp(ConnectionFactory factory, Handler handler) {
        this.factory = factory;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            /**创建一个连接*/
            connection = factory.newConnection();
            /**创建channel，声明一个通道*/
            channel = connection.createChannel();
            /**声明要关注的队列*/
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            /**告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery*/
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    Log.d("vivi", "handleDelivery: " + message);
                    Message msg = new Message();
                    msg.what = 1;
                    msg.obj = message;
                    handler.sendMessage(msg);
                }
            };
            /**自动回复队列应答 -- RabbitMQ中的消息确认机制*/
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭连接
     */
    public void close() {
        try {
            if (channel != null)
                channel.close();
            if (connection != null)
                connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
