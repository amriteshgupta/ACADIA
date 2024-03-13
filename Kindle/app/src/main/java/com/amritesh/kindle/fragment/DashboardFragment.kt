package com.amritesh.kindle.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amritesh.kindle.R
import com.amritesh.kindle.adapter.DashboardRecyclerAdapter
import com.amritesh.kindle.model.Book
import com.amritesh.kindle.util.ConnectionManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class DashboardFragment : Fragment() {

lateinit var recyclerDashboard: RecyclerView
lateinit var layoutManager: RecyclerView.LayoutManager
lateinit var progressLayout:RelativeLayout
lateinit var progressBar: ProgressBar

    lateinit var recyclerAdapter: DashboardRecyclerAdapter
    val bookInfoList= arrayListOf<Book>(
//        Book("P.S. I Love You", "Cecelia Ahern","Rs.299","4.5",R.drawable.ps_ily),
//        Book("The Great Gatsby","F.Scott Fitzgerald","Rs.399","4.1",R.drawable.great_gatsby),
//        Book("Anna Karenina","Leo Tolstoy","Rs.199","4.3",R.drawable.anna_kare),
//        Book("Mademe Bovary","Gustava Flaubert","Rs.500","4.0",R.drawable.madame),
//        Book("War and Peace","Leo Tolstoy","Rs.249","4.0",R.drawable.war_and_peace),
//        Book("Lolita","Vladmir Nabokov","Rs.349","3.9",R.drawable.lolita),
//        Book("Middlemarch","George Elliot","Rs.599","4.2",R.drawable.middlemarch),
//        Book("The Advnetures of Huckleberry Finn","Mark Twain","Rs. 699","4.5",R.drawable.adventures_finn),
//        Book("Moby-Dick","Herman Melville","Rs,.499","4.5",R.drawable.moby_dick),
//        Book("The Lord of the Rings","J.R.R Tolkien","Rs.749","5.0",R.drawable.lord_of_rings)
//
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val view=inflater.inflate(R.layout.fragment_dashboard, container, false)
       recyclerDashboard=view.findViewById(R.id.recyclerDashboard)

        progressLayout=view.findViewById(R.id.progressLayout)
        progressBar=view.findViewById(R.id.progressBar)
        progressLayout.visibility=View.VISIBLE

        layoutManager= LinearLayoutManager(activity)

       val queue= Volley.newRequestQueue(activity as Context)
        val url= "http://13.235.250.119/v1/book/fetch_books/"

        if (ConnectionManager().checkConnectivity(activity as Context)){
        val jsonObjectRequest=object :JsonObjectRequest(Request.Method.GET, url, null,Response.Listener {
            try {

            progressLayout.visibility=View.GONE
            val success= it.getBoolean("success")
            if(success){
                val data= it.getJSONArray("data")
                for(i in 0 until data.length()){
                    val bookJsonObject=data.getJSONObject(i)
                    val bookObject=Book(
                        bookJsonObject.getString("book_id"),
                        bookJsonObject.getString("name"),
                        bookJsonObject.getString("author"),
                        bookJsonObject.getString("rating"),
                        bookJsonObject.getString("price"),
                        bookJsonObject.getString("image")
                    )
                    bookInfoList.add(bookObject)
                    recyclerAdapter= DashboardRecyclerAdapter(activity as Context, bookInfoList)
                    recyclerDashboard.adapter=recyclerAdapter
                    recyclerDashboard.layoutManager=layoutManager

                }
            }
            else{
                Toast.makeText(activity, "Some Error Occured !!!", Toast.LENGTH_SHORT).show()
            }}
            catch(e:JSONException){
                Toast.makeText(activity as Context,"Some unexpected error occurred !!!", Toast.LENGTH_SHORT).show()
            }
        },Response.ErrorListener {
                Toast.makeText(activity as Context, "Volley Error Occurred !!!", Toast.LENGTH_SHORT).show()

        }){
            override fun getHeaders(): MutableMap<String, String> {
                val headers= HashMap<String,String>()
                headers["Content-type"] ="application/json"
                headers["token"]="9bf534118365f1"
                return headers
            }
        }

        queue.add(jsonObjectRequest)}
        else{
            val dialog=AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error")
            dialog.setMessage("Internet Connection is not Found")
            dialog.setPositiveButton("Open Settings"){text,listener->
                val settingsIntent= Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                activity?.finish()
            }
            dialog.setNegativeButton("Exit"){text, listener ->
                ActivityCompat.finishAffinity(activity as Activity)
            }
            dialog.create()
            dialog.show()
        }
        return view
    }

}