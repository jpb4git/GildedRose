package com.gildedrose;

public class GildedRoseRefactor {
    Item[] items;

    public GildedRoseRefactor(Item[] items) {
        this.items = items;
    }




    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Aged Brie":

                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":

                    if (items[i].sellIn > 10) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }else if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 3;
                            }
                    }else if (items[i].sellIn < 11) {
                        if (items[i].quality < 50) {
                            items[i].quality = items[i].quality + 2;
                        }
                    }

                    if (items[i].sellIn <= 0) {
                            items[i].quality = 0;
                    }

                    break;
                case "Sulfuras, Hand of Ragnaros":
                    // code block
                    break;

                default:

                    if (items[i].sellIn <= 0){
                        if (items[i].quality - 2 >= 0 ){
                            items[i].quality = items[i].quality - 2;
                        }else{
                            items[i].quality = 0;
                        }
                    }

                    if ( (items[i].quality - 1) >= 0  ){
                        items[i].quality = items[i].quality - 1;
                    }

                    // code block
            }
        }
/*
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
                // soit brie or Backstage
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            //------------------------
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            //-------------------------
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
        */

    }

    private void internalUpdate(){



    }

    public Item[] getItems() {
        return items;
    }
}

