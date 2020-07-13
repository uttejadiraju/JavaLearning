package Tricky;

import java.util.ArrayList;
import java.util.List;

public final class WrongWayImmutableClass {
	private final List<String> favoriteFoods;

	public WrongWayImmutableClass(List<String> favoriteFoods) {
		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required");
		}
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!
		return favoriteFoods;
	}
}

/***
The problem in this example is
that the user has direct access to the List defined in our instance of Animal. Even though
they can’t change the List object to which it points, they can modify the items in the List,
for example, deleting all of the items by calling getFavoriteFoods().clear(). They
could also replace, remove, or even sort the List.

The solution, then, is never to return that List reference to the user. More generally
stated, you should never share references to a mutable object contained within an
immutable object. If the user does need access to the data in the List, either create
wrapper methods to iterate over the data or create a one‐time copy of the data that is
returned to the user and never stored as part of the object. In fact, the Collections
API includes the Collections.unmodifiableList() method, which does exactly this.
The key here is that none of the methods that you create should modify the mutable
object
***/