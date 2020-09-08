/**
 * 生产/消费者问题是个非常典型的多线程问题，涉及到的对象包括“生产者”、“消费者”、“仓库”和“产品”。他们之间的关系如下：
 *
 * ① 生产者仅仅在仓储未满时候生产，仓满则停止生产。
 *
 * ② 消费者仅仅在仓储有产品时候才能消费，仓空则等待。
 *
 * ③ 当消费者发现仓库没产品可消费时候会通知生产者生产。
 *
 * ④ 生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 *
 * 用wait/notify/notifyAll实现
 * 用Lock的Condition实现。
 *
 * 用wait/notify/notifyAll 实现生产者消费者模型：
 *
 * 方法一：用五个类来实现，分别为Produce(实现生产过程), Consumer(实现消费过程), ProduceThread(实现生产者线程),ConsumeThread(实现消费者线程),Main等。需要注意的是有两个地方。
 *
 * ① 用while判断当前list是否为空；
 *
 * ② 调用的是object的notifyAll()方法而不是notify()方法。
 *
 * 方法二：用四个类实现，分别为MyService(实现生产和消费过程用synchronized关键字实现同步)，ProduceThread(实现生产者线程),ConsumeThread(实现消费者线程),Main。需要注意的也是方法一中的两个地方while和notifyAll()。
 *
 * 用Lock和Condition实现。共有四个类，分别是分别为MyService(实现生产和消费过程，用lock实现线程间同步)，ProduceThread(实现生产者线程),ConsumeThread(实现消费者线程),Main。需要注意的也是方法一中的两个地方while和signalAll()。
 * @author hxxhk
 */
public class Main {
}
