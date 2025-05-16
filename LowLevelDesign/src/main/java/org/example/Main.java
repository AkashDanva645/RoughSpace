package org.example;
import java.util.*;

class Solution {

    private boolean allFound(int[] arr, int[] exp) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != exp[i]) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getAnswers(int[] wordAtIndex, int start, int l, int numWords, int[] expCount) {
        int i = start, j = start;
        int[] presentWords = new int[expCount.length];
        List<Integer> ans = new ArrayList<>();

        int count = 0;
        while (j < wordAtIndex.length) {
            if (wordAtIndex[j] != -1) {
                presentWords[wordAtIndex[j]] += 1;
                count += 1;
                if (count == numWords) {
                    if (allFound(presentWords, expCount)) {
                        ans.add(i);
                    }
                    presentWords[wordAtIndex[i]] -= 1;
                    count -= 1;
                    i += l;
                }
                j += l;
            } else {
                i = j + l;
                j = i;
                Arrays.fill(presentWords, 0);
                count = 0;
            }
        }

        return ans;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int l = words[0].length();

        Map<String, Integer> wordIds = new HashMap<>();
        int numUnqWords = 0;
        for (int i = 0; i < words.length; i++) {
            if (wordIds.get(words[i]) == null) {
                wordIds.put(words[i], numUnqWords++);
            }
        }

        int[] wordAtIndex = new int[s.length()];
        Arrays.fill(wordAtIndex, -1);

        for (int i = 0; i < s.length() - l; i++) {
            String w = s.substring(i, i + l);
            if (wordIds.get(w) != null) {
                wordAtIndex[i] = wordIds.get(w);
            }
        }

        for (int i = 0; i < wordAtIndex.length; i++) {
            System.out.print(wordAtIndex[i] + " ");
        }

        int[] expCount = new int[numUnqWords];
        for (int i = 0; i < words.length; i++) {
            int currWordId = wordIds.get(words[i]);
            expCount[currWordId] += 1;
        }

        int numWords = words.length;

        Set<Integer> st = new HashSet<>();

        for (int i = 0; i < l; i++) {
            st.addAll(getAnswers(wordAtIndex, i, l, numWords, expCount));
        }

        return new ArrayList<>(st);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String x = "wordgoodgoodgoodbestword";
        String[] words = new String[] {"word","good","best","good"};
        System.out.println(s.findSubstring(x, words));
    }
}






