package milestoneEx;

public class WordCount {
	
	public static int wordcount(String str,String word) {
		String a[] = str.split(" ");
		int count = 0;
		for (int i=0; i < a.length; i++) {
			if (word.equals(a[i]))
				count++;
		}
		return count;
		}
	public static void main(String[] args) {
		String str ="java is simple , java is object oriented.";
		String word = "java";
		System.out.println("The word java is repeated in given sentence"  );
		System.out.println(+wordcount(str, word)+  "  times ");
	}


}
