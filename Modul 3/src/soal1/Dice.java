package soal1;

public class Dice {
    private int value;

    public Dice(){
        randomizedValue();
    }

    public void randomizedValue(){
        this.value = (int)(Math.random() * 6) + 1;
    }

    public int getValue(){
        return value;
    }
}