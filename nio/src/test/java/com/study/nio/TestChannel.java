package com.study.nio;

import org.junit.Test;
import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir"));
    }

    //1. 利用通道完成文件的复制
    @Test
    public void test1() throws IOException {
        FileInputStream fis=new FileInputStream("1.jpg");
        FileOutputStream fos=new FileOutputStream("2.jpg");
        FileChannel in = fis.getChannel();
        FileChannel out = fos.getChannel();
        ByteBuffer buf=ByteBuffer.allocate(1024);
        while (in.read(buf)!=-1){
            buf.flip();
            out.write(buf);
            buf.clear();
        }
        out.close();
        in.close();
        fos.close();
        fis.close();
    }

    /**
     * 使用直接缓冲区完成文件的复制（内存映射文件）
     */
    @Test
    public void test2() throws IOException {
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"),StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.WRITE,
                StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);
        MappedByteBuffer inMapBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        byte[] dst=new byte[inMapBuf.limit()];
        inMapBuf.get(dst);
        outMapBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }

    /**
     * 通道之间的数据传输（直接缓冲区）
     */
    @Test
    public void test3() throws IOException {
        FileChannel inChannel=FileChannel.open(Paths.get("1.jpg"),StandardOpenOption.READ);
        FileChannel outChannel=FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.WRITE,
                StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    /**
     * 分散读取，聚集写入
     */
    @Test
    public void test4() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("hosts.txt","rw");
        //1.获取通道
        FileChannel channel1=raf1.getChannel();

        //2.分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.分散读取：
        ByteBuffer[] buffers=new ByteBuffer[]{buf1,buf2};
        channel1.read(buffers);

        for (ByteBuffer buffer : buffers) {
            buffer.flip();
        }

        //打印各分散buffer详情
        System.out.println(new String(buffers[0].array(),0,buffers[0].limit()));
        System.out.println("___________________");
        System.out.println(new String(buffers[1].array(),0,buffers[1].limit()));

        //4.聚集写入
        RandomAccessFile raf2=new RandomAccessFile("2.txt","rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(buffers);

        channel2.close();
    }

    /**
     * 字符集
     */
    @Test
    public void test5() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");
        CharsetEncoder encoder = gbk.newEncoder();  //  编码
        CharsetDecoder decoder = gbk.newDecoder();  //  解码

        CharBuffer buf=CharBuffer.allocate(1024);
        buf.put("学习使我快乐");
        buf.flip();

        //编码
        ByteBuffer byteBuffer=encoder.encode(buf);
        for (int i = 0; i < 12; i++) {  //Java中一个Char占两个字节
            System.out.println(byteBuffer.get());
        }

        byteBuffer.flip();
        CharBuffer charBuffer=decoder.decode(byteBuffer);
        System.out.println(charBuffer.toString());
    }
}
