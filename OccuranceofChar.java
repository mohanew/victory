package JavaPractice;

public class OccuranceofChar {
	public static void main(String[] args) {
		//1st Approach 
		String Input="You have no choice other than following me!";
	
		int count=0;
		char chartocheck='o';
		char[] out=Input.toCharArray();
		for (char printString : out) {
			
			if(printString==chartocheck)
			{
				count=count+1;
				
			}
			
		}
		
		System.out.println("Number of occurance of o in the string is:"+count);
		
		//2nd Approach
		
		String Input1="You have no choice other than following me!";
		int length = Input.length();
		int count1=0;
		char checkchar='o';
		for(int i=0;i<=length-1;i++)
		{
			char out1=Input.charAt(i);
			if(out1==checkchar)
			{
				count1=count1+1;
			}
			
		}
		
		System.out.println("The number of occurance is:"+count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
