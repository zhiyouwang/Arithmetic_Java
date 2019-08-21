package com.JnuWangSwordOffer;

/**
 * 题目：实现一个函数，吧字符串中的每个空格替换成"%20"。
 * 例如，输入"we are happy"，
 * 则输出"we%20are%20happy"
 * 思路：先根据字符串中空格的数目进行判断，得到最终需要的长度，然后在数组中进行处理，这里从后往前进行处理，减少字符的处
 * 理次数
 */
public class ReplaceBlankSpace {
    public static String replaceBlankSpace (String str) {
        String replaceStr = "%20";
        int spaceNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }
        char[] charArr = new char[str.length() + spaceNum * 2];
        int charLen = charArr.length - 1;
        int strIndex = str.length() - 1;
        for (int i = charLen; i >= 0 && strIndex >= 0; i--) {
            if (str.charAt(strIndex) != ' ') {
                charArr[i] = str.charAt(strIndex--);
            } else {
                for (int j = 2; j >= 0; j--) {
                    charArr[i--] = replaceStr.charAt(j);
                }
                i += 1;
                strIndex--;
            }
        }
        return String.valueOf(charArr);
    }

    public static void main (String[] args) {
        System.out.println(replaceBlankSpace(" "));
        System.out.println();
    }
}
