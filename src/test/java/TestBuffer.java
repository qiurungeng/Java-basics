import org.junit.jupiter.api.Test;

/**
 * 缓冲区：NIO中负责存取数据。就是数组。存取不同类型的数据
 * 系统根据数据类型的不同提供了不同的缓冲区：
 * ByteBuffer、CharBuffer、ShortBuffer、LongBuffer、IntButter、FloatBuffer、DoubleBuffer
 * 上述缓冲区管理方式几乎一致，通过allocate（）获取缓冲区
 *
 * 缓冲区存取数据的两个核心方法
 * put、get
 *
 * 核心属性
 * capacity：容量，buffer最大存储容量，一旦声明不可变
 * limit：界限，表示缓冲区的可以操作的数据大小
 * position：位置，表示缓冲区中正在操作的数据的位置
 *
 * position<=limit<=capacity
 */
public class TestBuffer {
    @Test
    public void test1(){

    }
}
