package com.santosh.multithreading;

public class DeadlockInMultiThread {

	public static void main(String args[]) throws Exception {

		ProductA a = new ProductA();
		ProductA b = new ProductA();

		ThreadX x = new ThreadX(a, b);
		ThreadX y = new ThreadX(b, a);
		x.start();
		y.start();

		x.join();
		y.join();
 	}

}

class ThreadX extends Thread {

	ProductA k;
	ProductA j;

	ThreadX(ProductA a, ProductA b) {
		k = a;
		j = b;
	}

	public void run() {
		synchronized (this.k) {

			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		
		synchronized (this.j) {

			this.k.inc();
		}
		}
	}
}

class ProductA {

	int quantity = 0;

	public synchronized void inc() {
		for (int i = 0; i < 5; i++)
			System.out.println(quantity++);

	}

}