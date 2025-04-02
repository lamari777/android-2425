package es.usj.jjhernandez.mainapplication

object ItemsDataSource {

    private val _items by lazy {
        (1 .. 1000).map { Item("Name $it", "Surname $it") }.toMutableList()
    }

    val items : List<Item> get() = _items

    fun getItemByPosition(position: Int) = items[position]

    fun getItemByName(name: String) = items.find { it.name == name }

    fun addItem(item: Item) {
        _items += item
    }

    fun removeByPosition(position: Int) : Item {
        return _items.removeAt(position)
    }
}