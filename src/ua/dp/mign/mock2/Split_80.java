package ua.dp.mign.mock2;

class Split_80 {
    /*
     * In the current example \\S is passed as an argument
     * for the split method and so all non whitespace
     * characters are treated as a separators.
     * During split empty space between two separators
     * are treated as an empty token.
     * Separator in the beginning will also produce an
     * empty token.
     * So we will get empty token between 'I' and 
     * first whitespace, then empty token between 'a'
     * and 'm', next 8 empty tokens from 'preparing'
     * and finally 2 empty tokens from 'for'
     * We have 4 whitespace characters + 12 empty tokens.
     * As far as there is no non-empty tokens after the
     * last whitespace all empty tokens produced by 'OCPJP'
     * are not included in the resulting array.
     * As a result we will have an array with 16 tokens inside.
     */
    public static void main(String[] args) {
        String test = "I am preparing for OCPJP";
        String[] tokens = test.split("\\S");
        System.out.println(test);
        System.out.println(tokens.length);
        for(String token : tokens) {
            System.out.println("\"" + token + "\"");
        }
    }
}
