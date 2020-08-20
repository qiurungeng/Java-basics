package com.study.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestNoBlockingNIO {
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //2.切换为非阻塞模式
        socketChannel.configureBlocking(false);
        //3.分配指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //4.发送数据给server
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString()+"\n"+str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }


        //4.关闭通道
        socketChannel.close();
    }
    @Test
    public void server() throws IOException {
        //1. 获取通道
        ServerSocketChannel ssChannel=ServerSocketChannel.open();
        //2. 切换到非阻塞模式
        ssChannel.configureBlocking(false);
        //3. 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        //4. 获取选择器
        Selector selector = Selector.open();
        //5. 将通道注册到选择器上，指定监听事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6. 轮询获取选择器上已经准备就绪的事件
        while(selector.select()>0){
            //7. 获取当前选择器中所有注册的选择键(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //8. 获取准备就绪的时间
                SelectionKey sk = iterator.next();
                //9. 判断具体是什么时间准备就绪
                if (sk.isAcceptable()){
                    //10. 若“接收就绪”，获取客户端连接
                    SocketChannel accept = ssChannel.accept();
                    //11. 切换为非阻塞模式
                    accept.configureBlocking(false);
                    //12. 将该通道注册到选择器上
                    accept.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    //13. 获取当前选择器上“读就绪”的通道
                    SocketChannel channel = (SocketChannel) sk.channel();
                    //14. 读取数据
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=channel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                //15.记得取消选择键SelectionKey
                iterator.remove();
            }

        }
    }
}
