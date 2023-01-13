package com.epam.rd.autotasks.words;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int count = 0;
        if (words != null && sample !=null && !sample.isEmpty()) {
            for (String world : words) {
                if (world.trim().equalsIgnoreCase(sample.trim())) count++;
            }
        }
        return count;
    }

    public static String[] splitWords(String text) {
        if (text==null) return null;

        ArrayList<String> splitWords = new ArrayList<>();

        String[] worlds =  text.split(",|\\.|;|:|\\?|!|\\h");

        for (String world: worlds) {
            if (!world.isBlank()){
                splitWords.add(world.trim());
            }
        }
        String[] result = new String[splitWords.size()];
        if (splitWords.size() == 0) {
            return null;
        }

        return splitWords.toArray(result);
    }

    public static String convertPath(String path, boolean toWin) {
        if(!isCorrectPath(path))return null;

        if (isWin(path) == toWin) {
            return path;
        } else {
            if (toWin){
                if (path.startsWith("~")){
                    path = path.replaceFirst("~", "C:\\\\User");
                }
                if (path.startsWith("/")){
                    path = path.replaceFirst("/", "C:\\\\");
                }
                path = path.replaceAll("/", "\\\\");
            } else {
                if (path.startsWith("C:\\User")){
                    path = path.replaceFirst("C:\\\\User",
                            "~");
                }
                if (path.startsWith("C:")){
                    path = path.replaceFirst("C:", "");
                }
                path = path.replaceAll("\\\\", "/");
            }
        }
        return path;
    }

    public static String joinWords(String[] words) {
        if (words == null) return null;
        StringBuilder result = new StringBuilder();

        boolean flag = false;

        for (String word: words) {
            if (!word.isBlank()){
                if (flag){
                    result.append(", ");
                }else {
                    flag = true;
                }
                result.append(word);
            }
        }

        if (!result.toString().isEmpty()){
            result.insert(0, "[");
            result.append("]");
        } else return null;

        return result.toString();
    }

    public static boolean isWin(String path){
        return !path.contains("~") && !path.contains("/");
    }

    public static boolean isCorrectPath(String path){
        boolean flag = true;

        if (path == null||
                path.isBlank() ||
                ((path + "\0").split("~").length - 1)>1 ||
                path.indexOf("~")>0 ||
                path.contains("~") && path.contains("\\") ||
                ((path + "\0").split("C:").length - 1)>1 ||
                path.indexOf("C:")>0 ||
                path.contains("C:") && path.contains("/") ||
                path.contains("\\") && path.contains("/")) {
            flag = false;
        }

        return flag;
    }

    public static void main(String[] args) {
//        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
//        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
//        String sample = "words   ";
//        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
//        System.out.println("Result: " + countResult);
//        int expectedCount = 2;
//        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
//        String text = "   ,, first, second!!!! third";
        String text = " ;:a ,,,  b ::; c,d:e    f:g::;;;::::    h            ";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
//        String[] expectedSplit = new String[]{"first", "second", "third"};
        String[] expectedSplit = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));
//
//        System.out.println("Test 3: convertPath");
//        String unixPath = "/some/unix/path";
//        String convertResult = convertPath(unixPath, true);
//        System.out.println("Result: " + convertResult);
//        String expectedWinPath = "C:\\some\\unix\\path";
//        System.out.println("Must be: " + expectedWinPath);
//
//        System.out.println("Test 4: joinWords");
//        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
//        String joinResult = joinWords(toJoin);
//        System.out.println("Result: " + joinResult);
//        String expectedJoin = "[go, with, the, FLOW]";
//        System.out.println("Must be: " + expectedJoin);
    }
}