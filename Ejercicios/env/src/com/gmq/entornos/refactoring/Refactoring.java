package com.gmq.entornos.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Refactoring {



	public List<Item> start(List<Item> items) {
        if(items == null || items.size() == 0) {
            Item item1 = new Item();
            item1.name = "Car";
            item1.quality = 100;
            item1.sold = 10;
            Item item2 = new Item();
            item2.name = "Bus";
            item2.quality = 50;
            item2.sold = 20;
            Item item3 = new Item();
            item3.name = "Truck";
            item3.quality = 0;
            item3.sold = 0;
            Item item4 = new Item();
            item4.name = "Bike";
            item4.quality = 50;
            item4.sold = 15;

            items.add(item1);
            items.add(item2);
            items.add(item3);
            items.add(item4);
        }

		

		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
            if (!item.name.equals("Car")
                    && !item.name.equals("Bus")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Truck")) {
                    	item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                	item.quality = item.quality + 1;
                	
                    if (item.name.equals("Bus")) {
                        if (item.sold < 11) {
                            if (item.quality < 50) {
                            	item.quality = item.quality + 1;
                            }
                        }

                        if (item.sold < 6) {
                            if (item.quality < 50) {
                            	item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Truk")) {
            	item.sold = item.sold - 1;
            } 

            if (item.sold < 0) {
                if (!item.name.equals("Car")) {
                    if (!item.name.equals("Bus")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Truk")) {
                            	item.quality = item.quality - 1;
                            }
                        }
                    } else {
                    	item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < 50) {
                    	item.quality = item.quality + 1;
                    }
                }
            }
        }
		return items;
	}

}
