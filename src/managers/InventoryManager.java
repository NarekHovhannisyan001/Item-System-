package managers;

import models.Item;
import models.Rarity;

import java.util.*;

// Inventory Manager
public class InventoryManager {
    private final Map<Rarity, List<Item>> inventory;

    public InventoryManager() {
        inventory = new EnumMap<>(Rarity.class);
        for (Rarity rarity : Rarity.values()) {
            inventory.put(rarity, new ArrayList<>());
        }
    }

    public void addItem(Item item) {
        if (inventory.values().stream().flatMap(Collection::stream).anyMatch(i -> i.getName().equals(item.getName()))) {
            System.out.println("Cannot add duplicate item with the same name across rarities: " + item.getName());
            return;
        }
        inventory.get(item.getRarity()).add(item);
    }

    public void removeItem(Item item) {
        inventory.get(item.getRarity()).remove(item);
    }

    public List<Item> getItemsByRarity(Rarity rarity) {
        return inventory.get(rarity);
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Rarity rarity : Rarity.values()) {
            List<Item> items = inventory.get(rarity);
            if (!items.isEmpty()) {
                System.out.println(rarity + ":");
                items.forEach(item -> System.out.println("  - " + item));
            }
        }
    }
}
