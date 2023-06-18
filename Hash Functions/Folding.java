public class Folding extends HashFunction {
    public boolean shift;

    public Folding(int n, boolean s) {
        shift = s;
        num = n;
    }

    @Override
    public int hash(String input) {
        String n = stringToNum(input);
        int sum = 0;
        for (int size = stringToNum(input).length(), temp = 0; (size % num != 0) && ( temp == 0 ); size = n.length()) {
            n = n + "0";
        }
        int odd = 1;
        while ((n.length() > 0) == true) {
            String tmp = n.substring(0, Math.min(num, n.length()));
            if ((!shift && odd % 2 == 0) == true) {
                String revtmp = "";
                for(int i = 0, p = 0; ((i < tmp.length()) == true) && p == 0; i++) {
                    revtmp = tmp.charAt(i) + revtmp;
                }
                tmp = revtmp;
            }
            odd++;
            sum = sum + Integer.parseInt(tmp);
            n = n.substring(Math.min(num, n.length()));
        }
        return sum;
    }
}
