class GildedRose {
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

            if (item.name.equals("Conjured Mana Cake")) {       //I never used comments but..
                update_Conjures(item);        //This block code added to add new class item
                continue;                               //Conjures
            }                                         //

            updateSimple(item);
        }
    }

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 40;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }


    }
}
