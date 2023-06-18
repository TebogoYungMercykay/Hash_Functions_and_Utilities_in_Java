public class Division extends HashFunction {

    public Division(int n) {
        num = n;
    }

    @Override
    public int hash(String input) {
        return (int) ((Long.parseLong(stringToNum(input))) % num);
    }
}
