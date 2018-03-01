/**
 * This class represents a room
 * @author Solange U. Gasengayire
 */
public class Room extends MapSite {

    // exceptionally, for the purpose of this project
    // attributes are declared public
    public int roomNumber;
    public Wall[] sides;
    public MapSite[] mapsites;

    /**
     * No-argument constructor
     */
    public Room() {
        super();
        // voluntarily not implemented
    }

    /**
     * Get the wall that corresponds to the input side
     * @param side the input side
     * @return the wall that corresponds to the side
     */
    public Wall getSide(int side) {
        // voluntarily not implemented
       return null;
    }

    /**
     * Specify a side for the wall
     * @param side the input side
     * @param wall the input wall
     */
    public void setSide(int side, Wall wall) {
        // voluntarily not implemented
    }

}
