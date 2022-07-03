package android.example.sensorpressure;

public class CustomModel {

    private int id;
    private String data;
    private boolean isActive;

    public CustomModel(int id, String data, boolean isActive) {
        this.id = id;
        this.data = data;
        this.isActive = isActive;
    }

    public CustomModel() {

    }

    @Override
    public String toString() {
        return "CustomModel{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
