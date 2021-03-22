package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        if (isBlankOrNull(s)) {
            return false;
        }
        int sumDigit = 0;
        int sumOthers = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sumDigit++;
            } else {
                sumOthers++;
            }
        }
        return sumDigit > sumOthers;
    }

    private boolean isBlankOrNull(String str) {
        return str == null || str.isBlank();
    }

}
