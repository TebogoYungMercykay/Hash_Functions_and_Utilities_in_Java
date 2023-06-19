public class Extraction extends HashFunction {
    public Extraction(int n) {
        num = n;
    }
    @Override
    public int hash(String input) {
        String u = "";
        if ((int)(stringToNum(input)).length() > num) {
            for (int i = (int)(stringToNum(input)).length() - 1, temp = 0, j = 0; (j < num && temp == 0); i--, j++) {
                u = (stringToNum(input)).charAt(i) + u;
            }
        } else {
            u = (stringToNum(input));
        }
        return Integer.parseInt(u);
    }
}