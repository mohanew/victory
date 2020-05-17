package JavaPractice;

public class Reversealternateword {
	public static void main(String[] args) {
		
		String inputword="when the world realize its own mistake, corona will dissolve automatically";
		String[] splitStr=inputword.split(" ",12);
		int len=splitStr.length;
		String print = null,builder1 = null;
		StringBuilder builder = null;
		for(int i=0;i<=len-1;i++)
		{
			if(i%2==0)
			{
				 print=splitStr[i];
				System.out.println("Even word is:"+print);
			}
			else
			{
				 builder=new StringBuilder();
				
				builder.append(splitStr[i]);
				
				 builder1=builder.reverse().toString();
				 
				System.out.println("Odd Word is"+builder);
				
			}
						
		
		}
		
		
	}

}
