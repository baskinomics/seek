package seek.domain.entity;

/**
 * Represents a geographic location.
 */
public class Location {

    /**
     * The city component of the location.
     */
    private String city;

    /**
     * The state component of the location.
     * todo This should be converted to an enum
     */
    private String state;

    /**
     * The cost of living for this location. TBD on what this value will actually be.
     */
    private String costOfLiving;

}
