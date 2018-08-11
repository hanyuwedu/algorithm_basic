package datastructure.hash;

public class HashFunction {
    /**
     * 8/11/2018
     *
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length == 0) {
            return 0;
        }

        Long sum = Long.valueOf(0);
        for (int i = 0; i <= key.length - 1; i++) {
            sum *= 33;
            sum += key[i];
        }

        return sum.intValue();
    }
}
