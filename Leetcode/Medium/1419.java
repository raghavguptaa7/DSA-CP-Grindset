class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
	int[] letterCounts = new int[26]; 
	int count = 0;
	int maxCount = 0;
	
	for (char c : croakOfFrogs.toCharArray()) {
		letterCounts[c - 'a'] ++; 
		// do boundary count 
		if (c == 'c') { // left boundary
			count++;
			maxCount = Math.max(maxCount, count);
		} else {
			if (!isValid(c, letterCounts)) return -1; 
			if (c == 'k') { // right boundary 
				count--;
			}
		}
	}
	// check if the string is finished
	return count == 0 ? maxCount : -1;
}

// check string validity
private boolean isValid(char c, int[] counts) {
	char prevChar;
	if (c == 'r') prevChar = 'c';
	else if (c == 'o') prevChar = 'r';
	else if (c == 'a') prevChar = 'o';
	else prevChar = 'a'; 

	return counts[prevChar - 'a'] >= counts[c - 'a']; 
}
}