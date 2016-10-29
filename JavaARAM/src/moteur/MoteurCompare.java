/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moteur;

/**
 *
 * @author alain
 */
public class MoteurCompare {

    private static int   length(String s) { 
        return s == null ? 0 : s.length(); 
    }
    private static char[] chars(String s) { 
        return s == null ? new char[0] : s.toCharArray(); 
    }

    private final String left;
    private final String right;

    private final char[] lccs;
    private final String lcs;

    public MoteurCompare(String left, String right) {
        this.left = left;
        this.right = right;
        lccs = init();
        lcs = new String(lccs);
    }

    public String getLcs()  { return lcs; }
    public char[] getLccs() { return lccs.clone(); }

    private char[] init() {
        int lLength = length(left);
        int rLength = length(right);
        char[] lChars = chars(left);
        char[] rChars = chars(right);
        int [][] t = new int [lLength + 1][rLength + 1];
        for (int i = lLength - 1; i >= 0; --i) {
            for (int j = rLength - 1; j >= 0; --j) {
                if (lChars[i] == rChars[j]) {
                    t[i][j] = t[i + 1][j + 1] + 1;
                } else {
                    t[i][j] = Math.max(t[i + 1][j], t[i][j + 1]);
                }
            }
        }
        char[] result = new char[t[0][0]];
        int l = 0, r = 0, p = 0;
        while (l < lLength && r < rLength) {
            if (lChars[l] == rChars[r]) {
                result[p++] = lChars[l++];
                r++;
            } else {
                if (t[l + 1][r] > t[l][r + 1]) {
                    ++l;
                } else {
                    ++r;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        MoteurCompare mc = new MoteurCompare("Teste andrana", "Test Andranana");
        System.out.println(mc.init()[3]+" "+mc.getLcs());
    }
}

