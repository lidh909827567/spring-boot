package com.lidh.zookeeper;

/**
 * Created by lidhk on 2018/8/29.
 *
 * @author lidhk
 */
public class OrserService implements Runnable {

    OrderNumberConfig config = new OrderNumberConfig();

    private ZookeeperLock lock = new ZookeeperDistrbuteLock();


    @Override
    public void run() {
        try {
            lock.getLock();
            getNumber();
        } catch (Exception e) {
        } finally {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unLock();
        }
    }

    public void getNumber() {
        String number = config.getNumber();
        System.out.println(Thread.currentThread().getName() + "订单号:" + number);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new OrserService()).start();
        }
    }
}
