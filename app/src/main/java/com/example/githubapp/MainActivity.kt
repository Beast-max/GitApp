package com.example.githubapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.githubapp.AddRepo.RepoViewModel
import com.example.githubapp.database.RepoData
import com.example.githubapp.database.Repodatabase
import com.google.android.material.appbar.MaterialToolbar


class MainActivity() : AppCompatActivity() {
    private lateinit var model :RepoViewModel

    companion object {
        const val PREFS_FILE_AUTH = "prefs_auth"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragrepodetail = RepoDetailFragment()
        val frgmentadd = AddFragment()
        val repolist = RepoListFragment()
        model = ViewModelProvider(this)[RepoViewModel::class.java]
        setSupportActionBar(findViewById<MaterialToolbar>(R.id.material_toolbar))
        findViewById<MaterialToolbar>(R.id.material_toolbar).showOverflowMenu()

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
           PREFS_FILE_AUTH,
            Context.MODE_PRIVATE)
        val id:Int = sharedPreferences.getInt("id",1)
        if(id==0){
            setfragment(repolist)
        }
        else{
            setfragment(frgmentadd)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu,menu)
        return true

    }

    @SuppressLint("ApplySharedPref")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
      var itemview = item.itemId
        when(itemview){
            R.id.add_icon->{

                setfragment(RepoDetailFragment())
            }
            R.id.clearallrepo->{
                val sharedPreferences: SharedPreferences = this.getSharedPreferences(PREFS_FILE_AUTH,
                    Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.commit()
                model.onClear()}
        }
        return false
    }
    private fun setfragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left)
        transaction.replace(R.id.fram,fragment)
            transaction.commit()
    }
}