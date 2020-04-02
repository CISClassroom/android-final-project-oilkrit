package th.ac.kku.cis.mobileapp.Car

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class show2 : AppCompatActivity() {
    lateinit var writeList: MutableList<write>
    lateinit var mDatabase: DatabaseReference
    lateinit var auth: FirebaseAuth

    lateinit var adapter: commentAdapter
    private var listViewItems: ListView? = null
    var toDoItemList: MutableList<write>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show2)

        if (supportActionBar != null) // เอาแถบบนออก
            supportActionBar?.hide()

        listViewItems = findViewById<View>(R.id.showlist) as ListView
        toDoItemList = mutableListOf<write>()
        adapter = commentAdapter(this, toDoItemList!!)
        listViewItems!!.setAdapter(adapter)

        mDatabase = FirebaseDatabase.getInstance().reference
        mDatabase.child("Comment").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = dataSnapshot.children.iterator()
                // Check if current database contains any collection
                if (items.hasNext()) {
                    while (items.hasNext()) {
                        val toDoListindex = items.next()
                        val map = toDoListindex.getValue() as HashMap<String, Any>

                        // add data to object
                        val todoItem = write.create()
                        todoItem.Comment = map.get("comment") as String?
                        todoItem.Nametype = map.get("nametype") as String?
                        toDoItemList!!.add(todoItem);
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            }
        })
    }
}
