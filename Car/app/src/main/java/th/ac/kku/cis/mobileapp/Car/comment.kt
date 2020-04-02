package th.ac.kku.cis.mobileapp.Car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_comment.*

class comment : AppCompatActivity() {
    lateinit var writeList: MutableList<write>
    lateinit var mDatabase: DatabaseReference
    lateinit var auth: FirebaseAuth

    lateinit var adapter: commentAdapter
    private var listViewItems: ListView? = null
    var toDoItemList: MutableList<write>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        if (supportActionBar != null) // เอาแถบบนออก
            supportActionBar?.hide()

        var name = getIntent().getStringExtra("nametypetype")
        writeList = mutableListOf()
        auth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        btnok.setOnClickListener {
            AddDatacom("String")
        }

    }
    fun AddDatacom(data: String) {

        var name = getIntent().getStringExtra("nametypetype")
        var newData: write = write.create()
        val obj = mDatabase.child("Comment").push()
        newData.Nametype = name.toString()
        newData.Comment = editText2.text.toString()
        newData.CommentId = obj.key
        obj.setValue(newData)


        Toast.makeText(applicationContext,"save successfully", Toast.LENGTH_LONG).show()
        var i = Intent(this, show2::class.java)
        startActivity(i)//รีเฟรชกลับไปหน้าก่อนนี้เพื่อรีเฟรชfirebase มาแสดง

    }

}
