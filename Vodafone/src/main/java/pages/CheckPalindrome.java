package pages;

public class CheckPalindrome
{
	public static boolean Checkpalindrome(String CheckecString)
	{	
		char[] CheckecArray = new char[CheckecString.length()];
		int stringLenght = 0 ;
		int notMatch = 0 ;

		for (int i = 0; i < CheckecString.length(); i++) {
			CheckecArray[i] = CheckecString.charAt(i);
		}
		
		stringLenght = (CheckecArray.length-1);

		for (int i=0;i<(CheckecArray.length/2);i++)
		{
			if(CheckecArray[i]==CheckecArray[stringLenght-i]) {}
	
			else
			{
				notMatch++;
			}
		}
		if(notMatch==0) 
			return true ;
		else
			return false ;
	}
}
