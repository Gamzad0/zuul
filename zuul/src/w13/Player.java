package w13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Player {
	private Room currentRoom;
	private Stack<Room> pastRooms;
	private ArrayList<Item> items;
	private int maxWeight;
	
	public Player(Room startRoom, int maxWeight) {
		currentRoom = startRoom;
		this.items = new ArrayList<>();
		this.maxWeight = maxWeight;
		pastRooms = new Stack<Room>();
	}
	
	int moveTo(String direction)  {
		Room nextRoom = null;
		nextRoom = currentRoom.getExit(direction);
		
		if(nextRoom == null) {
			return -1;
		}else {
			pastRooms.push(currentRoom);
			currentRoom = nextRoom; // 방을 변경
			return 0;
		}


	}
	
	public void back() {
		if(!pastRooms.isEmpty()) {
			currentRoom = pastRooms.pop();
		}
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
	
	private boolean pickable(Item item) {
		if(item.getWeight() + totalWeight() > maxWeight)
			return false;
		else
			return true;
	}
	
	private int totalWeight() {
		Iterator<Item> it = items.iterator();
		int sum = 0;
		while (it.hasNext())
			sum += it.next().getWeight();
		return sum;
		
	}
	
	public Item takeItem(String name) {
		Item item = currentRoom.removeItem(name);
		
		if(item != null) {
			if(pickable(item))
				items.add(item);
			else {
				currentRoom.addItem(item);
				item = null;
			}
		}
		return item;
	}
	
	public Item dropItem(String name) {
		Iterator<Item> it = items.iterator();
		
		while (it.hasNext()) {
			Item item = it.next();
			if(item.getName().equals(name)) {
				it.remove();
				currentRoom.addItem(item);
				return item;
			}
		}
		return null;
	}
	
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
	}
	
	public int getMaxWeight() {
		return maxWeight;
	}
	

}
