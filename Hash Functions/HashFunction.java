public abstract class HashFunction {
    public abstract int hash(String input);

    public int num;

    public String stringToNum(String input) {
        int[] vals = new int[6];
        int i = 0;
        char[] inputChars = input.toCharArray();
        while (i < inputChars.length) {
            vals[i % 6] += inputChars[i];
            i++;
        }
        String[] value = new String[6];
        i = 0;
        while (i < vals.length) {
            value[i] = String.format("%3d", vals[i]).replace(" ", "0");
            while (value[i].length() > 3) {
                value[i] = value[i].substring(1);
            }
            i++;
        }

        String concat = "";
        int j = 5;
        while (j >= 0) {
            concat += value[j];
            j--;
        }

        while (concat.length() > 1 && concat.charAt(0) == '0') {
            concat = concat.substring(1);
        }

        return concat;
    }
}
