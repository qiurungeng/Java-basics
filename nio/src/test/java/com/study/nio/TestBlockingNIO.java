package com.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO {
    @Test
    public void client() throws IOException{
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel fileChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

        //分配指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //3.读取本地文件并发送到服务端
        while (fileChannel.read(buf)!=-1){
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        //4.关闭通道
        fileChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2.绑定端口
        serverSocketChannel.bind(new InetSocketAddress(9898));
        //3.获取客户端连接的通道
        System.out.println("等待client连接...");
        SocketChannel accept = serverSocketChannel.accept();
        System.out.println("Client连接成功...:"+accept.getRemoteAddress()+"|"+accept.getLocalAddress());
        //4.分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //5.接收客户端传来的数据并保存到本地

        while (accept.read(buffer)!=-1){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        //6.关闭通道
        System.out.println("关闭server...");
        accept.close();
        fileChannel.close();
        serverSocketChannel.close();
    }
}
