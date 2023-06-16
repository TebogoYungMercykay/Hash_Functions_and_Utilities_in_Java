public class Hashmap {
    public HashFunction[] functions;
    private String[] map;

    public Hashmap(int length, HashFunction[] funcs) {
        map = new String[length];
        int i = 0;
        while (i < length) {
            map[i] = "";
            i++;
        }
        functions = funcs;
    }

    public int hash(String val) {
        int sum = 0;
        int i = 0;
        while (i < map.length) {
            sum = sum + functions[i].hash(val);
            i++;
        }
        sum = sum % map.length;
        return sum;
    }

    public boolean contains(String val) {
        int sum = 0;
        int i = 0;
        while (i < functions.length) {
            sum = sum + functions[i].hash(val);
            i++;
        }
        sum = sum % map.length;
        if (!map[sum].equals("")) {
            String[] values = map[sum].split("&/");
            int j = 0;
            while (j < values.length) {
                if (values[j].equals(val)) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public void insert(String s) {
        if (contains(s) == true) {
            return;
        }
        int sum = 0;
        int i = 0;
        while (i < functions.length) {
            sum = sum + functions[i].hash(s);
            i++;
        }
        sum = sum % map.length;
        switch (map[sum]) {
            case "":
                map[sum] = s;
                break;
            default:
                map[sum] += "&/" + s;
                break;
        }
    }

    public void remove(String s) {
        int sum = 0;
        int i = 0;
        while (i < functions.length) {
            sum = sum + functions[i].hash(s);
            i++;
        }
        sum = sum % map.length;
        if (!map[sum].equals("")) {
            String tmp = "";
            Boolean flag = false;
            String[] values = map[sum].split("&/");
            int j = 0;
            while (j < values.length) {
                if (values[j].equals(s)) {
                    j++;
                    continue;
                }
                int h = flag ? 1 : 0;
                switch (h) {
                    case 0:
                        flag = true;
                        tmp = values[j];
                        break;
                    default:
                        tmp += "&/" + values[j];
                        break;
                }
                j++;
            }
            map[sum] = tmp;
        }
    }

    public String toString() {
        String tostring = "";
        tostring += "[";
        int k = 0;
        while (k < map.length - 1) {
            String tmp = "";
            Boolean flag = false;
            String[] values = map[k].split("&/");
            int i = 0;
            while (i < values.length) {
                int h = flag ? 1 : 0;
                switch (h) {
                    case 0:
                        flag = true;
                        tmp = values[i];
                        break;
                    default:
                        tmp += "," + values[i];
                        break;
                }
                i++;
            }
            tostring = tostring + tmp + ";";
            k++;
        }
        if (map.length > 0) {
            String tmp = "";
            Boolean flag = false;
            String[] values = map[map.length - 1].split("&/");
            int i = 0;
            while (i < values.length) {
                int h = flag ? 1 : 0;
                switch (h) {
                    case 0:
                        flag = true;
                        tmp = values[i];
                        break;
                    default:
                        tmp += "," + values[i];
                        break;
                }
                i++;
            }
            tostring = tostring + tmp;
        }
        tostring += "]";
        return tostring;
    }
}
