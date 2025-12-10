package w13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Room {
	private String description; // 이 Room에 대한 설명.
	
	
	private Map<String, Room> exits;

	/**
	 * "description" 설명에 해당하는 Room을 구성한다. 초기에는 exit을 갖지 않는다. "description"은 가령
	 * "과사무실", "실습실", "동아리방" 같은 것이다.
	 * 
	 * @param description 이 방에 관한 설명.
	 */
	public Room(String description) {
		this.description = description;
		exits = new HashMap<String, Room>();
	}

	public void setExit(String direction, Room neighbor) {
		if (neighbor != null) {
			exits.put(direction, neighbor);
		}
	}
	
	public Room getExit(String direction) {
		return exits.get(direction);
	}
	
	public String getExitString() {
		StringBuilder s = new StringBuilder("Exits: ");
		
		Set<String> keys = exits.keySet();
		
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			s.append(it.next()+" ");
		}
		
		return s.toString();
	}
	

	/**
	 * @return The description of the room.
	 */
	public String getDescription() {
		return description;
	}
	
	public String getLongDescription() {
		return description + ".\n" + getExitString();
	}
}
