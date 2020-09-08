package ProduceConsumer;

import java.util.ArrayList;

/**
 * 消费者
 *
 * @author hxxhk
 */
public class Consumer {

    public final Object object;
    /**
     * 模拟队列
     */
    public ArrayList<Integer> list;

    public Consumer(Object object, ArrayList<Integer> list) {
        this.object = object;
        this.list = list;
    }

    public void consmer() {

        synchronized (object) {
            try {
                /*只有list不为空时才会去进行消费操作*/
                while (list.isEmpty()) {
                    System.out.println("消费者" + Thread.currentThread().getName() + " waiting");
                    object.wait();
                }
                list.clear();
                System.out.println("消费者" + Thread.currentThread().getName() + " Runnable");
                //然后去唤醒因object调用wait方法处于阻塞状态的线程
                object.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
