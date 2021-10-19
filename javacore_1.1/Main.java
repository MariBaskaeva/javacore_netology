public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();
        double a = calc.plus.apply(1, 2);
        double b = calc.minus.apply(1,1);
        /**Проблема была в том, что мы пытались поделить число на 0.
         * Я исправила ситуацию, поменяв принимаемые типы у переменных divide и println на Double
         * для того, чтобы в качестве возвращаемого значения при делении на 0 могли получать Infinity.
         * Так же, если бы мы делили другие числа, к примеру 3 на 2, то получали бы лишь целую часть.
         * Теперь такой проблемы не возникнет.
         */
        double c = calc.divide.apply(a, b);

        calc.println.accept(c);
    }
}
