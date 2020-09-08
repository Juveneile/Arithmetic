package ProduceConsumer;

/**
 * @author hxxhk
 */
public class ProduceThread extends Thread {
    private Produce produce;

    public ProduceThread(Produce produce) {
        this.produce = produce;
    }

    @Override
    public void run() {
        while (true) {
            produce.produce();
        }
    }
}
