public class palindrome
{ 
private static boolean isPalindrome(String str) 
{ 
int length = str.length(); 
for (int i = 0; i < length / 2; i++) 
{ 
if (str.charAt(i) != str.charAt(length - i - 1)) 
{ 
return false; 
} 
} 
return true; 
} 
public static void main(String[] args) 
{ 
if (args.length == 0) 
{ 
System.out.println("Please provide a string as a command line argument."); 
return; 
} 
String str = args[0]; 
if (isPalindrome(str)) 
{ 
System.out.println(str + " is a palindrome."); 
} 
else
{ 
System.out.println(str + " is not a palindrome."); 
}
}
}

