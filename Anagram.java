/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		String strA = preProcess(str1);
		String strB = preProcess(str2);
		char curr = ' ';
		Boolean isSame = false;
		if (strA.length() != strB.length()) {
			return isSame;
		}
		for(int i = 0; i < strA.length(); i++ ){
			curr = strA.charAt(i);
			if(strB.indexOf(curr) == -1){
				return isSame;
			} 
		}
		isSame = true;
		return isSame;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String toProcess = str.toLowerCase();
		String toCorrect = "";
		char toCheck = ' ';
			for(int i = 0; i < toProcess.length(); i++){
				toCheck = toProcess.charAt(i);
				if (toCheck >= 'a' && toCheck <= 'z') {
					toCorrect = toCorrect + String.valueOf(toCheck);
				}
			}

		return toCorrect;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String toChange = str;
		String check = "";
		int newI = 0, currI = 0;
		char c = ' ';
		while(!(toChange.isEmpty())){
			newI = (int)(Math.random() * toChange.length());
			c = toChange.charAt(newI);
			check = check + String.valueOf(c);
			currI = toChange.indexOf(c);
			toChange = toChange.substring(0, currI) + toChange.substring(currI + 1);
		}
		return check;
	}
}
