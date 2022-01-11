package com.example.githubapp.AddRepo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.githubapp.database.RepoData
import com.example.githubapp.database.Repodatabase
import kotlinx.coroutines.*

class RepoViewModel(application: Application):AndroidViewModel(application) {

private val db:Repodatabase = Repodatabase.getinstanc(application)
internal val getallrepo:LiveData<List<RepoData>> =db.RepoDatabaseDao().getAllRepo()

   private var viewModelJob = Job()

   private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

   private var _showSnackbarEvent = MutableLiveData<Boolean?>()
   val showSnackBarEvent: LiveData<Boolean?>
      get() = _showSnackbarEvent

   fun insert(repoData: RepoData){
      uiScope.launch {
         withContext(Dispatchers.IO) {
            db.RepoDatabaseDao().insert(repoData)
         }
      }

   }

   fun onClear() {
      uiScope.launch {
         withContext(Dispatchers.IO) {

            db.RepoDatabaseDao().clear()
         }

         _showSnackbarEvent.value = true
      }
   }
   fun doneShowingSnackbar() {
      _showSnackbarEvent.value = null
   }

   override fun onCleared() {
      super.onCleared()
      viewModelJob.cancel()
   }
}



