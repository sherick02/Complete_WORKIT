package com.kanad.workit

import android.content.Context
import com.kanad.workit.ui.base.BaseActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.NavController
import com.kanad.workit.R
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.kanad.workit.data.common.Constants
import com.kanad.workit.data.model.ExerciseModel
import com.kanad.workit.data.model.WorkoutModel
import com.kanad.workit.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : BaseActivity<ActivityMainBinding?>() {

    private var mAppBarConfiguration: AppBarConfiguration? = null
    var navController: NavController? = null

    override val layoutId: Int
        get() = R.layout.activity_main

    override val context: Context
        protected get() = this

    override fun initViews(savedInstanceState: Bundle?) {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home,
            R.id.nav_streak,
            R.id.nav_reminder,
            R.id.nav_logout
        )
            .build()
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main)

        NavigationUI.setupWithNavController(binding!!.navView, navController!!)

        //For workout data
        for (i in 0..1) {
            val exerciseModels = ArrayList<ExerciseModel>()
            for (j in 0..1) {
                val exerciseModel = ExerciseModel()
                exerciseModel.day = i + 1
                exerciseModel.title = "Jumping Jacks"
                exerciseModel.des =
                    "How to jump jacks. Start with your feet in the bottom of the shoe where the sky meets."
                exerciseModel.workout_name = ""
                exerciseModel.sets = 3
                exerciseModel.reps = 20
                exerciseModel.rest_time = 10
                exerciseModels.add(exerciseModel)
            }
            val workoutModel = WorkoutModel("Relaxing workout " + i + 1, i + 1, exerciseModels)
            Constants.workoutModelArrayList.add(workoutModel)
        }
    }

    override fun setListeners() {}

    fun onDoBack() {
        onBackPressed()
    }

    /* @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}