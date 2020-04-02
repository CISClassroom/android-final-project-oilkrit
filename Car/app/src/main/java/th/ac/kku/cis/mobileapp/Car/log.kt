package th.ac.kku.cis.mobileapp.Car

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_log.*

class log : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        if (supportActionBar != null) // เอาแถบบนออก
            supportActionBar?.hide()

        val NameSetting: TextView = findViewById(R.id.textView)
        val Profile: ImageView = findViewById(R.id.imageView)
        val Email: TextView = findViewById(R.id.textView2)
        auth = FirebaseAuth.getInstance()
        auth.currentUser!!.email
        val xx: Uri? = auth.currentUser!!.photoUrl
        NameSetting.text = auth.currentUser!!.displayName.toString()
        Picasso.get().load(xx).into(Profile)
        Email.text = auth.currentUser!!.email
        auth.currentUser!!.email

        val typename = resources.getStringArray(R.array.typecar)
        val st_list = mutableListOf<cartype>()


        for (i in 0..typename.size-1) {
            st_list.add(cartype(typename[i]))

        }
        val listView = findViewById<ListView>(R.id.listviewpv1)
        listView.adapter = ListAdapter(
            this,
            R.layout.namecartype,
            st_list
        )
//        val arrayAdapter: ArrayAdapter<*>
//
//        val Province = resources.getStringArray(R.array.typecar)
//
//        // access the listView from xml file
//        var mListView = findViewById<ListView>(R.id.listviewpv1)
//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Province)
//        mListView.adapter = arrayAdapter
//
//        mListView.setOnItemClickListener { parent, view, position, id ->
//
//            val selectedItem = parent.getItemAtPosition(position) as String
//            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
//
//        }
//        listviewpv1.setOnItemClickListener { parent, view, position, id ->
//            val selectedItem = parent.getItemAtPosition(position) as String
//            //Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show()
//            val intent = Intent(this, comment::class.java)
////            intent.putExtra("namePro", selectedItem.ProvincesName)//ส่งไปยัง showstudent
//            startActivity(intent)
//    }
        listviewpv1.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as cartype
            val intent = Intent(this, comment::class.java)
            intent.putExtra("nametypetype", selectedItem.nametype)
            startActivity(intent)
        }
}
}
