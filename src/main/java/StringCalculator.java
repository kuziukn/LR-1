public class StringCalculator{

    public int add(String numbers){
        if(numbers.isEmpty()) return 0;

        String delimiter = "";
        String regex = "\n|,";

        String[] num = numbers.split("");


        if(numbers.indexOf("//") == 0){
            String[] delimiters_array = numbers.substring(2, numbers.indexOf("\n")).split("]");

            if(delimiters_array.length > 1) {
            for(int i = 0; i < delimiters_array.length - 1; i++){
                delimiter = delimiter + delimiters_array[i] + "]+|";
            }
            delimiter = delimiter + delimiters_array[delimiters_array.length - 1] + "]+";
            }
            else{ delimiter = numbers.substring(2, numbers.indexOf("\n")) + "+"; }


            regex = "\n|,|" + delimiter;
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        String[] elements = numbers.split(regex);

        int sum = 0;
        for (String element : elements) {
            if (Integer.parseInt(element) < 0) {
                throw new NegativeException(getNegativeNumbersAsString(elements));
            } else {
                if (Integer.parseInt(element) <= 1000) {
                    sum = sum + Integer.parseInt(element);
                }
            }
        }
        return sum;
    }

    private String getNegativeNumbersAsString(String[] elements){
        String result = "";
        for(String s: elements){
            if(Integer.parseInt(s) < 0){
                result += s + " ";
            }
        }
        return result;
    }
}
