package ui;

import factories.BaseFactory;
import factories.EpicFactory;
import factories.ItemFactory;
import managers.InventoryManager;
import managers.UpgradeManager;
import models.Item;
import models.Rarity;

import java.util.*;

// Console UI
public class ConsoleUI {
    private final InventoryManager inventoryManager;
    private final UpgradeManager upgradeManager;
    private final Map<String, BaseFactory> factories;

    public ConsoleUI() {
        inventoryManager = new InventoryManager();
        upgradeManager = new UpgradeManager();

        // Initialize factories
        factories = new HashMap<>();
        factories.put("COMMON", new ItemFactory(Rarity.COMMON));
        factories.put("GREAT", new ItemFactory(Rarity.GREAT));
        factories.put("RARE", new ItemFactory(Rarity.RARE));
        factories.put("EPIC", new EpicFactory());
        factories.put("LEGENDARY", new ItemFactory(Rarity.LEGENDARY));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions: \n1. Add models.Item \n2. Upgrade models.Item \n3. Display Inventory \n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addItem(scanner);
                case 2 -> upgradeItem(scanner);
                case 3 -> inventoryManager.displayInventory();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addItem(Scanner scanner) {
        System.out.println("Enter item name:");
        String name = scanner.nextLine();
        System.out.println("Enter rarity (COMMON, GREAT, RARE, EPIC, LEGENDARY):");
        String rarityInput = scanner.nextLine().toUpperCase();

        BaseFactory factory = factories.get(rarityInput);
        if (factory != null) {
            Item item = factory.createItem(name);
            inventoryManager.addItem(item);
        } else {
            System.out.println("Invalid rarity. models.Item not added.");
        }
    }

    private void upgradeItem(Scanner scanner) {
        System.out.println("Enter the name of the item to upgrade:");
        String name = scanner.nextLine();
        Rarity rarity = getRarityByName(name);
        if (rarity == null) {
            System.out.println("models.Item not found.");
            return;
        }

        List<Item> items = inventoryManager.getItemsByRarity(rarity);
        List<Item> ingredients = new ArrayList<>();
        System.out.println("Enter the names of items to use as ingredients (comma-separated):");
        String[] ingredientNames = scanner.nextLine().split(",");

        for (String ingredientName : ingredientNames) {
            String ingredientNameTmp = ingredientName.trim();
            items.stream().filter(i -> i.getName().equalsIgnoreCase(ingredientNameTmp)).findFirst().ifPresent(ingredients::add);
        }

        boolean success = upgradeManager.upgradeItem(items.get(0), ingredients, inventoryManager);
        System.out.println(success ? "Upgrade successful." : "Upgrade failed.");
    }

    private Rarity getRarityByName(String name) {
        for (Rarity rarity : Rarity.values()) {
            if (inventoryManager.getItemsByRarity(rarity).stream().anyMatch(item -> item.getName().equalsIgnoreCase(name))) {
                return rarity;
            }
        }
        return null;
    }
}
