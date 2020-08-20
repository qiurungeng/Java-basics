package com.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class TestNoBlockingNIO2 {
    @Test
    public void send() throws IOException {
        InetSocketAddress server_addr = new InetSocketAddress("127.0.0.1", 9898);
        //1.获取通道
        DatagramChannel dc = DatagramChannel.open();
        //2.切换为非阻塞模式
        dc.configureBlocking(false);
        //3.分配指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //4.发送数据给server
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString()+"\n"+str).getBytes());
            buf.flip();
            dc.send(buf,server_addr);
            buf.clear();
        }


        //4.关闭通道
        dc.close();
    }
    @Test
    public void receive() throws IOException {
        DatagramChannel dc=DatagramChannel.open();
        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(9898));
        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);
        while(selector.select()>0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey sk = iterator.next();
                if (sk.isReadable()){
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    dc.receive(buffer);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0,buffer.limit()));
                    buffer.clear();
                }
                iterator.remove();
            }
        }
    }
}
