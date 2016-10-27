package level4codeingtest;

public class WordLetterCount {
	int[] letters = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

	public void addLetter(char cs) {
		int c = cs-97;
		if (c<25||c>0&&cs!='-') {
			letters[c] = letters[c] + 1;
		}
		

	}

	public void addWord(String word) {
		StringBuilder rod = new StringBuilder();
		word = word.toLowerCase();
		if (word.contains("-")) {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!(c == '-')) {
					rod.append(c);
				}
			}
			word = rod.toString();
		}
		
		for (char i : word.toCharArray()) {
			addLetter(i);
		}
	}
	public boolean compare(WordLetterCount i){
		for (int j = 0; j < letters.length; j++) {
			int x = letters[j];
			int y = i.getLetters()[j];
			if(x!=y){
				return false;
			}
		}
		return true;
	}

	public int[] getLetters() {
		return letters;
	}
}
