package Accessories.Keyboard;

public class Keyboard {

    private final int weightKeyboard;
    private final KeyboardType keyboard;
    private final KeyboardBackLight keyboardLight;

    public Keyboard(int weightKeyboard, KeyboardType keyboard, KeyboardBackLight keyboardLight) {
        this.weightKeyboard = weightKeyboard;
        this.keyboard = keyboard;
        this.keyboardLight = keyboardLight;
    }

    public int getWeightKeyboard() {
        return weightKeyboard;
    }

    public KeyboardType getKeyboard() {
        return keyboard;
    }

    public KeyboardBackLight getKeyboardLight() {
        return keyboardLight;
    }

    @Override
    public String toString() {
        return  "Тип соединения: " + keyboard +
                ", Подсветка клавиш: " + keyboardLight +
                ", Вес клавиатуры: " + weightKeyboard + " гр.";
    }
}
