
public class Item {

    //Name of item
    public String name;

    //Days to Sell item
    public int sellIn;

    //Quality Value of item
    public int quality;

    
    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
