package w13;

public class Player {
	private Room currentRoom;
	private Room recentRoom;
	
	public Player(Room startRoom) {
		currentRoom = startRoom;
		recentRoom = startRoom;
	}
	
	
	int moveTo(String direction)  {
		Room nextRoom = null;
		nextRoom = currentRoom.getExit(direction);
		
		if(nextRoom == null) {
			return -1;
		}else {
			recentRoom = currentRoom;
			currentRoom = nextRoom; // 방을 변경
			return 0;
		}


	}
	
	public void back() {
		if(recentRoom != null) {
			currentRoom = recentRoom;
		}
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
}
