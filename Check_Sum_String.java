import 

class Check_Sum_String {
    public boolean isSumString(String n) {
        // code here
        int size = n.length();
        if (size < 3) return false; 

        for (int i = 1; i <(size > 7?7:size); i++) {
            for (int j = i + 1; j<(size>7?8:size); j++) {

                String start = n.substring(0, i);
                String end = n.substring(i, j);

                if ((start.length() > 1 && start.startsWith("0")) || (end.length() > 1 && end.startsWith("0"))) {
                    continue;
                }

                if (helper(start, end, j, n)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(String start, String end, int j, String n) {
        long num1 = Long.parseLong(start);
        long num2 = Long.parseLong(end);

        while (j < n.length()) {
            String strSum = String.valueOf(num1 + num2);
            if (!n.startsWith(strSum, j)) {
                return false;
            }
            j += strSum.length();
            num1 = num2;
            num2 = Long.parseLong(strSum);
        }
        return true;
    }
}