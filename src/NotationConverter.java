import java.util.HashMap;
import java.util.Map;

public class NotationConverter {

    public static int toArabic(String romanNotation) throws InvalidValueException{
        if (romanNotation == null || romanNotation.equals("")){
            throw new InvalidValueException("String must contain only valid roman numerals");
        }

        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int result = 0;
        for (int i = 0; i < romanNotation.length(); i++) {
            if (!romanMap.containsKey(romanNotation.charAt(i))){
                throw new InvalidValueException("String must contain only valid roman numerals");
            }
            if (i>0 && romanMap.get(romanNotation.charAt(i)) > romanMap.get(romanNotation.charAt(i-1))){
                //если за числом следует большее значение мы вычитаем его дважды т.к. мы его в блоке else уже сложили
                result += romanMap.get(romanNotation.charAt(i)) - 2 * romanMap.get(romanNotation.charAt(i-1));;
            }
            else {
                //если первый проход цикла или текущее значении меньше предыдущего просто складываем их
                result += romanMap.get(romanNotation.charAt(i));
            }
        }
        return result;
    }
}
