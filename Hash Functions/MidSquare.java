public class MidSquare extends HashFunction {

    public MidSquare(int n) {
        num = n;
    }

    public int hash(String input) {
        String numString = Long.toString((Long.parseLong(stringToNum(input)) * Long.parseLong(stringToNum(input))));
        if (numString.length() > num) {
            int odd = (numString.length() - num) % 2;
            if (((numString.length() - num) % 2) != 0) {
                numString = numString + "0";
            }
            odd = (numString.length() - num) / 2;
            numString = numString.substring(odd);
            String v = "";
            for (int i = 0, t = 0; (i < num && t == 0); i++) {
                v += numString.charAt(i);
            }
            return Integer.parseInt(v);
        }
        return Integer.parseInt(numString);
    }
}
