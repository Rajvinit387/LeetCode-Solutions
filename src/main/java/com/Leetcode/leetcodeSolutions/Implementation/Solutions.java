package com.Leetcode.leetcodeSolutions.Implementation;


import com.Leetcode.leetcodeSolutions.Comparator.ListComparator;
import com.Leetcode.leetcodeSolutions.Model.*;
import org.springframework.stereotype.Component;

import java.lang.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Component
public class Solutions {
    static String s;
    static String t;
    private static List<String> ans1 = new ArrayList<>();
    static String maxString;


    static HashMap<String, Integer> memo = new HashMap<>();

    static Set chessSet = new LinkedHashSet();
    static List<List<String>> solutions = new ArrayList<>();


    static int position = 0;

    static Map<String, List<TreeNode>> treeMap = new HashMap<>();


    static Map<List<Integer>, Integer> integerPermuteMap = new HashMap<>();


    static Map<List<Integer>, Integer> subsetMap = new HashMap<>();

    static Map<List<Integer>, Integer> combinationSumMap = new HashMap<>();

    static Map<List<Integer>, Integer> combineMap = new HashMap<>();
    static Map<String, Integer> testMap = new HashMap<>();


    static Set<Character> permuteMap = new HashSet<>();
    static int countword = 0;//for word search

    static int k = 0;//for word search
    static int flag = 0, call = 0;//for word search and for bst tree as well and for operators expressions

    static List<String> answers = new ArrayList<>();

    static List<List<String>> expressions = new ArrayList<>();


    static Node head = null;


    static Node tail = null;

    static Node head1 = null;


    static int fill = 1;//for spiral matrix 2

    static List<Integer> spiralMatrix = new ArrayList<>();//for spiral matrix


    static List<List<Integer>> temp = new ArrayList<>();//for combination sum
    static List<Integer> set = new ArrayList<>(); //for combination sum

    static int count = 0;


    static TreeNode prev;
    static TreeNode first;

    static TreeNode middle;

    static TreeNode last;


    static int max;


