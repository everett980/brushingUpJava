public class reverse{ 	
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("You need to provide at least one String to be reversed.");
			return;
		}
		String reverseMe = "";
		for(int i = 0; i<args.length; i++) reverseMe+=args[i]+" ";
		reverseMe=reverseMe.substring(0,reverseMe.length()-1);
		System.out.println(reversing(reverseMe));
	}
	public static String reversing(String old) {
		String result = new String();
		for(int i = old.length() - 1; i>=0; i--)
			result+=old.charAt(i);
		return result;
	}
}
