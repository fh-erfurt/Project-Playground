package projectplayground;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import projectplayground.domains.Location;


@NoArgsConstructor(staticName = "of")
public class LocationTestEntityBuilder {
    private String streetname;
    private int houseNumber;
    private int postCode;
    private String cityname;
    private String district;

    public LocationTestEntityBuilder setStreetname(String streetname) {
        this.streetname = streetname;
        return this;
    }

    public LocationTestEntityBuilder setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public LocationTestEntityBuilder setPostCode(int postCode) {
        this.postCode = postCode;
        return this;
    }

    public LocationTestEntityBuilder setCityname(String cityname) {
        this.cityname = cityname;
        return this;
    }

    public LocationTestEntityBuilder setDistrict(String district) {
        this.district = district;
        return this;
    }
    public Location build(){
        Location res = new Location();
        if(StringUtils.isEmpty(streetname)){
        res.setStreetname("Hütergasse");
        res.setHouseNumber(4);
        res.setPostCode(99084);
        res.setCityname("Erfurt");
        res.setDistrict("Andreasviertel");

        }else{
            res.setStreetname(this.streetname);
        }
        return res;
    }
}
