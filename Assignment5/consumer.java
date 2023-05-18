import java.util.*;
public class consumer extends Thread{
	public producer p;
	public static final int MAX_SIZE = 5;
	
	public consumer(producer pro){
		this.p = pro;
	}
	public void run(){
		try{
			while(true){
				p.consume();
				
			}
		}
		catch(Exception exp){

		}
	}



}
