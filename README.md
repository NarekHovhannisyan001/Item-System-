# Item Upgrade System


## Overview
The Item Upgrade System is an application written in Java that handles item management and item upgrades in a game-like scenario. Items are present in various forms of rarity with rules to be used for upgrading the items. The project is based on Object-Oriented Programming, design patterns, and clean, modular code structure.


---


## Features
1. **Item Management**:
   - Creates, stores, and displays items in an inventory.
- The unique names of the items must avoid name duplication across rarity.

2. **Upgrade Mechanisms**:
  - Upgrades to be followed as per each rarity's rules
  - Multiple levels of upgrade are supported. It is Epic → Legendary

3. **Error Handling**:
  - No Duplicate names to the items
  - Upon an invalid upgrade, raise an error message in the console

4. **Console-based Interface**:
  - Add an item to the inventory.
- Create new items by combining existing items into it.
   - Print the inventory with its current contents.

---
## Design Principles and Patterns Utilized
### 1. **Object-Oriented Programming (OOP)**
   - Encapsulation: Separating the concern of having classes that are specifically item, inventory, and upgrade logic.
   - Polymorphism: Usage of interfaces and abstracted logic in strategies.
   - Inheritance: Epic item class then extends or inherited from the Item class.

2. **Design Patterns**
   - **Factory Pattern**:
     - `BaseFactory` interface and concrete factories (`ItemFactory`, `EpicFactory`) to create items of specific rarities.
     - A map is used to dynamically choose the appropriate factory based on user input.
   - 
   - **Strategy Pattern**:
- Encapsulate each upgrade rule as a separate strategy class (`CommonToGreatUpgrade`, `GreatToRareUpgrade`, etc.).
     - Adds new upgrade rules without modifying any existing code.
  .
   - **EnumMap**:
     - An efficient way of grouping and accessing items by their rarity.
  .
---

## Classes and Responsibilities
### `Item` and `EpicItem`
- Represents game items.
- The `EpicItem` includes tracking of upgrade counts.

### `InventoryManager`
- Manages storage, adding, and removing items.
- Prevents item names from being the same.

### `UpgradeManager`
- Deals with the upgrading process by calling the corresponding `UpgradeStrategy`.
- Splits the logic of upgrading away from inventory and item management.

### `UpgradeStrategy` and Implementations
- Interface describing the upgrade process.
- Implementation for each transition between rarity types, such as `CommonToGreatUpgrade`.

### `BaseFactory` and Implementations
- Interface to create items.
- Factory for concrete types (`ItemFactory`, `EpicFactory`) of items with specific rarities.

### `java` file `ConsoleUI`

- Is the more friendly user interface to the system.
It will perform input, output, interacts with `InventoryManager` and `UpgradeManager`

---

## Application Execution
### Conditions
- JDK 8+

### Execution
1. Compile
   ```bash
   javac *.java
   ```
2. Run the main class
   ```bash
   java ItemUpgradeSystem
   ```
3. Use the prompts on the screen to:
    - Add items to the inventory.
    - Upgrade items.
    - Display the inventory.

---

## Example Use Cases
1. **Adding Items**:
    - Enter a unique item name and choose its rarity.
    The system guarantees that the name is unique across all rarities.

2. **Upgrading Items**:
- Picks an item for upgrading and gives the necessary ingredient.
  - The system checks for the legality of the action following the individual rules for each rarity type.

3. **Display Inventory**:
  - Display all items by rarity.

---

## Error Handling
- **Duplicated Items**: Cannot add the same name items
- **Invalid Upgrades**: It warns that the upgrade has not been satisfied.
- **Invalid Input**: Handles input that's not expected or given in the wrong format

---

## Extensibility
1. **Add New Rarity**:
- Extend enum `Rarity`.
   Add the corresponding `UpgradeStrategy`.
   Add this one to `UpgradeManager`.

2. **Custom Factories**
   Implement new factories for custom item instantiations.

3. **Save and Load Inventory** (Soon)
   Add file I/O functionality to save and load inventory.

---
## Dependencies
No dependencies are used outside the Java standard library, as this project only relies on them.
This project was developed as an application of advanced Java concepts to illustrate mastery of OOP, design patterns, and modular programming principles.

