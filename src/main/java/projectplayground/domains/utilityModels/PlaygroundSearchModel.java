package projectplayground.domains.utilityModels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaygroundSearchModel {
    public String playgroundName;
    public String streetName;
    public String cityName;
    public int postCode;
}