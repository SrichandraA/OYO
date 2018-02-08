package chandu.oyo;

/**
 * Created by Chandu on 2/8/2018.
 */

public class FacilityData {
    int img_id;
    String name;

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacilityData(int img_id, String name) {

        this.img_id = img_id;
        this.name = name;
    }
}
