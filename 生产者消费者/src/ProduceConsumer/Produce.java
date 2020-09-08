package ProduceConsumer;

import java.util.ArrayList;

/**
 * 生产者
 *
 * @author hxxhk
 */
public class Produce {

    public final Object object;
    //用list存放生产之后的数据，最大容量为1
    public ArrayList<Integer> list;

    public Produce(Object object, ArrayList<Integer> list) {
        this.object = object;
        this.list = list;
    }

    public void produce() {

        synchronized (object) {
            /*只有list为空时才会去进行生产操作*/
            try {
                // 仓库非空就认为满了
                while (!list.isEmpty()) {
                    System.out.println("生产者" + Thread.currentThread().getName() + " waiting");
                    object.wait();
                }
                int value = 9999;
                list.add(value);
                System.out.println("生产者" + Thread.currentThread().getName() + " Runnable");
                //然后去唤醒因object调用wait方法处于阻塞状态的线程
                object.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
