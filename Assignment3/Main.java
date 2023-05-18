//Mengyang Zhang
//T00696467
//TRU COMP3411 A4

class Main
{
    private int[][] m1,m2;
    private int[][] result;
    final int ed = 2; //It is a matrix with width 2 and height 2

    private static java.util.Random ran=new java.util.Random();

    public void initial()
    {
        m1=new int [ed][ed];
        m2=new int [ed][ed];
        result=new int[ed][ed];
        random_matrix(m1);
        random_matrix(m2);
        System.out.println("Matrix 1 is: ");
        print_matrix(m1);
        System.out.println("Matrix 2 is: ");
        print_matrix(m2);
    }
    private Thread Calculate()
    {
        return new Thread()
        {
            public void run()
            {
		for(int t=0;t<ed;t++){
			int [] temp=new int[ed];
			for(int i=0;i<ed;i++)
			{
			    for(int j=0;j<ed;j++)
			    {
				temp[i]+=m1[t][j]*m2[j][i];
			    }
			}
			result[t]=temp;
		}
            }
        };
    }
    public void cal_matrix ()throws Exception
    {

            Thread t=Calculate();
            t.start();
            t.join();

    }
    public void printResult()
    {
        System.out.println("The result is: ");
        print_matrix(result);
    }

    private static void random_matrix(int[][]m)
    {
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                m[i][j]=ran.nextInt()%10;
            }
        }
    }
    private static void print_matrix(int[][] m)
    {
        for(int i=0;i<m.length;i++)
        {
            for(int j=0;j<m[i].length;j++)
            {
                System.out.printf("%8d",m[i][j]);
            }
            System.out.println();
        }
    }
    public static void main (String[]args)throws Exception
    {
        Main main=new Main();
        main.initial();
        main.cal_matrix();
        main.printResult();
    }
}
