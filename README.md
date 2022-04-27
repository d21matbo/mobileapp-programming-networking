
# Rapport

**Skriv din rapport här!**

- [x] Add a `RecyclerView` to your layout

Added RecyclerView to `activity_main.xml`

- [x] Add a `ArrayList<Mountain>` as a member variable in your activity

```
private ArrayList<Mountain> mountains = new ArrayList<Mountain>();
```

- [x] Add a `RecyclerView.Adapter` as a member variable in your activity

```
private MountainAdapter adapter;
```

- [x] Create a RecyclerView.Adapter and a RecyclerView.ViewHolder

Added 'MountainAdapter.java' with an internal 'MountainAdapterViewHolder' class. The adapter has a
private arraylist that holds objects of the class 'Mountain'.

- [x] Use getJson() to download your json data by changing the JSON_URL and write code in onPostExecute().

This code retrieves the Json data "FamousPeaksJSON" from the URL
```
private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
...
new JsonTask(this).execute(JSON_URL);
```

And this code processes the retrieved Json data using the Gson library.

```
public void onPostExecute(String json) {
    if(json != null)
    {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        mountains = gson.fromJson(json, type);
        adapter.setMountains(mountains);
        adapter.notifyDataSetChanged();
    }
}
```
An issue occurred when testing the application on a real device (OnePlus A3003) as this device did
not have any connection to the internet. The Application would crash due to a NullPointerException
in 'MountainAdapter.java'

The problem turned out to be 'JsonTask(this).execute(JSON_URL)' returning null, which was set
as the internal ArrayList of the adapter by 'mountains = gson.fromJson(json, type);' and
'adapter.setMountains(mountains);'. A quick fix to the issue was to stop all code in 'onPostExecute'
from being executed with a null value.

- [x] Display the names of the mountains in the `RecyclerView`
        Hint: override `toString()` in your Mountain class

This code sets the value of each item in the recyclerview
```
public void onBindViewHolder(@NonNull MountainAdapterViewHolder holder, int position) {
    holder.mountainName.setText(mountains.get(position).getName());
}
```

'mountains.get(position)' retrieves the instance of 'Mountain' at a specific position.
'.getName()' is a getter that returns the name of said instance.

![](Screenshot.png)