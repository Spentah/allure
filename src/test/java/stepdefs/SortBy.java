package stepdefs;

public enum SortBy {
    DEFAULT(101, "По умолчанию"),
    EXPENSIVE(2, "Дороже"),
    CHEAPER(1, "Дешевле"),
    BY_DATE(104, "По дате");

    public int value;
    public String text;

    SortBy(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public void oi(SortBy by){
        String s1 = by.text;
    }


}
