package javaprograms;

public class Exceptionhandling {
	
		public static void main(String[] args) {
			try
			{
				int x=10,y=2;
				int z=x/y;
				System.out.println("The value of z is:"+z);
				int a[]={1,2,3,4};
				a[10]=20;
				System.out.println("***** End of the try block *****");
			}
			/*catch(Exception e)
			{
				System.out.println(e);
				System.out.println("***** End of the catch block *****");
			}*/
			catch(ArithmeticException ae)
			{
				System.out.println(ae);
				System.out.println("***** End of the catch block1 *****");
			}
			catch(ArrayIndexOutOfBoundsException a)
			{
				System.out.println(a);
				System.out.println("***** End of the catch block2 *****");
			}
			System.out.println("***** End of the Program *****");
		}

	}