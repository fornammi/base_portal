package io.nio;

import java.io.IOException;

import io.nio.client.NioClient;

public class MainTest {
	public static void main(String[] args) {  
        System.out.println("clients start..............");  
        NioClient client = new NioClient("127.0.0.1", 8080, 5000);  
        try {  
            client.startNioClient();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }
}
