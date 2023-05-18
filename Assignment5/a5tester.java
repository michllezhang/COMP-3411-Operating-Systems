
public class a5tester{

	public static void main(String[] args){
		producer pro = new producer();
		consumer con = new consumer(pro);

		pro.start();
		con.start();

	}

}
