package arrays_numbers.partition;

public class SortLettersbyCase {
    /*
     * 8/4/2018
     *
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }

        int left = 0, right = chars.length - 1;
        while (left <= right) {
            while (left <= right && isLowerCase(chars[left])) {
                left++;
            }

            while (left <= right && !isLowerCase(chars[right])) {
                right--;
            }

            if (left <= right) {
                Character temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        return;
    }

    private boolean isLowerCase(char c) {
        if (c >= 'a' && c <= 'z') {
            return true;
        } else {
            return false;
        }
    }
}
