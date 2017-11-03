public class BracketsSimpleBalancer {
    public String balance(String original) {
        StringBuilder str = new StringBuilder(original);
        int imba = updateCloseBrackets(str);
        for(int i = 0; i < imba; i++) str.append(")");
        return str.toString();
    }

    private int updateCloseBrackets(StringBuilder str) {
        int i = 0, balance = 0;
        while(i < str.length()) {
            char ch = str.charAt(i);
            if(ch == '(') balance++;
            else if(ch == ')')
                if(balance == 0){
                    str.deleteCharAt(i);
                    i--;
                } else balance--;
            i++;
        }
        return balance;
    }

    public static void main(String[] args) {
        String unbalanced = "((((a))sdsa)ds))  vs  (((sa) (()asdas)) ((";
        String balanced = new BracketsSimpleBalancer().balance(unbalanced);
        System.out.println("unbalanced: " + unbalanced);
        System.out.println("balanced: " + balanced);
    }
}
