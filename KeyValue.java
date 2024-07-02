public class KeyValue {
    private String key;
    private Runnable value;

    public KeyValue(String key, Runnable value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Runnable getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(Runnable value) {
        this.value = value;
    }
}
