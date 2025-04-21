package org.example;

import java.util.Stack;

class Solution {

    private void popWord(Stack<String> stac) {
        if (stac.peek().equals(String.valueOf('/'))) {
            stac.pop();
        }
        if (!stac.isEmpty()) stac.pop();
    }

    public String simplifyPath(String path) {
        Stack<String> stac = new Stack<>();
        int n = path.length();
        int i = 0;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            while (i < n && '/' != path.charAt(i)) {
                sb.append(path.charAt(i));
                i++;
            }
            if (sb.length() > 0) {
                stac.add(sb.toString());
            }
            i++;
        }

        Stack<String> ansStac = new Stack<>();

        while (!stac.isEmpty()) {
            int pop = 0;

            while (!stac.isEmpty() && stac.peek().equals("..")) {
                stac.pop();
                pop++;
            }

            while (!stac.isEmpty() && pop > 0) {
                if (!stac.peek().equals(".")) {
                    pop--;
                }
                stac.pop();
            }

            if (!stac.isEmpty()) {
                if (!stac.peek().equals(".")) {
                    ansStac.push(stac.peek());
                }
                stac.pop();
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!ansStac.isEmpty()) {
            ans.append("/");
            ans.append(ansStac.pop());
        }

        return ans.toString().length() == 0 ? "/" : ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.simplifyPath("/a/../../b/../c//.//"));
    }
}