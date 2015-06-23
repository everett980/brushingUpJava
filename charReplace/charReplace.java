public class charReplace {
	public static void main(String args[]) {
		if (args.length!=3) {
			System.out.println("Please provide 3 arguments, original string, character to be replaced, and new character");
			return;
		}
		String doReplace = args[0];
		char replaceMe = args[1].charAt(0);
		char replacement = args[2].charAt(0);
		System.out.println("Your new string is: "+actualReplacement(doReplace, replaceMe, replacement));
	}
	public static String actualReplacement(String input, char a, char b) {
		return input.replace(a,b);
	}
}
