


public class RomNum extends Num { //все действия переносим из ромнам в нам

    String romanResult;

    static String[] LARGEROMAN = {"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"};
    static String[] ROMAN = {"0","I","II","III","IV","V","VI","VII","VIII","IX","X"};

    public static String[] getRoman() {
        return ROMAN;
    }

    public RomNum(String firstRoman, String secondRoman) {
        super(toInt(firstRoman),toInt(secondRoman));
    }

    public String getStringResult() {
        return romanResult;
    }

    private static int toInt(String roman) {
        int i = 0;
        while (!roman.equals(ROMAN[i])) {
            i++;
        }
        return i;
    }

    public void toRoman() {

        if (result == 100) {
            romanResult = "C";

        }

        if (result < 1) {
            throw new RuntimeException("Римский результат должен быть положительным");
        }

        int units = result % 10; // 50 - 0
        int large = (result - units) / 10;

        String romanUnits = ROMAN[units];
        String romanLarge = LARGEROMAN[large];

        if (large == 0) {
            romanResult = romanUnits;

        }
        if (units == 0) {
            romanResult = romanLarge;

        }
        romanResult = romanLarge + romanUnits;
    }
}

