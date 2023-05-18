public class producer extends Thread{
	
	public static final int MAX_SIZE=5;
	public static int[] buffer;
	public static int in;
	public static int count;
	
	public producer(){
		
		this.buffer = new int[MAX_SIZE];
		this.in = 0;
		this.count = 0;
	}

	public void run(){
		try{
			while(true){
				produce(1);
				
			}
		}
		catch(Exception exp){

		}
	}

	public synchronized void produce(int item) {
		while (count == MAX_SIZE) {
			try{
				wait();
			}
			catch (InterruptedException ie) { }
		}
		buffer[in] = item;
		in = (in + 1) % MAX_SIZE;
		
		count = count+1;
		
		System.out.println("Produced by:"+Thread.currentThread().getName()+" Count="+count);
		
		notify();
	}

	public synchronized void consume() {
	
		while (count == 0) {
			try{
			wait();
			 }
		        catch (InterruptedException ie) { }
		}
		
		buffer[count-1] = 0;
		count--;
		System.out.println("Consume by:"+Thread.currentThread().getName()+" Count="+count);
		notify();
		
	}
}
