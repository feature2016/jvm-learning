package jos.learning.jvm.chapter4;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jos on 2018/6/11.
 */
@Slf4j
public class DeadLoop {
    /**
     * 线程死循环演示
     */
    public static void createBusyThread() {
        int cores = Runtime.getRuntime().availableProcessors() / 2;
        final CyclicBarrier barrier = new CyclicBarrier(cores);
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                while (true) {
                    new Bar().sum(3);
                }
            }
        };
        for (int i = 0; i < cores; i++) {
            new Thread(runnable, "testBusyThread" + i).start();
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sIn = br.readLine();
        log.info("{}", sIn);

        createBusyThread();

        sIn = br.readLine();
        log.info("{}", sIn);
    }
}
