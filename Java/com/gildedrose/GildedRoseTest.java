
import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    @Test
    public void testBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 3, 0) };
        GildedRose app = new GildedRose(items);
        //Set initial quality of Brie
        int initialQuality = items[0].quality;
        //Set initial Sellin
        int initialSellIn = app.items[0].sellIn;
        int daysLeft = app.items[0].sellIn;
         app.updateQuality();
   
        //Test if Brie increases in quality 
        assert(initialQuality<app.items[0].quality);
        //Test if Brie's Sellin decreases 
        assert(initialSellIn>app.items[0].sellIn);
        
        int days = 7;
       
        //EDGE CASE
        //Test if Brie increases by 2 after sellin, because it runs in the quality check AND the sellin check
         for (int i = 0; i < days; i++) {
            if (app.items[0].sellIn<0){
            initialQuality =  app.items[0].quality;
            assertEquals(initialQuality+2,app.items[0].quality);
              
            }
        }
         
        //Now check conditions for once quality reaches 50
        app.items[0].quality=50;
        app.updateQuality();
        assertEquals(50,app.items[0].quality);

    }
    
    @Test
    public void testBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0) };
        GildedRose app = new GildedRose(items);
        int initialQuality = items[0].quality;
        //Set initial Sellin
        int initialSellIn = items[0].sellIn;
        int daysLeft = app.items[0].sellIn;
        
       app.updateQuality();


        //Assumption: Quality will increase by 1 each day before day 10 CASE:Between AnyDay-Sellin Day 10
        assertEquals(initialQuality+1,app.items[0].quality);
         assertEquals(initialSellIn-1,app.items[0].sellIn);
        
        for (int i = daysLeft; i>-2; i--){   
        initialQuality = app.items[0].quality;
        app.updateQuality();
        if (app.items[0].sellIn<10&&app.items[0].sellIn>=5){
            assertEquals(initialQuality+2,app.items[0].quality);
        }
        else if (app.items[0].sellIn<5&&app.items[0].sellIn>0){
        assertEquals(initialQuality+3,app.items[0].quality);
        }
        
        //Check that the value of BackstagePasses goes to zero after sellin
        else if (app.items[0].sellIn<0){
        assertEquals(0,app.items[0].quality);
        }
        
     
        //Now check conditions for once quality reaches 50
        app.items[0].quality=50;
        app.items[0].sellIn=50;
         app.updateQuality();
        assertEquals(50,app.items[0].quality);
       }  
    }
      @Test
    public void testSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 0) };
        GildedRose app = new GildedRose(items);
        
        //Make one day of changes
        app.updateQuality();
        
        //Set Initial Quality Value 
        int initialQuality = app.items[0].quality;
        
        //Set Initial SellIn days left
        int initialSellIn = app.items[0].sellIn;
        
        //Check that quality stays the same
        assertEquals(initialQuality, app.items[0].quality);
        
        //Check that day it has to be sold stays the same 
        assertEquals(initialSellIn, app.items[0].sellIn);
    }
      @Test
    public void testGeneralItem() {
        Item[] items = new Item[] { new Item("Generic Item", 7, 5) };
        GildedRose app = new GildedRose(items);
        
         //Set Initial Quality Value 
        int initialQuality = app.items[0].quality;
        
        //Set Initial SellIn days left
        int initialSellIn = app.items[0].sellIn;
       app.updateQuality();
              
        //Check Quality is 1 Less
        assertEquals(initialQuality-1, app.items[0].quality);
        
        //Check Sellin is 1 Less
        assertEquals(initialSellIn-1, app.items[0].sellIn);
        
        //Check edge cases of quality
        app.items[0].quality=52;
        app.items[0].sellIn=5;
        initialQuality = app.items[0].quality;
        app.updateQuality();
       assert(initialQuality>app.items[0].quality);

        
        app.items[0].quality=0;
        app.items[0].sellIn=5;
       app.updateQuality();
        assertEquals(0,app.items[0].quality);

        
        //check edge cases of sellin that it decreases by 2 
        app.items[0].quality=3;
        initialQuality = app.items[0].quality;

        app.items[0].sellIn=-1;
        app.updateQuality();
        assertEquals(initialQuality-2, app.items[0].quality);   
    }
    
    @Test
    public void testConjured(){
    Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 20) };
    GildedRose app = new GildedRose(items);
    
    
    //Since the quality degrades twice as fast as other items, we assume quality decreases by 2 each day
    //We also assume the same conditions as other items that is:
    //Quality of Conjured is never negatives
    //Quality of Conjured is never greater than 50
    //At the end of the day, the system lowers the quality and SellIn values
          
         //Set Initial Quality Value 
        int initialQuality = app.items[0].quality;
        
        //Set Initial SellIn days left
        int initialSellIn = app.items[0].sellIn;

        app.updateQuality();
        
        //Check Quality is 2 Less
        assertEquals(initialQuality-2, app.items[0].quality);
        
        //Check Sellin is 1 Less
        assertEquals(initialSellIn-1, app.items[0].sellIn);
         

        //Check edge cases of quality
        app.items[0].quality=52;
        app.items[0].sellIn=5;
        initialQuality = app.items[0].quality;
         app.updateQuality();
       assert(initialQuality>app.items[0].quality);

        
        app.items[0].quality=0;
        app.items[0].sellIn=5;
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

}