    public static int removeduplicates(int[] a) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);

            } else map.put(a[i], map.get(a[i]) + 1);
        }
        List<Integer> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int j = 0;
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Integer key = entry.getKey();
            a[j] = key;
            j++;
        }

        return map.size();
    }

    public static String LCP(String[] strs) {
        int j = 0;
        String st = "";
        int flag = 0;
        while (flag != 1) {
            flag = 0;
            for (int i = 0; i < strs.length; i++) {

                if (j == strs[0].length() || j == strs[i].length() || (strs[0].charAt(j) != strs[i].charAt(j))) {
                    flag = 1;
                    i = strs.length;
                }
            }
            if (flag == 0) {
                st = st.concat(String.valueOf(strs[0].charAt(j)));
            }

            j++;
        }
        return st;
    }

    public static int singleNumber(int[] nums) {
        int x = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))

                map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                x = entry.getKey();
                break;
            }

        }
        return x;
    }


    public static int myMaxArea(int[] h) {
        int i = 0;
        int j = h.length - 1;
        int area = 0;
        int temparea = 0;
        while (i < j) {

            if (h[i] <= h[j]) {
                temparea = h[i] * (j - i);
                if (temparea > area) area = temparea;
                i++;
            } else {
                temparea = h[j] * (j - i);
                if (temparea > area) area = temparea;
                j--;
            }


        }
        return area;
    }

    public static boolean IsValidSoduku(char[][] a) {
        Map<String, Integer> map = new HashMap<>();
        String rowcheck = "";
        String coloumncheck = "";
        String boxcheck = "";
        int boxIndex = 0;
        int flag = 0;
        int div = a.length / 3;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rowcheck = String.valueOf(a[i][j]) + "value at" + i + "row";
                coloumncheck = String.valueOf(a[i][j]) + "value at" + j + "coloumn";
                boxIndex = (i / div) * div + (j / div);
                boxcheck = String.valueOf(a[i][j]) + "value at" + boxIndex + "box";
                if (!map.containsKey(rowcheck) && !map.containsKey(coloumncheck) && !map.containsKey(boxcheck) && a[i][j] != '.') {
                    map.put(rowcheck, 1);
                    map.put(coloumncheck, 1);
                    map.put(boxcheck, 1);
                } else if (a[i][j] != '.') {
                    flag = 1;
                    break;
                }

            }
        }
        if (flag == 0) return true;
        else return false;


    }


    public static List<List<Integer>> powerSet(int[] set) {
        List<Integer> blankArrayList = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(blankArrayList);
        for (int i = 0; i < set.length; i++) {
            List<List<Integer>> newArrayLists = new ArrayList<>();
            for (List<Integer> m : lists) {
                List<Integer> x = new ArrayList<>();
                for (Integer c : m)
                    x.add(c);
                x.add(set[i]);
                newArrayLists.add(x);

            }
            for (List<Integer> addedList : newArrayLists) {
                lists.add(addedList);
            }
        }

        return lists;
    }


    public static int LongestConsecutiveSequence(int a[]) {
        Set<Integer> set = new HashSet<>();

        int x = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (!set.contains(a[i] - 1)) {
                List<Integer> list = new ArrayList<>();
                list.add(a[i]);
                x = a[i];
                while (set.contains(x + 1)) {
                    list.add(x + 1);
                    x++;

                }
                if (max < list.size()) {
                    max = list.size();
                }
            }
        }


        return max;
    }


    public static int factorial(int n) {
        if (n == 1 || n == 0) return 1;
        else return n * factorial(n - 1);
    }


    public static boolean sudokuSolver(int[][] a) {


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                if (a[i][j] == 0) {

                    for (int num = 1; num <= 9; num++) {
                        if (validValueAdded(num, i, j, a)) {
                            a[i][j] = num;
                            boolean t = sudokuSolver(a);
                            if (t) return true;
                            else a[i][j] = 0;
                        }


                    }
                    return false;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        return true;
    }

    private static boolean validValueAdded(int num, int i, int j, int[][] a) {
        int div = a.length / 3;
        int boxIndex = (i / div) * div + (j / div);


        for (int k = 0; k < a.length; k++) {
            if (a[i][k] == num) return false;

        }
        for (int k = 0; k < a.length; k++) {
            if (a[k][j] == num) return false;

        }

        for (int k = 0; k < a.length; k++) {
            // if(a[div*(i/div)+i/3][div*(j/div)+j%div]==num)

            if (a[(k / div) + (boxIndex / div) * div][(k % div) + (boxIndex % div) * div] == num)


                return false;
        }
        return true;


    }


    public static int jumpgame2(int[] a) {
        int jump = 0;
        int current = 0;
        int farthest = 0;
        for (int i = 0; i < a.length - 1; i++) {
            farthest = Math.max(farthest, i + a[i]);
            if (i == 0 || i == current) {
                current = farthest;
                jump++;
            }


        }
        return jump;
    }


    public static int[][] insertintervals(int[][] intervals, int[] newInterval) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            lists.add(Arrays.stream(intervals[i]).boxed().toList());
        }
        lists.add(Arrays.stream(newInterval).boxed().toList());
        // System.out.println(lists);
        Collections.sort(lists, new ListComparator());
        System.out.println(lists);
        // System.out.println(lists);
        int j = 0;
        int k = lists.size();
        for (int i = 0; i < k; i++) {
            if ((i != 0) && (lists.get(i).get(0) <= lists.get(i - 1).get(1))) {
                List<Integer> listtobeAdded = new ArrayList<>();
                listtobeAdded.add(lists.get(i - 1).get(0));
                listtobeAdded.add(Math.max((lists.get(i).get(1)), lists.get(i - 1).get(1)));
                j = i;
                while (j <= k - 1) {
                    lists.set(j - 1, lists.get(j));
                    j++;
                }
                lists.remove(k - 1);
                lists.set(i - 1, listtobeAdded);

                k--;
                i = i - 2;
            }


        }
        int[][] ints = lists.stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
        return ints;

    }


    public static int largestRectangleInHistogram(int[] a) {

        int left[] = new int[a.length];
        int right[] = new int[a.length];
        int area[] = new int[a.length];
        Stack leftstack = new Stack<>();
        Stack rightstack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                leftstack.push(0);
                left[i] = 0;
            }
            while (a[(int) leftstack.peek()] >= a[i]) //2>1
            {
                leftstack.pop();
                if (leftstack.isEmpty()) break;
            }
            if (leftstack.isEmpty()) {
                left[i] = 0;
                leftstack.push(i); //1

            }
            if (a[(int) leftstack.peek()] < a[i]) {
                left[i] = (int) leftstack.peek() + 1;
                leftstack.push(i);
            }
        }
        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1) {
                rightstack.push(a.length - 1);
                right[i] = a.length - 1;
            }
            while (a[(int) rightstack.peek()] >= a[i]) {
                rightstack.pop();
                if (rightstack.isEmpty()) break;
            }
            if (rightstack.isEmpty()) {
                right[i] = a.length - 1;
                rightstack.push(i);

            }
            if (a[(int) rightstack.peek()] < a[i]) {
                right[i] = (int) rightstack.peek() - 1;
                rightstack.push(i);
            }


        }


        int maxarea = 0;
        for (int i = 0; i < a.length; i++) {
            maxarea = Math.max(maxarea, a[i] * (right[i] - left[i] + 1));
        }

        return maxarea;
    }


    public static int maximalRectangle(int[][] matrix) {

        int a[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a[0].length; j++)
                a[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));


        }
        int l = 0, sum;
        int max = 0;
        int b[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                b[i][j] = a[i][j];
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {

                l = i - 1;
                if (a[i][j] != 0) {
                    sum = 0;
                    for (int k = l; k >= 0; k--) {
                        if (a[k][j] == 0) break;
                        sum = sum + a[k][j];
                    }
                    b[i][j] = b[i][j] + sum;
                }
            }

            max = Math.max(max, largestRectangleInHistogram(b[i]));
        }

        return max;
    }


    public static double findMedianSortedArraysWithoutBinarySearch(int[] a, int[] b) {
        double median;
        int c[] = new int[a.length + b.length];
        int i = 0, j;
        while (i < a.length) {
            c[i] = a[i];
            i++;
        }
        j = 0;
        while (j < b.length) {
            c[i] = b[j];
            j++;
            i++;
        }

        Arrays.sort(c);
        if (c.length % 2 == 0) {
            return (c[(int) c.length / 2] + c[(int) c.length / 2 - 1]) / 2.0;
        } else return c[(int) c.length / 2];


    }


    public static double findMedianByBinarySearch(int[] a, int b[]) {


        if (a.length > b.length) return findMedianByBinarySearch(b, a);

        if (a.length == 0) {
            if (b.length % 2 == 0) return (b[b.length / 2] + b[(b.length / 2) - 1]) / 2;
            else

                return b[b.length / 2];
        }


        int i = 0, j, mid, half;
        int longest_int = Integer.MAX_VALUE;
        int smallest_int = Integer.MIN_VALUE;

        j = a.length - 1;

        half = (a.length + b.length) / 2;

        mid = (i + j) / 2;

        int a1, a2, b1, b2;
        a1 = a[mid];
        if (mid + 1 <= a.length - 1) {
            a2 = a[mid + 1];

        } else {
            a2 = longest_int;


        }
        if (half - mid - 2 >= 0) {

            b1 = b[half - mid - 2];
        } else {
            b1 = smallest_int;
        }
        if (half - mid - 1 <= b.length - 1)


            b2 = b[half - mid - 1];
        else b2 = longest_int;

        while (a1 > b2 || a2 < b1) {

            if (a1 > b2) {
                j = mid - 1;
            }
            if (a2 < b1) {
                i = mid + 1;
            }
            mid = Math.floorDiv(i + j, 2);
            if (mid >= 0) a1 = a[mid];
            else a1 = smallest_int;
            if (half - mid - 1 <= b.length - 1) b2 = b[half - mid - 1];
            else b2 = longest_int;
            if (mid + 1 <= a.length - 1) {

                a2 = a[mid + 1];
            } else {
                a2 = longest_int;
            }
            if (half - mid - 2 >= 0) {

                b1 = b[half - mid - 2];
            } else {
                b1 = smallest_int;
            }


        }
        if ((a.length + b.length) % 2 == 0) {
            return (Math.max(a1, b1) + Math.min(a2, b2)) / 2.0;
        } else return Math.min(a2, b2);
    }


    public static int findFirstPositiveNumber(int[] a) {

        int x = 0;
        int flag = 0;
        int temp;
        int missingnumber = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != a[i] - 1 && a[i] > 0 && a[i] <= a.length && a[i] != a[a[i] - 1]) {
                temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
                i--;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (i != a[i] - 1) {
                missingnumber = i + 1;
                flag = 1;
                break;
            }
        }

        if (flag == 1) return missingnumber;
        else return a[a.length - 1] + 1;

    }


    public static int trapRainWater(int a[], int width) {
        int sum = 0;
        int t = 0;
        int w = width;
        int leftmaxarray[] = new int[a.length];
        int rightmaxarray[] = new int[a.length];
        int leftmax = 0, rightmax = 0;
        for (int i = 0; i < leftmaxarray.length; i++) {
            leftmaxarray[i] = leftmax;
            leftmax = Math.max(a[i], leftmax);
        }
        for (int i = rightmaxarray.length - 1; i >= 0; i--) {
            rightmaxarray[i] = rightmax;
            rightmax = Math.max(a[i], rightmax);
        }

        for (int i = 1; i < a.length - 1; i++) {
            t = Math.min(leftmaxarray[i], rightmaxarray[i]);
            if (t > a[i]) sum = sum + (Math.min(leftmaxarray[i], rightmaxarray[i]) - a[i]) * w;
        }

        return sum;


    }


    public static List<List<String>> solveNQueens(int n) {


        char chessBoard[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                chessBoard[i][j] = '_';
        }

        NQueenSolve(n, chessBoard, 0);
        return solutions;


    }


    public static void NQueenSolve(int n, char a[][], int i) {
//


        if (i >= n) {

            List str = new ArrayList<>();
            for (int x = 0; x < n; x++) {


                String t = new String(a[x]);
                str.add(t);


            }
            solutions.add(str);

            return;
        }

        for (int j = 0; j < n; j++) {

            if (QueenIsSafe(i, j, a)) {
                a[i][j] = 'Q';

                NQueenSolve(n, a, i + 1);


                a[i][j] = '_';
                chessSet.remove("Queen is at Row: " + i);
                chessSet.remove("Queen is at Coloumn: " + j);
                chessSet.remove("Queen is at Positive Diagonal: " + (-j - i - 1 + a.length));
                chessSet.remove("Queen is at Negative Diagonal: " + (j - i));
            }
        }
    }


    private static boolean QueenIsSafe(int i, int j, char[][] a) {

        String rowcheck = "Queen is at Row: " + i;
        String coloumnCheck = "Queen is at Coloumn: " + j;
        String posDiagonalCheck = "Queen is at Positive Diagonal: " + (-j - i - 1 + a.length);
        String negativeDiagonalCheck = "Queen is at Negative Diagonal: " + (j - i);
        if (!chessSet.contains(rowcheck) && !chessSet.contains(coloumnCheck) && !chessSet.contains(posDiagonalCheck) && !chessSet.contains(negativeDiagonalCheck)) {
            chessSet.add(rowcheck);
            chessSet.add(coloumnCheck);
            chessSet.add(posDiagonalCheck);
            chessSet.add(negativeDiagonalCheck);
            return true;
        }
        return false;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap<>();
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char characterArray[] = new char[strs[i].length()];
            for (int j = 0; j < strs[i].length(); j++) {
                characterArray[j] = strs[i].charAt(j);
            }
            Arrays.sort(characterArray);
            String sortedString = new String(characterArray);
            if (!hashmap.containsKey(sortedString)) {
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                hashmap.put(sortedString, stringList);
            } else {
                hashmap.get(sortedString).add(strs[i]);

            }

        }
        Iterator<Map.Entry<String, List<String>>> iterator = hashmap.entrySet().iterator();
        int j = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            lists.add(entry.getValue());
        }
        return lists;
    }

    public static int longestValidParentheses(String str) {
        Stack stack = new Stack<>();
        int maximum = 0;
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else maximum = Math.max(maximum, i - (int) stack.peek());

            }
        }

        return maximum;

    }


    public static List<Integer> findSubString(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        String combinedString = "";
        for (int i = 0; i < words.length; i++)
            combinedString = combinedString.concat(words[i]);
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) map.put(words[i], 1);
            else map.put(words[i], map.get(words[i]) + 1);
        }
        for (int i = 0; i <= s.length() - combinedString.length(); i++) {

            for (j = i; j <= combinedString.length() - 1 + i; j = j + words[0].length()) {
                String string = s.substring(j, j + words[0].length());
                if (!map1.containsKey(string)) map1.put(string, 1);
                else map1.put(string, map1.get(string) + 1);
            }

            if (map1.equals(map)) list.add(i);
            map1.clear();

        }
        return list;
    }

    public static boolean regularExpressionMatch(int i, int j, String s, String p) {
        if (i >= s.length() && j >= p.length()) {

            return true;
        } else if (j >= p.length()) return false;
        boolean charmatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ismatch;

        if (j < p.length() - 1 && p.charAt(j + 1) == '*')
            ismatch = (charmatch && regularExpressionMatch(i + 1, j, s, p)) || regularExpressionMatch(i, j + 2, s, p);
        else ismatch = charmatch && regularExpressionMatch(i + 1, j + 1, s, p);
        return ismatch;


    }


    public static String getPermutation(int n, int k) {
        int index;
        int length = n;
        String answer = "";
        int x = 0;
        int[] digit = new int[n];
        for (int i = 0; i < n; i++)
            digit[i] = i + 1;
        int j = 1;
        while (j <= length) {
            index = k / (factorial(n - 1));
            if (k % (factorial(n - 1)) == 0) index = index - 1;
            answer = answer.concat(String.valueOf(digit[index]));
            while (digit[x] != digit[index]) x++;
            for (int y = x + 1; y < digit.length; y++) {
                digit[y - 1] = digit[y];
            }

            k = k - factorial(n - 1) * index;
            x = 0;
            n--;
            j++;


        }
        return answer;

    }


    public static String minimumWindowSubstring(String s, String t) {
        String string = "";
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> have = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!need.containsKey(t.charAt(i))) need.put(t.charAt(i), 1);
            else need.put(t.charAt(i), need.get(t.charAt(i)) + 1);

        }
        Iterator<Map.Entry<Character, Integer>> iterator = need.entrySet().iterator();
        int count = 0;

        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            have.put(entry.getKey(), 0);
            count = need.get(entry.getKey()) + count;

        }
        int required = count;
        int already = 0;
        //System.out.println(have);
        int x = 0;
        int y = 0;
        int j = 0;
        int minimum = Integer.MAX_VALUE;
        String minimumWindow = "";
        while (x != s.length()) {
            if (need.containsKey(s.charAt(x))) {
                have.put(s.charAt(x), have.get(s.charAt(x)) + 1);
                if (have.get(s.charAt(x)) <= need.get(s.charAt(x))) already++;

                while (y != s.length() && already == required) {
                    if (need.containsKey(s.charAt(y))) {
                        have.put(s.charAt(y), have.get(s.charAt(y)) - 1);
                        if (need.get(s.charAt(y)) == have.get(s.charAt(y)) + 1) already--;
                    }
                    y++;
                }

                if ((y != 0) && (minimum > s.substring(y - 1, x + 1).length()) && (already == required - 1)) {
                    minimum = s.substring(y - 1, x + 1).length();
                    minimumWindow = s.substring(y - 1, x + 1);
                }
                if (s.length() == 1 && y == x && ((already == required))) return s;


            }


            x++;
        }


        return minimumWindow;

    }


    public static List<Integer> getSpiralMatrix(int[][] a) {
        List<Integer> spiralMatrix1 = new ArrayList<>();


        spiralMatrix(a, 0, a.length - 1, 0, a[0].length - 1);
        spiralMatrix1.addAll(spiralMatrix);
        spiralMatrix.clear();
        return spiralMatrix1;

    }


    public static void spiralMatrix(int[][] a, int rowupper, int rowlower, int leftcoloum, int rightcoloumn) {
        int left = leftcoloum;
        int right = rightcoloumn;
        int up = rowupper;
        int down = rowlower;


        for (int i = left; i <= right; i++) {
            spiralMatrix.add(a[up][i]);
        }
        if (spiralMatrix.size() == a.length * a[0].length) {

            return;
        }

        for (int i = up + 1; i <= down; i++) {
            spiralMatrix.add(a[i][right]);
        }
        if (spiralMatrix.size() == a.length * a[0].length) {

            return;
        }


        for (int i = right - 1; i >= left; i--)
            spiralMatrix.add(a[down][i]);
        if (spiralMatrix.size() == a.length * a[0].length) {

            return;
        }

        for (int i = down - 1; i > up; i--)
            spiralMatrix.add(a[i][left]);
        if (spiralMatrix.size() == a.length * a[0].length) {

            return;
        }


        rowupper++;
        rowlower--;
        leftcoloum++;
        rightcoloumn--;
        spiralMatrix(a, rowupper, rowlower, leftcoloum, rightcoloumn);


    }

    public static int maxSubArray(int[] a) {
        int max = a[0];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {

            sum = sum + a[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;

        }


        return max;
    }


    public static void setZeroMatrix(int[][] a) {

        int x = 1, y = 1;
        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 0) {
                y = 0;
                break;
            }

        }


        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] == 0) {
                x = 0;
                break;
            }


        }


        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] == 0) {
                    a[0][j] = 0;
                    a[i][0] = 0;
                }

            }
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i][0] == 0) {
                for (int j = 0; j < a[0].length; j++)
                    a[i][j] = 0;
            }

        }

        for (int i = 1; i < a[0].length; i++) {


            if (a[0][i] == 0) {
                for (int j = 0; j < a.length; j++)
                    a[j][i] = 0;


            }

        }
        if (x == 0) {


            for (int j = 0; j < a[0].length; j++)
                a[0][j] = 0;


        }


        if (y == 0) {


            for (int j = 0; j < a.length; j++)
                a[j][0] = 0;


        }


        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();


        }
    }

    public static void nStarTriangle(int n) {
        // Write your code here

        int space = n - 1;

        int star = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= space; j++)
                System.out.print(" ");
            for (int k = 1; k <= star; k++)
                System.out.print("*");
            space--;
            star = star + 2;
            System.out.println();


        }


    }


    public static int[][] getSpiralMatrix2(int n) {

        int[][] spiralMatrix2 = new int[n][n];
        SpiralMatrix2(spiralMatrix2, 0, n - 1, 0, n - 1, n);
        return spiralMatrix2;


    }

    public static void SpiralMatrix2(int a[][], int left, int right, int up, int down, int n) {

        for (int i = left; i <= right; i++) {
            a[up][i] = fill;
            fill++;
        }

        if (fill == n * n + 1) return;
        for (int i = up + 1; i <= down; i++) {
            a[i][right] = fill;
            fill++;
        }

        if (fill == n * n + 1) return;


        for (int i = right - 1; i >= left; i--) {

            a[down][i] = fill;
            fill++;


        }
        if (fill == n * n + 1) return;

        for (int i = down - 1; i >= up + 1; i--) {
            a[i][left] = fill;
            fill++;
        }
        if (fill == n * n + 1) return;
        left++;
        right--;
        up++;
        down--;
        SpiralMatrix2(a, left, right, up, down, n);
    }

    //Starting of Linked List

    public static void addLinkedList(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        } else {
            node.next = head;
            head = node;
        }
    }


    public static void printLinkedList() {
        if (head != null) {
            Node currentnode = head;
            String str = "";
            while (currentnode != null) {
                str = str + currentnode.data + "->";
                currentnode = currentnode.next;
            }
            System.out.println(str.substring(0, str.length() - 2));
            System.out.println("--------");
        } else System.out.println("Linked list is empty");
    }

    public static void addLinkedList2(int data) {
        Node node = new Node(data);
        if (head1 == null) {
            head1 = node;
            return;
        } else {
            node.next = head1;
            head1 = node;
        }
    }

    public static void printLinkedList2() {
        if (head1 != null) {
            String str = "";
            Node currentnode = head1;
            while (currentnode != null) {
                str = str + currentnode.data + "->";
                currentnode = currentnode.next;
            }
            System.out.println(str.substring(0, str.length() - 2));
            System.out.println("--------");
        } else System.out.println("Linked list is empty");
    }


    public static void printaddList() {
        Node sum = addTwoNumbers(head, head1);
        Node head3 = sum;
        while (head3 != null) {
            System.out.print(head3.data + "-->");
            head3 = head3.next;
        }
    }


    public static Node addTwoNumbers(Node l1, Node l2) {

        Node l3 = new Node(0);
        Node current = l3;
        int carry = 0;
        int sum = 0;
        while (l1 != null || l2 != null) {

            sum = carry;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            current.next = new Node(sum);
            current = current.next;

        }
        if (carry == 1) current.next = new Node(1);

        return l3.next;

    }

    public static void removefromLast() {

        removeNthFromEnd(2);


    }

    public static void removeNthFromEnd(int n) {


        Node current = head;
        int i = 1;
        Node previous = new Node(0);
        int count = 0;

        if (n == 0) return;

        while (current != null) {

            count++;
            current = current.next;
        }
        current = head;


        while (i != count - n + 1) {
            previous = current;
            current = current.next;
            i++;
        }

        if (n == count) {

            head = head.next;
            return;

        }


        previous.next = current.next;
        current.next = null;
        return;
    }

    public static void rotateList(int k) {
        Node current = head;
        Node previous = head;
        int length = 0;
        if (head == null) {
            printLinkedList();
            return;
        }

        while (current != null) {
            length++;
            current = current.next;
        }

        int newk = k % length;

        if (length == 1 || newk == 0) {
            printLinkedList();
            return;
        }
        current = head;
        for (int i = 1; i <= length - newk; i++) {

            previous = current;
            current = current.next;

        }

        previous.next = null;

        Node current1 = current;
        while (current1.next != null) current1 = current1.next;
        current1.next = head;
        head = current;
        printLinkedList();
    }


    public static Node swapPairs() {
        Node current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        current = head;
        if (length == 1 || length == 0) return head;
        Node currentNext = current.next;
        Node x = new Node(0);
        Node y = new Node(0);
        Node z = new Node(0);
        int count = 0;
        while (current != null && current.next != null) {
            x = current;
            y = currentNext;

            x.next = y.next;

            y.next = x;
            z.next = y;

            if (count == 0) {
                head = currentNext;
            }
            count++;
            z = current;
            current = current.next;
            if (current == null) break;

            currentNext = current.next;

        }
        return head;

    }


    public static Node evenOddList() {
        if (head == null || head.next == null || head.next.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node firsteven = head.next;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = firsteven;
        return head;
    }


    public static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;
        Node forward = null;


        while (temp != null) {
            forward = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forward;

        }
        head = prev;
        return head;

    }


    public static Node reverseKGroup(int k) {
        Node temp = head;
        Node firstNodeOfSegment = null;
        Node lastNodeOfSegment = null;
        Node firstNodeofPreviousSegment = null;
        Node lastNodeOfPreviousSegment = null;
        Node tempForHead = head;
        int count = 1;
        while (count < k) {
            tempForHead = tempForHead.next;
            count++;
        }
        head = tempForHead;

        while (temp != null) {
            firstNodeOfSegment = temp; //head

            for (int i = 0; i < k - 1; i++) {
                temp = temp.next;
                if (temp == null) break;
            }

            lastNodeOfSegment = temp; //tail
            if (temp == null) break;
            temp = temp.next;
            reverseSegmentOfLinkedList(firstNodeOfSegment, lastNodeOfSegment, k);
            if (firstNodeofPreviousSegment != null) firstNodeofPreviousSegment.next = lastNodeOfSegment;

            firstNodeOfSegment.next = temp;
            firstNodeofPreviousSegment = firstNodeOfSegment;

        }
        return head;

    }


    private static void reverseSegmentOfLinkedList(Node firstNodeOfSegment, Node lastNodeOfSegment, int k) {
        Node temp = firstNodeOfSegment;
        Node prev = null;
        Node forward = null;
        int count = 0;

        while (count < k) {
            forward = temp.next;
            temp.next = prev;
            prev = temp;
            temp = forward;
            count++;
        }
    }


    public static Node mergeKLists(Node[] lists) {

        if (lists.length == 0) return null;
        Node temp = lists[0];
        for (int i = 1; i < lists.length; i++) {
            temp = mergeTwoLists(temp, lists[i]);
        }
        return temp;

    }

    private static Node mergeTwoLists(Node temp, Node list) {
        Node t1 = temp;
        Node t2 = list;
        Node finalmergedList = new Node(-1);
        Node tempFinalMergedList = finalmergedList;
        while (t2 != null && t1 != null) {
            Node mergedList = new Node(-1);
            if (t1.data <= t2.data) {
                mergedList.data = t1.data;
                t1 = t1.next;
            } else {
                mergedList.data = t2.data;
                t2 = t2.next;
            }
            tempFinalMergedList.next = mergedList;
            tempFinalMergedList = tempFinalMergedList.next;

        }
        if (t1 != null) {
            while (t1 != null) {
                Node mergedList = new Node(-1);
                mergedList.data = t1.data;
                t1 = t1.next;
                tempFinalMergedList.next = mergedList;
                tempFinalMergedList = tempFinalMergedList.next;
            }
        }
        if (t2 != null) {
            while (t2 != null) {
                Node mergedList = new Node(-1);
                mergedList.data = t2.data;
                t2 = t2.next;
                tempFinalMergedList.next = mergedList;
                tempFinalMergedList = tempFinalMergedList.next;
            }
        }
        return finalmergedList.next;
    }

    public static void printLinkedListByPassingHead(Node list) {
        if (list != null) {
            String str = "";
            Node currentnode = list;
            while (currentnode != null) {
                str = str + currentnode.data + "->";
                currentnode = currentnode.next;
            }
            System.out.println(str.substring(0, str.length() - 2));
            System.out.println("--------");
        } else System.out.println("Linked list is empty");
    }


    public static Node sortLinkedList(Node node) {
        if (node == null || node.next == null) return node;
        Node middleNode = getMiddleNode(node);
        Node startNodeOfLeftList = node;
        Node startNodeOfRightList = middleNode.next;
        middleNode.next = null;
        Node leftSortedList = sortLinkedList(startNodeOfLeftList);
        Node rightSortedList = sortLinkedList(startNodeOfRightList);
        return mergeTwoLists(leftSortedList, rightSortedList);
    }

    private static Node getMiddleNode(Node node) {
        int count = 0;
        Node temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int x = 1;
        if (count % 2 == 0) {
            temp = node;
            while (x < count / 2) {
                x++;
                temp = temp.next;
            }
        } else {
            temp = node;
            while (x <= count / 2) {
                x++;
                temp = temp.next;
            }

        }
        return temp;

    }

    public static Node deleteFromSortedLinkedList(Node head) {
        Node temp = head;
        if (head == null) return head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                if (temp.next.next != null) temp.next = temp.next.next;
                else temp.next = null;
            } else temp = temp.next;
        }
        return head;
    }


    public static Node deleteFromSortedLinkedList2(Node head) {
        if (head == null || head.next == null) return head;
        Node dummy = new Node(-1);
        dummy.next = head;
        head = dummy;
        Node prev = head;
        Node temp = prev.next;
        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                temp = temp.next;
            } else {
                if (prev.next == temp) {
                    prev = prev.next;
                    temp = temp.next;

                } else {
                    prev.next = temp.next;
                    temp = temp.next;
                }
            }
        }
        return dummy.next;
    }


    public static Node reverseBetween(Node head, int left, int right) {
        int count = 1;
        Node temp = head;
        Node prev = temp;
        while (count < left) {
            prev = temp;
            temp = temp.next;
            count++;

        }
        Node firstnode = temp;
        count = 1;
        temp = head;
        while (count < right) {
            temp = temp.next;
            count++;
        }
        Node lastnode = temp;
        Node next = lastnode.next;
        int flag = 0;
        if (firstnode == head) flag = 1;

        reverseSegmentOfLinkedList(firstnode, lastnode, right - left + 1);
        prev.next = lastnode;
        firstnode.next = next;
        if (flag == 1) head = lastnode;
        return head;

    }

    public static boolean hasCycle(Node head) {
        Node faster = head;
        Node slower = head;
        while (slower != null && faster != null && faster.next != null) {

            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) return true;
        }
        return false;

    }

    public static Node detectCycle(Node head) {
        Node faster = head;
        Node slower = head;
        int flag = 0;
        while (slower != null && faster != null && faster.next != null) {

            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                flag = 1;
                break;
            }


        }
        if (flag == 0) return null;
        faster = head;
        while (faster != slower) {
            faster = faster.next;
            slower = slower.next;
        }
        return faster;
    }

    public static void reorderList(Node head) {
        Node slower = head;
        Node faster = head.next;
        while (faster != null && faster.next != null) {
            faster = faster.next.next;
            slower = slower.next;
        }
        Node firsthalf = head;
        Node secondhalf = slower.next;
        slower.next = null;
        secondhalf = reverseLinkedList(secondhalf);
        Node temp = firsthalf;
        Node temp1 = secondhalf;
        Node x = null;
        Node y = null;
        while (temp1 != null && temp != null) {
            x = temp1.next;
            y = temp.next;
            temp1.next = temp.next;
            temp.next = temp1;
            temp = y;
            temp1 = x;
        }


    }


    public static Node partition(Node head, int x) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        Node left = null;
        Node leftHead = null;
        Node right = null;
        Node rightHead = null;
        int leftflag = 0;
        int rightflag = 0;
        while (temp != null) {
            if (temp.data < x) {
                if (leftflag == 0) {
                    Node newNode = new Node(temp.data);
                    left = newNode;
                    left.next = null;
                    leftHead = left;
                    leftflag = 1;
                } else {
                    Node newNode = new Node(temp.data);
                    left.next = newNode;
                    left = left.next;
                }
            } else {
                if (rightflag == 0) {
                    Node newNode = new Node(temp.data);
                    right = newNode;
                    right.next = null;
                    rightHead = right;
                    rightflag = 1;
                } else {
                    Node newNode = new Node(temp.data);
                    right.next = newNode;
                    right = right.next;
                }

            }
            temp = temp.next;
        }
        if (left == null) {
            return head;
        }
        left.next = rightHead;

        return leftHead;

    }


    public static Node removeElements(Node head, int val) {
        if (head == null)
            return null;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == val) {
                if (prev != null) {
                    prev.next = temp.next;
                    temp = prev.next;
                } else {
                    head = temp.next;
                    temp.next = null;
                    temp = head;
                }
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    public Node mergeInBetween(Node list1, int a, int b, Node list2) {
        Node temp= list1;
        Node prev=null;
        int count=0;
        while (count!=a)
        {
            prev= temp;
            temp= temp.next;
            count++;
        }
        if(prev==null)
        {
            list1= list1.next;

        }
        else
        prev.next= list2;
        while (count!=b)
        {
            temp= temp.next;
            count++;
        }
      Node  temp2= list2;
        while (temp2.next!=null)
            temp2= temp2.next;
        temp2.next= temp.next;
        temp.next=null;

     return list1;
    }


    public static boolean isPalindrome(Node head) {
             Node temp = head;
             String str="";
             while (temp!=null)
             {
                 str= str+temp.data;
                 temp= temp.next;
             }
             if(isPalindrome(str))
                 return true;
             else
                 return false;
    }

    public  static  Node addTwoNumbers2(Node l1, Node l2) {
        Stack<Integer> l1stack = new Stack<>();
        Stack<Integer> l2stack= new Stack<>();
        Node temp1= l1;
        Node temp2 = l2;
        while (temp1!=null)
        {
            l1stack.push(temp1.data);
            temp1= temp1.next;
        }
        while (temp2!=null)
        {
            l2stack.push(temp2.data);
            temp2= temp2.next;
        }
        int carry =0;
        int res=0;
        Node x = null;
        Node newHead= null;
        while (!l1stack.isEmpty() && !l2stack.isEmpty())
        {
            int t = (carry+l1stack.pop()+l2stack.pop());
            res= t%10;
            carry= t/10;
            Node newNode = new Node(res);
            newNode.next= x;
            x= newHead=newNode;
        }
        while (!l1stack.isEmpty())
        {
            int t = (carry+l1stack.pop());
            res= t%10;
            carry= t/10;
            Node newNode = new Node(res);
            newNode.next= x;
            x= newHead=newNode;
        }
        while (!l2stack.isEmpty())
        {
            int t = (carry+l2stack.pop());
            res= t%10;
            carry= t/10;
            Node newNode = new Node(res);
            newNode.next= x;
            x= newHead=newNode;
        }
        if(carry==1)
        {
            Node newNode = new Node(1);
            newNode.next= x;
            x= newHead=newNode;
        }
        return newHead;

    }
    public  static Node doubleIt(Node head) {
        int carry=0, res=0;
        Stack<Integer> nodeStack = new Stack<>();
        Node temp =head;
        while (temp!=null)
        {
            nodeStack.push(temp.data);
            temp= temp.next;
        }
        Node newHead= null;
        Node k = null;
        while (!nodeStack.isEmpty())
        {
            int x= nodeStack.pop();
            res= (x*2)%10;
            carry= (x*2)/10;
            Node newNode = new Node(res);
            newNode.next=k;
            k= newNode;
            newHead= newNode;

        }
        if(carry==1)
        {
            Node newNode = new Node(1);
            newNode.next= newHead;
            newHead= newNode;
        }
        return newHead;

    }





    //add polynomial uslng linked list

    public static PolynomialNode addPolynomial(PolynomialNode head1, PolynomialNode head2) {
        PolynomialNode temp1= head1;
        PolynomialNode temp2= head2;
        PolynomialNode x= null;
        PolynomialNode newHead= null;
        while (temp1!=null && temp2!=null)
        {
            PolynomialNode newPolynomialNode=null;
            if(temp1.exp== temp2.exp)
            {
                newPolynomialNode = new PolynomialNode(temp1.coeff+temp2.coeff, temp2.exp);
                temp2 = temp2.next;
                temp1 = temp1.next;
            }
            else  if(temp1.exp<temp2.exp)
            {
                newPolynomialNode = new PolynomialNode(temp2.coeff, temp2.exp);
                temp2= temp2.next;
            }
            else {
                newPolynomialNode = new PolynomialNode(temp1.coeff, temp1.exp);
                temp1= temp1.next;
            }
            if(x==null)
            {
                newHead= newPolynomialNode;
                x= newPolynomialNode;
            }
            else {
                x.next = newPolynomialNode;
                x= newPolynomialNode;

            }
        }
        if(temp1!=null)
        {
            while (temp1!=null)
            {
                PolynomialNode newPolynomialNode = new PolynomialNode(temp1.coeff, temp1.exp);
                x.next = newPolynomialNode;
                x= newPolynomialNode;
                temp1= temp1.next;

            }
        }
        if(temp2!=null)
        {
            while (temp2!=null)
            {
                PolynomialNode newPolynomialNode = new PolynomialNode(temp2.coeff, temp2.exp);
                x.next = newPolynomialNode;
                x= newPolynomialNode;
                temp2= temp2.next;
            }
        }
        return  newHead;
    }

    //multiply polynomial using linked list

    public static PolynomialNode multiplyPolynomial(PolynomialNode head1, PolynomialNode head2) {
        PolynomialNode temp1= head1;
        PolynomialNode temp2= head2;
        PolynomialNode resultantPolyonimalHead = null;
        PolynomialNode temp3 = null;
        PolynomialNode previous= null;
        while (temp1!=null)
        {
            if(temp1.coeff !=0 ) {
                temp2 = head2;
                while (temp2 != null) {
                    if (temp2.coeff != 0) {
                        temp3 = resultantPolyonimalHead;
                        if (temp3 == null) {
                            PolynomialNode newNode = new PolynomialNode(temp1.coeff * temp2.coeff, temp1.exp + temp2.exp);
                            resultantPolyonimalHead = newNode;
                            temp3 = newNode;

                        } else {


                            while (temp3 != null && temp3.exp > temp1.exp + temp2.exp) {
                                previous = temp3;
                                temp3 = temp3.next;
                            }
                            if (temp3 != null && (temp3.exp == temp1.exp + temp2.exp)) {
                                temp3.coeff = temp3.coeff + (temp1.coeff * temp2.coeff);
                            } else {
                                PolynomialNode newNode = new PolynomialNode(temp1.coeff * temp2.coeff, temp1.exp + temp2.exp);
                                previous.next = newNode;
                                newNode.next = temp3;
                            }
                        }
                    }
                    temp2 = temp2.next;
                }

            }
                temp1 = temp1.next;

            }

    return  resultantPolyonimalHead;
    }


    public static void printPolynomialByPassingHead(PolynomialNode list) {
        if (list != null) {
            String str = "";
            PolynomialNode currentnode = list;
            while (currentnode != null) {
                if(currentnode.coeff==0)
                    continue;

                if(currentnode.exp==1) {
                    if(currentnode.next!=null && currentnode.next.coeff>0)
                        str = str + currentnode.coeff + "x" + "+";
                    else
                        str = str + currentnode.coeff + "x"  ;
                }
                else if(currentnode.exp==0)
                {
                    str = str + currentnode.coeff ;
                }

               else  {
                    if(currentnode.next!=null && currentnode.next.coeff>0)
                    str = str + currentnode.coeff + "x" + '^' + currentnode.exp + "+";
                    else
                        str = str + currentnode.coeff + "x" + '^' + currentnode.exp ;
                }

                currentnode = currentnode.next;
            }
            if(str.charAt(str.length()-1)=='+')
            System.out.println(str.substring(0, str.length() - 1));
            else
                System.out.println(str);
            System.out.println("--------");
        } else System.out.println("Polynomial is empty");
    }

//end of linked list


    //start of tree

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();
        inorder(root, inOrderTraversal);
        return inOrderTraversal;
    }

    private static void inorder(TreeNode node, List<Integer> inOrderTraversal) {
        if (node == null) return;
        inorder(node.left, inOrderTraversal);
        inOrderTraversal.add(node.data);
        inorder(node.right, inOrderTraversal);
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> preOrderTraversal = new ArrayList<>();
        preorder(root, preOrderTraversal);
        return preOrderTraversal;
    }

    private static void preorder(TreeNode node, List<Integer> preOrderTraversal) {
        if (node == null) return;
        preOrderTraversal.add(node.data);
        preorder(node.left, preOrderTraversal);
        preorder(node.right, preOrderTraversal);
    }

    public static List<Integer> preOrderTraversalwithnull(TreeNode root) {
        List<Integer> preOrderTraversalwithnull = new ArrayList<>();
        preorderwithnull(root, preOrderTraversalwithnull);
        return preOrderTraversalwithnull;
    }

    private static void preorderwithnull(TreeNode node, List<Integer> preOrderTraversalwithnull) {
        if (node == null) {
            preOrderTraversalwithnull.add(null);
            return;
        }
        preOrderTraversalwithnull.add(node.data);
        preorderwithnull(node.left, preOrderTraversalwithnull);
        preorderwithnull(node.right, preOrderTraversalwithnull);
    }

    public static List<Integer> symmetricOrderTraversalwithnull(TreeNode root) {
        List<Integer> symmetricOrderTraversalwithnull = new ArrayList<>();
        symorderwithnull(root, symmetricOrderTraversalwithnull);
        return symmetricOrderTraversalwithnull;
    }

    private static void symorderwithnull(TreeNode node, List<Integer> symmetricOrderTraversalwithnull) {
        if (node == null) {
            symmetricOrderTraversalwithnull.add(null);
            return;
        }
        symmetricOrderTraversalwithnull.add(node.data);
        symorderwithnull(node.right, symmetricOrderTraversalwithnull);
        symorderwithnull(node.left, symmetricOrderTraversalwithnull);
    }


    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> postOrderTraversal = new ArrayList<>();
        postorder(root, postOrderTraversal);
        return postOrderTraversal;
    }

    private static void postorder(TreeNode node, List<Integer> postOrderTraversal) {
        if (node == null) return;

        postorder(node.left, postOrderTraversal);
        postorder(node.right, postOrderTraversal);
        postOrderTraversal.add(node.data);
    }


    public static List<List<Integer>> levelOrderwithlevel(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        if (root == null) return answers;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> answer = new ArrayList<>();
            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNode temp = treeNodeQueue.peek();
                treeNodeQueue.poll();

                if (temp.left != null) treeNodeQueue.add(temp.left);
                if (temp.right != null) treeNodeQueue.add(temp.right);
                answer.add(temp.data);
                length--;
            }
            answers.add(answer);

        }
        return answers;
    }


    public static List<List<Integer>> BottomlevelOrderwithlevel(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        if (root == null) return answers;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> answer = new ArrayList<>();
            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNode temp = treeNodeQueue.peek();
                treeNodeQueue.poll();

                if (temp.left != null) treeNodeQueue.add(temp.left);
                if (temp.right != null) treeNodeQueue.add(temp.right);
                answer.add(temp.data);
                length--;
            }
            answers.add(answer);

        }
        Collections.reverse(answers);
        return answers;
    }

    public static List<Integer> levelOrderwithoutlevel(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {

            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNode temp = treeNodeQueue.peek();
                treeNodeQueue.poll();

                if (temp.left != null) treeNodeQueue.add(temp.left);
                if (temp.right != null) treeNodeQueue.add(temp.right);
                answer.add(temp.data);
                length--;
            }


        }
        return answer;
    }


    public static List<Integer> levelOrderwithoutlevelWithNull(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {

            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNode temp = treeNodeQueue.peek();
                treeNodeQueue.poll();
                if (temp != null) {

                    if (temp.left != null) treeNodeQueue.add(temp.left);
                    else treeNodeQueue.add(null);
                    if (temp.right != null) treeNodeQueue.add(temp.right);
                    else treeNodeQueue.add(null);

                    answer.add(temp.data);
                } else answer.add(null);
                length--;
            }


        }
        return answer;
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int level = 0;
        List<List<Integer>> answers = new ArrayList<>();
        if (root == null) return answers;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> answer = new ArrayList<>();
            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNode temp = treeNodeQueue.peek();
                treeNodeQueue.poll();

                if (temp.left != null) treeNodeQueue.add(temp.left);
                if (temp.right != null) treeNodeQueue.add(temp.right);
                answer.add(temp.data);
                length--;
            }
            if (level % 2 == 1) {
                revlist(answer);
                answers.add(answer);
            } else answers.add(answer);
            level++;


        }
        return answers;
    }

    //to reverse the collection list
    public static <T> void revlist(List<T> list) {

        if (list.size() <= 1 || list == null) return;
        T value = list.remove(0);
        revlist(list);
        list.add(value);
    }


    public static boolean isValidBST(TreeNode root) {
        return isValidBSTree(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }

    private static boolean isValidBSTree(TreeNode root, Long minValue, Long maxValue) {
        if (root == null) return true;
        if (maxValue <= root.data || minValue >= root.data) return false;
        return isValidBSTree(root.left, minValue, (long) root.data) && isValidBSTree(root.right, (long) root.data, maxValue);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        List<Integer> list1 = levelOrderwithoutlevelWithNull(p);
        List<Integer> list2 = levelOrderwithoutlevelWithNull(q);
        if (list1.equals(list2)) return true;
        else return false;

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        List<Integer> leftsubtreetraversal = preOrderTraversalwithnull(root.left);
        List<Integer> rightsubtreetraversal = symmetricOrderTraversalwithnull(root.right);
        if (leftsubtreetraversal.equals(rightsubtreetraversal)) return true;
        else return false;

    }


    public static int heightOfTree(TreeNode root) {
        int level = 0;
        if (root == null) return level;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {

            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNode temp = treeNodeQueue.peek();
                treeNodeQueue.poll();

                if (temp.left != null) treeNodeQueue.add(temp.left);
                if (temp.right != null) treeNodeQueue.add(temp.right);
                length--;
            }
            level++;
        }
        return level;
    }


    public static void inorderCorrectionforBST(TreeNode root) {
        if (root == null) return;
        inorderCorrectionforBST(root.left);
        if (root.data < prev.data && flag == 0) {
            first = prev;
            middle = root;
            flag++;

        } else if (root.data < prev.data && flag == 1) {
            last = root;
            flag++;

        }
        prev = root;
        inorderCorrectionforBST(root.right);
    }


    public static void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorderCorrectionforBST(root);
        int temp = 0;
        if (first != null && last != null) {
            temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
        prev = first = middle = last = null;
        flag = 0;
    }


    //no of bst
    public static int catalineNumber(int n) {
        if (n == 0 || n == 1) return 1;
        else {
            int result = 0;
            for (int i = 0; i < n; i++)
                result += catalineNumber(i) * catalineNumber(n - i - 1);
            return result;
        }
    }


    public static TreeNode buildTreefromInorderandPreOrder(int[] inorder, int[] preorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        TreeNode root = buildTreefromInorderandPreOrderMain(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, inorderMap);
        return root;
    }

    private static TreeNode buildTreefromInorderandPreOrderMain(int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend, Map<Integer, Integer> inorderMap) {
        if (instart > inend || prestart > preend) return null;
        int index = inorderMap.get(preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = buildTreefromInorderandPreOrderMain(inorder, instart, index - 1, preorder, prestart + 1, prestart + index - instart, inorderMap);
        root.right = buildTreefromInorderandPreOrderMain(inorder, index + 1, inend, preorder, prestart + index - instart + 1, preend, inorderMap);
        return root;
    }


    public static TreeNode buildTreefromInorderandPostOrder(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        TreeNode root = buildTreefromInorderandPostOrderMain(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
        return root;
    }

    private static TreeNode buildTreefromInorderandPostOrderMain(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend, Map<Integer, Integer> inorderMap) {
        if (instart > inend || poststart > postend) return null;
        int index = inorderMap.get(postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = buildTreefromInorderandPostOrderMain(inorder, instart, index - 1, postorder, poststart, poststart + index - instart - 1, inorderMap);
        root.right = buildTreefromInorderandPostOrderMain(inorder, index + 1, inend, postorder, poststart + index - instart, postend - 1, inorderMap);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = createTreeFromArray(nums, 0, nums.length - 1);
        return root;

    }

    private static TreeNode createTreeFromArray(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTreeFromArray(nums, left, mid - 1);
        root.right = createTreeFromArray(nums, mid + 1, right);
        return root;
    }


    public static TreeNode sortedListToBST(Node head) {
        TreeNode root = createTreeFromList(head);
        return root;

    }

    private static TreeNode createTreeFromList(Node head) {
        if (head == null) return null;
        Node middle = getMiddleNode(head);
        TreeNode root = new TreeNode(middle.data);
        Node rightsubtree = middle.next;
        Node leftsubtree = null;
        Node temp = head;
        if (head != middle) {
            while (temp.next != middle) temp = temp.next;
            leftsubtree = head;
            temp.next = null;
        }

        middle.next = null;


        root.left = createTreeFromList(leftsubtree);
        root.right = createTreeFromList(rightsubtree);
        return root;
    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftheight = findheight(root.left);
        int rightheight = findheight(root.right);

        if (Math.abs(leftheight - rightheight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) return true;
        else return false;

    }

    private static int findheight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else return 1 + Math.max(findheight(root.left), findheight(root.right));

    }


    public static int findmindepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else {
            int depthofleftsubtree = findmindepth(root.left);
            int depthofrightsubtree = findmindepth(root.right);
            return 1 + Math.min(depthofleftsubtree == 0 ? Integer.MAX_VALUE : depthofleftsubtree, depthofrightsubtree == 0 ? Integer.MAX_VALUE : depthofrightsubtree);
        }

    }

    public static int findmaxdepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else {
            int depthofleftsubtree = findmaxdepth(root.left);
            int depthofrightsubtree = findmaxdepth(root.right);
            return 1 + Math.max(depthofleftsubtree, depthofrightsubtree);
        }
    }

    public static boolean path(TreeNode root, int target) {

        if (root == null) return false;
        if (root.left == null && root.right == null && root.data == target) return true;
        Map<TreeNode, Integer> treeNodeIntegerMap = new HashMap<>();
        int sum = 0;
        int flag = 0;
        if (root == null) return false;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        treeNodeIntegerMap.put(root, root.data);
        int result = 0;
        TreeNode temp = null;
        outerloop:
        while (!treeNodeQueue.isEmpty()) {

            List<Integer> answer = new ArrayList<>();
            int length = treeNodeQueue.size();
            while (length > 0) {
                temp = treeNodeQueue.peek();
                treeNodeQueue.poll();


                if (temp.left != null) {
                    treeNodeQueue.add(temp.left);
                    int val = treeNodeIntegerMap.get(temp);
                    result = val + temp.left.data;
                    if (result == target && temp.left.right == null && temp.left.left == null) {
                        flag = 1;
                        break outerloop;
                    }
                    treeNodeIntegerMap.put(temp.left, result);
                }
                if (temp.right != null) {


                    treeNodeQueue.add(temp.right);
                    int val = treeNodeIntegerMap.get(temp);
                    result = val + temp.right.data;
                    if (result == target && temp.right.left == null && temp.right.right == null) {
                        flag = 1;
                        break outerloop;
                    }
                    treeNodeIntegerMap.put(temp.right, result);
                }
                length--;
            }
        }

        if (flag == 1) return true;
        else return false;
    }


    public static void flatten(TreeNode root) {
        prev = null;
        flattenTree(root);
    }


    public static void flattenTree(TreeNode root) {
        if (root == null) return;
        flattenTree(root.right);
        flattenTree(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }

    public static TreeNodeWithNext connectNextRightSidePointer(TreeNodeWithNext root) {
        List<List<Integer>> answers = new ArrayList<>();
        if (root == null) return null;
        Queue<TreeNodeWithNext> treeNodeQueue = new LinkedList<>();
        List<TreeNodeWithNext> treeNodeWithNextList = new ArrayList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> answer = new ArrayList<>();
            int length = treeNodeQueue.size();
            while (length > 0) {
                TreeNodeWithNext temp = treeNodeQueue.peek();
                treeNodeQueue.poll();

                if (temp.left != null) treeNodeQueue.add(temp.left);
                if (temp.right != null) treeNodeQueue.add(temp.right);
                treeNodeWithNextList.add(temp);
                length--;
            }
            treeNodeWithNextList.add(null);

        }

        for (int i = 0; i < treeNodeWithNextList.size() - 1; i++) {
            if (treeNodeWithNextList.get(i) != null) treeNodeWithNextList.get(i).next = treeNodeWithNextList.get(i + 1);
        }
        return root;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        maxdiameter(root);
        return max;

    }

    private static void maxdiameter(TreeNode root) {
        if (root == null) return;
        int leftheight = findmaxdepth(root.left);
        int rightheight = findmaxdepth(root.right);
        max = Math.max(max, leftheight + rightheight + 1);
        maxdiameter(root.left);
        maxdiameter(root.right);
    }

    public static int findMaxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSum(root);
        return max;

    }


    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int leftsum = maxPathSum(root.left);
        int rightsum = maxPathSum(root.right);
        max = Math.max(leftsum + rightsum + root.data, max);
        return root.data + Math.max(leftsum, rightsum);

    }

    public static int sumNumbers(TreeNode root) {
        return sumfromRootToLeaf(root, 0);
    }

    private static int sumfromRootToLeaf(TreeNode root, int curr) {
        if (root == null) return 0;
        curr = curr * 10 + root.data;
        if (root.left == null && root.right == null) return curr;
        int leftsum = sumfromRootToLeaf(root.left, curr);
        int rightsum = sumfromRootToLeaf(root.right, curr);
        return leftsum + rightsum;
    }


    public static String serialize(TreeNode root) {
        if (root == null)
            return "NULL";
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        String str = "";
        while (!treeNodeQueue.isEmpty()) {
            TreeNode x = treeNodeQueue.poll();
            if (x == null) {
                str = str + "NULL,";
            } else {
                str = str + x.data + ",";
                if (x.left == null)
                    treeNodeQueue.add(null);
                else
                    treeNodeQueue.add(x.left);
                if (x.right == null)
                    treeNodeQueue.add(null);
                else
                    treeNodeQueue.add(x.right);
            }

        }
        return str.substring(0, str.length() - 1);


    }

    public static TreeNode deserialize(String data) {
        if (data.equals("NULL"))
            return null;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        String t[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(t[0]));
        treeNodeQueue.add(root);
        int i = 1;
        while (i <= t.length - 1) {
            TreeNode x = treeNodeQueue.poll();
            if (!t[i].equals("NULL")) {
                TreeNode left = new TreeNode(Integer.parseInt(t[i]));
                x.left = left;
                treeNodeQueue.add(left);
            } else
                x.left = null;
            i++;
            if (!t[i].equals("NULL")) {
                TreeNode right = new TreeNode(Integer.parseInt(t[i]));
                x.right = right;
                treeNodeQueue.add(right);
            } else
                x.right = null;
            i++;


        }
        return root;

    }

    public  static int kthSmallest(TreeNode root, int k) {
            if(root==null)
                return -1;
        TreeNode x= root;
       int flag=0;
       Stack<TreeNode> treeNodeStack= new Stack<>();
       ArrayList<TreeNode> treeNodeArrayList= new ArrayList<>();
       treeNodeStack.push(root);
       while (flag==1 && !treeNodeStack.isEmpty() || flag==0)
       {
           flag=1;
           while (x.left!=null && !treeNodeArrayList.contains(x.left))
           {
               treeNodeStack.push(x.left);
               x= x.left;
           }
           TreeNode t = treeNodeStack.pop();
           treeNodeArrayList.add(t);
           if(t.right!=null && !treeNodeArrayList.contains(t.right))
               treeNodeStack.push(t.right);
           if(!treeNodeStack.isEmpty())
           x= treeNodeStack.peek();
       }
       return treeNodeArrayList.get(k-1).data;
    }

    public static TreeNode deleteNodeInBST(TreeNode root, int key) {
        if (root != null && root.data == key && root.left == null && root.right == null)
            return null;
            deleteNodeFromBST(root, key);
            return root;


    }

    private static void deleteNodeFromBST(TreeNode root, int key) {
        TreeNode treeNodeToBeDeleted= searchBST(root,key);
        if(treeNodeToBeDeleted==null)
            return;
        if(treeNodeToBeDeleted.right==null && treeNodeToBeDeleted.left==null) //for no child
        {

            TreeNode parent = getParentOfNodeInBST(root,treeNodeToBeDeleted.data);
            if(parent==null)
                return ;
            if(parent.left==treeNodeToBeDeleted)
                parent.left=null;
            if(parent.right== treeNodeToBeDeleted)
                parent.right=null;
            return;
        }

        if(treeNodeToBeDeleted.left !=null && treeNodeToBeDeleted.right ==null) //for one child in left
        {
            TreeNode t = findMaxOfLeftSubTree(treeNodeToBeDeleted.left);
            int x = t.data;
            deleteNodeFromBST(root,t.data);
            treeNodeToBeDeleted.data= x;

        }

        else {
            //for both children case
            TreeNode t = findMinOfRightSubTree(treeNodeToBeDeleted.right);
            int x = t.data;
            deleteNodeFromBST(root,t.data);
            treeNodeToBeDeleted.data= x;

        }

    }

    private static TreeNode findMaxOfLeftSubTree(TreeNode left) {
        while (left.right!=null)
            left= left.right;
        return left;
    }

    private static TreeNode getParentOfNodeInBST(TreeNode root, int key) {

              if(root==null)
                  return null;
              TreeNode getParent = null;
              while (root!=null)
              {
                  if(key<root.data)
                  {
                      getParent= root;
                      root= root.left;
                  }
                 else if(key>root.data)
                  {
                      getParent= root;
                      root= root.right;
                  }
                 else
                     break;
              }
              return getParent;



    }

    private static TreeNode findMinOfRightSubTree(TreeNode right) {
        while (right.left!=null)
            right= right.left;
        return right;
    }

    private static TreeNode searchBST(TreeNode root, int key) {
       while ((root)!=null)
       {
           if(root.data==key)
               return root;
           else if(root.data>key)
               root= root.left;
           else
               root= root.right;
       }
       return null;
    }


    //end of tree


    public static List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> answers = new ArrayList<>();
        if (numRows == 0) return answers;
        for (int i = 0; i < numRows; i++) {
            List<Integer> answer = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) answer.add(1);
                else answer.add(answers.get(i - 1).get(j) + answers.get(i - 1).get(j - 1));
            }
            answers.add(answer);

        }
        System.out.println(answers.get(answers.size() - 1));
        return answers;
    }

    public static List<Integer> getPascalRow(int rowIndex) {
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> answer = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) answer.add(1);
                else answer.add(answers.get(i - 1).get(j) + answers.get(i - 1).get(j - 1));
            }

            answers.add(answer);
        }
        return answers.get(answers.size() - 1);
    }


    public static int minimumTotalFromTriangle(List<List<Integer>> triangles) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangles.size(); i++) {
            List<Integer> x = new ArrayList<>();
            for (int j = 0; j < triangles.get(i).size(); j++) {
                if (i == 0) x.add(triangles.get(0).get(0));
                else if (j == 0 || j == triangles.get(i).size() - 1) {
                    if (j == 0) x.add(dp.get(i - 1).get(0) + triangles.get(i).get(0));
                    if (j == triangles.get(i).size() - 1)
                        x.add(dp.get(i - 1).get(dp.get(i - 1).size() - 1) + triangles.get(i).get(j));
                } else {
                    x.add(Math.min(dp.get(i - 1).get(j) + triangles.get(i).get(j), dp.get(i - 1).get(j - 1) + triangles.get(i).get(j)));
                }

            }
            dp.add(x);
        }
        return Collections.min(dp.get(dp.size() - 1));
    }


    public static int searchInRotatedArray(int[] a, int target) {

        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left <= right) {

            mid = (left + right) / 2;
            if (a[mid] >= a[left]) {
                //left sorted including element
                if (target <= a[mid] && target >= a[left]) {

                    right = mid;
                } else {
                    left = mid + 1;
                }


            } else {


                //right sorted including element
                if (target <= a[right] && target >= a[mid]) {
                    left = mid;
                } else right = mid - 1;


            }
            if (left > right) return -1;
            if (a[mid] == target) return mid;


        }

        return -1;
    }

    public static int[] searchRange(int[] a, int target) {
        int answer[] = new int[2];
        int k = 0;
        int i = 0, j = a.length - 1;
        int mid = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (i <= j) {
            mid = (i + j) / 2;
            if (target > a[mid]) i = mid + 1;
            if (target < a[mid]) j = mid - 1;
            if (a[mid] == target) {
                min = Math.min(min, mid);
                j = mid - 1;


            }


        }
        i = 0;
        j = a.length - 1;
        while (i <= j) {
            mid = (i + j) / 2;
            if (target > a[mid]) i = mid + 1;
            if (target < a[mid]) j = mid - 1;
            if (a[mid] == target) {
                max = Math.max(max, mid);
                i = mid + 1;


            }


        }
        if ((min == Integer.MAX_VALUE) && (max == Integer.MIN_VALUE)) {
            answer[0] = -1;
            answer[1] = -1;
        } else {
            answer[0] = min;
            answer[1] = max;
        }
        return answer;
    }


    public static void getRotatedArray(int[][] a, int edge) {
        if (edge == a[0].length / 2) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println();
            }
            return;
        }

        rotateArray(a, edge, edge, edge, a[0].length - 1 - edge, a.length - 1 - edge, a.length - 1 - edge, a.length - 1 - edge, edge);
        edge++;
        getRotatedArray(a, edge);

    }


    public static void rotateArray(int[][] a, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {


        if (x1 + y1 == a[0].length - 1) {

            return;
        }

        int temp = a[x1][y1];
        a[x1][y1] = a[x4][y4];
        int temp2 = a[x2][y2];
        a[x2][y2] = temp;
        int temp3 = a[x3][y3];
        a[x3][y3] = temp2;
        int temp4 = a[x4][y4];
        a[x4][y4] = temp3;
        y1 = y1 + 1;
        x2 = x2 + 1;
        y3 = y3 - 1;
        x4--;


        rotateArray(a, x1, y1, x2, y2, x3, y3, x4, y4);


    }


    public static void sortColors(int[] a) {

        int l = 0, m = 0, h = a.length - 1;
        int temp = 0;
        while (m <= h) {
            if (a[m] == 0) {
                temp = a[m];
                a[m] = a[l];
                a[l] = temp;
                l++;
                m++;
                continue;

            }

            if (a[m] == 1) {
                m++;
                continue;
            }

            if (a[m] == 2) {

                temp = a[m];
                a[m] = a[h];
                a[h] = temp;
                h--;


            }


        }
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    public static int minPathSum(int[][] a) {
        int path = 0;
        int sum = 0;
        int matrix[][] = new int[a.length][a[0].length];
        matrix[0][0] = 1;
        for (int i = 1; i < a[0].length; i++) {

            matrix[0][i] = matrix[0][i - 1] + a[0][i];
        }

        for (int i = 1; i < a.length; i++) {

            matrix[i][0] = matrix[i - 1][0] + a[i][0];
        }

        for (int i = 1; i < a.length; i++) {

            for (int j = 1; j < a[0].length; j++) {
                matrix[i][j] = a[i][j] + Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            }


        }
        path = matrix[a.length - 1][a[0].length - 1];

        return path;
    }


    public static int uniquePaths(int m, int n) {
        int matrix[][] = new int[m][n];
        matrix[0][0] = 1;
        for (int i = 1; i < m; i++)

            matrix[i][0] = 1;

        for (int i = 1; i < n; i++)
            matrix[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
        }
        return matrix[m - 1][n - 1];


    }


    public static int uniquePathsWithObstacles(int[][] a) {

        int matrix[][] = new int[a.length][a[0].length];
        int flagrow = 0, flagcoloumn = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i][0] == 0 && flagcoloumn == 0) {
                matrix[i][0] = 1;
            } else {
                matrix[i][0] = 0;
                flagcoloumn = 1;
            }
        }


        for (int i = 0; i < a[0].length; i++) {
            if (a[0][i] == 0 && flagrow == 0) {
                matrix[0][i] = 1;
            } else {
                matrix[0][i] = 0;
                flagrow = 1;
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                if (a[i][j] != 1) matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                else matrix[i][j] = 0;
            }
        }
        return matrix[a.length - 1][a[0].length - 1];


    }


    public static void removeDuplicates2(int[] a) {
        int i = 2;
        while (i < a.length) {
            if (a[i] == a[i - 2] && a[i] != Integer.MIN_VALUE) {
                for (int j = i + 1; j <= a.length - 1; j++) {
                    a[j - 1] = a[j];
                }
                a[a.length - 1] = Integer.MIN_VALUE;
            } else i++;
        }
        int count = 2;

        for (int k = 2; k < a.length; k++) {
            if (a[k] == Integer.MIN_VALUE) break;
            count++;
        }
        System.out.println(count);


    }

    public static String simplifyPath(String path) {

        Stack stack = new Stack<>();
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length; i++) {
            if (!paths[i].equals("") && !paths[i].equals("..") && !paths[i].equals(".")) {

                stack.push(paths[i]);
            } else if (paths[i].equals("..") && stack.isEmpty() == false) stack.pop();

        }
        String result = "";

        if (stack.isEmpty()) return "/";

        while (stack.isEmpty() == false) {
            result = "/" + stack.peek() + result;
            stack.pop();
        }
        return result;


    }


    public static void nextPermutation(int[] a) {
        int i = 0, j = 0;
        if (a.length == 1) return;


        for (i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) break;
        }
        if (i == a.length) {
            Arrays.sort(a);
            return;
        }
        int inflexionValue = a[i];
        int min = Integer.MAX_VALUE;
        int k = 1;
        int equalBreak = 0;
        for (j = i; j < a.length; j++) {

            if (inflexionValue < a[j]) {
                if (min > a[j]) {

                    min = a[j];
                    k = j;
                }


            }
        }

        int temp = a[k];
        a[k] = a[i];
        a[i] = temp;
        Arrays.sort(a, i + 1, a.length);

    }


    public static List<List<Integer>> combinationSum(int a[], int target) {
        temp.clear();
        set.clear();
        solvecombinationSum(a, target, 0, 0);
        return temp;


    }

    private static void solvecombinationSum(int[] a, int target, int i, int sum) {

        if (target == sum) {
            List<Integer> listtobeAdded = new ArrayList<>();
            listtobeAdded.addAll(set);
            temp.add(listtobeAdded);
            return;
        }

        if (i > a.length - 1 || target < sum) return;

        sum = sum + a[i];
        set.add(a[i]);
        solvecombinationSum(a, target, i, sum);
        sum = sum - a[i];
        set.remove(Integer.valueOf(a[i]));
        solvecombinationSum(a, target, i + 1, sum);

    }

    public static int EditDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        int matrix[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][matrix[0].length - 1] = x;
            x--;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[matrix.length - 1][i] = y;
            y--;
        }
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) matrix[i][j] = matrix[i + 1][j + 1];
                else matrix[i][j] = minimumOfThree(matrix[i + 1][j + 1], matrix[i + 1][j], matrix[i][j + 1]) + 1;
            }

        }

        return matrix[0][0];


    }

    private static int minimumOfThree(int a, int b, int c) {


        if (c <= b && c <= a) return c;
        else if (a <= b) return a;
        else return b;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean matrix[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = false;
        }
        matrix[0][0] = true;
        for (int i = 1; i < matrix.length; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) matrix[i][0] = matrix[i - 1][0];

        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) matrix[0][i] = matrix[0][i - 1];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                if ((s3.charAt(i + j - 1) == s1.charAt(i - 1)) && (s3.charAt(i + j - 1) == s2.charAt(j - 1))) {
                    matrix[i][j] = matrix[i - 1][j] || matrix[i][j - 1];
                    continue;
                }


                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    matrix[i][j] = matrix[i - 1][j];
                }
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i][j - 1];

                }
            }
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }


    public static boolean searchin2DARRAY(int[][] a, int target) {

        int low = 0;
        int high = (a.length) * (a[0].length) - 1;
        int row, coloum = 0;
        int mid = 0;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid == a.length) row = 0;
            else row = (mid) / a[0].length;

            coloum = (mid) % a[0].length;

            if (a[row][coloum] == target) return true;
            else if (a[row][coloum] < target) low = mid + 1;
            else high = mid - 1;


        }
        return false;


    }


    public static int longestConsecutive(int[] a) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < a.length; i++)
            numberSet.add(a[i]);
        int longestConsecutive = 0;
        int count = 1;
        for (Integer number : numberSet) {
            if (!numberSet.contains(number - 1)) {
                int x = number;
                while (numberSet.contains(x + 1)) {
                    x++;
                    count++;
                }

            } else count = 1;
            longestConsecutive = Math.max(count, longestConsecutive);
            count = 1;

        }
        return longestConsecutive;

    }


    public static String longestPalindromeSubstring(String a) {
        int matrix[][] = new int[a.length()][a.length()];
        String solution = "";
        int i, j;
        int max = 0;
        for (i = 0; i < a.length(); i++)
            matrix[i][i] = 1;
        for (i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) matrix[i][i + 1] = 2;
            else matrix[i][i + 1] = 0;
        }
        int space = 2;
        for (i = a.length() - 2; i >= 1; i--) {
            for (j = 0; j < i; j++) {

                if (a.charAt(j) == a.charAt(j + space)) {
                    if (matrix[j + 1][j + space - 1] != 0) matrix[j][j + space] = matrix[j + 1][j + space - 1] + 2;
                    else matrix[j][j + space] = 0;


                } else matrix[j][j + space] = 0;
            }
            space++;
        }
        for (i = 0; i < a.length(); i++) {
            for (j = i; j < a.length(); j++) {
                if (matrix[i][j] != 0) {
                    if (max < j - i + 1) {
                        max = j - i + 1;
                        solution = a.substring(i, max + i);
                    }
                }


            }


        }
        return solution;

    }

    public static boolean isValidParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                if (s.charAt(i) == '(') stack.push(')');
                if (s.charAt(i) == '{') stack.push('}');
                if (s.charAt(i) == '[') stack.push(']');
            } else {
                if (!stack.isEmpty() && stack.peek() != s.charAt(i)) return false;
                else {
                    stack.pop();
                }

            }
        }

        if (stack.isEmpty()) return true;
        else return false;


    }

    public static void SorroundedRegion(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            dfs(0, i, board);
        }
        for (int i = 0; i < board.length; i++) {
            dfs(i, board[0].length - 1, board);
        }
        for (int i = board[0].length - 1; i >= 0; i--) {
            dfs(board.length - 1, i, board);
        }
        for (int i = board.length - 1; i >= 0; i--) {
            dfs(i, 0, board);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if ((board[i][j] == 'T')) {

                    board[i][j] = 'O';
                    continue;
                }
                if (board[i][j] == 'O') board[i][j] = 'X';
            }

        }

    }


    public static void dfs(int i, int j, char[][] board) {
        if (board[i][j] == 'O') {
            board[i][j] = 'T';
            if (j > 0) dfs(i, j - 1, board);

            if (j < board[0].length - 1) dfs(i, j + 1, board);
            if (i > 0) dfs(i - 1, j, board);

            if (i < board.length - 1) dfs(i + 1, j, board);
        }


    }


    public int maxProduct(int[] a) {

        int prefix = 1;
        int suffix = 1;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (suffix == 0) suffix = 1;
            if (prefix == 0) prefix = 1;
            prefix = prefix * a[i];
            suffix = suffix * a[a.length - i - 1];
            answer = Math.max(answer, Math.max(suffix, prefix));

        }

        return answer;

    }

    public static int gasDistanceProblem(int[] gas, int[] distance) {
        int totalgas = Arrays.stream(gas).sum();
        int totaldistance = Arrays.stream(distance).sum();
        if (totaldistance > totalgas) return -1;
        int index = 0;
        int total = 0;
        for (int i = 0; i < gas.length; i++) {

            total = gas[i] - distance[i];
            if (total < 0) {
                total = 0;
                index = i + 1;
            }


        }
        return index;


    }


    public static boolean wordBreak(String word, List<String> dictionary) {

        boolean matrix[][] = new boolean[word.length()][word.length()];
        Set<String> set = new HashSet<>();
        for (String words : dictionary)
            set.add(words);
        for (int i = 0; i < matrix.length; i++) {
            if (set.contains(String.valueOf(word.charAt(i)))) matrix[i][i] = true;
            else matrix[i][i] = false;
        }
        int space = 1;
        int flag = 0;

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (set.contains(word.substring(j, j + space + 1))) matrix[j][j + space] = true;
                else {
                    for (int k = 0; k <= j + space - 1; k++) {
                        if (matrix[0][k] == true && matrix[k + 1][j + space] == true) {
                            matrix[j][j + space] = true;
                            flag = 1;
                            k = j + space;
                        }
                    }
                    if (flag == 0) {
                        matrix[j][j + space] = false;
                    }
                    flag = 0;


                }

            }
            space++;

        }


        return matrix[0][matrix[0].length - 1];
    }

    public static int decodeWays(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] matrix = new int[s.length() + 1];
        for (int i = 0; i < matrix.length; i++)
            matrix[i] = 0;
        matrix[0] = 1;
        matrix[1] = 1;
        for (int i = 2; i < matrix.length; i++) {
            if (Character.getNumericValue(s.charAt(i - 1)) <= 9 && Character.getNumericValue(s.charAt(i - 1)) >= 1)
                matrix[i] = matrix[i - 1];
            if (Character.getNumericValue(s.charAt(i - 2)) == 1) matrix[i] += matrix[i - 2];
            if (Character.getNumericValue(s.charAt(i - 2)) == 2 && (Character.getNumericValue(s.charAt(i - 1)) <= 6) && Character.getNumericValue(s.charAt(i - 1)) >= 0)
                matrix[i] += matrix[i - 2];

        }
        return matrix[matrix.length - 1];


    }

    public static int evaluateReversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int value1 = 0, value = 0, result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals("*") && !tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("/"))
                stack.push(Integer.valueOf(tokens[i]));
            else {
                if (tokens[i].equals("+")) {
                    value = Integer.valueOf(stack.peek());
                    stack.pop();
                    value1 = Integer.valueOf(stack.peek());
                    stack.pop();
                    result = value + value1;
                    stack.push(result);

                }
                if (tokens[i].equals("-")) {
                    value = Integer.valueOf(stack.peek());
                    stack.pop();
                    value1 = Integer.valueOf(stack.peek());
                    stack.pop();
                    result = value1 - value;
                    stack.push(result);

                }
                if (tokens[i].equals("*")) {
                    value = Integer.valueOf(stack.peek());
                    stack.pop();
                    value1 = Integer.valueOf(stack.peek());
                    stack.pop();
                    result = value * value1;
                    stack.push(result);

                }
                if (tokens[i].equals("/")) {
                    value = Integer.valueOf(stack.peek());
                    stack.pop();
                    value1 = Integer.valueOf(stack.peek());
                    stack.pop();
                    result = value1 / value;
                    stack.push(result);

                }

            }
        }
        return stack.peek();
    }


    public static int maxiumGap(int[] a) {

        if (a.length == 1) return 0;
        int maximum = a[0];
        int minimum = a[0];
        int answer = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maximum) maximum = a[i];
            if (a[i] < minimum) minimum = a[i];
        }
        int[] Bucketmin = new int[a.length - 1];
        for (int i = 0; i < Bucketmin.length; i++)
            Bucketmin[i] = Integer.MAX_VALUE;

        int[] BucketMax = new int[a.length - 1];
        for (int i = 0; i < BucketMax.length; i++)
            BucketMax[i] = Integer.MIN_VALUE;
        double d = Math.ceil((maximum - minimum) * 1.0 / (a.length - 1));
        int interval = (int) d;
        int magic = 0;
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == maximum || a[i] == minimum) continue;
            magic = (a[i] - minimum) / interval;
            Bucketmin[magic] = Math.min(Bucketmin[magic], a[i]);
            BucketMax[magic] = Math.max(BucketMax[magic], a[i]);
        }

        int prev = minimum;
        int x;


        for (int i = 0; i < BucketMax.length; i++) {
            if (Bucketmin[i] != Integer.MAX_VALUE) {
                x = Math.min(Bucketmin[i], BucketMax[i]);
                answer = Math.max(answer, x - prev);
                prev = Math.max(Bucketmin[i], BucketMax[i]);

            }
        }

        return Math.max(answer, maximum - prev);
    }


    public static int candy(int[] ratings) {
        int[] LeftCandy = new int[ratings.length];
        int[] rightCandy = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            LeftCandy[i] = 1;
            rightCandy[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) LeftCandy[i] = LeftCandy[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) rightCandy[i] = rightCandy[i + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum = sum + Math.max(LeftCandy[i], rightCandy[i]);

        }

        return sum;


    }

    public static int rob(int[] a) {
        int loot[] = new int[a.length];
        loot[0] = a[0];
        if (a.length > 0) loot[1] = Math.max(a[0], a[1]);
        for (int i = 2; i < loot.length; i++) {
            loot[i] = Math.max(loot[i - 2] + a[i], loot[i - 1]);
        }
        return loot[loot.length - 1];
    }

    public static int rob2(int[] a) {
        if (a.length == 1) return a[0];
        if (a.length == 2) return Math.max(a[0], a[1]);

        int loot1[] = new int[a.length - 1];
        int loot2[] = new int[a.length - 1];
        loot1[0] = a[0];
        loot1[1] = Math.max(a[0], a[1]);
        for (int i = 2; i < loot1.length; i++) {
            loot1[i] = Math.max(loot1[i - 2] + a[i], loot1[i - 1]);
        }
        loot2[0] = a[1];
        loot2[1] = Math.max(a[1], a[2]);
        for (int i = 2; i < loot2.length; i++) {
            loot2[i] = Math.max(loot2[i - 2] + a[i + 1], loot2[i - 1]);
        }
        return Math.max(loot1[loot1.length - 1], loot2[loot2.length - 1]);

    }

    public static int kthLargestElementinArray(int[] a, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k + 1);
        for (int i = 0; i < a.length; i++) {

            priorityQueue.add(a[i]);
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        return priorityQueue.poll();


    }


    public static String shortestPalindrome(String s) {
        String x = s + "#" + reverse(s);
        int a[] = new int[x.length()];
        for (int i = 0; i < a.length; i++)
            a[i] = 0;
        int i = 0, j = 1;
        while (j <= a.length - 1) {
            if (x.charAt(i) != x.charAt(j)) {
                if (i != 0) {
                    i = a[i - 1];
                } else j++;
            } else {
                a[j] = i + 1;
                i++;
                j++;
            }


        }
        int length = a[a.length - 1];
        String addedstring = s.substring(length, s.length());
        String reverseaddedstring = reverse(addedstring);
        return reverseaddedstring + s;
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }


    public static int maxPoints(int[][] points) {
        Map<Double, Integer> hashmap = new HashMap<>();
        double slope = 0;
        int max = Integer.MIN_VALUE;
        int answer = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {

                {
                    if (((points[j][0] - points[i][0])) != 0)
                        slope = (points[j][1] - points[i][1]) * 1.0 / (points[j][0] - points[i][0]);
                    else slope = Integer.MAX_VALUE;
                    if (slope == -0.0) {
                        slope = Math.abs(slope);
                    }

                    if (!hashmap.containsKey(slope)) hashmap.put(slope, 1);
                    else hashmap.put(slope, hashmap.get(slope) + 1);


                }
            }
            Iterator<Map.Entry<Double, Integer>> iterator = hashmap.entrySet().iterator();


            while (iterator.hasNext()) {
                Map.Entry<Double, Integer> entry = iterator.next();
                max = Math.max(max, entry.getValue());

            }
            max = max + 1;
            answer = Math.max(answer, max);
            max = Integer.MIN_VALUE;
            hashmap.clear();
        }
        return answer;
    }

    public static String multiplyString(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0")) return "0";
        int carry = 0;
        int answer[] = new int[s1.length() + s2.length()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = 0;
        int k = 0;
        String multipliedString = "";
        int result = 0;
        int shift = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            k = answer.length - 1 - shift;

            for (int j = s2.length() - 1; j >= 0; j--) {
                if (i == s1.length() - 1) {
                    result = Character.getNumericValue(s2.charAt(j)) * Character.getNumericValue(s1.charAt(i)) + carry;
                    answer[k] = result % 10;
                    carry = result / 10;
                    k--;
                } else {
                    result = Character.getNumericValue(s2.charAt(j)) * Character.getNumericValue(s1.charAt(i)) + carry + answer[k];
                    answer[k] = result % 10;
                    carry = result / 10;
                    k--;

                }


            }
            answer[k] = carry;
            shift++;
            carry = 0;
        }
        int t = 0;
        while (answer[t] == 0) t++;
        while (t < answer.length) {
            multipliedString = multipliedString.concat(String.valueOf(answer[t]));
            t++;
        }
        return multipliedString;
    }

    public static int myAtoiFunction(String s) {

        int i = 0, j = 0;
        double answer = 0;
        int sign = 1; //1 for positive and -1 for negative
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if ((i < s.length()) && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') sign = -1;
            i++;
        }

        while ((i < s.length()) && s.charAt(i) == 0) i++;
        for (j = i; j < s.length(); j++) {
            if (s.charAt(j) <= 57 && s.charAt(j) >= 48) answer = answer * 10 + Character.getNumericValue(s.charAt(j));
            else break;
        }
        if ((i < s.length()) && (j == i) && (s.charAt(j) == '0')) return 0;

        if (sign == -1) answer = answer * (-1);

        if (answer > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (answer < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) answer;


    }


    public static int findPeakElement(int[] a) {
        int low = 0, high = a.length - 1;
        if (a.length == 1) return a[0];
        int mid = low + (high - low) / 2;
        int x = 0, y = 0;
        while (low <= high) {

            if (mid == 0) x = Integer.MIN_VALUE;
            else x = a[mid - 1];

            if (mid == a.length - 1) y = Integer.MIN_VALUE;
            else y = a[mid + 1];

            if (a[mid] > x && a[mid] > y) break;


            {
                if (a[mid] < y) low = mid + 1;
                else high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }


        return mid;
    }


    public static int compareVersion(String s1, String s2) {
        String[] string1 = s1.split("\\.");
        String[] string2 = s2.split("\\.");
        int maxleft = 0, maxright = 0;
        int[] array1 = new int[Math.max(string1.length, string2.length)];
        int array2[] = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {

            if (i < string1.length) array1[i] = Integer.parseInt(string1[i]);


        }
        for (int i = 0; i < array2.length; i++) {
            if (i < string2.length) array2[i] = Integer.parseInt(string2[i]);

        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > array2[i]) {
                maxleft = 1;
                break;
            }
            if (array1[i] < array2[i]) {
                maxright = 1;
                break;
            }


        }
        if (maxleft == 1) return 1;
        if (maxright == 1) return -1;
        return 0;
    }


    public static int bestTimeToBuyAndSell(int[] a) {

        int max = 0;
        int buyPrice = a[0];
        int currentprofit = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < buyPrice) {
                buyPrice = a[i];
                continue;
            }
            if (a[i] > buyPrice) {
                currentprofit = a[i] - buyPrice;
                max = Math.max(max, currentprofit);
            }

        }
        return max;
    }

    public static int bestTimeToBuyandStock2(int[] a) {
        int profit = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) profit += a[i] - a[i - 1];
        }
        return profit;
    }

    public static int divide(int a, int b) {
        double x = 0;
        x = a * (1.0) / b;
        return (int) x;
    }

    public static double pow(double x, int y) {
        long pow = y;
        return power1(x, y);

    }

    private static double power1(double x, long y) {
        if (y == 0) return 1;
        if (y < 0) return power1(1 / x, -y);
        if (y % 2 == 0) return power1(x * x, y / 2);
        else return x * power1(x * x, (y - 1) / 2);
    }


    public static int WordLadder(String beginWord, String endWord, List<String> wordList) {
        String x = "";
        String y = "";
        Set<String> set = new HashSet<>();
        for (String list : wordList)
            set.add(list);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        int depth = 0;
        int size = 0;
        queue.add(beginWord);
        depth = 0;
        size = 0;


        while (!queue.isEmpty()) {
            if (size == 0) {
                depth++;
                size = queue.size();
            }

            x = queue.remove();

            for (int i = 0; i < x.length(); i++) {

                for (char curchar = 'a'; curchar <= 'z'; curchar++) {
                    String combinedString = x.substring(0, i) + String.valueOf(curchar) + x.substring(i + 1, x.length());
                    if (set.contains(combinedString)) {
                        if (combinedString.equals(endWord)) return depth + 1;
                        queue.add(combinedString);
                        set.remove(combinedString);
                    }

                }

            }

            size--;

        }
        return 0;

    }


    public static String studentaverage(String[] strings) {
        String studentname = "";
        int average = 0;
        String finalanswer = "";

        for (String string : strings) {
            String[] parts = string.split(" ");
            for (String part : parts) {
                if (!(48 <= part.charAt(0) && part.charAt(0) <= 57)) studentname = studentname + part + " ";
                else average = average + Integer.parseInt(part);
            }

            finalanswer = finalanswer + studentname.substring(0, studentname.length() - 1) + "-" + average + ";";
            average = 0;
            studentname = "";

        }


        return finalanswer;
    }


    public static void hourGlassProblem(int n) {
        if (n < 4) System.out.println("Invalid value of n");
        int space = 1;
        int content = n;
        int value = 1;
        int flag = 0;
        int changingElement = n * (n + 1) - 8;
        int lastvalue = 8;
        int totalElement = n * (n + 1) - 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < space; j++)
                System.out.print(" ");
            for (int k = 1; k <= content; k++) {
                if (value > 9 && value % 2 == 0) {
                    System.out.print(0 + " ");
                    value++;
                    continue;
                }
                if (value > 9 && value % 2 != 0) {
                    System.out.print(9 + " ");
                    value++;
                    continue;
                }
                System.out.print(value + " ");
                value++;
            }
            System.out.println();
            space++;
            content--;

        }
        space = space - 2;
        content = 2;
        for (int i = 1; i < n; i++) {

            for (int j = 1; j < space; j++)
                System.out.print(" ");
            for (int k = 1; k <= content; k++) {


                if ((value < changingElement) && (value % 2 == 0)) {
                    System.out.print(0 + " ");
                    value++;
                    continue;
                }
                if ((value < changingElement) && (value % 2 != 0)) {
                    System.out.print(9 + " ");
                    value++;
                    continue;
                }

                System.out.print(lastvalue + " ");
                lastvalue--;
                value++;


            }
            System.out.println();
            content++;
            space--;

        }

    }


    public static int addDigits(int num) {
        if (num == 0) return 0;
        int x = num;
        int digit = 0;
        int sum = 0;
        while (x != 0) {
            digit = x % 10;
            x = x / 10;
            sum = sum + digit;
        }
        if ((sum >= 1) && (sum <= 9)) return sum;
        else return addDigits(sum);

    }


    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answers = new ArrayList<>();
        int i = 0;
        int n = words.length;
        int slot = 0;
        int spacePerSlot = 0;
        int letterCount = 0;
        int spaceCount = 0;
        int extraSpace = 0;
        int j = i + 1;
        while (i < n) {
            spaceCount = 0;
            letterCount = words[i].length();
            j = i + 1;
            while ((j < n) && (letterCount + spaceCount + words[j].length() < maxWidth)) {
                letterCount = letterCount + words[j].length();
                spaceCount++;
                j++;


            }
            String answer = "";
            String space = "";
            if (j != n) {
                slot = j - i - 1;
                if (slot == 0 && i != n - 1) {
                    String sp = "";
                    String answersp = "";
                    for (int k = 1; k <= (maxWidth - words[i].length()); k++)
                        sp = sp + " ";
                    answersp = words[i] + sp;
                    answers.add(answersp);
                    i++;

                    continue;
                }
                if (slot != 0) spacePerSlot = (maxWidth - letterCount) / slot;
                extraSpace = (maxWidth - letterCount) % slot;
                //get the answer


                for (int k = i; k <= j - 1; k++) {

                    for (int t = 1; t <= spacePerSlot; t++) {

                        space = space + " ";
                        if (extraSpace != 0) {
                            space = space + " ";
                            extraSpace--;
                        }
                    }

                    answer = answer + words[k] + space;
                    space = "";


                }
                System.out.println(answer.length());
                answers.add(answer.substring(0, maxWidth));
                i = j;
            }
            if (j == n) {
                for (int k = i; k <= j - 1; k++) {
                    answer = answer + words[k] + " ";

                }
                for (int k = 1; k <= maxWidth - answer.length(); k++)
                    space = space + " ";
                answer = answer + space;
                answers.add(answer.substring(0, maxWidth));
                i = j;


            }

        }
        return answers;
    }


    public static int[] slidingWindowMaximum(int[] nums, int maxwidth) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        int max = nums[0];


        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) deque.addFirst(i);
            else {
                while (!deque.isEmpty() && deque.getFirst() <= i - maxwidth && (i - maxwidth >= 0)) deque.removeFirst();
                while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) deque.removeLast();
                deque.addLast(i);

            }
            if (i >= maxwidth - 1) answer.add(nums[deque.getFirst()]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static int basicCalculator(String s) {
        int sign = 1;
        int current = 0;
        int ans = 0;
        int popped = 0;
        Stack stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ' ') continue;

            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                current = current * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }

            ans = ans + sign * current;
            current = 0;
            if (i < s.length() && s.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            if (i < s.length() && s.charAt(i) == '+') {
                sign = 1;
                continue;
            }
            if (i < s.length() && s.charAt(i) == '(') {
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
                continue;
            }
            if (i < s.length() && s.charAt(i) == ')') {
                popped = (int) stack.pop();
                ans = ans * popped;
                popped = (int) stack.pop();
                ans = ans + popped;
                continue;
            }
        }
        return ans;
    }


    public static int strongPasswordConvertOperations(String s) {
        int missing = 0;
        missing = isRequiresDigit(s) + isRequiresUpperCase(s) + isRequiresLowerCase(s);
        int length = s.length();
        int zeroModuloSeq = 0;
        int oneModuloSeq = 0;
        int replace = 0;
        int lengthOfSequence = 0;
        int i = 2;
        while (i < s.length()) {
            lengthOfSequence = 2;
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                lengthOfSequence++;
                i++;
            }
            replace += lengthOfSequence / 3;
            if (lengthOfSequence >= 3 && lengthOfSequence % 3 == 0) zeroModuloSeq++;
            if (lengthOfSequence >= 3 && lengthOfSequence % 3 == 1) oneModuloSeq++;
            if (lengthOfSequence == 2) i++;

        }
        if (length < 6) return Math.max(6 - length, missing);
        if (length >= 6 && length <= 20) return Math.max(replace, missing);
        else {
            int delete = length - 20;
            replace -= Math.min(delete, zeroModuloSeq);
            replace -= Math.min(Math.max(delete - zeroModuloSeq, 0), oneModuloSeq * 2) / 2;
            replace -= Math.max(delete - zeroModuloSeq - 2 * oneModuloSeq, 0) / 3;
            return delete + Math.max(replace, missing);
        }
    }

    public static int isRequiresDigit(String s) {
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                flag = 0;
                break;

            }

        }
        return flag;
    }


    public static int isRequiresUpperCase(String s) {
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                flag = 0;
                break;

            }

        }
        return flag;
    }


    public static int isRequiresLowerCase(String s) {
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                flag = 0;
                break;

            }
        }
        return flag;
    }

    public static int countDigitOne(int n) {

        int count = 0;
        int x = n;
        int digit = 0;
        int sum = 0;
        while (x != 0) {
            count++;
            x = x / 10;
        }
        int numberarray[] = new int[count];
        x = n;
        int j = count - 1;
        while (x != 0) {
            digit = x % 10;
            numberarray[j] = digit;
            j--;
            x = x / 10;

        }

        int base = 1;
        int left = 0, right = 0;
        String leftString = "";
        String rightString = "";
        int k = 0;
        for (int i = count - 1; i >= 0; i--) {

            if (i > 0) {
                for (k = 0; k < i; k++) {
                    leftString += numberarray[k];
                }
                left = Integer.parseInt(leftString);
            }

            if (i < count - 1) {
                for (k = i + 1; k < count; k++) {
                    rightString += numberarray[k];
                }
                right = Integer.parseInt(rightString);
            }

            if (numberarray[i] == 1) sum += left * base + (right + 1);
            else if (numberarray[i] > 1) sum += (left + 1) * base;
            else sum += left * base;
            base *= 10;
            left = right = 0;
            leftString = rightString = "";

        }
        return sum;
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeArray(arr, low, mid, high);
    }

    private static void mergeArray(int[] arr, int low, int mid, int high) {

        int a1[] = new int[mid - low + 1];
        int a2[] = new int[high - mid];
        int k = 0;
        for (int i = low; i <= mid; i++) {
            a1[k] = arr[i];
            k++;
        }
        k = 0;
        for (int i = mid + 1; i <= high; i++) {
            a2[k] = arr[i];
            k++;
        }
        k = low;
        int x = 0;
        int y = 0;

        while (x <= a1.length - 1 && y <= a2.length - 1) {
            if (a1[x] <= a2[y]) {
                arr[k] = a1[x];
                x++;

            } else {
                arr[k] = a2[y];
                y++;

            }

            k++;
        }
        while (x <= a1.length - 1) {
            arr[k] = a1[x];
            x++;
            k++;
        }
        while (y <= a2.length - 1) {
            arr[k] = a2[y];
            y++;
            k++;
        }
    }

    public static int bestTimeToSellAndBuy3(int[] profits) {
        int leftProfits[] = new int[profits.length];
        int rightProfits[] = new int[profits.length];
        int leftmin = profits[0];
        int rightmax = profits[profits.length - 1];

        leftProfits[0] = 0;
        rightProfits[rightProfits.length - 1] = 0;
        for (int i = 1; i < profits.length; i++) {
            if (leftmin > profits[i]) leftmin = profits[i];
            leftProfits[i] = Math.max(leftProfits[i - 1], profits[i] - leftmin);
        }
        for (int i = profits.length - 2; i >= 0; i--) {
            if (rightmax < profits[i]) rightmax = profits[i];
            rightProfits[i] = Math.max(rightProfits[i + 1], rightmax - profits[i]);
        }
        int maxprofit = rightProfits[0];

        for (int i = 1; i < profits.length; i++) {
            maxprofit = Math.max(maxprofit, leftProfits[i - 1] + rightProfits[i]);
        }

        return maxprofit;
    }

    public static int bestTimeToSellAndBuy4(int k, int[] prices) {
        int tempMatrix[][] = new int[k + 1][prices.length];
        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i][0] = 0;
        }
        for (int i = 0; i < tempMatrix[0].length; i++) {
            tempMatrix[0][i] = 0;
        }
        int maxdiff = 0;
        int m = 0;
        for (int i = 1; i < tempMatrix.length; i++) {

            maxdiff = tempMatrix[i - 1][m] - prices[m];
            for (int j = 1; j < tempMatrix[0].length; j++) {
                if (tempMatrix[i - 1][m] - prices[m] > maxdiff) maxdiff = tempMatrix[i - 1][m] - prices[m];
                tempMatrix[i][j] = Math.max(tempMatrix[i][j - 1], prices[j] + maxdiff);
                m++;
            }
            m = 0;
        }
        return tempMatrix[tempMatrix.length - 1][tempMatrix[0].length - 1];
    }

    public static boolean isWordExist(char[][] board, String word) {
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(index)) {
                    if (searchWord(board, word, index, i, j, board.length, board[0].length)) return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(char[][] board, String word, int index, int i, int j, int rowlength, int coloumnlength) {
        if (index == word.length() - 1 && (word.charAt(index) == board[i][j])) return true;
        if ((word.charAt(index) != board[i][j])) return false;
        char c = board[i][j];
        board[i][j] = '*';
        boolean left, right, down, up;
        left = right = up = down = false;
        if (j > 0 && board[i][j - 1] != '*')
            left = searchWord(board, word, index + 1, i, j - 1, rowlength, coloumnlength);
        if (j < coloumnlength - 1 && board[i][j + 1] != '*')
            right = searchWord(board, word, index + 1, i, j + 1, rowlength, coloumnlength);
        if (i > 0 && board[i - 1][j] != '*')
            up = searchWord(board, word, index + 1, i - 1, j, rowlength, coloumnlength);
        if (i < rowlength - 1 && board[i + 1][j] != '*')
            down = searchWord(board, word, index + 1, i + 1, j, rowlength, coloumnlength);
        board[i][j] = c;
        return left || right || up || down;

    }

    public static List<String> findPathInRat(int[][] m, int n) {
        answers.clear();
        if (m[0][0] == 1) ratInMaze(m, n, answers, 0, 0, "");
        return answers;


    }

    private static void ratInMaze(int[][] m, int n, List<String> answers, int i, int j, String s) {
        int flag = 0;
        if (i == n - 1 && j == n - 1) {
            answers.add(s);
            return;
        }
        if (m[i][j] == 1) {
            flag = 1;
            m[i][j] = 0;
        }
        if (i < n - 1 && m[i + 1][j] == 1) ratInMaze(m, n, answers, i + 1, j, s + "D");
        if (j < n - 1 && m[i][j + 1] == 1) ratInMaze(m, n, answers, i, j + 1, s + "R");
        if (j > 0 && m[i][j - 1] == 1) ratInMaze(m, n, answers, i, j - 1, s + "L");
        if (i > 0 && m[i - 1][j] == 1) ratInMaze(m, n, answers, i - 1, j, s + "U");
        if (flag == 1) m[i][j] = 1;

    }

    public static List<String> generateParenthesisUsingBacktrackingwithCallByRefrence(int n) {
        answers.clear();
        s = "";
        makeParenthesisUsingBacktrackingWithCallByReference(n, answers, s, 0, 0);
        return answers;

    }

    private static void makeParenthesisUsingBacktrackingWithCallByReference(int n, List<String> answers, String s, int open, int closed) {
        if (open == closed && open == n) {
            answers.add(s);
            return;
        }
        String x = s;

        if (open < n) {
            s = s + "(";
            makeParenthesisUsingBacktrackingWithCallByReference(n, answers, s, open + 1, closed);
            s = x; //backtrack
        }
        if (open > closed) {
            s = s + ")";
            makeParenthesisUsingBacktrackingWithCallByReference(n, answers, s, open, closed + 1);
            s = x; //backtrack
        }
    }

    public static List<String> generateParenthesisUsingBacktrackingWithCallByValue(int n) {
        answers.clear();
        makeParenthesisUsingBacktrackingWithCallByValue(n, answers, "", 0, 0);
        return answers;
    }

    private static void makeParenthesisUsingBacktrackingWithCallByValue(int n, List<String> answers, String s, int open, int closed) {
        if (open == closed && open == n) {
            answers.add(s);
            return;
        }
        if (open < n) {
            makeParenthesisUsingBacktrackingWithCallByValue(n, answers, s + "(", open + 1, closed);
        }
        if (open > closed) makeParenthesisUsingBacktrackingWithCallByValue(n, answers, s + ")", open, closed + 1);
    }


    public static List<String> letterCombinations(String digits) {
        answers.clear();
        Map<Character, String> stringMap = new HashMap<>();
        stringMap.put('2', "abc");
        stringMap.put('3', "def");
        stringMap.put('4', "ghi");
        stringMap.put('5', "jkl");
        stringMap.put('6', "mno");
        stringMap.put('7', "pqrs");
        stringMap.put('8', "tuv");
        stringMap.put('9', "wxyz");
        String temp = "";
        lettercombo(digits, answers, 0, stringMap, temp);
        return answers;

    }

    private static void lettercombo(String digits, List<String> answers, int i, Map<Character, String> stringMap, String temp) {
        if (digits.length() == 0) return;
        if (i == digits.length()) {
            answers.add(temp);
            return;
        }
        char ch = digits.charAt(i);
        String w = stringMap.get(ch);
        for (int j = 0; j < w.length(); j++) {
            lettercombo(digits, answers, i + 1, stringMap, temp + w.charAt(j));
        }
    }


    public List<List<Integer>> combinationSumNew(int[] candidates, int target) {
        temp.clear();
        List<Integer> curr = new ArrayList<>();
        combination(candidates, target, curr, temp, 0);
        return temp;
    }

    public static void combination(int[] candidates, int target, List<Integer> curr, List<List<Integer>> temp, int idx) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> x = new ArrayList<>();
            x.addAll(curr);
            temp.add(x);
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            //if (target>0)  we can place this condition here as well
            curr.add(candidates[i]);
            combination(candidates, target - candidates[i], curr, temp, i);
            curr.remove(curr.size() - 1);
        }
    }


    public static int lengthOfLastWord(String s) {
        String[] temp = s.split(" ", 0);
        return temp[temp.length - 1].length();
    }


    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineHashMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!magazineHashMap.containsKey(magazine.charAt(i))) magazineHashMap.put(magazine.charAt(i), 1);
            else magazineHashMap.put(magazine.charAt(i), magazineHashMap.get(magazine.charAt(i)) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!magazineHashMap.containsKey(ransomNote.charAt(i)) || magazineHashMap.get(ransomNote.charAt(i)) <= 0)
                return false;
            else magazineHashMap.put(ransomNote.charAt(i), magazineHashMap.get(ransomNote.charAt(i)) - 1);
        }
        return true;
    }

    public static List<String> permutation(String s) {
        List<String> answer = new ArrayList<>();
        permute(s, 0, answer);
        Collections.sort(answer);
        return answer;
    }

    private static void permute(String s, int start, List<String> answer) {
        if (start == s.length() - 1) {
            answer.add(s);
            return;
        }
        Set<Character> permuteMap = new HashSet<>();
        for (int i = start; i <= s.length() - 1; i++) {
            if (!permuteMap.contains(s.charAt(i))) {
                permuteMap.add(s.charAt(i));
                s = swapChar(s, i, start);
                permute(s, start + 1, answer);

                s = swapChar(s, i, start);

            }
        }

    }

    private static String swapChar(String s, int i, int start) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[start];
        charArray[start] = temp;
        return String.valueOf(charArray);
    }


    public static String maxIntegerAfterKSwap(String num, int k) {
        maxString = num;
        kSwapMax(num, k, 0);
        return maxString;

    }

    private static void kSwapMax(String num, int k, int start) {

        if (k == 0 || start == num.length() - 1) return;
        int max = Character.getNumericValue(num.charAt(start));
        for (int i = start; i < num.length(); i++) {
            if (max < Character.getNumericValue(num.charAt(i))) max = Character.getNumericValue(num.charAt(i));
        }

        for (int i = start + 1; i < num.length(); i++) {
            if (Character.getNumericValue(num.charAt(i)) > Character.getNumericValue(num.charAt(start)) && Character.getNumericValue(num.charAt(i)) == max) {
                num = swapChar(num, i, start);
                for (int j = 0; j < num.length(); j++) {
                    if (Character.getNumericValue(num.charAt(j)) != Character.getNumericValue(maxString.charAt(j))) {
                        if (Character.getNumericValue(num.charAt(j)) > Character.getNumericValue(maxString.charAt(j)))
                            maxString = num;
                        break;
                    }
                }
                kSwapMax(num, k - 1, start + 1);
                num = swapChar(num, i, start);
            }

        }

        kSwapMax(num, k, start + 1);
    }

    public static List<Integer> increasingNumbersOfDigitN(int n) {
        if (n == 1) {
            List<Integer> x = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            return x;

        }
        List<Integer> answers = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        solveIncreasingNumbersOfDigitN(n, answers, x);
        return answers;

    }

    private static void solveIncreasingNumbersOfDigitN(int n, List<Integer> answers, List<Integer> x) {
        if (n == 0) {
            StringBuilder stringBuilder = new StringBuilder();

            for (Integer num : x) {
                stringBuilder.append(num);
            }

            answers.add(Integer.parseInt(stringBuilder.toString()));
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (x.isEmpty() || i > x.get(x.size() - 1)) {
                x.add(i);
                solveIncreasingNumbersOfDigitN(n - 1, answers, x);
                x.remove(x.size() - 1);
            }
        }
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> answers = new ArrayList<>();
        List<String> grayCodes = generateGrayCode(n);
        for (int i = 0; i < grayCodes.size(); i++) {
            String t = grayCodes.get(i);
            int b = 1;
            int decimal = 0;
            for (int j = t.length() - 1; j >= 0; j--) {
                decimal = decimal + b * Character.getNumericValue(t.charAt(j));
                b = b * 2;
            }
            answers.add(decimal);
        }
        return answers;
    }

    public static List<String> generateGrayCode(int n) {
        if (n == 1) {
            List<String> x = new ArrayList<>();
            x.add("0");
            x.add("1");
            return x;
        } else {
            List<String> x = generateGrayCode(n - 1);
            List<String> grayCodes = new ArrayList<>();
            for (int i = 0; i < x.size(); i++) {
                grayCodes.add("0" + x.get(i));
            }
            for (int i = x.size() - 1; i >= 0; i--)
                grayCodes.add("1" + x.get(i));
            return grayCodes;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> s = new ArrayList<>();
        findPaths(s, paths, root);
        //return  paths.stream().map(x->x.toString()).collect(Collectors.toList());
        List<String> answers = new ArrayList<>();
        String ans = "";
        for (List<Integer> path : paths) {
            ans = "";
            for (int num : path) {
                ans += num + "->";
            }
            answers.add(ans.substring(0, ans.length() - 2));
        }
        return answers;

    }

    private static void findPaths(List<Integer> s, List<List<Integer>> paths, TreeNode root) {
        if (root.left == null && root.right == null) {
            List<Integer> listtobeAdded = new ArrayList<>();
            listtobeAdded.addAll(s);
            listtobeAdded.add(root.data);
            paths.add(listtobeAdded);
            return;
        }
        if (root.left != null) {
            s.add(root.data);
            findPaths(s, paths, root.left);
            s.remove(s.size() - 1);
        }
        if (root.right != null) {
            s.add(root.data);
            findPaths(s, paths, root.right);
            s.remove(s.size() - 1);
        }
    }


    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        count = 0;
        List<Integer> answers = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        countNumbers(n, answers, x);
        System.out.println(answers);
        return count++;

    }

    private static void countNumbers(int n, List<Integer> answers, List<Integer> x) {
        if (n == 0) {

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (x.isEmpty() || (!x.contains(i) && (x.get(0) != 0))) {

                x.add(i);
                System.out.println(x);
                count++;
                countNumbers(n - 1, answers, x);
                x.remove(x.size() - 1);

            }
        }
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> answers = new ArrayList<>();
        t = "";
        generateIpAddress(answers, s, 0);
        return answers;
    }

    private static void generateIpAddress(List<String> answers, String s, int start) {
        int count = 0;
        for (int x = 0; x < t.length(); x++) {
            if (t.charAt(x) == '.') count++;
        }
        if (count == 4 && t.length() == 4 + s.length()) {
            answers.add(t.substring(1));
            return;
        }
//        if(count==4 && t.length()!=4+s.length())  //we can eliminate decision by this way as well ( same as 4574 line)
//            return;
        for (int i = start; i < s.length(); i++) {
            if ((s.substring(start, i + 1).length() == 2 && s.charAt(start) != '0') || ((s.substring(start, i + 1).length() == 3) && (Integer.parseInt(s.substring(start, i + 1)) <= 255) && s.charAt(start) != '0') || s.substring(start, i + 1).length() == 1) {
                if ((count == 3 && s.substring(start, i + 1).length() + t.length() == s.length() + 3) || count <= 2) {
                    t = t + "." + s.substring(start, i + 1);
                    generateIpAddress(answers, s, start + s.substring(start, i + 1).length());
                    t = t.substring(0, t.lastIndexOf('.'));
                }
            }
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if (root == null) return paths;
        findPathSum(paths, root, path, targetSum);
        return paths;

    }

    private static void findPathSum(List<List<Integer>> paths, TreeNode root, List<Integer> path, int targetSum) {
        if (root.left == null && root.right == null && targetSum - root.data == 0) {
            List<Integer> listtobeAdded = new ArrayList<>();
            listtobeAdded.addAll(path);
            listtobeAdded.add(root.data);
            paths.add(listtobeAdded);
            return;
        }


        if (root.left != null && !(root.left.left == null && root.left.right == null && (targetSum - root.left.data - root.data != 0))) {
            path.add(root.data);
            findPathSum(paths, root.left, path, targetSum - root.data);
            path.remove(path.size() - 1);
        }
        if (root.right != null && !(root.right.left == null && root.right.right == null && (targetSum - root.right.data - root.data != 0))) {
            path.add(root.data);
            findPathSum(paths, root.right, path, targetSum - root.data);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<String>> partitionPalindrome(String s) {
        List<List<String>> answers = new ArrayList<>();
        List<String> t = new ArrayList<>();
        partition(answers, s, t, 0);
        return answers;
    }

    private static void partition(List<List<String>> answers, String s, List<String> t, int start) {
        int count = 0;
        for (String k : t) {
            count = count + k.length();
        }
        if (count == s.length()) {
            List<String> listtobeAdded = new ArrayList<>();
            listtobeAdded.addAll(t);
            answers.add(listtobeAdded);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                t.add(s.substring(start, i + 1));
                partition(answers, s, t, start + s.substring(start, i + 1).length());
            }
        }
    }

    private static boolean isPalindrome(String string) {

        int i = 0, j = string.length() - 1;

        while (i < j) {


            if (string.charAt(i) != string.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> trees = new ArrayList<>();
        trees = createTree(1, n);
        return trees;

    }

    private static List<TreeNode> createTree(int start, int end) {


        if (treeMap.containsKey(start + "-" + end)) return treeMap.get(start + "-" + end);

        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }
        if (start == end) {
            TreeNode node = new TreeNode(start);
            treeNodes.add(node);
            treeMap.put(start + "-" + end, treeNodes);
            return treeNodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = createTree(start, i - 1);
            List<TreeNode> rightSubTrees = createTree(i + 1, end);
            for (TreeNode leftSubtree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftSubtree;
                    treeNode.right = rightSubTree;
                    treeNodes.add(treeNode);
                }

            }
        }
        treeMap.put(start + "-" + end, treeNodes);
        return treeNodes;
    }


    public static void xyz(int start, List<String> string, String nums) {
        System.out.println(String.valueOf(start) + "/" + string + "/" + nums);
        if (start == nums.length()) return;

        string.add(nums.substring(start, start + 1));
        xyz(start + 1, string, nums);
        string.remove(string.size() - 1);
        string.add(nums.substring(start + 1, nums.length()));
        xyz(start + string.size() - 1, string, nums);
        string.remove(string.size() - 1);

    }

    public static List<List<Integer>> findSubset(int[] nums) {
        subsetMap.clear();
        List<List<Integer>> subsets = new ArrayList<>();
        subsetgenerator(subsets, nums, 0, new ArrayList<>());
        return subsets;
    }

    private static void subsetgenerator(List<List<Integer>> subsets, int[] nums, int start, List<Integer> temp) {
        if (start == nums.length) {
            List<Integer> listtobeAdded = new ArrayList<>();
            listtobeAdded.addAll(temp);
            if (!subsetMap.containsKey(listtobeAdded)) {
                subsetMap.put(listtobeAdded, 1);
                subsets.add(listtobeAdded);
            }
            return;
        }
        subsetgenerator(subsets, nums, start + 1, temp);
        temp.add(nums[start]);
        subsetgenerator(subsets, nums, start + 1, temp);
        temp.remove(temp.size() - 1);
    }


    public static List<String> evaluateExpresssionContainingOperators(String nums, int target) {
        //base condition
        List<String> test = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        String res = stringBuilder.toString();
        ArrayList<StringBuffer> expression = new ArrayList<>();


        for (int i = 0; i < nums.length(); i++) {
            String x = nums.substring(0, i + 1);
            flag = 0;
            callFunction(new ArrayList<>(), new ArrayList<>(), Long.valueOf(0), Long.parseLong(x), x.length() - 1, nums, test, expression, Long.valueOf(0), target, Long.valueOf(0), x);

        }
        return test;
    }

    public static void callFunction(List<Integer> upperString, List<Integer> innerString, Long x, Long y, int start, String nums, List<String> test, ArrayList<StringBuffer> expression, Long expressionResult, int target, Long resultSoFar, String up) {


        if (x != 0 || (x == 0 && flag == 1)) {
            String expr = "";
            for (StringBuffer sb : expression)
                expr = expr + sb.toString();


            System.out.println("(" + y + "," + x + "," + expr + "," + expressionResult + "," + start + ")");

        }


        if (x == 0 && flag == 0) {
            flag = 1;
            expression.clear();
            expression.add(new StringBuffer(String.valueOf(up)));

            expressionResult = Long.parseLong(expression.get(0).toString());
            resultSoFar = expressionResult;
        }


        if ((expression.get(expression.size() - 1).toString().length() > 1 && expression.get(expression.size() - 1).toString().charAt(0) == '0'))
            return;


        //  base condition

        if (expressionResult >= Integer.MIN_VALUE && expressionResult <= Integer.MAX_VALUE && expressionResult.intValue() == target && start == nums.length() - 1) {
            String expr = "";
            for (StringBuffer sb : expression)
                expr += sb.toString();
            test.add(expr);
            return;
        }


        for (int i = start + 1; i < nums.length(); i++) {

            //for addition
            String g = "";
            for (int k = start + 1; k <= i; k++)
                g += nums.charAt(k);
            if (!innerString.isEmpty()) y = Long.valueOf(innerString.get(innerString.size() - 1));
            innerString.add(Integer.parseInt(g));
            x = Long.valueOf(innerString.get(innerString.size() - 1));
            expression.add(new StringBuffer("+"));
            // position++;
            expression.add(new StringBuffer(g));

            expressionResult += Long.parseLong(g);
            resultSoFar = expressionResult;

            callFunction(upperString, innerString, x, y, start + g.length(), nums, test, expression, expressionResult, target, resultSoFar, up);
            innerString.remove(innerString.size() - 1);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);
            expressionResult = expressionResult - Long.parseLong(g);
            resultSoFar = expressionResult;


            //for substraction
            g = "";
            for (int k = start + 1; k <= i; k++)
                g += nums.charAt(k);
            if (!innerString.isEmpty()) y = Long.valueOf(innerString.get(innerString.size() - 1));
            innerString.add(Integer.parseInt(g));
            x = Long.valueOf(innerString.get(innerString.size() - 1));
            expression.add(new StringBuffer("-"));
            // position++;
            expression.add(new StringBuffer(g));
            expressionResult -= Long.parseLong(g);
            resultSoFar = expressionResult;

            callFunction(upperString, innerString, x, y, start + g.length(), nums, test, expression, expressionResult, target, resultSoFar, up);
            innerString.remove(innerString.size() - 1);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);
            expressionResult = expressionResult + Long.parseLong(g);
            resultSoFar = expressionResult;


// for multiplication
            g = "";
            long kk;
            for (int k = start + 1; k <= i; k++)
                g += nums.charAt(k);
            if (!innerString.isEmpty()) y = Long.valueOf(innerString.get(innerString.size() - 1));
            innerString.add(Integer.parseInt(g));
            x = Long.valueOf(innerString.get(innerString.size() - 1));
            expression.add(new StringBuffer("*"));
            // position++;
            expression.add(new StringBuffer(g));
            kk = expressionResult;
            //  expressionResult= (long) Expression.evaluateInfix(expression.toString());


            //if prev operator is nothing
            if (expression.size() == 3) {
                expressionResult = x * y;
            }


            //if prev operator is '+'
            else if (expression.size() > 4 && expression.get(expression.size() - 4).toString().equals("+")) {
                expressionResult = x * y + resultSoFar - y;
            }

            //if prev operator is '-'
            else if (expression.size() > 4 && expression.get(expression.size() - 4).toString().equals("-")) {
                expressionResult = -x * y + resultSoFar + y;
            }

            // if prev is '*'
            else {
                int index1 = 0;
                for (int t = expression.size() - 1; t >= 0; t--) {
                    if (expression.get(t).toString().equals("+") || expression.get(t).toString().equals("-")) {
                        index1 = t + 2;
                        break;
                    }
                }
                Long tt = Long.valueOf(1);
                int index2 = expression.size() - 2;
                int index3 = index1 - 2;
                if (index3 > 0) {
                    for (int t = index1 - 1; t < index2; t = t + 2)
                        tt = tt * Long.parseLong(String.valueOf(expression.get(t)));
                    if (expression.get(index3).toString().equals("+")) expressionResult = resultSoFar - tt + tt * x;
                    else expressionResult = resultSoFar + tt - tt * x;

                } else {
                    expressionResult = resultSoFar * x;
                }
            }

            resultSoFar = expressionResult;


            callFunction(upperString, innerString, x, y, start + g.length(), nums, test, expression, expressionResult, target, resultSoFar, up);
            innerString.remove(innerString.size() - 1);
            expression.remove(expression.size() - 1);
            expression.remove(expression.size() - 1);
            expressionResult = kk;
            resultSoFar = expressionResult;
        }
    }


    public static List<List<Integer>> permuteIntegerArray(int[] nums) {
        integerPermuteMap.clear();
        List<List<Integer>> answer = new ArrayList<>();
        permuteArray(answer, nums, 0);
        return answer;

    }

    private static void permuteArray(List<List<Integer>> answer, int[] nums, int start) {

        //base condition
        if (start == nums.length - 1) {
            ArrayList t = new ArrayList();
            for (int n : nums)
                t.add(n);
            if (!integerPermuteMap.containsKey(t)) {
                integerPermuteMap.put(t, 1);


                answer.add(t);

            }
        }
        int var = 0;
        for (int i = start; i < nums.length; i++) {
            //swap
            var = nums[start];
            nums[start] = nums[i];
            nums[i] = var;
            permuteArray(answer, nums, start + 1);
            //swap
            var = nums[start];
            nums[start] = nums[i];
            nums[i] = var;
        }
    }


    public static List<List<Integer>> findSubsetwithDup(int[] nums) {
        subsetMap.clear();
        List<List<Integer>> subsets = new ArrayList<>();
        subsetgeneratorwithDup(subsets, nums, 0, new ArrayList<>());
        return subsets;
    }

    private static void subsetgeneratorwithDup(List<List<Integer>> subsets, int[] nums, int start, List<Integer> temp) {
        if (start == nums.length) {
            List<Integer> listtobeAdded = new ArrayList<>();
            listtobeAdded.addAll(temp);
            Collections.sort(listtobeAdded);
            if (!subsetMap.containsKey(listtobeAdded)) {
                subsetMap.put(listtobeAdded, 1);
                subsets.add(listtobeAdded);
            }
            return;
        }
        subsetgeneratorwithDup(subsets, nums, start + 1, temp);
        temp.add(nums[start]);
        subsetgeneratorwithDup(subsets, nums, start + 1, temp);
        temp.remove(temp.size() - 1);
    }


    public static List<List<Integer>> combinationSumNewWithDup(int[] candidates, int target) {
        temp.clear();
        combinationSumMap.clear();
        if (candidates.length == 1 && candidates[0] == target) {
            temp.add(Arrays.stream(candidates).boxed().collect(Collectors.toList()));
            return temp;
        }
        if (candidates.length == 1 && candidates[0] != target) return temp;

        List<Integer> curr = new ArrayList<>();
        combinationwithDup(candidates, target, curr, temp, -1);
        return temp;
    }

    public static void combinationwithDup(int[] candidates, int target, List<Integer> curr, List<List<Integer>> temp, int idx) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> x = new ArrayList<>();
            x.addAll(curr);
            Collections.sort(x);
            if (!combinationSumMap.containsKey(x)) {
                combinationSumMap.put(x, 1);
                temp.add(x);
            }
            return;
        }

        for (int i = idx + 1; i < candidates.length; i++) {

            //if (target>0)  we can place this condition here as well
            if (i == idx + 1 || i > 0 && candidates[i] != candidates[i - 1]) {
                curr.add(candidates[i]);
                combinationwithDup(candidates, target - candidates[i], curr, temp, i);
                curr.remove(curr.size() - 1);
            }

        }
    }


    public static List<List<Integer>> combine(int n, int k) {
        combineMap.clear();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinations(ans, n, k, 0, curr);
        return ans;
    }

    public static void combinations(List<List<Integer>> ans, int n, int k, int start, List<Integer> curr) {

        if (k == 0) {
            List<Integer> x = new ArrayList<>();
            x.addAll(curr);
            Collections.sort(x);
            if (!combineMap.containsKey(x)) {
                combineMap.put(x, 1);
                ans.add(x);
            }
            return;
        }

        for (int i = start + 1; i <= n; i++) {

            curr.add(i);
            combinations(ans, n, k - 1, i, curr);
            curr.remove(curr.size() - 1);
        }
    }


    //just for understanding

    public static int findTargetSumWays(int[] nums, int target) {
        flag = 0;
        count = 0;
        ArrayList<StringBuffer> expression = new ArrayList<>();
        callfindTargetSumWays(nums, expression, 0, target, 0);
        return flag;


    }

    private static void callfindTargetSumWays(int[] nums, ArrayList<StringBuffer> expression, int resultsofar, int target, int start) {


        if (start == nums.length && resultsofar == target) {
            flag++;
            return;
        }
        if (start == nums.length && resultsofar != target) return;


        // for addition

        expression.add(new StringBuffer("+"));
        expression.add(new StringBuffer(String.valueOf(nums[start])));
        if (expression.size() == 2 && expression.get(0).toString().equals("+"))
            resultsofar = Integer.parseInt(expression.get(1).toString());
        else resultsofar = resultsofar + Integer.parseInt(expression.get(expression.size() - 1).toString());
        callfindTargetSumWays(nums, expression, resultsofar, target, start + 1);
        count = 1;
        resultsofar = resultsofar - Integer.parseInt(expression.get(expression.size() - 1).toString());
        expression.remove(expression.size() - 1);
        expression.remove(expression.size() - 1);

        // for substraction
        expression.add(new StringBuffer("-"));
        expression.add(new StringBuffer(String.valueOf(nums[start])));
        if (expression.size() == 2 && expression.get(0).toString().equals("-"))
            resultsofar = -Integer.parseInt(expression.get(1).toString());
        else resultsofar = resultsofar - Integer.parseInt(expression.get(expression.size() - 1).toString());
        callfindTargetSumWays(nums, expression, resultsofar, target, start + 1);
        resultsofar = resultsofar + Integer.parseInt(expression.get(expression.size() - 1).toString());
        expression.remove(expression.size() - 1);
        expression.remove(expression.size() - 1);

    }


    //another implementation of same method without TLE

    public static int findTargetSumWay(int[] nums, int target) {
        flag = 0;
        callFunction(nums, target, 0, 0);
        return flag;
    }

    private static void callFunction(int[] nums, int target, int index, int currentSum) {
        if (index == nums.length) {
            if (currentSum == target) {
                flag++;
            }
            return;
        }

        //for addition
        currentSum += nums[index];
        callFunction(nums, target, index + 1, currentSum);
        currentSum -= nums[index];

        //for substraction
        currentSum -= nums[index];
        callFunction(nums, target, index + 1, currentSum);
        currentSum += nums[index];
    }


    public static boolean isAdditiveNumber(String num) {
        flag = 0;
        call = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            if (flag == 1) return true;
            call = 0;
            String firstnumber = num.substring(0, i + 1);
            backtrack(num, firstnumber, "", Long.parseLong(firstnumber), Long.parseLong("0"), Long.parseLong(firstnumber));
        }

        return false;

    }

    public static void backtrack(String num, String firstnumber, String secondnumber, Long n1, Long n2, Long sums) {


        if ((firstnumber.length() > 1 && firstnumber.charAt(0) == '0') || (secondnumber.length() > 1 && secondnumber.charAt(0) == '0'))
            return;


        if (flag == 1) return;

        //base condition
        if (call == 1) {
            String sumsoFar = String.valueOf(sums);
            int l = firstnumber.length() + (secondnumber).length();
            if (num.length() - l < sumsoFar.length()) return;
            else {
                String ans = num.substring(l, l + sumsoFar.length());
                int start = 0;
                if (!ans.equals(sumsoFar) || (ans.length() > 1 && ans.charAt(0) == '0')) return;
                else {
                    int x = 0;
                    x = firstnumber.length() + secondnumber.length();
                    while (ans.equals(sumsoFar)) {
                        x = x + sumsoFar.length();
                        if (x >= num.length()) {
                            flag = 1;
                            return;
                        }
                        n1 = n2;
                        n2 = sums;
                        firstnumber = secondnumber;
                        secondnumber = ans;
                        sums = n1 + n2;
                        sumsoFar = String.valueOf(sums);
                        l = l + secondnumber.length();
                        if (num.length() - l < sumsoFar.length()) return;
                        ans = num.substring(l, l + sumsoFar.length());


                    }
                    return;
                }
            }
        }

        n1 = Long.parseLong(firstnumber);

        for (int i = firstnumber.length(); i < num.length(); i++) {


            call = 1;
            secondnumber = num.substring(firstnumber.length(), i + 1);
            n2 = Long.parseLong(secondnumber);
            sums = n1 + n2;
            backtrack(num, firstnumber, secondnumber, n1, n2, sums);
            if (flag == 1) break;
            sums = n1;
            n2 = Long.parseLong("0");
            secondnumber = "";

        }
    }


    //just for understanding

    public static int countBeautifulArrangement(int n) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;

        integerPermuteMap.clear();
        flag = 0;
        List<List<Integer>> answer = new ArrayList<>();
        callArrangementBackTrack(answer, nums, 0);
        System.out.println(answer);
        return flag;
    }

    private static void callArrangementBackTrack(List<List<Integer>> answer, int[] nums, int start) {

        //base condition
        if (start == nums.length - 1) {
            ArrayList t = new ArrayList();
            for (int n : nums)
                t.add(n);

            if (!integerPermuteMap.containsKey(t) && isConditionSatisfied(t)) {

                integerPermuteMap.put(t, 1);


                answer.add(t);
                flag++;

            }
        }
        int var = 0;
        for (int i = start; i < nums.length; i++) {
            //swap
            var = nums[start];
            nums[start] = nums[i];
            nums[i] = var;
            callArrangementBackTrack(answer, nums, start + 1);
            //swap
            var = nums[start];
            nums[start] = nums[i];
            nums[i] = var;
        }
    }

    private static boolean isConditionSatisfied(ArrayList t) {
        int i = 1;
        for (Object integer : t) {
            String d = integer.toString();
            int k = Integer.parseInt(d);
            if (k % i != 0 && i % k != 0) return false;
            i++;

        }
        return true;
    }


    public static int countBeautifulArrangementOpt(int n) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i + 1;

        integerPermuteMap.clear();
        flag = 0;
        List<List<Integer>> answer = new ArrayList<>();
        callArrangementBackTrackOpt(answer, nums, 0);
        System.out.println(answer);
        return flag;
    }

    private static void callArrangementBackTrackOpt(List<List<Integer>> answer, int[] nums, int start) {

        if (start == nums.length && (((start) % nums[start - 1] == 0) || (nums[start - 1] % (start) == 0))) {
            ArrayList t = new ArrayList();
            for (int n : nums)
                t.add(n);

            if (!integerPermuteMap.containsKey(t)) {
                integerPermuteMap.put(t, 1);
                answer.add(t);
                flag++;
            }
            return;
        } else if (start > 0 && ((start) % nums[start - 1] != 0) && (nums[start - 1] % (start) != 0)) return;
        int var = 0;
        for (int i = start; i < nums.length; i++) {
            //swap
            var = nums[start];
            nums[start] = nums[i];
            nums[i] = var;
            //call function
            callArrangementBackTrackOpt(answer, nums, start + 1);
            //backtrack
            var = nums[start];
            nums[start] = nums[i];
            nums[i] = var;
        }

    }


    public static String addBinary(String a, String b) {
        int num1[] = new int[Math.max(a.length(), b.length())];
        int num2[] = new int[Math.max(a.length(), b.length())];
        int x = 0;

        if (a.length() < b.length()) {
            for (int i = 0; i < b.length(); i++) {
                num2[i] = Character.getNumericValue(b.charAt(i));
                if (i < (b.length() - a.length())) {
                    num1[i] = 0;
                } else {
                    num1[i] = Character.getNumericValue(a.charAt(x));
                    x++;
                }
            }
        }
        x = 0;

        if (b.length() < a.length()) {
            for (int i = 0; i < a.length(); i++) {
                num1[i] = Character.getNumericValue(a.charAt(i));
                if (i < (a.length() - b.length())) {
                    num2[i] = 0;
                } else {
                    num2[i] = Character.getNumericValue(b.charAt(x));
                    x++;
                }
            }
        }

        if (a.length() == b.length()) {
            for (int i = 0; i < a.length(); i++) {
                num1[i] = Character.getNumericValue(a.charAt(i));
                num2[i] = Character.getNumericValue(b.charAt(i));
            }
        }
        int answer[] = new int[num1.length + 1];
        int carry[] = new int[num1.length + 1];
        carry[carry.length - 1] = 0;
        for (int i = answer.length - 1; i >= 1; i--) {

            if (carry[i] == 0) {
                if (num1[i - 1] == 0 && num2[i - 1] == 0) {
                    answer[i] = 0;
                    carry[i - 1] = 0;
                } else if (num1[i - 1] == 1 && num2[i - 1] == 0) {
                    answer[i] = 1;
                    carry[i - 1] = 0;
                } else if (num1[i - 1] == 0 && num2[i - 1] == 1) {
                    answer[i] = 1;
                    carry[i - 1] = 0;
                } else {
                    answer[i] = 0;
                    carry[i - 1] = 1;
                }

            } else {
                if (num1[i - 1] == 0 && num2[i - 1] == 0) {
                    answer[i] = 1;
                    carry[i - 1] = 0;
                } else if (num1[i - 1] == 1 && num2[i - 1] == 0) {
                    answer[i] = 0;
                    carry[i - 1] = 1;
                } else if (num1[i - 1] == 0 && num2[i - 1] == 1) {
                    answer[i] = 0;
                    carry[i - 1] = 1;
                } else {
                    answer[i] = 1;
                    carry[i - 1] = 1;
                }
            }
        }


        answer[0] = carry[0];

        if (answer[0] == 0) {

            return IntStream.of(answer).mapToObj(String::valueOf).collect(Collectors.joining()).substring(1);
        }

        return IntStream.of(answer).mapToObj(String::valueOf).collect(Collectors.joining());

    }


    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> stringHashSet = new HashSet<>();
        HashSet<String> dnaLists = new HashSet<>();
        int i = 0;
        while (i <= s.length() - 10) {

            if (!stringHashSet.contains(s.substring(i, i + 10))) {
                stringHashSet.add(s.substring(i, i + 10));

            } else dnaLists.add(s.substring(i, i + 10));
            i++;

        }

        ArrayList<String> answer = new ArrayList<>(dnaLists);
        return answer;


    }


    public static int[] plusOne(int[] digits) {

        int ans[] = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            ans[i] = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
        }
        if (carry == 0) return ans;
        int ansnew[] = new int[ans.length + 1];
        ansnew[0] = 1;
        int j = 0;
        for (int i = 1; i < ansnew.length; i++) {
            ansnew[i] = ans[j];
            j++;
        }
        return ansnew;
    }


    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;

        }
        if (nums[mid] < target) return mid + 1;
        else return mid;

    }


    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        int mid = 0;
        long res = 0;


        while (start <= end) {
            mid = start + (end - start) / 2;
            res = (long) mid * mid;
            if (res == x) return mid;
            else if (res > x) end = mid - 1;
            else start = mid + 1;

        }
        if (res > x) return mid - 1;
        else return mid;

    }

    public static int singleNumberWithoutSpace(int[] nums) {

        //using XOR Operator
        int xor = 0;

        for (int i = 0; i < nums.length; i++)
            xor = xor ^ nums[i];
        return xor;

    }


    public boolean isValidPalindrome(String s) {
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                if (Character.isUpperCase(s.charAt(i))) newString = newString + Character.toLowerCase(s.charAt(i));
                else newString = newString + s.charAt(i);
            }
        }

        return isPalindrome(newString);
    }


    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        Map<Integer, String> lessThan10 = new HashMap<>();
        lessThan10.put(0, "");
        lessThan10.put(1, "One");
        lessThan10.put(2, "Two");
        lessThan10.put(3, "Three");
        lessThan10.put(4, "Four");
        lessThan10.put(5, "Five");
        lessThan10.put(6, "Six");
        lessThan10.put(7, "Seven");
        lessThan10.put(8, "Eight");
        lessThan10.put(9, "Nine");


        Map<Integer, String> lessThan20 = new HashMap<>();

        lessThan20.put(10, "Ten");
        lessThan20.put(11, "Eleven");
        lessThan20.put(12, "Twelve");
        lessThan20.put(13, "Thirteen");
        lessThan20.put(14, "Fourteen");
        lessThan20.put(15, "Fifteen");
        lessThan20.put(16, "Sixteen");
        lessThan20.put(17, "Seventeen");
        lessThan20.put(18, "Eighteen");
        lessThan20.put(19, "Nineteen");


        Map<Integer, String> tensPlace = new HashMap<>();
        tensPlace.put(0, "");
        tensPlace.put(2, "Twenty");
        tensPlace.put(3, "Thirty");
        tensPlace.put(4, "Forty");
        tensPlace.put(5, "Fifty");
        tensPlace.put(6, "Sixty");
        tensPlace.put(7, "Seventy");
        tensPlace.put(8, "Eighty");
        tensPlace.put(9, "Ninety");


        String inputString = String.valueOf(num);
        int start = inputString.length() - 3;
        int end = inputString.length() - 1;
        int count = 0;
        String words = "";
        while (start >= 0 || end >= 0) {
            if (count == 0) {

                if ((start == -1 && end >= 0) || (start >= 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) != '0')) {
                    if (Character.getNumericValue(inputString.charAt(start + 1)) != 1)
//                        words = tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1)))+" "+


                        words = tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end)));

                    else
                        words = lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end)));

                } else if ((start == -2 && end >= 0) || (start > 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) == '0' && inputString.charAt(end) != '0')) {
                    words = lessThan10.get(Character.getNumericValue(inputString.charAt(end)));

                } else {
                    if (!inputString.substring(start, end + 1).equals("000")) {

                        if (inputString.charAt(start + 1) != '1')

                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end)));

                        else
                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end)));


                    }
                }
                count++;

            } else if (count == 1) {
                //for thousand
                if ((start == -1 && end >= 0) || (start >= 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) != '0')) {
                    if (Character.getNumericValue(inputString.charAt(start + 1)) != 1)

                        words = tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Thousand " + words;
                    else
                        words = lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end))) + " Thousand " + words;


                } else if ((start == -2 && end >= 0) || (start >= 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) == '0' && inputString.charAt(end) != '0')) {
                    words = lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Thousand " + words;

                } else {
                    if (!inputString.substring(start, end + 1).equals("000")) {

                        if (inputString.charAt(start + 1) != '1')

                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Thousand " + words;

                        else
                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end))) + " Thousand " + words;


                    }
                }
                count++;
            } else if (count == 2) {
                //for million


                if ((start == -1 && end >= 0) || (start > 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) != '0')) {
                    if (Character.getNumericValue(inputString.charAt(start + 1)) != 1)

                        words = tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Million " + words;
                    else
                        words = lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end))) + " Million " + words;


                } else if ((start == -2 && end >= 0) || (start >= 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) == '0' && inputString.charAt(end) != '0')) {
                    words = lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Million " + words;

                } else {
                    if (!inputString.substring(start, end + 1).equals("000")) {
                        if (inputString.charAt(start + 1) != '1')

                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Million " + words;

                        else
                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end))) + " Million " + words;


                    }
                }
                count++;
            } else if (count == 3) {
                //for billion


                if ((start == -1 && end >= 0) || (start >= 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) != '0')) {

                    if (Character.getNumericValue(inputString.charAt(start + 1)) != 1)
                        words = tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Billion " + words;

                    else
                        words = lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end))) + " Billion " + words;


                } else if ((start == -2 && end >= 0) || (start >= 0 && inputString.charAt(start) == '0' && inputString.charAt(start + 1) == '0' && inputString.charAt(end) != '0')) {
                    words = lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Billion " + words;

                } else {
                    if (!inputString.substring(start, end + 1).equals("000")) {
                        if (inputString.charAt(start + 1) != '1')

                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + tensPlace.get(Character.getNumericValue(inputString.charAt(start + 1))) + " " + lessThan10.get(Character.getNumericValue(inputString.charAt(end))) + " Billion " + words;

                        else
                            words = lessThan10.get(Character.getNumericValue(inputString.charAt(start))) + " Hundred " + lessThan20.get(Character.getNumericValue(inputString.charAt(start + 1)) * 10 + Character.getNumericValue(inputString.charAt(end))) + " Billion " + words;


                    }
                }
                count++;
            }


            start = start - 3;
            end = end - 3;
        }


        return words.trim().replaceAll("\\s{2,}", " ");

    }

    public static Node insertionSortList(Node head) {
        Node x = head.next;
        Node xprev = head;
        while (x != null) {
            Node k = x.next;

            Node temp = head;
            Node prev = null;
            while (temp != x && temp.data <= x.data) {
                prev = temp;
                temp = temp.next;
            }
            if (temp.data > x.data) {
                xprev.next = x.next;
                x.next = temp;
                if (prev != null) {
                    prev.next = x;
                } else
                    head = x;
                x = k;

            } else {
                xprev = x;
                x = k;

            }
        }
        return head;

    }

    public static void rotateArrayWithNewArray(int[] nums, int k) {
        int[] numnew = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numnew[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numnew[i];
        }

    }

    public static void rotateArrayWithConstantSpace(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        k = k % nums.length;
        int temp;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = 0;
        j = k - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        i = k;
        j = nums.length - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static boolean isIsomorphic(String s, String t) {
        String s1 = "";
        Map<Character, Character> map = new HashMap<>();
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !map.containsValue(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));

            }
            s1 = s1 + map.get(s.charAt(i));

        }
        if (s1.equals(t))
            return true;
        else
            return false;

    }

    public static int countPrimes(int n) {
        int count = 0;
        int flag = 0;
        for (int i = 2; i < n; i++) {
            flag = 0;
            for (int j = 2; j <= (i / 2); j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;

                }
            }
            if (flag == 0)
                count++;
        }
        return count;

    }

    public static int countPrimesUsingSieveOfEratosthenes(int n) {
        if (n == 0 || n == 1)
            return 0;
        int count = 0;
        int arr[] = new int[n];
        int val = 2;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                int j = 2;
                int x = 1;
                x = i * j;
                while (x <= n - 1) {
                    arr[x] = 0;
                    j++;
                    x = i * j;
                }
            }
        }
        return count;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }

        return ans;
    }

    public static String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        String str = "";
        while (i <= word1.length() - 1 && j <= word2.length() - 1) {
            str = str + word1.charAt(i) + word2.charAt(j);
            i++;
            j++;
        }
        if (i <= word1.length() - 1) {
            while (i <= word1.length() - 1) {
                str = str + word1.charAt(i);
                i++;
            }
        }
        if (j <= word2.length() - 1) {
            while (j <= word2.length() - 1) {
                str = str + word2.charAt(j);
                j++;
            }
        }
        return str;

    }


    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int x = 1;
        for (int i = 0; i < prefix.length; i++) {
            x = x * nums[i];
            prefix[i] = x;
        }
        x = 1;
        for (int i = postfix.length - 1; i >= 0; i--) {
            x = x * nums[i];
            postfix[i] = x;
        }
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                ans[i] = postfix[i + 1];
            } else if (i == nums.length - 1)
                ans[i] = prefix[i - 1];
            else {
                ans[i] = prefix[i - 1] * postfix[i + 1];
            }
        }
        return ans;


    }

    public static int[] productExceptSelfWithoutSpace(int[] nums) {
        int ans[] = new int[nums.length];
        int x = 1;
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            x = x * nums[i - 1];
            ans[i] = x;
        }
        x = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            x = x * nums[i + 1];
            ans[i] = x * ans[i];
        }
        return ans;
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ay2 - ay1) * (ax2 - ax1);
        int area2 = (by2 - by1) * (bx2 - bx1);
        int xoverlap = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int yoverlap = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlap = 0;
        if (xoverlap > 0 && yoverlap > 0)
            overlap = xoverlap * yoverlap;
        return area1 + area2 - overlap;
    }

    public  static boolean isUgly(int n) {
        if(n<0)
            return false;
        int x=n;
        while(x%2==0)
        {
            x=x/2;
        }
        while(x%3==0)
        {
            x=x/3;
        }
        while(x%5==0)
        {
            x=x/5;
        }
        if(x==1)
            return true;
        else
            return false;

    }

    public  static int trailingZeroesInFactorial(int n) {
        int count=0;
        while(n/5!=0)
        {
            count+=n/5;
            n=n/5;
        }
        return count;

    }

    public static boolean areTwoStringsAnagram(String s, String t) {
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i =0; i<s.length(); i++)
        {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        for(int i =0; i<t.length(); i++)
        {
            if(!map.containsKey(t.charAt(i)))
                return false;
            else
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
        }

        for (Map.Entry<Character, Integer> set :
                map.entrySet()) {
            if (set.getValue() != 0)
                return false;

            }
            return true;
        }

    public static int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;

        do
        {

            slow= nums[slow];
            fast= nums[nums[fast]];
        } while(fast!=slow );
        slow=0;
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }

        return fast;
    }




    public static boolean isPowerOfTwo(int n) {
        if(n<0)
            return false;

        double logBase2 = Math.log(n)/Math.log(2);
        double logResultRounded = Math.round(logBase2 * 1e10) / 1e10;
        if(Math.floor(logResultRounded)==Math.ceil(logResultRounded))
            return true;
        else
            return false;
    }


    public static void moveZeroes(int[] nums) {
        if (nums.length > 1) {
            int left = 0;
            int right = 1;
            while (right <= nums.length - 1 && left <= nums.length - 1) {
                if (nums[left] != 0)
                    left++;
                if (nums[right] == 0)
                    right++;
                if ((right <= nums.length - 1 && left <= nums.length - 1) && nums[left] != 0 && nums[right] != 0) {

                    right++;
                }
                if ((right <= nums.length - 1 && left <= nums.length - 1) && nums[right] != 0 && nums[left] == 0) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                    right++;
                }
            }
        }
    }

        public static String getHint(String secret, String guess) {
        int bull=0;
        int cow=0;
        int secretFreq[] = new int[10];
        int guessFreq[] = new int[10];
        for(int i =0; i< secret.length(); i++)
        {
            if(secret.charAt(i) == guess.charAt(i))
                bull++;
            else
            {
                secretFreq[Character.getNumericValue(secret.charAt(i))] ++;
                guessFreq[Character.getNumericValue(guess.charAt(i))]++;
            }
        }
        for(int i =0; i<secretFreq.length; i++)
        {
            cow= cow+Math.min(secretFreq[i], guessFreq[i]);
        }

        return bull+"A"+cow+"B";

        }

    public static String reverseVowels(String s) {
        char[] word= s.toCharArray();
        int i =0, j = s.length()-1;
        while (i<j)
        {
            if(!isVowel(s.charAt(i)))
                i++;
            if(!isVowel(s.charAt(j)))
                j++;
            if((i<j) && (isVowel(s.charAt(i)) && isVowel(s.charAt(j))))
            {
                char temp= word[j];
                word[j]= word[i];
                word[i]=temp;
                i++;
                j--;
            }
        }
        return new String(word);


    }


     private static boolean isVowel(char c)
     {
         if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
             return true;
         else
             return false;
     }


