public class StringCases {

    public static String camelCase(String inputString) {
        //complete this method
        StringBuilder camelCaseSentence = new StringBuilder();
        String[] splitString = inputString.split(" ");

        for (int i = 0; i < splitString.length; i++) {
            StringBuilder theLetters = new StringBuilder();

            for (int j = 0; j < splitString[i].length(); j++) {
                if (Character.isLetter(splitString[i].charAt(j))) {
                    theLetters.append(splitString[i].charAt(j));
                }
            }
            splitString[i] = theLetters.toString();
        }

        for (String word : splitString) {
            String latestWord = "";
            if (word.equals(splitString[0])) {
                latestWord = word.toLowerCase();
            } else if (word.length() != 0) {
                latestWord = latestWord + word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
            camelCaseSentence.append(latestWord);
        }
        return camelCaseSentence.toString();
    }

    public static String pascalCase(String inputString) {
        //complete this method
        StringBuilder pascalCaseSentence = new StringBuilder();
        String[] splitString = inputString.split(" ");

        for (int i = 0; i < splitString.length; i++) {
            StringBuilder theLetters = new StringBuilder();

            for (int j = 0; j < splitString[i].length(); j++) {
                if (Character.isLetter(splitString[i].charAt(j))) {
                    theLetters.append(splitString[i].charAt(j));
                }
            }
            splitString[i] = theLetters.toString();
        }

        for (String word : splitString) {
            String latestWord = "";

            if (word.length() != 0) {
                latestWord = latestWord + word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
            }
            pascalCaseSentence.append(latestWord);
        }
        return pascalCaseSentence.toString();
    }

    public static String snakeCase(String inputString) {
        //complete this method
        StringBuilder snakeCaseSentence = new StringBuilder();
        String[] splitString = inputString.split(" ");

        for (int i = 0; i < splitString.length; i++) {
            StringBuilder theLetters = new StringBuilder();

            for (int j = 0; j < splitString[i].length(); j++) {
                if (Character.isLetter(splitString[i].charAt(j))) {
                    theLetters.append(splitString[i].charAt(j));
                }
            }
            splitString[i] = theLetters.toString();
        }

        for (String word : splitString) {
            if (word.equals(splitString[0])) {
                snakeCaseSentence.append(word.toLowerCase());
            } else if (word.length() != 0) {
                snakeCaseSentence.append("_").append(word.toLowerCase());
            }
        }
        return snakeCaseSentence.toString();
    }

    public static String screamingSnakeCase(String inputString) {
        //complete this method
        StringBuilder screamingSnakeCaseSentence = new StringBuilder();
        String[] splitString = inputString.split(" ");

        for (int i = 0; i < splitString.length; i++) {
            StringBuilder theLetters = new StringBuilder();

            for (int j = 0; j < splitString[i].length(); j++) {
                if (Character.isLetter(splitString[i].charAt(j))) {
                    theLetters.append(splitString[i].charAt(j));
                }
            }
            splitString[i] = theLetters.toString();
        }

        for (String word : splitString) {
            if (word.equals(splitString[0])) {
                screamingSnakeCaseSentence.append(word.toUpperCase());
            } else if (word.length() != 0) {
                screamingSnakeCaseSentence.append("_").append(word.toUpperCase());
            }
        }
        return screamingSnakeCaseSentence.toString();
    }

    public static String alternateCase(String inputString) {
        //complete this method
        StringBuilder alternateCaseSentence1 = new StringBuilder();
        StringBuilder alternateCaseSentence2 = new StringBuilder();

        for (char a : inputString.toCharArray()) {

            if (Character.isAlphabetic(a)) {
                alternateCaseSentence1.append(Character.toLowerCase(a));
            }
        }

        for (int i = 1; i <= alternateCaseSentence1.length(); i++) {
            if (i % 2 != 0) {
                alternateCaseSentence2.append(Character.toUpperCase(alternateCaseSentence1.charAt(i - 1)));
            }
            else {
                alternateCaseSentence2.append(alternateCaseSentence1.charAt(i - 1));
            }
        }
        return alternateCaseSentence2.toString();
    }
}


