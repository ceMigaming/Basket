# Ocado Technology | Internship | Java | Task | Wrocław
## Recruitment task
### Task description
The task is to create a `.jar` library, which will separate objects from clients basket into delivery methods stored in config file (`.json`). The config file is read from absolute path passed as an argument to the constructor of the `BasketSplitter` class. The library should also contain `BasketSplitter#split` method, which will take a list of strings as argument and put them into delivery methods. The method should return a map, where the key is the delivery method name and the value is a list of strings.
## Input
### Example config file
```json
{
    "Carrots (1kg)": ["Express Delivery", "Click&Collect"],
    "Cold Beer (330ml)": ["Express Delivery"],
    "Steak (300g)": ["Express Delivery", "Click&Collect"],
    "AA Battery (4 Pcs.)": ["Express Delivery", "Courier"],
    "Espresso Machine": ["Courier", "Click&Collect"],
    "Garden Chair": ["Courier"]
}
```
Path to this file should be passed as an argument to the constructor of the `BasketSplitter` class.
### Example list of items in baskets (`List<String> items`):
```
[
    "Steak (300g)",
    "Carrots (1kg)",
    "Soda (24x330ml)",
    "AA Battery (4 Pcs.)",
    "Espresso Machine",
    "Garden Chair"
]
```

## Output
The algoritthm should return a map, where the key is the delivery method name and the value is a list of strings containing items that should be delivered using this method.
It should:
- use the least possible number of delivery methods
- the largest group should contain the most items

### Example output represented as JSON
```json
{
    "Express Delivery": ["Steak (300g)", "Carrot (1kg)", "Cold Beer (330ml)", "AA Battery (4 Pcs.)"],
    "Courier": ["Espresso Machine", "Garden Chair"]
}
```
The library does not need to print the output to the console nor save the JSON output. It should only return the map.

