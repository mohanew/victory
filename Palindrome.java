package JavaPractice;

public class Palindrome {
	public static void main(String[] args) {
	
		//1st Approach
		
		String input1="malayalam";
		String input2="testleaf";
		
		String RevStr="";
		
		//Find the length of the String
		
		int lenpalidrome=input1.length();
		
		for(int i=lenpalidrome-1;i>=0;i--)
		{
			RevStr=RevStr+input1.charAt(i);
			
			
		}
		if(RevStr.equals(input1))
		{
			System.out.println("Given string malayalam is a palindrome");
		}
		else
		{
			System.out.println("Given string malayalam is not a palindrome");
		}
		
		//2nd Approach
		
		String inputM1="malayalam";
		String inputM2="TestLeaf";
		//String clean = input2.replaceAll("\\s+", "").toLowerCase();
		StringBuilder original = new StringBuilder(inputM1);
		String OriginalText=original.toString();
		System.out.println("Original Text:"+OriginalText);
		String reverse=original.reverse().toString();
		
		if(OriginalText.equals(reverse))
		{
			System.out.println("Given String is Palindrome");
		}
		else
		{
			System.out.println("Given String is not a Palindrome");
		}
		
		
		//3 rd Approach
		
		String text="malayalam";
		String text1="TestLeaf";
		char[] testChar=text.toCharArray();
		
		int len=testChar.length;
		String revStr="";
		
		for(int i=0;i<=len-1;i++)
		{
			revStr=revStr+testChar[i];
		}
		if(text.equalsIgnoreCase(revStr))
		{
			System.out.println("The Given String is palindrome");
		}
		else
		{
			System.out.println("The Given String is not a Palindrome");
		}




		//Updated by mohan for github update purpose.

		
   }

}
