package Abstractions;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    void update_quality_AgedBrie(Item item) {
        item.sellIn--;
        item.quality++;
        if (item.quality > 50)
            item.quality = 50;
    }

    void update_quality_BackstagePasses(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
            return;
        }
        item.quality++;
        if (item.sellIn < 11)
            item.quality++;
        if (item.sellIn < 6)
            item.quality++;
        item.sellIn--;
        if (item.quality > 50)
            item.quality = 50;
    }

    void update_quality_Sulfuras(Item item) {
        return;
    }

    void update_Conjures(Item item) {
        item.quality -= 2;
        if (item.sellIn < 0)
            item.quality -= 2;
        item.sellIn--;
        if (item.quality < 0)
            item.quality = 0;
    }

    void updateSimple(Item item) {
        item.quality--;
        if (item.sellIn < 0)
            item.quality--;
        item.sellIn--;
        if (item.quality < 0)
            item.quality = 0;
    }


    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                update_quality_AgedBrie(item);
                continue;
            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                update_quality_BackstagePasses(item);
                continue;
            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                update_quality_Sulfuras(item);
                continue;
            }

            if (item.name.equals("Conjured Mana Cake")) {
                update_Conjures(item);
                continue;
            }

            updateSimple(item);
        }
    }
}
