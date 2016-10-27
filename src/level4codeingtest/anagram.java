package level4codeingtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class anagram {
	// Change me to test \/
	String input = "iceman";
	WordLetterCount then = new WordLetterCount();
	ArrayList<String> dict = new ArrayList<>();
	ArrayList<Character> word = new ArrayList<>();

	public static void main(String[] args) {
		anagram a = new anagram();
		try {
			a.run();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() throws FileNotFoundException {
		then.addWord(input.toLowerCase());
		word = createList(input);
		dict = readFile(new File("/Users/league/Desktop/words.txt"));
		ArrayList<String> j = check();
		System.out.println("The Word Is:" + input);
		System.out.println("Anagrams");
		j.forEach(i -> {
			System.out.println(i);
		});
	}

	private ArrayList<String> check() {
		ArrayList<String> ret = new ArrayList<String>();
		
		for (String s : dict) {
			System.out.println("----"+s+"----");
			WordLetterCount now = new WordLetterCount();
			now.addWord(s.toLowerCase());
			if (now.compare(then)) {
				ret.add(s);
				System.out.println("added");
			}else {
				System.out.println("rejected");
			}
		}

		return ret;
	}

	public ArrayList<Character> createList(String word) {
		char[] temp = word.toCharArray();
		ArrayList<Character> ret = new ArrayList<Character>();
		for (char c : temp) {
			ret.add(c);
		}
		return ret;

	}

	public ArrayList<String> readFile(File f) throws FileNotFoundException {
		ArrayList<String> temp = new ArrayList<>();

		BufferedReader file = new BufferedReader(new FileReader(f));
		try {
			while (file.ready()) {
				temp.add(file.readLine());
			}
		} catch (IOException e) {
			return temp;
		}
		return temp;

	}
}
