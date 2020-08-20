package com.study.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {
    @Test
    public void test1(){
        String str="abcde";
        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("__________allocate()_________");
        System.out.println("position:"+byteBuffer.position());
        System.out.println("limit:\t"+byteBuffer.limit());
        System.out.println("capacity:"+byteBuffer.capacity());

        //利用put存入数据到缓冲区
        byteBuffer.put(str.getBytes());
        System.out.println("____________put()____________");
        System.out.println("position:"+byteBuffer.position());
        System.out.println("limit:\t"+byteBuffer.limit());
        System.out.println("capacity:"+byteBuffer.capacity());

        //切换到读取数据的模式
        byteBuffer.flip();
        System.out.println("____________flip()___________");
        System.out.println("position:"+byteBuffer.position());
        System.out.println("limit:\t"+byteBuffer.limit());
        System.out.println("capacity:"+byteBuffer.capacity());

        //利用get方法读取缓冲区中的数据
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("____________get()____________");
        System.out.println("position:"+byteBuffer.position());
        System.out.println("limit:\t"+byteBuffer.limit());
        System.out.println("capacity:"+byteBuffer.capacity());
        //rewind()重复读取数据
        byteBuffer.rewind();
        System.out.println("___________rewind()__________");
        System.out.println("position:"+byteBuffer.position());
        System.out.println("limit:\t"+byteBuffer.limit());
        System.out.println("capacity:"+byteBuffer.capacity());

        //clear()清空缓冲区,但缓冲区里面的数据依然存在，处于“被遗忘”状态
        byteBuffer.clear();
        System.out.println("___________clear()___________");
        System.out.println("position:"+byteBuffer.position());
        System.out.println("limit:\t"+byteBuffer.limit());
        System.out.println("capacity:"+byteBuffer.capacity());
    }

    @Test
    public void test2(){
        String str="abcde";
        ByteBuffer buf=ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        buf.flip();
        byte[] dst=new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println("buf current position:"+buf.position());

        //mark标记
        buf.mark();

        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println("buf current position:"+buf.position());

        //reset() 恢复到mark时的位置
        buf.reset();
        System.out.println("buf current position:"+buf.position());

        //判断缓冲区中是否还有剩余的数据
        if (buf.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());
        }
    }
}
