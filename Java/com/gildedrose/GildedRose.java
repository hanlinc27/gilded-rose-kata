class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        
        //iterate through the items in the system per day
        for (Item item : items) {
            
            switch (item.name) {
                case "Aged Brie":
                    item.quality += 1;
                    if (item.sellIn<0) {
                        item.quality +=1;
                    }   updateFinalQuality(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality +=1;
                    //Changes for when it's 10 days or less
                    if (item.sellIn < 11) {
                        item.quality += 1;
                    }
                    //Changes for when it's 5 days or less
                    if (item.sellIn < 6) {
                        item.quality += 1;
                    }
                    //If the sellin date has been reached, quality becomes 0
                    if (item.sellIn<0) {
                        item.quality = 0;
                    }   updateFinalQuality(item);
                    break;
                case "Conjured Mana Cake":
                    //Conjured decreases twice as fast
                    item.quality-=2;
                    updateFinalQuality(item);
                    break;
                default:
                    //A default item decreases in quality by 1
                    item.quality -= 1;
                    if (item.sellIn<0) {
                        //Twice as fast if sellin date is reached
                        item.quality -= 1;
                    }   updateFinalQuality(item);
                    break;
            }
            //Update the sell in date 
             updateSellIn(item);
            }
        }
    
     public void updateFinalQuality(Item item){
        //If the quality is over 50, reset quality to 50
        if (item.quality >= 50) {
            item.quality=50;
        }
        //If quality is negative, it shouldn't be! So set it to 0
        if (item.quality <= 0){
            item.quality=0;
        }
    }
    public void updateSellIn (Item item) {
            //all items sell-in day goes down by 1 except Sulfruras which is legendary
            //decrement sellin by 1
              if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
            }
         }
         }
    
   
//            //If the item is not Brie or Backstage Passes (Since both items increase in value)
//            //Variable changes for "Backstage passes" as it approaches date (and not Backstage Passes)
//            if (!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                //As long as quality is greater than 0 (remember no negatives!)
//                if (item.quality > 0) {
//                    //And the item isn't Sulfuras
//                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                        //Quality decreases by 1 each day- quality will reach negative
//                        if (item.name.equals("Conjured Mana Cake")){
//                            item.quality-=1;
//                        }
//                        item.quality -= 1;
//
//                    }
//                }
//            } else {
//                //For Brie or Backstage Passes
//                if (item.quality < 50) {
//                    //50 is max quality value
//                    item.quality += 1;
//                    //Conditions for Backstage Passes
//                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        //Changes for when it's 10 days or less
//                        if (item.sellIn < 11) {
//                            if (item.quality < 50) {
//                                item.quality += 1;
//                            }
//                        }
//                        //Changes for when it's 5 days or less
//                        if (item.sellIn < 6) {
//                            if (item.quality < 50) {
//                                item.quality += 1;
//                            }
//                        }
//                    }
//                }
//            }
//         
//            //Conditions for when it's past the sell-in date
//            if (item.sellIn < 0) {
//                //And the item isn't Brie or Backstage Passes
//                if (!item.name.equals("Aged Brie")) {
//                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        //And the quality is still greater than 0
//                        if (item.quality > 0) {
//                            //And it isn't Sulfuras
//                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                                //Decrease the quality by 1 (Us this right? Shouldn't it decrease 2x as fast?)
//                                item.quality -= 1;
//                            }
//                        }
//                    } else {
//                        //Otherwise set quality to 0 for Backstage Passes
//                        item.quality = item.quality - item.quality;
//                    }
//                } else {
//                    //For aged brie, if quality is less than 50, increase quality still
//                    if (item.quality < 50) {
//                        item.quality += 1;
//                    }
//                }
//            }
//        }
//    }
//    
     


