package com.gmq.entornos.refactoring.solution;

import java.util.List;

import com.gmq.entornos.refactoring.Item;

public class Refactoring {

	private final int MEDIUM_QUALITY = 50;
	
	private final int TOTAL_QUALITY = 100;

	public List<Item> start(List<Item> items) {
		
		initItems(items);
		
		for (int i = 0; i < items.size(); i++) {
			
			Item item = items.get(i);
			
            if (isABike(item) && hasQuality(item)) {        
                sumQuality(item, -1);
            } else if (isLowQuality(item)) {
                mangeLowQuality(item);
            }

            if (isNotATruck(item)) {
            	item.setSold(item.getSold()-1);
            }

            if (noSold(item)) {
            	if(isACar(item) && isLowQuality(item)) {
                    sumQuality(item, 1);
            	} else {
                    if (isNotABus(item)) {
                        if (hasQuality(item) && isNotATruck(item)) {
                           sumQuality(item, -1);
                        }
                    } else {
                    	item.setQuality(0);
                    }
            	}
            }
        }
		return items;
	}

	private boolean noSold(Item item) {
		return item.getSold() < 0;
	}

	private void sumQuality(Item item, int sumQuality) {
		item.setQuality(item.getQuality()+sumQuality);
	}

	private void mangeLowQuality(Item item) {
		sumQuality(item, 1);
		
		if (item.getItemName().equals("Bus")) {
		    int SOLD_UNIT_ELEVEN = 11;
			if (item.getSold() < SOLD_UNIT_ELEVEN && isLowQuality(item)) {
		        sumQuality(item, 1);
		    }

		    if (item.getSold() < 6) {
		        if (isLowQuality(item)) {
		        	sumQuality(item, 1);
		        }
		    }
		}
	}

	private void initItems(List<Item> items) {
		
		if(isEmpty(items)) {
            
			items.add(new Item("Car", TOTAL_QUALITY, 10));
            items.add(new Item("Bus", MEDIUM_QUALITY, 20));
            items.add(new Item("Truck", 0, 0));
            items.add(new Item("Bike", MEDIUM_QUALITY, 15));
        }
	}

	private boolean isLowQuality(Item item) {
		
		return item.getQuality() < MEDIUM_QUALITY;
	}

	private boolean hasQuality(Item item) {
		
		return item.getQuality() > 0;
	}


	private boolean isNotABus(Item item) {
		return !item.getItemName().equals("Bus");
	}

	private boolean isNotATruck(Item item) {
		return !item.getItemName().equals("Truk");
	}
	
	private boolean isABike(Item item) {
		
		return "Bike".equalsIgnoreCase(item.getItemName());
	}
	
	private boolean isACar(Item item) {
		
		return "Car'".equalsIgnoreCase(item.getItemName());
	}

	private boolean isEmpty(List<Item> items) {
		
		return items == null || items.size() == 0;
	}

}