//saddle point in matrix
    public  static List<Integer> luckyNumbers (int[][] matrix) {
        int [][] flag= new int[matrix.length][matrix[0].length];
        List<Integer> ans = new ArrayList<>();
        int min, max,  minIndex, maxIndex;
        for(int i =0; i<matrix.length; i++)
        {
            for(int j =0; j<matrix[0].length; j++)
            {
                if(flag[i][j]==0)
                {

                     min = matrix[i][0];
                     minIndex=j;
                     for(int k =1; k<matrix[0].length; k++) {
                         if(min>matrix[i][k]) {
                             min = matrix[i][k];
                             minIndex = k;
                         }
                     }


                        for(int k=0; k<matrix[0].length; k++)
                        {
                            if(k!=minIndex)
                                flag[i][k]=1;
                        }


                    max = matrix[0][j];
                    maxIndex=i;

                    for(int k =1; k<matrix.length; k++) {
                       if(max<matrix[k][j])
                       {
                           maxIndex= k;
                           max= matrix[k][j];
                       }
                    }


                        for(int k=0; k<matrix.length; k++)
                        {
                            if(k!=maxIndex)
                                flag[k][j]=1;
                        }

                     if(max== min && min== matrix[i][j])
                        ans.add(max);

                }
            }

        }
        return ans;

    }

    public static int arrangeCoins(int n) {

        if(n==1)
            return 1;

        int x= (int)Math.ceil((double)n/2);
        long sum=0;
        int i =1;
        while( i<=x)
        {


            sum = sum+i;

            if(sum>n )
            {
                return i-1;
            }
            i++;

        }

            return i-1;

    }

    public  static  int compress(char[] chars) {
        int count=1;
        String str="";
        for(int i =1; i< chars.length; i++)
        {
            if(chars[i]==chars[i-1])
                count++;
            else {
                if(count!=1)
                str=str+String.valueOf(chars[i-1])+count;
                else
                    str= str+String.valueOf(chars[i-1]);
                count=1;
            }
        }
        if(count==1)
            str= str+chars[chars.length-1];
        else
            str= str+ chars[chars.length-1]+count;
        for(int i =0; i<str.length(); i++)
            chars[i]= str.charAt(i);
        return str.length();

    }
    public static boolean isPowerOfThree(int n) {
        double x=   Math.log(n);
        double y=   Math.log(3);
        double z = x/y;
        double w = z - (int) z;
        return Math.abs(z - Math.round(z)) < 1e-10;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> integerSet= new HashSet<>();
         for(int i =0; i<nums1.length; i++)
         {
             for(int j =0; j< nums2.length; j++)
             {
                 if(nums1[i]==nums2[j])
                     integerSet.add(nums1[i]);
             }
         }
         int ans[] = new int[integerSet.size()];
         int j=0;
         for (Integer i: integerSet) {
             ans[j] = i;
             j++;
         }
         return ans;
    }


    public static int[] intersectionII(int[] nums1, int[] nums2) {
        int max = nums1[0];
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < nums1.length; i++) {
            if (max < nums1[i])
                max = nums1[i];
        }
        int freqarray[] = new int[max + 1];
        for (int i = 0; i < nums1.length; i++) {
            freqarray[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i]<=freqarray.length-1 && freqarray[nums2[i]] > 0  ) {
                answer.add(nums2[i]);
                freqarray[nums2[i]]--;
            }
        }
        int arr[] = new int[answer.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = answer.get(i);
        }
        return arr;
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> integerSet= new HashSet<>();
        for(int i =0; i<nums.length; i++)
        {
            if(!integerSet.contains(nums[i]))
               integerSet.add(nums[i]);
            else
                return true;

            }
        return false;
        }
    public static int pivotIndex(int[] nums) {
           int sumleft=0; int sumright=0;
        for(int i=1; i<nums.length; i++)
            sumleft=sumleft+nums[i];
        if(sumleft==0)
            return 0;

          sumleft=sumright=0;
         for(int i=1; i<nums.length-1; i++)
         {
             for(int j=0; j<i; j++)
                 sumleft= sumleft+nums[j];
             for(int j=i+1; j<nums.length; j++)
                 sumright= sumright+nums[j];
             if(sumleft==sumright)
             {

                 return i;
             }
             sumleft=sumright=0;
         }
        for(int i=0; i<nums.length-1; i++)
            sumright=sumright+nums[i];
        if(sumright==0)
            return nums.length-1;
         return -1;
    }


    public int findContentChildren(int[] g, int[] s) {
   int count=0;
   Arrays.sort(g);
   Arrays.sort(s);
   int i =0, j=0;
   while (i < g.length && j <s.length)
   {
       if(g[i]<=s[j])
       {
           i++;
           j++;
           count++;
       }
       else
           j++;
   }
   return count;
    }

    public  static boolean isHappy(int n) {
        int sum=0, rem;
        Set<Integer> integerSet= new HashSet<>();
        while (sum!=1)
        {
            while (n!=0)
            {
                rem = n%10;
                sum= sum+rem*rem;

                n= n/10;
            }

            if(!integerSet.contains(sum))
                integerSet.add(sum);
            else if(sum!=1)
                return false;
            n =sum;
            if(sum!=1)
            sum=0;
        }
        return true;

    }


    public static char findTheDifference(String s, String t) {
      Map<Character, Integer> characterIntegerMap= new HashMap<>();
      for(int i =0; i<s.length(); i++)
      {
          if(!characterIntegerMap.containsKey(s.charAt(i)))
              characterIntegerMap.put(s.charAt(i),1);
          else
              characterIntegerMap.put(s.charAt(i),characterIntegerMap.get(s.charAt(i))+1);
      }
      for(int i =0; i<t.length(); i++)
      {
          if(characterIntegerMap.containsKey(t.charAt(i))) {
              characterIntegerMap.put(t.charAt(i), characterIntegerMap.get(t.charAt(i)) - 1);
              if(characterIntegerMap.get(t.charAt(i))==0)
                  characterIntegerMap.remove(t.charAt(i));
          }
          else
              return t.charAt(i);
      }
        return 0;
    }


    public static boolean isSubsequence(String s, String t) {

        if(t.length()==0 && s.length()>=1)
            return false;
        int i =0, j=0;
        while (i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                j++;
            }
            else
                j++;
            if(j==t.length() && i<s.length())
                return false;
        }
        return true;
    }


    public static boolean isMonotonic(int[] nums) {
        int i =0;
        while ( i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        if(i == nums.length-1)
            return true;
        if(nums[i]<nums[i+1]) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[j-1])
                    return false;
            }
            return true;
        }

        else  {
            for (int j = i+1; j< nums.length; j++) {
                if (nums[j] > nums[j-1])
                    return false;
            }

            return true;
        }

    }


    public static int heightChecker(int[] heights) {
        int[] temp= new int[heights.length];
        for(int i =0; i<temp.length;i++)
            temp[i]= heights[i];
        Arrays.sort(temp);
        int count=0;
        for(int i =0; i<temp.length; i++)
        {
            if(temp[i]!=heights[i])
                count++;
        }
        return count;
    }

    public static boolean  isBoomerang(int[][] points) {
        int s1=points[2][1]-points[1][1];
        int s2= points[2][0]-points[1][0];
        int s3=points[1][1]-points[0][1];
        int s4= points[1][0]-points[0][0];
        return (s1*s4!=s2*s3);

    }

    public static int[] decompressRLElist(int[] nums) {
        int size=0;
        for(int  i=0; i<nums.length; i++)
        {
            if(i%2==0)
                size+=nums[i];
        }
        int decompressedArray[]= new int[size];
        int j=0;

        for(int i=0; i< nums.length; i=i+2)
        {
            for(int k =0; k< nums[i]; k++)
            {
                decompressedArray[j]= nums[i+1];
                j++;
            }
        }
        return decompressedArray;
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] freqMatrix = new int[mat.length][2];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    count++;
            }
            freqMatrix[i][0] = i;
            freqMatrix[i][1] = count;
        }
        Arrays.sort(freqMatrix, (a, b) -> Integer.compare(a[1], b[1]));
        int ans[] = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = freqMatrix[i][0];
        return ans;
    }

    public static String reverseStr(String s, int k) {
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i++)
            str[i] = s.charAt(i);
        int x = 0, y = 0;
        char temp;

        for (int i = 0; i < s.length(); i = i + k * 2) {
            x = i;
            y = i + k - 1;
            if(y>s.length()-1)
                y= s.length()-1;
            while ( x < y) {
                temp = str[x];
                str[x] = str[y];
                str[y] = temp;
                x++;
                y--;
            }
        }
        return String.valueOf(str);
    }

    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (!characterIntegerMap.containsKey(stones.charAt(i)))
                characterIntegerMap.put(stones.charAt(i), 1);
            else
                characterIntegerMap.put(stones.charAt(i), characterIntegerMap.get(stones.charAt(i)) + 1);
        }
        for (int i = 0; i < jewels.length(); i++) {
            if (characterIntegerMap.containsKey(jewels.charAt(i)))
                count = count + characterIntegerMap.get(jewels.charAt(i));
        }
   return  count;

    }

    public static int[] diStringMatch(String s) {
        int lp=0;
        int rp=s.length();
        int ans[] = new int[s.length()+1];
        int j=0;
        for(int i =0; i<=s.length()-1; i++)
        {
            if(s.charAt(i)=='I')
            {
                ans[j]=lp;
                lp++;
            }
            else
            {
                ans[j]=rp;
                rp--;
            }
            j++;
        }
        if(s.charAt(s.length()-1)=='I')
            ans[ans.length-1]=lp;
        else
            ans[ans.length-1]=rp;
        return ans;

    }


    }









































